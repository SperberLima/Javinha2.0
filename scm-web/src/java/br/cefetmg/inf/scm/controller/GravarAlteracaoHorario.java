package br.cefetmg.inf.scm.controller;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.model.service.impl.*;
import br.cefetmg.inf.scm.controller.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

public class GravarAlteracaoHorario {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            /* Obtem-se os parâmetros do request e os tranforma em variáveis */
            Integer id_horario = Integer.parseInt(request.getParameter("id_horario"));
            Date inicio = new Date(formatter.parse(request.getParameter("inicio")).getTime());           
            Date fim = new Date(formatter.parse(request.getParameter("fim")).getTime());
           
            // Cria-se um objeto da respectiva Entidade.
            Horario horario = new Horario();

            // Faz-se o(s) Set(s) repsectivos. 
            horario.setId(id_horario);
            horario.setInicio(inicio);
            horario.setFim(fim);
            
            // Nesse caso tem de se pegar um/uns objeto(s) criado(s) dentro do projeto...
            IManterTurma manterTurma = new ManterTurma();
            Integer id_turma = Integer.parseInt(request.getParameter("id_turma"));
            Turma turma = manterTurma.buscarPorId(id_turma);
            
            IManterProfessorDisciplina manterProfessorDisciplina = new ManterProfessorDisciplina();
            Integer id_professor_disciplina = Integer.parseInt(request.getParameter("id_grade_curricular"));
            ProfessorDisciplina professorDisciplina = manterProfessorDisciplina.buscarPorId(id_professor_disciplina);

            IManterAmbienteAprendizagem manterAmbiente = new ManterAmbienteAprendizagem();
            Integer id_ambiente = Integer.parseInt(request.getParameter("id_ambiente"));
            AmbienteAprendizagem ambiente = manterAmbiente.buscarPorId(id_ambiente);

            // Para, enfim atribuí-lo(s) a outro.
            horario.setTurma(turma);
            horario.setProfessorDisciplina(professorDisciplina);
            horario.setAmbiente(ambiente);

            // Pesquisa pela Entidade
            IManterHorario manterHorario = new ManterHorario();
            boolean updated = manterHorario.alterar(horario);

            if (updated == true) {
                jsp = VisualizarHorario.execute(request);
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
