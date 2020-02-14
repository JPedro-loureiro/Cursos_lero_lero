/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Instrutor;
import util.DataBaseUtil;

/**
 *
 * @author Joao_
 */
public class InstrutorDao {
    
    private Connection connection;

    public InstrutorDao() {
        connection = DataBaseUtil.getConnection();
    }
    
    public void addInstrutor(Instrutor instrutor){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into "
                    + "instrutores(nome, email, valor_hora, login, senha, experiencia) "
                    + "values(?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, instrutor.getNome());
            preparedStatement.setString(2, instrutor.getEmail());
            preparedStatement.setInt(3, instrutor.getValor_hora());
            preparedStatement.setString(4, instrutor.getLogin());
            preparedStatement.setString(5, instrutor.getSenha());
            preparedStatement.setString(6, instrutor.getExperiencia());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
