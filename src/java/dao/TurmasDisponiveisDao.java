/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
import model.Instrutor;
import model.Turma;
import model.TurmasDisponiveis;
import util.DataBaseUtil;

/**
 *
 * @author Joao_
 */
public class TurmasDisponiveisDao {
    
    Connection connection;

    public TurmasDisponiveisDao() {
        connection = DataBaseUtil.getConnection();
    }
    
    public List<TurmasDisponiveis> getAll(List<Turma> turmas){
        List<TurmasDisponiveis> turmasDisponiveis = new ArrayList<TurmasDisponiveis>();
        
        for(int i=0; i<turmas.size(); i++){
            TurmasDisponiveis tn = new TurmasDisponiveis();
            
            Turma turma_atual = turmas.get(i);
            
            tn.setId_turma(turma_atual.getId());
            tn.setData_inicio(turma_atual.getData_inicio());
            tn.setData_fim(turma_atual.getData_fim());
            
            CursoDao cursoDao = new CursoDao();
            int id_curso = turma_atual.getCurso_id();
            Curso curso = cursoDao.getCursoById(id_curso);
            int carga_horaria = curso.getCarga_horaria();
            
            tn.setNome_curso(curso.getNome());
            tn.setCarga_horaria(carga_horaria);
            
            InstrutorDao instrutorDao = new InstrutorDao();
            int instrutor_id = turma_atual.getInstrutor_id();
            Instrutor instrutor = instrutorDao.getInstrutorById(instrutor_id);
            tn.setNome_instrutor(instrutor.getNome());
            
            turmasDisponiveis.add(tn);
        }
        return turmasDisponiveis;
    }
}
