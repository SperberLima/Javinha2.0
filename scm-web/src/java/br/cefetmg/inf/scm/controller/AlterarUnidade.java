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
 * @author Administrador
 */
public class AlterarUnidade {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o codUnidade que se deseja alterar
            String codUnidade = request.getParameter("id");

            IManterUnidadeEnsino manterUnidadeEnsino = new ManterUnidadeEnsino();
            UnidadeEnsino unidade = manterUnidadeEnsino.buscarPorId(Integer.parseInt(codUnidade));
            if(unidade != null){
                request.setAttribute("unidade", unidade);
                jsp = "/alterar/turma.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Unidade!";
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
