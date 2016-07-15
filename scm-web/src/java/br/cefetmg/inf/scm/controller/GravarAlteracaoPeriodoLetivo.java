package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.model.service.impl.*;
import br.cefetmg.inf.scm.controller.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

public class GravarAlteracaoPeriodoLetivo {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            /* Obtem-se os parâmetros do request e os tranforma em variáveis */
            Integer id_periodo = Integer.parseInt(request.getParameter("id_periodo"));
            Date inicio = new Date(formatter.parse(request.getParameter("inicio")).getTime());           
            Date fim = new Date(formatter.parse(request.getParameter("fim")).getTime());
            String descricao = request.getParameter("descricao");
            
            // Cria-se um objeto da respectiva Entidade.
            PeriodoLetivo periodo = new PeriodoLetivo();

            // Faz-se o(s) Set(s) repsectivos. 
            periodo.setId(id_periodo);
            periodo.setDescricao(descricao);
            periodo.setInicio(inicio);
            periodo.setFim(fim);
            
            // Pesquisa pela Entidade
            IManterPeriodoLetivo manterPeriodoLetivo = new ManterPeriodoLetivo();
            boolean updated = manterPeriodoLetivo.alterar(periodo);

            if (updated == true) {
                jsp = VisualizarPeriodo.execute(request);
            } else {
                String erro = "Nao foi possivel gravar a alteracao desse registro";
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
