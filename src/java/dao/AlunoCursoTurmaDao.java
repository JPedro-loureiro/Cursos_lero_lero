/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.AlunoCursoTurma;
import model.Matricula;
import model.Turma;
import util.DataBaseUtil;

/**
 *
 * @author Joao_
 */
public class AlunoCursoTurmaDao {
    
    Connection connection;

    public AlunoCursoTurmaDao() {
        connection = DataBaseUtil.getConnection();
    }

    
    
    public List<AlunoCursoTurma> getAll(Turma turma){
        List<AlunoCursoTurma> lst = new ArrayList<AlunoCursoTurma>();
        List<Matricula> matriculas = new ArrayList<Matricula>();
        
        AlunoDao alunoDao = new AlunoDao();
        TurmaDao turmaDao = new TurmaDao();
        CursoDao cursoDao = new CursoDao();
        
        int curso_id = turma.getCurso_id();
        
        
        MatriculaDao matriculaDao = new MatriculaDao();
        matriculas = matriculaDao.getMatriculasByTurma(turma);
        
        for(int i=0; i<matriculas.size(); i++){
            AlunoCursoTurma act = new AlunoCursoTurma();
            act.setId_turma(turma.getId());
            act.setNome_curso(cursoDao.getCursoById(curso_id).getNome());
            act.setNota(matriculas.get(i).getNota());
            
            
            int aluno_id = matriculas.get(i).getAluno_id();
            act.setId_aluno(aluno_id);
            act.setNome_aluno(alunoDao.getAlunoById(aluno_id).getNome());
            
            lst.add(act);
        }
        return lst;
    }
    
}
