/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.cadastrar;

import br.cefetmg.inf.model.domain.AmbienteAprendizagem;
import br.cefetmg.inf.model.domain.UnidadeEnsino;
import br.cefetmg.inf.model.service.IManterUnidadeEnsino;
import br.cefetmg.inf.model.service.IManterAmbienteAprendizagem;
import br.cefetmg.inf.model.service.impl.ManterAmbienteAprendizagem;
import br.cefetmg.inf.model.service.impl.ManterUnidadeEnsino;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ambiente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{        
            IManterAmbienteAprendizagem manterAmbiente = (IManterAmbienteAprendizagem) new ManterAmbienteAprendizagem();
            IManterUnidadeEnsino manterUnidade = new ManterUnidadeEnsino();

            AmbienteAprendizagem ambiente = new AmbienteAprendizagem();
            UnidadeEnsino unidade = manterUnidade.buscarPorId(Integer.parseInt(request.getParameter("unidadeensino")));

            ambiente.setId(Integer.parseInt(request.getParameter("id")));
            ambiente.setDescricao(request.getParameter("descricao"));
            ambiente.setCapacidade(Integer.parseInt(request.getParameter("capacidade")));
            ambiente.setSala(Integer.parseInt(request.getParameter("capacidade")));
            ambiente.setU_ensino(unidade);
            manterAmbiente.cadastrar(ambiente);
            request.getRequestDispatcher("../../verambiente.jsp").forward(null, null);
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
