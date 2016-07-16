/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.PeriodoLetivo;
import br.cefetmg.inf.model.domain.GradeCurricular;

import br.cefetmg.inf.model.service.IManterPeriodoLetivo;
import br.cefetmg.inf.model.service.IManterGradeCurricular;

import br.cefetmg.inf.model.service.impl.ManterPeriodoLetivo;
import br.cefetmg.inf.model.service.impl.ManterGradeCurricular;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Diego
 */
public class InserirCurriculoOferta {
        
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterPeriodoLetivo manterPeriodoLetivo = new ManterPeriodoLetivo();
            List<PeriodoLetivo> listPeriodoLetivo = manterPeriodoLetivo.listarTodos();

            IManterGradeCurricular manterGradeCurricular = new ManterGradeCurricular();
            List<GradeCurricular> listGradeCurricular = manterGradeCurricular.listarTodos();
            
            if (listPeriodoLetivo == null || listGradeCurricular == null) {
                String erro = "Nao existe registro!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            } else {
                request.setAttribute("listPeriodoLetivo",listPeriodoLetivo);
                request.setAttribute("listGradeCurricular", listGradeCurricular);
                jsp = "/cadastrar/curriculooferta.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
