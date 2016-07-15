/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.AmbienteAprendizagem;
import br.cefetmg.inf.model.domain.Horario;
import br.cefetmg.inf.model.service.IManterAmbienteAprendizagem;
import br.cefetmg.inf.model.service.IManterHorario;
import br.cefetmg.inf.model.service.impl.ManterAmbienteAprendizagem;
import br.cefetmg.inf.model.service.impl.ManterHorario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrador
 */
public class AlterarHorario {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o codHorario que se deseja alterar
            String codHorario = request.getParameter("id");

            IManterHorario manterHorario = new ManterHorario();
            Horario Horario = manterHorario.buscarPorId(Integer.parseInt(codHorario));
            if(Horario != null){
                request.setAttribute("horario", Horario);
                
                IManterAmbienteAprendizagem manterAmbienteAprendizagem = new ManterAmbienteAprendizagem();
                List<AmbienteAprendizagem> listAmbienteAprendizagem = manterAmbienteAprendizagem.listarTodos();
                request.setAttribute("listAmbiente", listAmbienteAprendizagem);
                
                jsp = "/alterar/horario.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Horario!";
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
