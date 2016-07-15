package controle.gravarinsercao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.cefetmg.inf.model.domain.Horario;
import br.cefetmg.inf.model.domain.AmbienteAprendizagem;
import br.cefetmg.inf.model.domain.Turma;
import br.cefetmg.inf.model.domain.ProfessorDisciplina;

import br.cefetmg.inf.model.service.IManterHorario;
import br.cefetmg.inf.model.service.IManterAmbienteAprendizagem;
import br.cefetmg.inf.model.service.IManterTurma;
import br.cefetmg.inf.model.service.IManterProfessorDisciplina;

import br.cefetmg.inf.model.service.impl.ManterHorario;
import br.cefetmg.inf.model.service.impl.ManterAmbienteAprendizagem;
import br.cefetmg.inf.model.service.impl.ManterTurma;
import br.cefetmg.inf.model.service.impl.ManterProfessorDisciplina;

import br.cefetmg.inf.scm.controller.VisualizarHorario;

import javax.servlet.http.HttpServletRequest;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Diego
 */
public class GravarInsercaoHorario {
       
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Integer id_ambiente_aprendizagem = Integer.parseInt(request.getParameter("ambienteAprendizagem"));
            Integer id_turma = Integer.parseInt(request.getParameter("turma"));
            Integer id_professor_disciplina = Integer.parseInt(request.getParameter("professorDisciplina"));
            Date dat_inicio = new Date(formatter.parse(request.getParameter("inicio")).getTime());           
            Date dat_fim = new Date(formatter.parse(request.getParameter("fim")).getTime());
           
            IManterAmbienteAprendizagem manterAmbienteAprendizagem = new ManterAmbienteAprendizagem();
            AmbienteAprendizagem ambienteAprendizagem = manterAmbienteAprendizagem.buscarPorId(id_ambiente_aprendizagem);
            
            IManterTurma manterTurma = new ManterTurma();
            Turma turma = manterTurma.buscarPorId(id_turma);
            
            IManterProfessorDisciplina manterDisciplina = new ManterProfessorDisciplina();
            ProfessorDisciplina professorDisciplina = manterDisciplina.buscarPorId(id_professor_disciplina);
 
            Horario horario = new Horario();
            horario.setAmbiente(ambienteAprendizagem);
            horario.setTurma(turma);
            horario.setProfessorDisciplina(professorDisciplina);
            horario.setInicio(dat_inicio);
            horario.setFim(dat_fim);
 
            IManterHorario manterHorario = new ManterHorario();
            Integer id_curriculo = manterHorario.cadastrar(horario);
 
            if (id_curriculo != null) {
                jsp = VisualizarHorario.execute(request);
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
