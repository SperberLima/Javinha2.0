package controle.gravarinsercao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.cefetmg.inf.model.domain.Curso;
import br.cefetmg.inf.model.domain.Departamento;

import br.cefetmg.inf.model.service.IManterCurso;
import br.cefetmg.inf.model.service.IManterDepartamento;

import br.cefetmg.inf.model.service.impl.ManterCurso;
import br.cefetmg.inf.model.service.impl.ManterDepartamento;

import br.cefetmg.inf.scm.controller.VisualizarCurso;

import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Diego
 */
public class GravarInsercaoCurso {
        
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Integer id_departamento = Integer.parseInt(request.getParameter("departamento"));
            String tipo = request.getParameter("tipo");
            String nome = request.getParameter("nome");
            String sigla = request.getParameter("sigla");
            
            IManterDepartamento manterDepartamento = new ManterDepartamento();
            Departamento departamento = manterDepartamento.buscarPorId(id_departamento);
 
            Curso curso = new Curso();
            curso.setDpto(departamento);
            curso.setTipo(tipo);
            curso.setNome(nome);
            curso.setSigla(sigla);
 
            IManterCurso manterCurso = new ManterCurso();
            Integer id_curso = manterCurso.cadastrar(curso);
 
            if (id_curso != null) {
                jsp = VisualizarCurso.execute(request);
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
