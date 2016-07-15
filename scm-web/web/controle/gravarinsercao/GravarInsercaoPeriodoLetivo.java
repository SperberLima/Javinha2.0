package controle.gravarinsercao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.cefetmg.inf.model.domain.PeriodoLetivo;
import br.cefetmg.inf.model.service.IManterPeriodoLetivo;
import br.cefetmg.inf.model.service.impl.ManterPeriodoLetivo;

import br.cefetmg.inf.scm.controller.VisualizarPeriodo;

import javax.servlet.http.HttpServletRequest;

import java.sql.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Diego
 */
public class GravarInsercaoPeriodoLetivo {
               
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dat_inicio = new Date(formatter.parse(request.getParameter("inicio")).getTime()); 
            Date dat_fim = new Date(formatter.parse(request.getParameter("fim")).getTime()); 
            String descricao = request.getParameter("descricao");
 
            PeriodoLetivo periodoLetivo = new PeriodoLetivo();
            periodoLetivo.setInicio(dat_inicio);
            periodoLetivo.setFim(dat_fim);
            periodoLetivo.setDescricao(descricao);
 
            IManterPeriodoLetivo manterPeriodoLetivo = new ManterPeriodoLetivo();
            Integer id_periodo_letivo = manterPeriodoLetivo.cadastrar(periodoLetivo);
 
            if (id_periodo_letivo != null) {
                jsp = VisualizarPeriodo.execute(request);
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
