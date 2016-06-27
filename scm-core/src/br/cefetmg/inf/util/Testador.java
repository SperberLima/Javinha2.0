package br.cefetmg.inf.util;

import br.cefetmg.inf.model.domain.Aluno;
import br.cefetmg.inf.model.domain.Curso;
import br.cefetmg.inf.model.domain.Matricula;
import br.cefetmg.inf.model.domain.Turma;
import br.cefetmg.inf.model.service.GenericManter;
import br.cefetmg.inf.model.service.IManterAluno;
import br.cefetmg.inf.model.service.IManterCurso;
import br.cefetmg.inf.model.service.IManterMatricula;
import br.cefetmg.inf.model.service.IManterTurma;
import br.cefetmg.inf.model.service.impl.ManterAluno;
import br.cefetmg.inf.model.service.impl.ManterCurso;
import br.cefetmg.inf.model.service.impl.ManterMatricula;
import br.cefetmg.inf.model.service.impl.ManterTurma;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class Testador<E> extends javax.swing.JFrame {
    private ButtonGroup bt;
    
    public Testador() {
        
        initComponents();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Testador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        bt = new ButtonGroup();
        
        bt.add(jRadioButton1);
        bt.add(jRadioButton2);
        bt.add(jRadioButton3);
        bt.add(jRadioButton4);
        
        this.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Excluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Alterar Dados");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cadastrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Curso");

        jRadioButton2.setText("Aluno");

        jRadioButton3.setText("Turma");

        jRadioButton4.setText("Matricula");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jRadioButton1)
                .addGap(73, 73, 73)
                .addComponent(jRadioButton2)
                .addGap(123, 123, 123)
                .addComponent(jRadioButton3)
                .addGap(74, 74, 74)
                .addComponent(jRadioButton4)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        E ele = tipo();
        if (ele instanceof ManterCurso) {
            Curso curso = new Curso();
            curso.setNome(JOptionPane.showInputDialog(null, " Digite o  nome: "));
            curso.setCargaHoraria(Integer.parseInt(JOptionPane.showInputDialog(null, " Digite a carga horária: ")));

            try {
                ((ManterCurso) ele).cadastrar(curso);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ele instanceof ManterMatricula) {
            Matricula mat = new Matricula();

            mat.setDataInscricao(new Date(12121212));
            mat.setNotaFinal(Double.parseDouble(JOptionPane.showInputDialog(null, " Digite a notaFinal: ")));
            
            Aluno aluno = null;
            try {
                IManterAluno manter = new ManterAluno();
                aluno = manter.buscarPorId(Long.parseLong(JOptionPane.showInputDialog(null, " Digite a id do Aluno: ")));
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            mat.setAluno(aluno);
                    
            Turma turma = null;
            try {
                IManterTurma manter = new ManterTurma();
                turma = manter.buscarPorId(Long.parseLong(JOptionPane.showInputDialog(null, " Digite a id da Turma: ")));
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            mat.setTurma(turma);
            
            try {
                ((ManterMatricula) ele).cadastrar(mat);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ele instanceof ManterTurma) {

            Turma turma = new Turma();
            Date data =new Date(111);
            data.setYear(2046);
            turma.setInicio(data);
            turma.setVagasLimite(Integer.parseInt(JOptionPane.showInputDialog(null, " Digite o numero de vagas limite: ")));
            
            
            Curso curso = null;
            try {
                IManterCurso manter = new ManterCurso();
                curso = manter.buscarPorId(Long.parseLong(JOptionPane.showInputDialog(null, " Digite a id do Curso: ")));
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            turma.setCurso(curso);
            
            try {
                ((ManterTurma) ele).cadastrar(turma);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (ele instanceof ManterAluno) {
            Aluno aluno = new Aluno();
            aluno.setNome(JOptionPane.showInputDialog(null, " Digite o  nome: "));
            aluno.setTelefone(JOptionPane.showInputDialog(null, " Digite a Telefone: "));
            aluno.setEndereco(JOptionPane.showInputDialog(null, " Digite a Endereco: "));
            aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog(null, " Digite a CPF: ")));

            try {
                ((ManterAluno) ele).cadastrar(aluno);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        GenericManter ele = (GenericManter) tipo();
        if (ele instanceof ManterCurso) {
            Curso curso = new Curso();
            curso.setNome(JOptionPane.showInputDialog(null, " Digite a id da Curso: "));
            //curso.setId(Long.parseLong(JOptionPane.showInputDialog(null, " Digite a carga horária: ")));

            try {
                ((ManterCurso) ele).buscarPorNome(curso.getNome());
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ele instanceof ManterMatricula) {
            Matricula mat = new Matricula();

            mat.setId(Long.parseLong(JOptionPane.showInputDialog(null, " Digite a id da Matricula: ")));
            
            try {
                ((ManterMatricula) ele).buscarPorId(mat.getId());
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ele instanceof ManterTurma) {
            Turma turma = new Turma();
            
            turma.setId(Long.parseLong(JOptionPane.showInputDialog(null, " Digite a id da Turma: ")));

            try {
                ((ManterTurma) ele).buscarPorId(turma.getId());
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ele instanceof ManterAluno) {
            Aluno aluno = new Aluno();
            aluno.setNome(JOptionPane.showInputDialog(null, " Digite o  nome: "));
            
            try {
                ((ManterAluno) ele).buscarPorNome(aluno.getNome());
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        E ele = tipo();
        if (ele instanceof ManterCurso) {
            Curso curso = new Curso();
            try {
                IManterCurso manter = new ManterCurso();
                Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Digite a id do Curso: "));
                curso = manter.buscarPorId(id);
                curso.setId(id);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(curso == null) {
                try {
                    throw new PersistenciaException("Curso Inexistente.");
                } catch (PersistenciaException ex) {
                    Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            try {
                ((ManterCurso) ele).excluir(curso);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ele instanceof ManterMatricula) {
            Matricula mat = new Matricula();
            try {
                IManterMatricula manter = new ManterMatricula();
                Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Digite a id da Matricula: "));
                mat = manter.buscarPorId(id);
                mat.setId(id);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(mat == null) {
                try {
                    throw new PersistenciaException("Matricula Inexistente.");
                } catch (PersistenciaException ex) {
                    Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            try {
                ((ManterMatricula) ele).excluir(mat);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ele instanceof ManterTurma) {

            Turma turma = new Turma();
            try {
                IManterTurma manter = new ManterTurma();
                Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Digite a id da Turma: "));
                turma = manter.buscarPorId(id);
                turma.setId(id);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(turma == null) {
                try {
                    throw new PersistenciaException("Turma Inexistente.");
                } catch (PersistenciaException ex) {
                    Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            try {
                ((ManterTurma) ele).excluir(turma);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (ele instanceof ManterAluno) {
            Aluno aluno = new Aluno();
            try {
                IManterAluno manter = new ManterAluno();
                Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Digite a id do Aluno: "));
                aluno = manter.buscarPorId(id);
                aluno.setId(id);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(aluno == null) {
                try {
                    throw new PersistenciaException("Aluno Inexistente.");
                } catch (PersistenciaException ex) {
                    Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ((ManterAluno) ele).excluir(aluno);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        E ele = tipo();
        if (ele instanceof ManterCurso) {
            
            Curso curso = null;
            try {
                IManterCurso manter = new ManterCurso();
                Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Digite a id do Curso: "));
                curso = manter.buscarPorId(id);
                curso.setId(id);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(curso == null) {
                try {
                    throw new PersistenciaException("Curso Inexistente.");
                } catch (PersistenciaException ex) {
                    Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            curso.setNome( JOptionPane.showInputDialog(null, " Digite o Novo Nome: ") );
            curso.setCargaHoraria(Integer.parseInt(JOptionPane.showInputDialog(null, " Digite a nova carga horária: ")));

            try {
                ((ManterCurso) ele).alterar(curso);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ele instanceof ManterMatricula) {
            
            Matricula mat = new Matricula();
            try {
                IManterMatricula manter = new ManterMatricula();
                Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Digite a id da Matricula: "));
                mat = manter.buscarPorId(id);
                mat.setId(id);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(mat == null) {
                try {
                    throw new PersistenciaException("Matricula Inexistente.");
                } catch (PersistenciaException ex) {
                    Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            mat.setDataInscricao(new Date(1212321212));
            mat.setNotaFinal(Double.parseDouble(JOptionPane.showInputDialog(null, " Digite a nova notaFinal: ")));
            
            try {
                ((ManterMatricula) ele).alterar(mat);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ele instanceof ManterTurma) {

            Turma turma = new Turma();
            try {
                IManterTurma manter = new ManterTurma();
                Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Digite a id do Turma: "));
                turma = manter.buscarPorId(id);
                turma.setId(id);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(turma == null) {
                try {
                    throw new PersistenciaException("Turma Inexistente.");
                } catch (PersistenciaException ex) {
                    Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            turma.setInicio(new Date(123123) );
            turma.setVagasLimite(Integer.parseInt(JOptionPane.showInputDialog(null, " Digite o novo numero de vagas limite: ")));
            
            
            try {
                ((ManterTurma) ele).alterar(turma);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (ele instanceof ManterAluno) {
            Aluno aluno = new Aluno();
            try {
                IManterAluno manter = new ManterAluno();
                Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Digite a id do Aluno: "));
                aluno = manter.buscarPorId(id);
                aluno.setId(id);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(aluno == null) {
                try {
                    throw new PersistenciaException("Aluno Inexistente.");
                } catch (PersistenciaException ex) {
                    Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            aluno.setNome(JOptionPane.showInputDialog(null, " Digite o novo  nome: "));
            aluno.setTelefone(JOptionPane.showInputDialog(null, " Digite o novo Telefone: "));
            aluno.setEndereco(JOptionPane.showInputDialog(null, " Digite o novo Endereco: "));
            aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog(null, " Digite o novo Cpf: ")));

            try {
                ((ManterAluno) ele).alterar(aluno);
            } catch (PersistenciaException | NegocioException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables

    public E tipo() {
        if (jRadioButton1.isSelected()) {
            return (E) new ManterCurso();
        }
        if (jRadioButton2.isSelected()) {
            return (E) new ManterAluno();
        }
        if (jRadioButton3.isSelected()) {
            return (E) new ManterTurma();
        }
        if (jRadioButton4.isSelected()) {
            return (E) new ManterMatricula();
        }

        return null;
    }

}
