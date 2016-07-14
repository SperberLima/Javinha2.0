package controle.gravarinsercao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.cefetmg.inf.model.domain.UnidadeEnsino;
import br.cefetmg.inf.model.service.IManterUnidadeEnsino;
import br.cefetmg.inf.model.service.impl.ManterUnidadeEnsino;

import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Diego
 */
public class GravarInsercaoUnidadeEnsino {
                      
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {          
            String sigla = request.getParameter("sigla");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            String cep = request.getParameter("cep");
            String site = request.getParameter("site");
 
            UnidadeEnsino unidadeEnsino = new UnidadeEnsino();
            unidadeEnsino.setSigla(sigla);
            unidadeEnsino.setNome(nome);
            unidadeEnsino.setEmail(email);
            unidadeEnsino.setTelefone(telefone);
            unidadeEnsino.setCEP(cep);
            unidadeEnsino.setSite(site);
 
            IManterUnidadeEnsino manterUnidadeEnsino = new ManterUnidadeEnsino();
            Integer id_unidade_ensino = manterUnidadeEnsino.cadastrar(unidadeEnsino);
 
            if (id_unidade_ensino != null) {
                //jsp = ListarAmbienteAprendizagem.execute(request);
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
