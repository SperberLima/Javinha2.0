package controle.gravar_alteracao;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.model.service.impl.*;
import br.cefetmg.inf.scm.controller.*;
import javax.servlet.http.HttpServletRequest;

public class GravarAlteracaoProfessorDisciplina {

    public static String execute(HttpServletRequest request) {
        String jsp = "";

        try {
            /* Obtem-se os parâmetros do request e os tranforma em variáveis */
            Integer id_professor_disciplina = Integer.parseInt(request.getParameter("id_professor_disciplina"));
            
            // Cria-se um objeto da respectiva Entidade.
            ProfessorDisciplina professor_disciplina = new ProfessorDisciplina();

            // Faz-se o(s) Set(s) repsectivos. 
            professor_disciplina.setId(id_professor_disciplina);
            
            // Nesse caso tem de se pegar um/uns objeto(s) criado(s) dentro do projeto...
            IManterDisciplina manterDisciplina = new ManterDisciplina();
            Integer id_disciplina = Integer.parseInt(request.getParameter("id_disciplina"));
            Disciplina disciplina = manterDisciplina.buscarPorId(id_disciplina);

            IManterProfessor manterProfessor = new ManterProfessor();
            Integer id_professor = Integer.parseInt(request.getParameter("id_professor"));
            Professor professor = manterProfessor.buscarPorId(id_professor);

            // Para, enfim atribuí-lo(s) a outro.
            professor_disciplina.setProfessor(professor);
            professor_disciplina.setDisciplina(disciplina);

            // Pesquisa pela Entidade
            IManterProfessorDisciplina manterProfessorDisciplina = new ManterProfessorDisciplina();
            boolean updated = manterProfessorDisciplina.alterar(professor_disciplina);

            if (updated == true) {
                jsp = VisualizarProfessorDisciplina.execute(request);
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
