package controle.gravar_alteracao;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.model.service.impl.*;
import br.cefetmg.inf.scm.controller.*;
import javax.servlet.http.HttpServletRequest;

public class GravarAlteracaoProfessor {

    public static String execute(HttpServletRequest request) {
        String jsp = "";

        try {
            /* Obtem-se os parâmetros do request e os tranforma em variáveis */
            Integer id_periodo = Integer.parseInt(request.getParameter("id_periodo"));
            String descricao = request.getParameter("descricao"),
                    nome = request.getParameter("nome"),
                    telefone = request.getParameter("telefone"),
                    cpf = request.getParameter("cpf");

            // Cria-se um objeto da respectiva Entidade.
            Professor professor = new Professor();

            // Faz-se o(s) Set(s) repsectivos. 
            professor.setId(id_periodo);
            professor.setDescricao(descricao);
            professor.setCPF(cpf);
            professor.setNome(nome);
            professor.setTelefone(telefone);

            // Nesse caso tem de se pegar um/uns objeto(s) criado(s) dentro do projeto...
            IManterDepartamento manterDpto = new ManterDepartamento();
            Integer id_departamento = Integer.parseInt(request.getParameter("departamento"));
            Departamento dpto = manterDpto.buscarPorId(id_departamento);

            // Para, enfim atribuí-lo(s) a outro.
            professor.setDpto(dpto);

            // Pesquisa pela Entidade
            IManterProfessor manterProfessor = new ManterProfessor();
            boolean updated = manterProfessor.alterar(professor);

            if (updated == true) {
                jsp = VisualizarProfessor.execute(request);
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
