/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.CurriculoOferta;
import br.cefetmg.inf.model.domain.GradeCurricular;
import br.cefetmg.inf.model.service.IManterCurriculoOferta;
import br.cefetmg.inf.model.service.IManterGradeCurricular;
import br.cefetmg.inf.model.service.impl.ManterCurriculoOferta;
import br.cefetmg.inf.model.service.impl.ManterGradeCurricular;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrador
 */
public class AlterarCurriculoOferta {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o codCurriculo que se deseja alterar
            String codCurriculo = request.getParameter("id");

            IManterCurriculoOferta manterCurriculoOferta = new ManterCurriculoOferta();
            CurriculoOferta CurriculoOferta = manterCurriculoOferta.buscarPorId(Integer.parseInt(codCurriculo));
            if(CurriculoOferta != null){
                request.setAttribute("curriculo", CurriculoOferta);
                
                IManterGradeCurricular manterGradeCurricular = new ManterGradeCurricular();
                List<GradeCurricular> listGradeCurricular = manterGradeCurricular.listarTodos();
                request.setAttribute("listGrade", listGradeCurricular);
                
                jsp = "/alterar/curriculo.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Curriculo!";
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
