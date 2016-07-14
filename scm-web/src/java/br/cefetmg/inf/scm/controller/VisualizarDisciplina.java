/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.model.service.impl.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Igor
 */
public class VisualizarDisciplina {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterDisciplina manterDisciplina = new ManterDisciplina();
            List<Disciplina> listDisciplina = manterDisciplina.listarTodos();
            if (listDisciplina != null) {
                request.setAttribute("listDisciplina", listDisciplina);
                jsp = "/visualizar/disciplina.jsp";
            } else {
                String erro = "Não existem disciplinas!";
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
