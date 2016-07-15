package br.cefetmg.inf.scm.controller;;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.cefetmg.inf.model.domain.ProfessorDisciplina;
import br.cefetmg.inf.model.domain.Professor;
import br.cefetmg.inf.model.domain.Disciplina;

import br.cefetmg.inf.model.service.IManterProfessorDisciplina;
import br.cefetmg.inf.model.service.IManterProfessor;
import br.cefetmg.inf.model.service.IManterDisciplina;

import br.cefetmg.inf.model.service.impl.ManterProfessorDisciplina;
import br.cefetmg.inf.model.service.impl.ManterProfessor;
import br.cefetmg.inf.model.service.impl.ManterDisciplina;

import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Diego
 */
public class GravarInsercaoProfessorDisciplina {
          
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Integer id_professor = Integer.parseInt(request.getParameter("professor"));
            Integer id_disciplina = Integer.parseInt(request.getParameter("disciplina"));
           
            IManterProfessor manterProfessor = new ManterProfessor();
            Professor professor = manterProfessor.buscarPorId(id_professor);
            
            IManterDisciplina manterDisciplina = new ManterDisciplina();
            Disciplina disciplina = manterDisciplina.buscarPorId(id_disciplina);
            
            ProfessorDisciplina professorDisciplina = new ProfessorDisciplina();
            professorDisciplina.setProfessor(professor);
            professorDisciplina.setDisciplina(disciplina);
 
            IManterProfessorDisciplina manterProfessorDisciplina = new ManterProfessorDisciplina();
            Integer id_professor_disciplina = manterProfessorDisciplina.cadastrar(professorDisciplina);
 
            if (id_professor_disciplina != null) {
                jsp = VisualizarProfessorDisciplina.execute(request);
            } else {
                String erro = "Não foi possível gravar esse registro!";
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
