/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Aluno;
import util.DataBaseUtil;
/**
 *
 * @author Joao_
 */
public class AlunoDao {
    
    private Connection connection;

    public AlunoDao() {
        /*Ao ser instanciado, estabelece conexão com o BD*/
        connection = DataBaseUtil.getConnection();
    }
    
    
    public void addAluno(Aluno aluno){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into "
                    + "alunos(cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, aprovado) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, aluno.getCpf());
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setString(3, aluno.getEmail());
            preparedStatement.setString(4, aluno.getCelular());
            preparedStatement.setString(5, aluno.getLogin());
            preparedStatement.setString(6, aluno.getSenha());
            preparedStatement.setString(7, aluno.getEndereco());
            preparedStatement.setString(8, aluno.getCidade());
            preparedStatement.setString(9, aluno.getBairro());
            preparedStatement.setString(10, aluno.getBairro());
            preparedStatement.setString(11, "N");
            
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
