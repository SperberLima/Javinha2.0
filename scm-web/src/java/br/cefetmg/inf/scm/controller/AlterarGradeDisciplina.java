/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.domain.GradeDisciplina;
import br.cefetmg.inf.model.service.IManterDisciplina;
import br.cefetmg.inf.model.service.IManterGradeDisciplina;
import br.cefetmg.inf.model.service.impl.ManterDisciplina;
import br.cefetmg.inf.model.service.impl.ManterGradeDisciplina;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrador
 */
public class AlterarGradeDisciplina {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o codGrade que se deseja alterar
            String codGrade = request.getParameter("id");

            IManterGradeDisciplina manterGradeDisciplina = new ManterGradeDisciplina();
            GradeDisciplina grade = manterGradeDisciplina.buscarPorId(Integer.parseInt(codGrade));
            if(grade != null){
                request.setAttribute("grade", grade);
                
                IManterDisciplina manterDisciplina = new ManterDisciplina();
                List<Disciplina> listDisciplina = manterDisciplina.listarTodos();
                request.setAttribute("listCurso", listDisciplina);
                
                jsp = "/alterar/gradecurricular.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Grade-Disciplina!";
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
