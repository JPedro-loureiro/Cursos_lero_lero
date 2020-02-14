/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Curso;
import util.DataBaseUtil;

/**
 *
 * @author Joao_
 */
public class CursoDao {
    
    private Connection connection;

    public CursoDao() {
        connection = DataBaseUtil.getConnection();
    }
    
    public void addCurso(Curso novo_curso){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into "
                    + "cursos(nome, requisito, ementa, carga_horaria, preco) "
                    + "values(?, ?, ?, ?, ?)");
            preparedStatement.setString(1, novo_curso.getNome());
            preparedStatement.setString(2, novo_curso.getRequisito());
            preparedStatement.setString(3, novo_curso.getEmenta());
            preparedStatement.setInt(4, novo_curso.getCarga_horaria());
            preparedStatement.setDouble(5, novo_curso.getPreco());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
