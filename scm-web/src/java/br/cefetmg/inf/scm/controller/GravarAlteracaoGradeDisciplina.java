package controle.gravar_alteracao;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.model.service.impl.*;
import br.cefetmg.inf.scm.controller.*;
import javax.servlet.http.HttpServletRequest;

public class GravarAlteracaoGradeDisciplina {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            /* Obtem-se os parâmetros do request e os tranforma em variáveis */
            Integer id_grade_disciplina = Integer.parseInt(request.getParameter("id_grade_disciplina"));
            
            // Cria-se um objeto da respectiva Entidade.
            GradeDisciplina gradeD = new GradeDisciplina();

            // Faz-se o(s) Set(s) repsectivos. 
            gradeD.setId(id_grade_disciplina);
            
            // Nesse caso tem de se pegar um/uns objeto(s) criado(s) dentro do projeto...
            IManterGradeCurricular manterGradeCurricular = new ManterGradeCurricular();
            Integer id_grade = Integer.parseInt(request.getParameter("id_grade_curricular"));
            GradeCurricular gradeC = manterGradeCurricular.buscarPorId(id_grade);

            IManterDisciplina manterDisciplina = new ManterDisciplina();
            Integer id_disciplina = Integer.parseInt(request.getParameter("id_disciplina"));
            Disciplina disciplina = manterDisciplina.buscarPorId(id_disciplina);

            // Para, enfim atribuí-lo(s) a outro.
            gradeD.setDisciplina(disciplina);
            gradeD.setGradeCurricular(gradeC);

            // Pesquisa pela Entidade
            IManterGradeDisciplina manterGradeDisciplina = new ManterGradeDisciplina();
            boolean updated = manterGradeDisciplina.alterar(gradeD);

            if (updated == true) {
                jsp = VisualizarGradeDisciplina.execute(request);
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