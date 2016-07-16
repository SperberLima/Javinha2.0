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
public class InserirHorario {
                  
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterAmbienteAprendizagem manterAmbiente = new ManterAmbienteAprendizagem();
            List<AmbienteAprendizagem> listAmbiente = manterAmbiente.listarTodos();
            
            IManterProfessor manterProfessor = new ManterProfessor();
            List<Professor> listProfessor = manterProfessor.listarTodos();
            
            IManterTurma manterTurma = new ManterTurma();
            List<Turma> listTurma = manterTurma.listarTodos();

            if (listAmbiente != null && listProfessor!=null && listTurma != null) {
                request.setAttribute("listAmbiente", listAmbiente);
                request.setAttribute("listTurma", listTurma);
                request.setAttribute("listProfessor", listProfessor);
                jsp = "/cadastrar/horario.jsp";
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