/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.AmbienteAprendizagem;
import br.cefetmg.inf.model.domain.UnidadeEnsino;
import br.cefetmg.inf.model.service.IManterAmbienteAprendizagem;
import br.cefetmg.inf.model.service.IManterUnidadeEnsino;
import br.cefetmg.inf.model.service.impl.ManterAmbienteAprendizagem;
import br.cefetmg.inf.model.service.impl.ManterUnidadeEnsino;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrador
 */
public class AlterarAmbiente {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o codAmbiente que se deseja alterar
            String codAmbiente = request.getParameter("id");

            IManterAmbienteAprendizagem manterAmbienteAprendizagem = new ManterAmbienteAprendizagem();
            AmbienteAprendizagem AmbienteAprendizagem = manterAmbienteAprendizagem.buscarPorId(Integer.parseInt(codAmbiente));
            if(AmbienteAprendizagem != null){
                request.setAttribute("ambiente", AmbienteAprendizagem);
                
                IManterUnidadeEnsino manterUnidadeEnsino = new ManterUnidadeEnsino();
                List<UnidadeEnsino> listUnidadeEnsino = manterUnidadeEnsino.listarTodos();
                request.setAttribute("listUnidade", listUnidadeEnsino);
                
                jsp = "/alterar/ambiente.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Ambiente!";
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
