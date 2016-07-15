package controle.gravarinsercao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.domain.UnidadeEnsino;

import br.cefetmg.inf.model.service.IManterDepartamento;
import br.cefetmg.inf.model.service.IManterUnidadeEnsino;

import br.cefetmg.inf.model.service.impl.ManterDepartamento;
import br.cefetmg.inf.model.service.impl.ManterUnidadeEnsino;

import br.cefetmg.inf.scm.controller.VisualizarDepartamento;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Diego
 */
public class GravarInsercaoDepartamento {
            
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String sigla = request.getParameter("sigla");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            String cep = request.getParameter("cep");
            String site = request.getParameter("site");
            Integer id_unidade_ensino = Integer.parseInt(request.getParameter("unidadeEnsino"));
            
            IManterUnidadeEnsino manterUnidadeEnsino = new ManterUnidadeEnsino();
            UnidadeEnsino unidade_ensino = manterUnidadeEnsino.buscarPorId(id_unidade_ensino);
 
            Departamento departamento = new Departamento();
            departamento.setSigla(sigla);
            departamento.setNome(nome);
            departamento.setEmail(email);
            departamento.setTelefone(telefone);
            departamento.setCEP(cep);
            departamento.setSite(site);
            departamento.setUnidadeEnsino(unidade_ensino);
 
            IManterDepartamento manterDepartamento = new ManterDepartamento();
            Integer id_departamento = manterDepartamento.cadastrar(departamento);
 
            if (id_departamento != null) {
                jsp = VisualizarDepartamento.execute(request);
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
