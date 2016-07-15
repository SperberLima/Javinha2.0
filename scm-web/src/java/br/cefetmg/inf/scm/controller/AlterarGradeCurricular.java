/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.Curso;
import br.cefetmg.inf.model.domain.GradeCurricular;
import br.cefetmg.inf.model.service.IManterCurso;
import br.cefetmg.inf.model.service.IManterGradeCurricular;
import br.cefetmg.inf.model.service.impl.ManterCurso;
import br.cefetmg.inf.model.service.impl.ManterGradeCurricular;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrador
 */
public class AlterarGradeCurricular {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o codGrade que se deseja alterar
            String codGrade = request.getParameter("id");

            IManterGradeCurricular manterDisciplina = new ManterGradeCurricular();
            GradeCurricular grade = manterDisciplina.buscarPorId(Integer.parseInt(codGrade));
            if(grade != null){
                request.setAttribute("grade", grade);
                
                IManterCurso manterDepartamento = new ManterCurso();
                List<Curso> listCurso = manterDepartamento.listarTodos();
                request.setAttribute("listCurso", listCurso);
                
                jsp = "/alterar/gradecurricular.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Grade!";
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
