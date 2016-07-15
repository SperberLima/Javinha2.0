package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.model.service.impl.*;
import br.cefetmg.inf.scm.controller.*;
import javax.servlet.http.HttpServletRequest;

public class GravarAlteracaoAmbienteAprendizagem {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            /* Obtem-se os parâmetros do request e os tranforma em variáveis */
            Integer id_ambiente = Integer.parseInt(request.getParameter("id_ambiente"));
            Integer nro_sala = Integer.parseInt(request.getParameter("nro_sala"));
            Integer capacidade = Integer.parseInt(request.getParameter("capacidade"));
            String descricao = request.getParameter("descricao");

            // Cria-se um objeto da respectiva Entidade.
            AmbienteAprendizagem ambiente = new AmbienteAprendizagem();

            // faz-se os Sets repsectivos. 
            ambiente.setId(id_ambiente);
            ambiente.setDescricao(descricao);
            ambiente.setSala(nro_sala);
            ambiente.setCapacidade(capacidade);

            // Nesse caso tem de pegar um objeto criado dentro do projeto...
            IManterUnidadeEnsino UE = new ManterUnidadeEnsino();
            Integer id_ensino = Integer.parseInt(request.getParameter("id_ensino"));
            UnidadeEnsino u_ensino = UE.buscarPorId(id_ensino);

            // Para, enfim atribuí-lo a outro.
            ambiente.setU_ensino(u_ensino);

            // Pesquisa pela Entidade
            IManterAmbienteAprendizagem manterAmbiente = new ManterAmbienteAprendizagem();
            boolean updated = manterAmbiente.alterar(ambiente);

            if (updated == true) {
                jsp = VisualizarAmbiente.execute(request);
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
