/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import PageServelts.ServletInserirMatricula;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;
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
    
    public List<Matricula> getAllMatriculas() {
        List<Matricula> listaDeMatriculas = new ArrayList<Matricula>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from matriculas");
            while (rs.next()) {
                Matricula matricula = new Matricula();
                matricula.setId(parseInt(rs.getString("id")));
                matricula.setTurma_id(parseInt(rs.getString("turmas_id")));
                matricula.setAluno_id(parseInt(rs.getString("alunos_id")));
                
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    matricula.setData_matricula(format.parse(rs.getString("data_matricula")));
                } catch (ParseException ex) {
                    Logger.getLogger(MatriculaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                matricula.setNota(parseFloat(rs.getString("nota")));
                listaDeMatriculas.add(matricula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeMatriculas;
    }
    
    public List<Matricula> getMatriculasByAluno(Aluno aluno){
        List<Matricula> listaDeMatriculas = new ArrayList<Matricula>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from matriculas where alunos_id='" + aluno.getId() + "'");
            while (rs.next()) {
                Matricula matricula = new Matricula();
                matricula.setId(parseInt(rs.getString("id")));
                matricula.setTurma_id(parseInt(rs.getString("turmas_id")));
                matricula.setAluno_id(parseInt(rs.getString("alunos_id")));
                
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    matricula.setData_matricula(format.parse(rs.getString("data_matricula")));
                } catch (ParseException ex) {
                    Logger.getLogger(MatriculaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                matricula.setNota(parseFloat(rs.getString("nota")));
                listaDeMatriculas.add(matricula);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaDeMatriculas;
    }
    
    public void deleteMatricula(int matriculaId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from matriculas where id=?");
            preparedStatement.setInt(1, matriculaId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateMatricula(Matricula matricula) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update matriculas set turmas_id=?, alunos_id=?, "
                            + "data_matricula=?, nota=? where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, matricula.getTurma_id());
            preparedStatement.setInt(2, matricula.getAluno_id());
            preparedStatement.setDate(3, (Date) matricula.getData_matricula());
            preparedStatement.setFloat(4, matricula.getNota());
            preparedStatement.setInt(5, matricula.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
