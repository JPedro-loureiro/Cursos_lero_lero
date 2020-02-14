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
import model.Administrador;
import util.DataBaseUtil;

/**
 *
 * @author Joao_
 */
public class AdministradorDao {
    private Connection connection;

    public AdministradorDao() {
        this.connection = DataBaseUtil.getConnection();
    }
    
    public void addAdminstrador(Administrador administrador){
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement("insert into "
                    + "administrador(nome, login, senha) values(?, ?, ?)");
            preparedStatement.setString(1, administrador.getNome());
            preparedStatement.setString(2, administrador.getLogin());
            preparedStatement.setString(3, administrador.getSenha());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
