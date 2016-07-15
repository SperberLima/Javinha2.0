/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.domain.Professor;
import br.cefetmg.inf.model.domain.ProfessorDisciplina;
import br.cefetmg.inf.model.service.IManterDisciplina;
import br.cefetmg.inf.model.service.IManterProfessor;
import br.cefetmg.inf.model.service.IManterProfessorDisciplina;
import br.cefetmg.inf.model.service.impl.ManterDisciplina;
import br.cefetmg.inf.model.service.impl.ManterProfessor;
import br.cefetmg.inf.model.service.impl.ManterProfessorDisciplina;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrador
 */
public class AlterarProfessorDisciplina {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o codProfessorDisciplina que se deseja alterar
            String codProfessorDisciplina = request.getParameter("id");

            IManterProfessorDisciplina manterProfessorDisciplina = new ManterProfessorDisciplina();
            ProfessorDisciplina ProfessorDisciplina = manterProfessorDisciplina.buscarPorId(Integer.parseInt(codProfessorDisciplina));
            if(ProfessorDisciplina != null){
                request.setAttribute("professordisciplina", ProfessorDisciplina);
                
                IManterProfessor manterProfessor = new ManterProfessor();
                List<Professor> listProfessor = manterProfessor.listarTodos();
                request.setAttribute("listProfessor", listProfessor);
                
                IManterDisciplina manterDisciplina = new ManterDisciplina();
                List<Disciplina> listDisciplina = manterDisciplina.listarTodos();
                request.setAttribute("listDisciplina", listDisciplina);
                
                jsp = "/alterar/professordisciplina.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Professor-Disciplina!";
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
