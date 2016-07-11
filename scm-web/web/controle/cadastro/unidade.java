/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.cadastro;

import br.cefetmg.inf.model.domain.UnidadeEnsino;
import br.cefetmg.inf.model.service.IManterUnidadeEnsino;
import br.cefetmg.inf.model.service.impl.ManterUnidadeEnsino;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class unidade extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{        
            IManterUnidadeEnsino manterUnidade = (IManterUnidadeEnsino) new ManterUnidadeEnsino();

            UnidadeEnsino unidade = new UnidadeEnsino();

            unidade.setId(Integer.parseInt(request.getParameter("id")));
            unidade.setCEP(request.getParameter("cep"));
            unidade.setEmail(request.getParameter("email"));
            unidade.setSigla(request.getParameter("sigla"));
            unidade.setNome(request.getParameter("nome"));
            unidade.setSite(request.getParameter("site"));
            unidade.setTelefone(request.getParameter("telefone"));
            
            manterUnidade.cadastrar(unidade);
            request.getRequestDispatcher("../../verunidade.jsp").forward(null, null);
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
