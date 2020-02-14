/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Administrador> getAllAdmins() {
        List<Administrador> listaDeAdmins = new ArrayList<Administrador>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from administrador");
            while (rs.next()) {
                Administrador admin = new Administrador();
                admin.setNome(rs.getString("nome"));
                admin.setLogin(rs.getString("login"));
                listaDeAdmins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeAdmins;
    }
}
