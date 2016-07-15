package controle.gravar_alteracao;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.model.service.impl.*;
import br.cefetmg.inf.scm.controller.*;
import javax.servlet.http.HttpServletRequest;

public class GravarAlteracaoTurma {

    public static String execute(HttpServletRequest request) {
        String jsp = "";

        try {
            /* Obtem-se os parâmetros do request e os tranforma em variáveis */
            Integer id_turma = Integer.parseInt(request.getParameter("id_turma"));
            String nome = request.getParameter("nome");
            
            // Cria-se um objeto da respectiva Entidade.
            Turma turma = new Turma ();

            // Faz-se o(s) Set(s) repsectivos. 
            turma.setId(id_turma);
            turma.setNome(nome);
            
            // Nesse caso tem de se pegar um/uns objeto(s) criado(s) dentro do projeto...
            IManterCurriculoOferta manterCurriculoOferta = new ManterCurriculoOferta();
            Integer id_CurriculoOferta = Integer.parseInt(request.getParameter("id_curriculo_oferta"));
            CurriculoOferta curriculoOferta = manterCurriculoOferta.buscarPorId(id_CurriculoOferta);

            // Para, enfim atribuí-lo(s) a outro.
            turma.setCurriculoOferta(curriculoOferta);
            // Pesquisa pela Entidade
            IManterTurma manterTurma = new ManterTurma();
            boolean updated = manterTurma.alterar(turma);

            if (updated == true) {
                jsp = VisualizarTurma.execute(request);
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
