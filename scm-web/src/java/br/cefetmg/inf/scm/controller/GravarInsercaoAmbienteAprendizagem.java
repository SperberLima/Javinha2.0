package br.cefetmg.inf.scm.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.cefetmg.inf.model.domain.AmbienteAprendizagem;
import br.cefetmg.inf.model.domain.UnidadeEnsino;
import br.cefetmg.inf.model.service.IManterAmbienteAprendizagem;
import br.cefetmg.inf.model.service.IManterUnidadeEnsino;
import br.cefetmg.inf.model.service.impl.ManterAmbienteAprendizagem;
import br.cefetmg.inf.model.service.impl.ManterUnidadeEnsino;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Diego
 */
public class GravarInsercaoAmbienteAprendizagem {
      
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            //Integer id = Integer.parseInt(request.getParameter("idAmbiente"));
            Integer qtd_capacidade = Integer.parseInt(request.getParameter("capacidade"));
            Integer nro_sala = Integer.parseInt(request.getParameter("sala"));
            String descricao = request.getParameter("descricao");
            Integer id_unidade_ensino = Integer.parseInt(request.getParameter("unidadeEnsino"));
           
            IManterUnidadeEnsino manterUnidadeEnsino = new ManterUnidadeEnsino();
            UnidadeEnsino unidadeEnsino = manterUnidadeEnsino.buscarPorId(id_unidade_ensino);
 
            AmbienteAprendizagem ambienteAprendizagem = new AmbienteAprendizagem();
            ambienteAprendizagem.setCapacidade(qtd_capacidade);
            ambienteAprendizagem.setSala(nro_sala);
            ambienteAprendizagem.setDescricao(descricao);
            ambienteAprendizagem.setU_ensino(unidadeEnsino);
 
            IManterAmbienteAprendizagem manterAmbienteAprendizagem = new ManterAmbienteAprendizagem();
            Integer id_ambiente = manterAmbienteAprendizagem.cadastrar(ambienteAprendizagem);
 
            if (id_ambiente != null) {
                jsp = VisualizarAmbiente.execute(request);
            } else {
                String erro = "Não foi possível gravar esse registro!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }
 
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
