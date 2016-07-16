/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.domain.GradeCurricular;

import br.cefetmg.inf.model.service.IManterDisciplina;
import br.cefetmg.inf.model.service.IManterGradeCurricular;

import br.cefetmg.inf.model.service.impl.ManterDisciplina;
import br.cefetmg.inf.model.service.impl.ManterGradeCurricular;

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
            IManterDisciplina manterDisciplina = new ManterDisciplina();
            List<Disciplina> listDisciplina = manterDisciplina.listarTodos();
            
            IManterGradeCurricular manterGradeCurricular = new ManterGradeCurricular();
            List<GradeCurricular> listGradeCurricular = manterGradeCurricular.listarTodos();

            if (listDisciplina == null || listGradeCurricular == null) {
                String erro = "Nao existe registro!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            } else {
                request.setAttribute("listDisciplina", listDisciplina);
                request.setAttribute("listGradeCurricular", listGradeCurricular);
                jsp = "/cadastrar/gradedisciplina.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
