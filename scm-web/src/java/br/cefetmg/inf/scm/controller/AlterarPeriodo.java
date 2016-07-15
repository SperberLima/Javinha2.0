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
 * @author Administrador
 */
public class AlterarPeriodo {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o codPeriodo que se deseja alterar
            String codPeriodo = request.getParameter("id");

            IManterPeriodoLetivo manterHorario = new ManterPeriodoLetivo();
            PeriodoLetivo Periodo = manterHorario.buscarPorId(Integer.parseInt(codPeriodo));
            if(Periodo != null){
                request.setAttribute("periodo", Periodo);
                jsp = "/alterar/periodo.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Periodo!";
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
