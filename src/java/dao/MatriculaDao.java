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
import model.Matricula;
import util.DataBaseUtil;

/**
 *
 * @author Joao_
 */
public class MatriculaDao {
   
    private Connection connection;

    public MatriculaDao() {
        connection = DataBaseUtil.getConnection();
    }
    
    public void addMatricula(Matricula matricula){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into "
                    + "matriculas(turmas_id, alunos_id, data_matricula, nota) "
                    + "values(?, ?, ?, ?)");
            preparedStatement.setInt(1, matricula.getTurma_id());
            preparedStatement.setInt(2, matricula.getAluno_id());
            preparedStatement.setDate(3, (Date) matricula.getData_matricula());
            preparedStatement.setFloat(4, matricula.getNota());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
