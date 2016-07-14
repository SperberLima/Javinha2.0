package controle.gravarinsercao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.cefetmg.inf.model.domain.GradeCurricular;
import br.cefetmg.inf.model.domain.Curso;
import br.cefetmg.inf.model.service.IManterGradeCurricular;
import br.cefetmg.inf.model.service.IManterCurso;
import br.cefetmg.inf.model.service.impl.ManterGradeCurricular;
import br.cefetmg.inf.model.service.impl.ManterCurso;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Diego
 */
public class GravarInsercaoGradeCurricular {
               
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String descricao = request.getParameter("descricao");
            Integer serie = Integer.parseInt(request.getParameter("serie"));
            Integer id_curso = Integer.parseInt(request.getParameter("curso"));
            
            IManterCurso manterCurso = new ManterCurso();
            Curso curso = manterCurso.buscarPorId(id_curso);
 
            GradeCurricular gradeCurricular = new GradeCurricular();
            gradeCurricular.setDescricao(descricao);
            gradeCurricular.setSerie(serie);
            gradeCurricular.setCurso(curso);
 
            IManterGradeCurricular manterGradeCurricular = new ManterGradeCurricular();
            Integer id_grade_curricular = manterGradeCurricular.cadastrar(gradeCurricular);
 
            if (id_grade_curricular != null) {
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
