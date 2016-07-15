/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.GradeDisciplina;
import br.cefetmg.inf.model.service.IManterGradeDisciplina;
import br.cefetmg.inf.model.service.impl.ManterGradeDisciplina;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Diego
 */
public class InserirGradeDisciplina {
                     
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterGradeDisciplina manterGradeDisciplina = new ManterGradeDisciplina();
            List<GradeDisciplina> listGradeDisciplina = manterGradeDisciplina.listarTodos();

            if (listGradeDisciplina != null) {
                request.setAttribute("listGradeDisciplina", listGradeDisciplina);
                jsp = "/cadastrar/gradedisciplina.jsp";
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
