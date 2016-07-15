package controle.gravar_alteracao;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.model.service.impl.*;
import br.cefetmg.inf.scm.controller.*;
import javax.servlet.http.HttpServletRequest;

public class GravarAlteracaoCurriculoOferta {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            /* Obtem-se os parâmetros do request e os tranforma em variáveis */
            Integer id_ambiente = Integer.parseInt(request.getParameter("id_curriculo_oferta"));

            // Cria-se um objeto da respectiva Entidade.
            CurriculoOferta curriculo = new CurriculoOferta();

            // Faz-se o(s) Set(s) repsectivos. 
            curriculo.setId(id_ambiente);

            // Nesse caso tem de se pegar um/uns objeto(s) criado(s) dentro do projeto...
            IManterGradeCurricular manterGradeC = new ManterGradeCurricular();
            Integer id_grade = Integer.parseInt(request.getParameter("id_grade_curricular"));
            GradeCurricular gradeCurricular = manterGradeC.buscarPorId(id_grade);

            IManterPeriodoLetivo manterPeriodo = new ManterPeriodoLetivo();
            Integer id_periodo = Integer.parseInt(request.getParameter("id_periodo"));
            PeriodoLetivo periodoLetivo = manterPeriodo.buscarPorId(id_grade);

            // Para, enfim atribuí-lo(s) a outro.
            curriculo.setGradeCurricular(gradeCurricular);
            curriculo.setPeriodoLetivo(periodoLetivo);

            // Pesquisa pela Entidade
            IManterCurriculoOferta manterCurriculoO = new ManterCurriculoOferta();
            boolean updated = manterCurriculoO.alterar(curriculo);

            if (updated == true) {
                jsp = VisualizarCurriculoOferta.execute(request);
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
