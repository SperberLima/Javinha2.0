package br.cefetmg.inf.scm.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletWeb extends HttpServlet {
    private String jsp = "";
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");
        
        if(acao.equals("Logar"))
            jsp = Login.execute(request);
        else if (acao.equals("VisualizarAmbienteAprendizagem"))
            jsp = VisualizarAmbiente.execute(request);
        else if (acao.equals("VisualizarCurso"))
            jsp = VisualizarCurso.execute(request); 
        else if (acao.equals("VisualizarCurriculoOferta"))
            jsp = VisualizarCurriculoOferta.execute(request);
        else if (acao.equals("VisualizarDepartamento"))
            jsp = VisualizarDepartamento.execute(request);
        else if (acao.equals("VisualizarDisciplina"))
            jsp = VisualizarDisciplina.execute(request);
        else if (acao.equals("VisualizarTurma"))
            jsp = VisualizarTurma.execute(request);
        else if (acao.equals("VisualizarProfessor"))
            jsp = VisualizarProfessor.execute(request);
        else if (acao.equals("VisualizarHorario"))
            jsp = VisualizarHorario.execute(request);
        else if (acao.equals("VisualizarUnidade"))
            jsp = VisualizarUnidade.execute(request);
        else if (acao.equals("VisualizarPeriodo"))
            jsp = VisualizarPeriodo.execute(request);
        else if (acao.equals("VisualizarProfessorDisciplina"))
            jsp = VisualizarProfessorDisciplina.execute(request);
        else if (acao.equals("VisualizarGradeCurricular"))
            jsp = VisualizarGradeCurricular.execute(request);
        else if (acao.equals("VisualizarGradeDisciplina"))
            jsp = VisualizarGradeDisciplina.execute(request);
        else if (acao.equals("AlterarAmbiente"))
            jsp = AlterarAmbiente.execute(request);
        else if (acao.equals("AlterarCurriculoOferta"))
            jsp = AlterarCurriculoOferta.execute(request);
        else if (acao.equals("AlterarCurso"))
            jsp = AlterarCurso.execute(request);
        else if (acao.equals("AlterarDisciplina"))
            jsp = AlterarDisciplina.execute(request);
        else if (acao.equals("AlterarDepartamento"))
            jsp = AlterarDepartamento.execute(request);
        else if (acao.equals("AlterarGradeCurricular"))
            jsp = AlterarGradeCurricular.execute(request);
        else if (acao.equals("AlterarGradeDisciplina"))
            jsp = AlterarGradeDisciplina.execute(request);
        else if (acao.equals("AlterarHorario"))
            jsp = AlterarHorario.execute(request);
        else if (acao.equals("AlterarPeriodo"))
            jsp = AlterarPeriodo.execute(request);
        else if (acao.equals("AlterarProfessor"))
            jsp = AlterarProfessor.execute(request);
        else if (acao.equals("AlterarProfessorDisciplina"))
            jsp = AlterarProfessorDisciplina.execute(request);
        else if (acao.equals("AlterarTurma"))
            jsp = AlterarTurma.execute(request);
        else if (acao.equals("AlterarUnidade"))
            jsp = AlterarUnidade.execute(request);
        else if (acao.equals("GravarAlteracaoAmbienteAprendizagem"))
            jsp = GravarAlteracaoAmbienteAprendizagem.execute(request);
        else if (acao.equals("GravarAlteracaoCurriculoOferta"))
            jsp = GravarAlteracaoCurriculoOferta.execute(request);
        else if (acao.equals("GravarAlteracaoCurso"))
            jsp = GravarAlteracaoCurso.execute(request);
        else if (acao.equals("GravarAlteracaoDepartamento"))
            jsp = GravarAlteracaoDepartamento.execute(request);
        else if (acao.equals("GravarAlteracaoDisciplina"))
            jsp = GravarAlteracaoDisciplina.execute(request);
        else if (acao.equals("GravarAlteracaoGradeCurricular"))
            jsp = GravarAlteracaoGradeCurricular.execute(request);
        else if (acao.equals("GravarAlteracaoGradeDisciplina"))
            jsp = GravarAlteracaoGradeDisciplina.execute(request);
        else if (acao.equals("GravarAlteracaoHorario"))
            jsp = GravarAlteracaoHorario.execute(request);
        else if (acao.equals("GravarAlteracaoPeriodoLetivo"))
            jsp = GravarAlteracaoPeriodoLetivo.execute(request);
        else if (acao.equals("GravarAlteracaoProfessor"))
            jsp = GravarAlteracaoProfessor.execute(request);
        else if (acao.equals("GravarAlteracaoProfessorDisciplina"))
            jsp = GravarAlteracaoProfessorDisciplina.execute(request);
        else if (acao.equals("GravarAlteracaoTurma"))
            jsp = GravarAlteracaoTurma.execute(request);
        else if (acao.equals("GravarAlteracaoUnidadeEnsino"))
            jsp = GravarAlteracaoUnidadeEnsino.execute(request);
        else if (acao.equals("GravarInsercaoAmbienteAprendizagem"))
            jsp = GravarInsercaoAmbienteAprendizagem.execute(request);
        else if (acao.equals("GravarInsercaoCurriculoOferta"))
            jsp = GravarInsercaoCurriculoOferta.execute(request);
        else if (acao.equals("GravarInsercaoCurso"))
            jsp = GravarInsercaoCurso.execute(request);
        else if (acao.equals("GravarInsercaoDepartamento"))
            jsp = GravarInsercaoDepartamento.execute(request);
        else if (acao.equals("GravarInsercaoDisciplina"))
            jsp = GravarInsercaoDisciplina.execute(request);
        else if (acao.equals("GravarInsercaoGradeCurricular"))
            jsp = GravarInsercaoGradeCurricular.execute(request);
        else if (acao.equals("GravarInsercaoGradeDisciplina"))
            jsp = GravarInsercaoGradeDisciplina.execute(request);
        else if (acao.equals("GravarInsercaoHorario"))
            jsp = GravarInsercaoHorario.execute(request);
        else if (acao.equals("GravarInsercaoPeriodoLetivo"))
            jsp = GravarInsercaoPeriodoLetivo.execute(request);
        else if (acao.equals("GravarInsercaoProfessor"))
            jsp = GravarInsercaoProfessor.execute(request);
        else if (acao.equals("GravarInsercaoProfessorDisciplina"))
            jsp = GravarInsercaoProfessorDisciplina.execute(request);
        else if (acao.equals("GravarInsercaoTurma"))
            jsp = GravarInsercaoTurma.execute(request);
        else if (acao.equals("GravarInsercaoUnidadeEnsino"))
            jsp = GravarInsercaoUnidadeEnsino.execute(request);
        else if (acao.equals("ExcluirAmbienteAprendizagem"))
            jsp = ExcluirAmbiente.execute(request);
        else if (acao.equals("ExcluirCurriculoOferta"))
            jsp = ExcluirCurriculoOferta.execute(request);
        else if (acao.equals("ExcluirCurso"))
            jsp = ExcluirCurso.execute(request);
        else if (acao.equals("ExcluirDepartamento"))
            jsp = ExcluirDepartamento.execute(request);
        else if (acao.equals("ExcluirDisciplina"))
            jsp = ExcluirDisciplina.execute(request);
        else if (acao.equals("ExcluirHorario"))
            jsp = ExcluirHorario.execute(request);
        else if (acao.equals("ExcluirPeriodoLetivo"))
            jsp = ExcluirPeriodo.execute(request);
        else if (acao.equals("ExcluirGradeDisciplina"))
            jsp = ExcluirGradeDisciplina.execute(request);
        else if (acao.equals("ExcluirGradeCurricular"))
            jsp = ExcluirGradeCurricular.execute(request);
        else if (acao.equals("ExcluirProfessor"))
            jsp = ExcluirProfessor.execute(request);
        else if (acao.equals("ExcluirProfessorDisciplina"))
            jsp = ExcluirProfessorDisciplina.execute(request);
        else if (acao.equals("ExcluirTurma"))
            jsp = ExcluirTurma.execute(request);
        else if (acao.equals("ExcluirUnidadeEnsino"))
            jsp = ExcluirUnidade.execute(request);
        else if (acao.equals("InserirAmbienteAprendizagem"))
            jsp = InserirAmbiente.execute(request);
        else if (acao.equals("InserirCurso"))
            jsp = InserirCurso.execute(request); 
        else if (acao.equals("InserirCurriculoOferta"))
            jsp = InserirCurriculoOferta.execute(request);
        else if (acao.equals("InserirDepartamento"))
            jsp = InserirDepartamento.execute(request);
        else if (acao.equals("InserirDisciplina"))
            jsp = InserirDisciplina.execute(request);
        else if (acao.equals("InserirTurma"))
            jsp = InserirTurma.execute(request);
        else if (acao.equals("InserirProfessor"))
            jsp = InserirProfessor.execute(request);
        else if (acao.equals("InserirHorario"))
            jsp = InserirHorario.execute(request);
        else if (acao.equals("InserirUnidade"))
            jsp = InserirUnidadeEnsino.execute(request);
        else if (acao.equals("InserirPeriodo"))
            jsp = InserirPeriodoLetivo.execute(request);
        else if (acao.equals("InserirProfessorDisciplina"))
            jsp = InserirProfessorDisciplina.execute(request);
        else if (acao.equals("InserirGradeCurricular"))
            jsp = InserirGradeCurricular.execute(request);
        else if (acao.equals("InserirGradeDisciplina"))
            jsp = InserirGradeDisciplina.execute(request);


        
        
        
        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response); 
        
    }    
}

