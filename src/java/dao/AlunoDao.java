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
            preparedStatement.setString(10, aluno.getCep());
            preparedStatement.setString(11, "N");
            
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public Aluno getAlunoById(int aluno_id){
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from alunos where id='" + aluno_id + "'");
            if(rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(parseInt(rs.getString("id")));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setCelular(rs.getString("celular"));
                aluno.setLogin(rs.getString("login"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setCep(rs.getString("cep"));
                aluno.setAprovado(rs.getString("aprovado"));
                return aluno;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Aluno getAlunoByLogin(String login){
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from alunos where login='" + login + "'");
            if(rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(parseInt(rs.getString("id")));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setSenha(rs.getString("senha"));
                aluno.setCelular(rs.getString("celular"));
                aluno.setLogin(rs.getString("login"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setCep(rs.getString("cep"));
                aluno.setAprovado(rs.getString("aprovado"));
                return aluno;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Aluno> getAllAlunos() {
        List<Aluno> listaDeAlunos = new ArrayList<Aluno>();
        
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from administrador");
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(parseInt(rs.getString("id")));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setCelular(rs.getString("celular"));
                aluno.setLogin(rs.getString("login"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setCep(rs.getString("cep"));
                aluno.setAprovado(rs.getString("aprovado"));
                listaDeAlunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeAlunos;
    }
    
    public List<Aluno> getAllAlunosAprovados() {
        List<Aluno> listaDeAlunos = new ArrayList<Aluno>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from administrador where aprovado='s'");
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(parseInt(rs.getString("id")));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setCelular(rs.getString("celular"));
                aluno.setLogin(rs.getString("login"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setCep(rs.getString("cep"));
                aluno.setAprovado(rs.getString("aprovado"));
                listaDeAlunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeAlunos;
    }
    
    public List<Aluno> getAllAlunosPendentes() {
        List<Aluno> listaDeAlunos = new ArrayList<Aluno>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from administrador where aprovado='n'");
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(parseInt(rs.getString("id")));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setCelular(rs.getString("celular"));
                aluno.setLogin(rs.getString("login"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setCep(rs.getString("cep"));
                aluno.setAprovado(rs.getString("aprovado"));
                listaDeAlunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeAlunos;
    }
    
    public void deleteAluno(int alunoId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from alunos where id=?");
            preparedStatement.setInt(1, alunoId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateAluno(Aluno aluno) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update alunos set cpf=?, nome=?, email=?,"
                            + " celular=?, login=?, endereco=?, cidade=?, bairro=?,"
                            + " cep=?, aprovado=?, senha=? where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, aluno.getCpf());
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setString(3, aluno.getEmail());
            preparedStatement.setString(4, aluno.getCelular());
            preparedStatement.setString(5, aluno.getLogin());
            preparedStatement.setString(6, aluno.getEndereco());
            preparedStatement.setString(7, aluno.getCidade());
            preparedStatement.setString(8, aluno.getBairro());
            preparedStatement.setString(9, aluno.getCep());
            preparedStatement.setString(10, aluno.getAprovado());
            preparedStatement.setString(11, aluno.getSenha());
            preparedStatement.setInt(12, aluno.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkAlunoLogin(String login, String senha){
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("select senha from alunos where login='" + login +"'");
            
            String correctPassword;
            while(rs.next()){
                 correctPassword = rs.getString("senha");
                
                if(correctPassword.equals(senha)){
                    return true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean checkExistLogin(String login){
        /*Verifica se já existe algum outro usuário da plataforma com o mesmo login.
          Garante a unicidade de cada login.*/
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("select login from alunos where login='" + login +"'");
            
            String returned_login;
            while(rs.next()){
                 returned_login = rs.getString("login");
                
                if(returned_login.equals(login)){
                return true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void aprovarAluno(Aluno aluno){
        aluno.setAprovado("s");
        
        AlunoDao alunoDao = new AlunoDao();
        alunoDao.updateAluno(aluno);
    }
    
}
