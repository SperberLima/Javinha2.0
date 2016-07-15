/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.domain.Professor;
import br.cefetmg.inf.model.service.IManterDepartamento;
import br.cefetmg.inf.model.service.IManterProfessor;
import br.cefetmg.inf.model.service.impl.ManterDepartamento;
import br.cefetmg.inf.model.service.impl.ManterProfessor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrador
 */
public class AlterarProfessor {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o codProfessor que se deseja alterar
            String codProfessor = request.getParameter("id");

            IManterProfessor manterProfessor = new ManterProfessor();
            Professor Professor = manterProfessor.buscarPorId(Integer.parseInt(codProfessor));
            if(Professor != null){
                request.setAttribute("professor", Professor);
                
                IManterDepartamento manterDepartamento = new ManterDepartamento();
                List<Departamento> listDepartamento = manterDepartamento.listarTodos();
                request.setAttribute("listDepartamento", listDepartamento);
                
                jsp = "/alterar/horario.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Professor!";
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
