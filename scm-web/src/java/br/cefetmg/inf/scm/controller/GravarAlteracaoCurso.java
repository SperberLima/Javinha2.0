package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.model.service.impl.*;
import br.cefetmg.inf.scm.controller.*;
import javax.servlet.http.HttpServletRequest;

public class GravarAlteracaoCurso {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Integer id_curso = Integer.parseInt(request.getParameter("id_curso"));
            String tipo = request.getParameter("tipo"),
                    nome = request.getParameter("nome"),
                    sigla = request.getParameter("sigla");

            IManterDepartamento dpto = new ManterDepartamento();
            Integer id_dpto = Integer.parseInt(request.getParameter("id_dpto"));
            Departamento departamento = dpto.buscarPorId(id_dpto);

            Curso curso = new Curso();
            curso.setId(id_curso);
            curso.setNome(nome);
            curso.setSigla(sigla);
            curso.setTipo(tipo);
            curso.setDpto(departamento);

            IManterCurso manterCurso = new ManterCurso();
            boolean updated = manterCurso.alterar(curso);

            if (updated == true) {
                jsp = VisualizarCurso.execute(request);
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
