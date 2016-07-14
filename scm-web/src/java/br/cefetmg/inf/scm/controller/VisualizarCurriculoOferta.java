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
public class VisualizarCurriculoOferta {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterCurriculoOferta manterCurriculoOferta = new ManterCurriculoOferta();
            List<CurriculoOferta> listCurriculoOferta = manterCurriculoOferta.listarTodos();
            if (listCurriculoOferta != null) {
                request.setAttribute("listCurriculoOferta", listCurriculoOferta);
                jsp = "/visualizar/curriculo.jsp";
            } else {
                String erro = "Não existem curriculos em oferta!";
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
