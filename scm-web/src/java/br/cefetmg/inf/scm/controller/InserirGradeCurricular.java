/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.GradeCurricular;
import br.cefetmg.inf.model.service.IManterGradeCurricular;
import br.cefetmg.inf.model.service.impl.ManterGradeCurricular;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Diego
 */
public class InserirGradeCurricular {
                  
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterGradeCurricular manterGradeCurricular = new ManterGradeCurricular();
            List<GradeCurricular> listGradeCurricular = manterGradeCurricular.listarTodos();

            if (listGradeCurricular != null) {
                request.setAttribute("listGradeCurricular", listGradeCurricular);
                jsp = "/cadastrar/gradecurricular.jsp";
            } else {
                String erro = "Nao existe registros!";
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
