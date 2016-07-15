/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.domain.UnidadeEnsino;
import br.cefetmg.inf.model.service.IManterDepartamento;
import br.cefetmg.inf.model.service.IManterUnidadeEnsino;
import br.cefetmg.inf.model.service.impl.ManterDepartamento;
import br.cefetmg.inf.model.service.impl.ManterUnidadeEnsino;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrador
 */
public class AlterarDepartamento {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o codDepartamento que se deseja alterar
            String codDepartamento = request.getParameter("id");

            IManterDepartamento manterDepartamento = new ManterDepartamento();
            Departamento Departamento = manterDepartamento.buscarPorId(Integer.parseInt(codDepartamento));
            if(Departamento != null){
                request.setAttribute("departamento", Departamento);
                
                IManterUnidadeEnsino manterUnidade = new ManterUnidadeEnsino();
                List<UnidadeEnsino> listUnidade = manterUnidade.listarTodos();
                request.setAttribute("listGrade", listUnidade);
                
                jsp = "/alterar/departamento.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Departamento!";
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
