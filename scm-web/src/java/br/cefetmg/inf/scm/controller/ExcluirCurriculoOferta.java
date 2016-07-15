/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.service.IManterCurriculoOferta;
import br.cefetmg.inf.model.service.impl.ManterCurriculoOferta;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nome
 */
public class ExcluirCurriculoOferta {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterCurriculoOferta manterCurriculoOferta = new ManterCurriculoOferta();
            boolean sucesso = manterCurriculoOferta.excluir(Integer.parseInt(request.getParameter("id")));
            if (sucesso != false) {
                jsp = VisualizarCurriculoOferta.execute(request);
            } else {
                String erro = "Errou ao excluir!";
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
