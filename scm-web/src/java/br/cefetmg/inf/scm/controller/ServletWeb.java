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
        
        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response); 
        
    }    
}

