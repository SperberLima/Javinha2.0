/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.CurriculoOferta;
import br.cefetmg.inf.model.domain.Turma;
import br.cefetmg.inf.model.service.IManterCurriculoOferta;
import br.cefetmg.inf.model.service.IManterTurma;
import br.cefetmg.inf.model.service.impl.ManterCurriculoOferta;
import br.cefetmg.inf.model.service.impl.ManterTurma;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrador
 */
public class AlterarTurma {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o codTurma que se deseja alterar
            String codTurma = request.getParameter("id");

            IManterTurma manterTurma = new ManterTurma();
            Turma Turma = manterTurma.buscarPorId(Integer.parseInt(codTurma));
            if(Turma != null){
                request.setAttribute("turma", Turma);
                
                IManterCurriculoOferta manterCurriculoOferta = new ManterCurriculoOferta();
                List<CurriculoOferta> listCurriculoOferta = manterCurriculoOferta.listarTodos();
                request.setAttribute("listCurriculo", listCurriculoOferta);
                
                jsp = "/alterar/turma.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Turma!";
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
