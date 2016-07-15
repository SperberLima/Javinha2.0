/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.PeriodoLetivo;
import br.cefetmg.inf.model.service.IManterPeriodoLetivo;
import br.cefetmg.inf.model.service.impl.ManterPeriodoLetivo;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Diego
 */
public class InserirPeriodoLetivo {
                  
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterPeriodoLetivo manterPeriodoLetivo = new ManterPeriodoLetivo();
            List<PeriodoLetivo> listPeriodoLetivo = manterPeriodoLetivo.listarTodos();

            if (listPeriodoLetivo != null) {
                request.setAttribute("listPeriodoLetivo", listPeriodoLetivo);
                jsp = "/cadastrar/periodo.jsp";
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