package br.cefetmg.inf.scm;

import br.cefetmg.inf.util.Testador;

public class Main {

    /*
    public static void main(String args[]) {
        try {
            Curso curso = new Curso();
            curso.setNome("Informática");
            curso.setCargaHoraria(12);
            

            IManterCurso Cadastro = new ManterCurso();

            Cadastro.cadastrar(curso);
        } catch (PersistenciaException | NegocioException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     */
    /*
    public static void main(String args[]) {
        try {
            Curso curso = new Curso();
            curso.setId(new Long(5));
            curso.setNome("Informática");
            curso.setCargaHoraria(12);
            
            Turma inf = new Turma();
            inf.setInicio(new Date(12121212) );
            inf.setVagasLimite(30);
            inf.setCurso(curso);

            IManterTurma Cadastro = new ManterTurma();

            Cadastro.cadastrar(inf);
        } catch (PersistenciaException | NegocioException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    } */
    
    public static void main(String args[]) {
        Testador test = new Testador();
        
    }
    
}
