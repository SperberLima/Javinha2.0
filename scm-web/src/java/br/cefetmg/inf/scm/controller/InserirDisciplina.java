/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.service.IManterDisciplina;
import br.cefetmg.inf.model.service.impl.ManterDisciplina;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Diego
 */
public class InserirDisciplina {
               
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterDisciplina manterDisciplina = new ManterDisciplina();
            List<Disciplina> listDisciplina = manterDisciplina.listarTodos();

            if (listDisciplina != null) {
                request.setAttribute("listDisciplina", listDisciplina);
                jsp = "/cadastrar/disciplina.jsp";
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
