/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.Curso;
import br.cefetmg.inf.model.service.IManterCurso;
import br.cefetmg.inf.model.service.impl.ManterCurso;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Diego
 */
public class InserirCurso {
           
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterCurso manterCurso = new ManterCurso();
            List<Curso> listCurso = manterCurso.listarTodos();

            if (listCurso != null) {
                request.setAttribute("listCurso", listCurso);
                jsp = "/cadastrar/curso.jsp";
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
