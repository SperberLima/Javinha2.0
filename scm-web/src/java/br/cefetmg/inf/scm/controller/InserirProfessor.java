/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.Professor;
import br.cefetmg.inf.model.service.IManterProfessor;
import br.cefetmg.inf.model.service.impl.ManterProfessor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Diego
 */
public class InserirProfessor {
                  
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterProfessor manterProfessor = new ManterProfessor();
            List<Professor> listProfessor = manterProfessor.listarTodos();

            if (listProfessor != null) {
                request.setAttribute("listProfessor", listProfessor);
                jsp = "/cadastrar/professor.jsp";
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
