/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.service.IManterProfessorDisciplina;
import br.cefetmg.inf.model.service.impl.ManterProfessorDisciplina;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nome
 */
public class ExcluirProfessorDisciplina {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterProfessorDisciplina manterProfessorDisciplina = new ManterProfessorDisciplina();
            boolean sucesso = manterProfessorDisciplina.excluir(Integer.parseInt(request.getParameter("id")));
            if (sucesso != false) {
                jsp = VisualizarAmbiente.execute(request);
            } else {
                String erro = "Errou ao excluir!";
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
