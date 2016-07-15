package controle.gravarinsercao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.cefetmg.inf.model.domain.CurriculoOferta;
import br.cefetmg.inf.model.domain.PeriodoLetivo;
import br.cefetmg.inf.model.domain.GradeCurricular;

import br.cefetmg.inf.model.service.IManterCurriculoOferta;
import br.cefetmg.inf.model.service.IManterPeriodoLetivo;
import br.cefetmg.inf.model.service.IManterGradeCurricular;

import br.cefetmg.inf.model.service.impl.ManterCurriculoOferta;
import br.cefetmg.inf.model.service.impl.ManterPeriodoLetivo;
import br.cefetmg.inf.model.service.impl.ManterGradeCurricular;

import br.cefetmg.inf.scm.controller.VisualizarCurriculoOferta;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Diego
 */
public class GravarInsercaoCurriculoOferta {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Integer id_periodo_letivo = Integer.parseInt(request.getParameter("periodoLetivo"));
            Integer id_grade_curricular = Integer.parseInt(request.getParameter("gradeCurricular"));
           
            IManterPeriodoLetivo manterPeriodoLetivo = new ManterPeriodoLetivo();
            PeriodoLetivo periodoLetivo = manterPeriodoLetivo.buscarPorId(id_periodo_letivo);
            
            IManterGradeCurricular manterGradeCurricular = new ManterGradeCurricular();
            GradeCurricular gradeCurricular = manterGradeCurricular.buscarPorId(id_grade_curricular);
 
            CurriculoOferta curriculoOferta = new CurriculoOferta();
            curriculoOferta.setPeriodoLetivo(periodoLetivo);
            curriculoOferta.setGradeCurricular(gradeCurricular);
 
            IManterCurriculoOferta manterCurriculoOferta = new ManterCurriculoOferta();
            Integer id_curriculo = manterCurriculoOferta.cadastrar(curriculoOferta);
 
            if (id_curriculo != null) {
                jsp = VisualizarCurriculoOferta.execute(request);
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
