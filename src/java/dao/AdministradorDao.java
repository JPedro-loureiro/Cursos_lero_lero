/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                    + "administrador(nome, login, senha) values(?, ?, ?, ?)");
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
                admin.setId(parseInt(rs.getString("id")));
                admin.setNome(rs.getString("nome"));
                admin.setLogin(rs.getString("login"));
                listaDeAdmins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeAdmins;
    }
    
    public void deleteAdministrador(int adminId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from administrador where id=?");
            preparedStatement.setInt(1, adminId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateAdministrador(Administrador admin) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update administrador set nome=?, login=?, senha=? where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, admin.getNome());
            preparedStatement.setString(2, admin.getLogin());
            preparedStatement.setString(3, admin.getSenha());
            preparedStatement.setInt(4, admin.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkAdminLogin(String login, String senha){
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("select senha from administrador where login='" + login +"'");
            
            String correctPassword;
            while(rs.next()){
                 correctPassword = rs.getString("login");
                
                if(correctPassword.equals(senha)){
                return true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
