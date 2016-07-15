/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.CurriculoOferta;
import br.cefetmg.inf.model.service.IManterCurriculoOferta;
import br.cefetmg.inf.model.service.impl.ManterCurriculoOferta;
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
            IManterCurriculoOferta manterCurriculoOferta = new ManterCurriculoOferta();
            List<CurriculoOferta> listCurriculoOferta = manterCurriculoOferta.listarTodos();

            if (listCurriculoOferta != null) {
                request.setAttribute("listCurriculoOferta", listCurriculoOferta);
                jsp = "/cadastrar/curriculooferta.jsp";
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
