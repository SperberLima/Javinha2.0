/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.cadastro;

import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.service.IManterDepartamento;
import br.cefetmg.inf.model.service.IManterDisciplina;
import br.cefetmg.inf.model.service.impl.ManterDepartamento;
import br.cefetmg.inf.model.service.impl.ManterDisciplina;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class disciplinas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{        
            IManterDisciplina manterDisciplina = (IManterDisciplina) new ManterDisciplina();
            IManterDepartamento manterDepartamento = new ManterDepartamento();

            Disciplina disciplina = new Disciplina();
            Departamento departamento = manterDepartamento.buscarPorId(Integer.parseInt(request.getParameter("departamento")));
            disciplina.setId(Integer.parseInt(request.getParameter("id")));
            disciplina.setNome(request.getParameter("nome"));
            disciplina.setCargaHoraria(Integer.parseInt(request.getParameter("carga")));
            disciplina.setEmenta(request.getParameter("ementa"));
            disciplina.setDepartamento(departamento);
            manterDisciplina.cadastrar(disciplina);
            request.getRequestDispatcher("../../verdisciplina.jsp").forward(null, null);
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
