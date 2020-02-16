/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.AlunoNotaTurma;
import model.Curso;
import model.Matricula;
import model.Turma;
import util.DataBaseUtil;

/**
 *
 * @author Joao_
 */
public class AlunoNotaTurmaDao {
    Connection connection;

    public AlunoNotaTurmaDao() {
        connection = DataBaseUtil.getConnection();
    }
    
    public List<AlunoNotaTurma> getAll(String login_aluno){
        List<AlunoNotaTurma> lst = new ArrayList<AlunoNotaTurma>();
        
        //Buscado pelos dados do aluno
        AlunoDao alunoDao = new AlunoDao();
        Aluno aluno = alunoDao.getAlunoByLogin(login_aluno);
        
        //Obtendo todas as matriculas do aluno
        MatriculaDao matriculaDao = new MatriculaDao();
        List<Matricula> matriculas = new ArrayList<Matricula>();
        matriculas = matriculaDao.getMatriculasByAluno(aluno);
        
        for(int i=0; i<matriculas.size(); i++){
            AlunoNotaTurma ant = new AlunoNotaTurma(); //ant: acrônimo de AlunoNotaTurma
            Matricula matricula = matriculas.get(i);
            
            ant.setNome_aluno(aluno.getNome());
            ant.setNota(matricula.getNota());
            ant.setId_turma(matricula.getTurma_id());
            
            //Obtendo nome do curso
            TurmaDao turmaDao = new TurmaDao();
            Turma turma = turmaDao.getTurmaById(ant.getId_turma());
            
            CursoDao cursoDao = new CursoDao();
            Curso curso = cursoDao.getCursoById(turma.getCurso_id());
            ant.setNome_curso(curso.getNome());
            
            lst.add(ant);
        }
        return lst;
    }
}
