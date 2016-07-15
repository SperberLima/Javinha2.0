/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.AmbienteAprendizagem;
import br.cefetmg.inf.model.service.IManterAmbienteAprendizagem;
import br.cefetmg.inf.model.service.impl.ManterAmbienteAprendizagem;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nome
 */
public class ExcluirAmbiente {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterAmbienteAprendizagem manterAmbiente = new ManterAmbienteAprendizagem();
            boolean sucesso = manterAmbiente.excluir(Integer.parseInt(request.getParameter("id")));
            List<AmbienteAprendizagem> listAmbiente = manterAmbiente.listarTodos();
            if (sucesso != false) {
                jsp = VisualizarAmbiente.execute(request);
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
