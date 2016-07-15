package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.model.service.impl.*;
import br.cefetmg.inf.scm.controller.*;
import javax.servlet.http.HttpServletRequest;

public class GravarAlteracaoDepartamento {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            /* Obtem-se os parâmetros do request e os tranforma em variáveis */
            Integer id_dpto = Integer.parseInt(request.getParameter("id_dpto"));
            String cep = request.getParameter("cep"),
                    email = request.getParameter("email"),
                    nome = request.getParameter("nome"),
                    sigla = request.getParameter("sigla"),
                    site = request.getParameter("site"),
                    telefone = request.getParameter("telefone");

            // Cria-se um objeto da respectiva Entidade.
            Departamento dpto = new Departamento();

            // Faz-se o(s) Set(s) repsectivos. 
            dpto.setId(id_dpto);
            dpto.setCEP(cep);
            dpto.setEmail(email);
            dpto.setNome(nome);
            dpto.setSigla(sigla);
            dpto.setSite(site);
            dpto.setTelefone(telefone);

            // Nesse caso tem de se pegar um/uns objeto(s) criado(s) dentro do projeto...
            IManterUnidadeEnsino UE = new ManterUnidadeEnsino();
            Integer id_ensino = Integer.parseInt(request.getParameter("id_ensino"));
            UnidadeEnsino u_ensino = UE.buscarPorId(id_ensino);

            // Para, enfim atribuí-lo(s) a outro.
            dpto.setUnidadeEnsino(u_ensino);

            // Pesquisa pela Entidade
            IManterDepartamento manterDepartamento = new ManterDepartamento();
            boolean updated = manterDepartamento.alterar(dpto);

            if (updated == true) {
                jsp = VisualizarDepartamento.execute(request);
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
