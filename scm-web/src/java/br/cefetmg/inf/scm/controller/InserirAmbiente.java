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
 * @author Diego
 */
public class InserirAmbiente {
           
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterAmbienteAprendizagem manterAmbienteAprendizagem = new ManterAmbienteAprendizagem();
            List<AmbienteAprendizagem> listAmbienteAprendizagem = manterAmbienteAprendizagem.listarTodos();

            if (listAmbienteAprendizagem != null) {
                request.setAttribute("listAmbienteAprendizagem", listAmbienteAprendizagem);
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
