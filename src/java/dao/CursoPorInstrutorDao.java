/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.CursoPorInstrutor;
import model.Turma;
import util.DataBaseUtil;

/**
 *
 * @author Joao_
 */
public class CursoPorInstrutorDao {
    
    Connection connection;

    public CursoPorInstrutorDao() {
        connection = DataBaseUtil.getConnection();
    }
    
    public List<CursoPorInstrutor> getAll(List<Turma> turmas){
        List<CursoPorInstrutor> lst = new ArrayList<CursoPorInstrutor>();
        
        for(int i=0; i<turmas.size(); i++){
            CursoPorInstrutor cpi = new CursoPorInstrutor();
            cpi.setId_turma(turmas.get(i).getId());
            
            InstrutorDao instrutorDao = new InstrutorDao();
            int instrutor_id = turmas.get(i).getInstrutor_id();
            cpi.setNome_instrutor(instrutorDao.getInstrutorById(instrutor_id).getNome());
            
            CursoDao cursoDao = new CursoDao();
            int curso_id = turmas.get(i).getCurso_id();
            cpi.setNome_curso(cursoDao.getCursoById(curso_id).getNome());
            
            lst.add(cpi);
        }
        return lst;
    }
    
}
