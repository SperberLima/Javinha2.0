package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.impl.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.scm.controller.*;
import javax.servlet.http.HttpServletRequest;

public class GravarAlteracaoUnidadeEnsino {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            /* Obtem-se os parâmetros do request e os tranforma em variáveis */
            Integer id_unidade = Integer.parseInt(request.getParameter("id_unidade"));
            String cep = request.getParameter("cep"),
                    email = request.getParameter("email"),
                    nome = request.getParameter("nome"),
                    sigla = request.getParameter("sigla"),
                    site = request.getParameter("site"),
                    telefone = request.getParameter("telefone");

            // Cria-se um objeto da respectiva Entidade.
            UnidadeEnsino unidade = new UnidadeEnsino ();

            // Faz-se o(s) Set(s) repsectivos. 
            unidade.setId(id_unidade);
            unidade.setCEP(cep);
            unidade.setEmail(email);
            unidade.setNome(nome);
            unidade.setSigla(sigla);
            unidade.setSite(site);
            unidade.setTelefone(telefone);
            
            // Pesquisa pela Entidade
            IManterUnidadeEnsino manterUnidadeEnsino = new ManterUnidadeEnsino();
            boolean updated = manterUnidadeEnsino.alterar(unidade);

            if (updated == true) {
                jsp = VisualizarUnidade.execute(request);
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
