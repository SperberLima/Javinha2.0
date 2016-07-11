/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.cadastro;

import br.cefetmg.inf.model.domain.Curso;
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.domain.UnidadeEnsino;
import br.cefetmg.inf.model.service.IManterCurso;
import br.cefetmg.inf.model.service.IManterDepartamento;
import br.cefetmg.inf.model.service.IManterUnidadeEnsino;
import br.cefetmg.inf.model.service.impl.ManterCurso;
import br.cefetmg.inf.model.service.impl.ManterDepartamento;
import br.cefetmg.inf.model.service.impl.ManterUnidadeEnsino;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class curso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{        
            IManterCurso manterCurso = (IManterCurso) new ManterCurso();
            IManterDepartamento manterDepartamento = new ManterDepartamento();

            Curso curso = new Curso();
            Departamento departamento = manterDepartamento.buscarPorId(Integer.parseInt(request.getParameter("departamento")));

            curso.setId(Integer.parseInt(request.getParameter("id")));
            curso.setSigla(request.getParameter("sigla"));
            curso.setNome(request.getParameter("nome"));
            curso.setGrades(null);
            
            curso.setDpto(departamento);
            manterCurso.cadastrar(curso);
            request.getRequestDispatcher("../../verdepartamento.jsp").forward(null, null);
        }catch(Exception e){
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

