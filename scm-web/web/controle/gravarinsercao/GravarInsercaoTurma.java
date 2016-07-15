package controle.gravarinsercao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.cefetmg.inf.model.domain.Turma;
import br.cefetmg.inf.model.domain.CurriculoOferta;

import br.cefetmg.inf.model.service.IManterTurma;
import br.cefetmg.inf.model.service.IManterCurriculoOferta;

import br.cefetmg.inf.model.service.impl.ManterTurma;
import br.cefetmg.inf.model.service.impl.ManterCurriculoOferta;

import br.cefetmg.inf.scm.controller.VisualizarTurma;

import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Diego
 */
public class GravarInsercaoTurma {
                       
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Integer id_curriculo_oferta = Integer.parseInt(request.getParameter("curriculoOferta"));
            String nome = request.getParameter("nome");
            
            IManterCurriculoOferta manterCurriculoOferta = new ManterCurriculoOferta();
            CurriculoOferta curriculoOferta = manterCurriculoOferta.buscarPorId(id_curriculo_oferta);
 
            Turma turma = new Turma();
            turma.setCurriculoOferta(curriculoOferta);
            turma.setNome(nome);
 
            IManterTurma manterTurma = new ManterTurma();
            Integer id_turma = manterTurma.cadastrar(turma);
 
            if (id_turma != null) {
                jsp = VisualizarTurma.execute(request);
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
