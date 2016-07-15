/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.service.IManterDepartamento;
import br.cefetmg.inf.model.service.IManterDisciplina;
import br.cefetmg.inf.model.service.impl.ManterDepartamento;
import br.cefetmg.inf.model.service.impl.ManterDisciplina;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrador
 */
public class AlterarDisciplina {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o codDisciplina que se deseja alterar
            String codDisciplina = request.getParameter("id");

            IManterDisciplina manterDisciplina = new ManterDisciplina();
            Disciplina Disciplina = manterDisciplina.buscarPorId(Integer.parseInt(codDisciplina));
            if(Disciplina != null){
                request.setAttribute("disciplina", Disciplina);
                
                IManterDepartamento manterDepartamento = new ManterDepartamento();
                List<Departamento> listDepartamento = manterDepartamento.listarTodos();
                request.setAttribute("listDepartamento", listDepartamento);
                
                jsp = "/alterar/disciplina.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Disciplina!";
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
