package controle.gravarinsercao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.domain.Departamento;

import br.cefetmg.inf.model.service.IManterDisciplina;
import br.cefetmg.inf.model.service.IManterDepartamento;

import br.cefetmg.inf.model.service.impl.ManterDisciplina;
import br.cefetmg.inf.model.service.impl.ManterDepartamento;

import br.cefetmg.inf.scm.controller.VisualizarDisciplina;

import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Diego
 */
public class GravarInsercaoDisciplina {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            //Integer id = Integer.parseInt(request.getParameter("idAmbiente"));
            String nome = request.getParameter("nome");
            String ementa = request.getParameter("ementa");
            Integer cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
            Integer id_departamento = Integer.parseInt(request.getParameter("departamento"));
           
            IManterDepartamento manterDepartamento = new ManterDepartamento();
            Departamento departamento = manterDepartamento.buscarPorId(id_departamento);
 
            Disciplina disciplina = new Disciplina();
            disciplina.setNome(nome);
            disciplina.setEmenta(ementa);
            disciplina.setCargaHoraria(cargaHoraria);
            disciplina.setDepartamento(departamento);
 
            IManterDisciplina manterDisciplina = new ManterDisciplina();
            Integer id_disciplina = manterDisciplina.cadastrar(disciplina);
 
            if (id_disciplina != null) {
                jsp = VisualizarDisciplina.execute(request);
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
