/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.service.IManterGradeDisciplina;
import br.cefetmg.inf.model.service.impl.ManterGradeDisciplina;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nome
 */
public class ExcluirGradeDisciplina {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterGradeDisciplina manterGrade = new ManterGradeDisciplina();
            boolean sucesso = manterGrade.excluir(Integer.parseInt(request.getParameter("id")));
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
