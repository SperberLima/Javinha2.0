package controle.gravar_alteracao;

import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.service.*;
import br.cefetmg.inf.model.service.impl.*;
import br.cefetmg.inf.scm.controller.VisualizarDisciplina;
import javax.servlet.http.HttpServletRequest;

public class GravarAlteracaoDisciplina {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            /* Obtem-se os parâmetros do request e os tranforma em variáveis */
            Integer id_disciplina = Integer.parseInt(request.getParameter("id_disciplina"));
            String  nome = request.getParameter("nome"),
                    ementa = request.getParameter("ementa");
            Integer cargahoraria = Integer.parseInt(request.getParameter("cargahoraria"));
                    
            // Cria-se um objeto da respectiva Entidade.
            Disciplina disciplina = new Disciplina();

            // Faz-se o(s) Set(s) repsectivos. 
            disciplina.setId(id_disciplina);
            disciplina.setNome(nome);
            disciplina.setCargaHoraria(cargahoraria);
            disciplina.setEmenta(ementa);
            
            // Nesse caso tem de se pegar um/uns objeto(s) criado(s) dentro do projeto...
            IManterDepartamento manterDpto = new ManterDepartamento();
            Integer id_departamento = Integer.parseInt(request.getParameter("departamento"));
            Departamento dpto = manterDpto.buscarPorId(id_departamento);

            // Para, enfim atribuí-lo(s) a outro.
            disciplina.setDepartamento(dpto);

            // Pesquisa pela Entidade
            IManterDisciplina manterDisciplina = new ManterDisciplina();
            boolean updated = manterDisciplina.alterar(disciplina);

            if (updated == true) {
                jsp = VisualizarDisciplina.execute(request);
            } else {
                String erro = "Nao foi possivel gravar a alteracao desse registro";
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
