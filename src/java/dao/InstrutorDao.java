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
import model.Aluno;
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
    
    public List<Instrutor> getAllInstrutores() {
        List<Instrutor> listaDeInstrutores = new ArrayList<Instrutor>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from instrutores");
            while (rs.next()) {
                Instrutor instrutor = new Instrutor();
                instrutor.setNome(rs.getString("nome"));
                instrutor.setEmail(rs.getString("email"));
                instrutor.setLogin(rs.getString("login"));
                instrutor.setValor_hora(parseInt(rs.getString("valor_hora")));
                instrutor.setExperiencia(rs.getString("experiencia"));
                listaDeInstrutores.add(instrutor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeInstrutores;
    }
}