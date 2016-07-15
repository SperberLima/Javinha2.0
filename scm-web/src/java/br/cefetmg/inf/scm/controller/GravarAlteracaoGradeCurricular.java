package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.model.service.impl.*;
import br.cefetmg.inf.scm.controller.*;
import javax.servlet.http.HttpServletRequest;

public class GravarAlteracaoGradeCurricular {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            /* Obtem-se os parâmetros do request e os tranforma em variáveis */
            Integer id_grade = Integer.parseInt(request.getParameter("id_grade"));
            String  descricao = request.getParameter("descricao");
            Integer serie = Integer.parseInt(request.getParameter("cargahoraria"));

            // Cria-se um objeto da respectiva Entidade.
            GradeCurricular grade = new GradeCurricular();

            // Faz-se o(s) Set(s) repsectivos. 
            grade.setId(id_grade);
            grade.setDescricao(descricao);
            grade.setSerie(serie);

            // Nesse caso tem de se pegar um/uns objeto(s) criado(s) dentro do projeto...
            IManterCurso manterCurso = new ManterCurso();
            Integer id_curso = Integer.parseInt(request.getParameter("id_curso"));
            Curso curso = manterCurso.buscarPorId(id_curso);

            // Para, enfim atribuí-lo(s) a outro.
            grade.setCurso(curso);

            // Pesquisa pela Entidade
            IManterGradeCurricular manterGradeCurricular = new ManterGradeCurricular();
            boolean updated = manterGradeCurricular.alterar(grade);

            if (updated == true) {
                jsp = VisualizarGradeCurricular.execute(request);
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
