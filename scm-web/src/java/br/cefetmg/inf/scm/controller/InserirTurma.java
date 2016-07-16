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
 * @author Diego
 */
public class InserirTurma {
                  
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterCurriculoOferta manterCurriculo = new ManterCurriculoOferta();
            List<CurriculoOferta> listCurriculo = manterCurriculo.listarTodos();

            if (listCurriculo != null) {
                request.setAttribute("listCurriculo", listCurriculo);
                jsp = "/cadastrar/turma.jsp";
            } else {
                String erro = "Nao existem registros!";
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
