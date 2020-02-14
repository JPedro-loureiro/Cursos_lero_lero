/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Turma;
import util.DataBaseUtil;

/**
 *
 * @author Joao_
 */
public class TurmaDao {
    
    private Connection connection;

    public TurmaDao() {
        connection = DataBaseUtil.getConnection();
    }
    
    public void addTurma(Turma turma){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into "
                    + "turmas(instrutores_id, cursos_id, data_inicio, data_final, carga_horaria) "
                    + "values(?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, turma.getInstrutor_id());
            preparedStatement.setInt(2, turma.getCurso_id());
            preparedStatement.setDate(3, (Date) turma.getData_inicio());
            preparedStatement.setDate(4, (Date) turma.getData_fim());
            preparedStatement.setInt(5, turma.getCarga_horaria());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
