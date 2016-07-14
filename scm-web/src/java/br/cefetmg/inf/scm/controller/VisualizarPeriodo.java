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
public class VisualizarPeriodo {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterPeriodoLetivo manterPeriodo = new ManterPeriodoLetivo();
            List<PeriodoLetivo> listPeriodo = manterPeriodo.listarTodos();
            if (listPeriodo != null) {
                request.setAttribute("listPeriodoLetivo", listPeriodo);
                jsp = "/visualizar/periodo.jsp";
            } else {
                String erro = "Não existem periodos letivos!";
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
