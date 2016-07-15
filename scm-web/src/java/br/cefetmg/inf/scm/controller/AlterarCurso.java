/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.Curso;
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.service.IManterCurso;
import br.cefetmg.inf.model.service.IManterDepartamento;
import br.cefetmg.inf.model.service.impl.ManterCurso;
import br.cefetmg.inf.model.service.impl.ManterDepartamento;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrador
 */
public class AlterarCurso {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o codCurso que se deseja alterar
            String codCurso = request.getParameter("id");

            IManterCurso manterCurso = new ManterCurso();
            Curso curso = manterCurso.buscarPorId(Integer.parseInt(codCurso));
            if(curso != null){
                request.setAttribute("curso", curso);
                
                IManterDepartamento manterDepartamento = new ManterDepartamento();
                List<Departamento> listDepartamento = manterDepartamento.listarTodos();
                request.setAttribute("listDepartamento", listDepartamento);
                
                jsp = "/alterar/curso.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Curso!";
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
