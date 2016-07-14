package controle.gravarinsercao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.cefetmg.inf.model.domain.Professor;
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.service.IManterProfessor;
import br.cefetmg.inf.model.service.IManterDepartamento;
import br.cefetmg.inf.model.service.impl.ManterProfessor;
import br.cefetmg.inf.model.service.impl.ManterDepartamento;

import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Diego
 */
public class GravarInsercaoProfessor {
                   
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Integer id_departamento = Integer.parseInt(request.getParameter("departamento"));
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String telefone = request.getParameter("telefone");
            String cpf = request.getParameter("cpf");
            
            IManterDepartamento manterDepartamento = new ManterDepartamento();
            Departamento departamento = manterDepartamento.buscarPorId(id_departamento);
 
            Professor professor = new Professor();
            professor.setDpto(departamento);
            professor.setNome(nome);
            professor.setDescricao(descricao);
            professor.setTelefone(telefone);
            professor.setCPF(cpf);
 
            IManterProfessor manterProfessor = new ManterProfessor();
            Integer id_professor = manterProfessor.cadastrar(professor);
 
            if (id_professor != null) {
                //jsp = ListarAmbienteAprendizagem.execute(request);
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
