/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.cadastro;

import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.domain.UnidadeEnsino;
import br.cefetmg.inf.model.service.IManterDepartamento;
import br.cefetmg.inf.model.service.IManterUnidadeEnsino;
import br.cefetmg.inf.model.service.impl.ManterDepartamento;
import br.cefetmg.inf.model.service.impl.ManterUnidadeEnsino;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class departamento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{        
            IManterDepartamento manterDepartamento = (IManterDepartamento) new ManterDepartamento();
            IManterUnidadeEnsino manterUnidade = new ManterUnidadeEnsino();

            Departamento departamento = new Departamento();
            UnidadeEnsino unidade = manterUnidade.buscarPorId(Integer.parseInt(request.getParameter("unidadeensino")));

            departamento.setId(Integer.parseInt(request.getParameter("id")));
            departamento.setCEP(request.getParameter("cep"));
            departamento.setEmail(request.getParameter("email"));
            departamento.setSigla(request.getParameter("sigla"));
            departamento.setNome(request.getParameter("nome"));
            departamento.setSite(request.getParameter("site"));
            departamento.setTelefone(request.getParameter("telefone"));
            
            departamento.setUnidadeEnsino(unidade);
            manterDepartamento.cadastrar(departamento);
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
