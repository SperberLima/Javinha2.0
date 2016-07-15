/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.UnidadeEnsino;
import br.cefetmg.inf.model.service.IManterUnidadeEnsino;
import br.cefetmg.inf.model.service.impl.ManterUnidadeEnsino;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Diego
 */
public class InserirUnidadeEnsino {
                  
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterUnidadeEnsino manterUnidadeEnsino = new ManterUnidadeEnsino();
            List<UnidadeEnsino> listUnidadeEnsino = manterUnidadeEnsino.listarTodos();

            if (listUnidadeEnsino != null) {
                request.setAttribute("listUnidadeEnsino", listUnidadeEnsino);
                jsp = "/cadastrar/unidade.jsp";
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
