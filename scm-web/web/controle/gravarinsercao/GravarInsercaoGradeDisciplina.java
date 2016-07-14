package controle.gravarinsercao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.cefetmg.inf.model.domain.GradeDisciplina;
import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.domain.GradeCurricular;
import br.cefetmg.inf.model.service.IManterGradeDisciplina;
import br.cefetmg.inf.model.service.IManterDisciplina;
import br.cefetmg.inf.model.service.IManterGradeCurricular;
import br.cefetmg.inf.model.service.impl.ManterGradeDisciplina;
import br.cefetmg.inf.model.service.impl.ManterDisciplina;
import br.cefetmg.inf.model.service.impl.ManterGradeCurricular;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Diego
 */
public class GravarInsercaoGradeDisciplina {
                  
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Integer id_disciplina = Integer.parseInt(request.getParameter("disciplina"));
            Integer id_grade_curricular = Integer.parseInt(request.getParameter("gradeCurricular"));
            
            
            IManterDisciplina manterDisciplina = new ManterDisciplina();
            Disciplina disciplina = manterDisciplina.buscarPorId(id_disciplina);
            
            IManterGradeCurricular manterGradeCurricular = new ManterGradeCurricular();
            GradeCurricular gradeCurricular = manterGradeCurricular.buscarPorId(id_grade_curricular);
 
            GradeDisciplina gradeDisciplina = new GradeDisciplina();
            gradeDisciplina.setDisciplina(disciplina);
            gradeDisciplina.setGradeCurricular(gradeCurricular);
 
            IManterGradeDisciplina manterGradeDisciplina = new ManterGradeDisciplina();
            Integer id_grade_disciplina = manterGradeDisciplina.cadastrar(gradeDisciplina);
 
            if (id_grade_disciplina != null) {
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
