/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.service.IManterDepartamento;
import br.cefetmg.inf.model.service.impl.ManterDepartamento;
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
            IManterDepartamento manterDepartamento = new ManterDepartamento();
            List<Departamento> listDepartamento = manterDepartamento.listarTodos();

            if (listDepartamento != null) {
               request.setAttribute("listDepartamento",listDepartamento);
                jsp = "/cadastrar/curso.jsp";
            } else {
                
                String erro = "Nao existe registro!";
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
