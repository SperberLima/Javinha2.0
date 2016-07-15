/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.ProfessorDisciplina;
import br.cefetmg.inf.model.service.IManterProfessorDisciplina;
import br.cefetmg.inf.model.service.impl.ManterProfessorDisciplina;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Diego
 */
public class InserirProfessorDisciplina {
                  
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterProfessorDisciplina manterProfessorDisciplina = new ManterProfessorDisciplina();
            List<ProfessorDisciplina> listProfessorDisciplina = manterProfessorDisciplina.listarTodos();

            if (listProfessorDisciplina != null) {
                request.setAttribute("listProfessorDisciplina", listProfessorDisciplina);
                jsp = "/cadastrar/professordisciplina.jsp";
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