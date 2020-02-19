/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
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
    
    public Curso getCursoById(int curso_id){
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cursos where id='" + curso_id + "'");
            if(rs.next()) {
                Curso curso = new Curso();
                curso.setId(parseInt(rs.getString("id")));
                curso.setNome(rs.getString("nome"));
                curso.setRequisito(rs.getString("requisito"));
                curso.setEmenta(rs.getString("ementa"));
                curso.setCarga_horaria(parseInt(rs.getString("carga_horaria")));
                curso.setPreco(parseDouble(rs.getString("preco")));
                return curso;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Curso> getAllCursos() {
        List<Curso> listaDeCursos = new ArrayList<Curso>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cursos");
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(parseInt(rs.getString("id")));
                curso.setNome(rs.getString("nome"));
                curso.setRequisito(rs.getString("requisito"));
                curso.setEmenta(rs.getString("ementa"));
                curso.setCarga_horaria(parseInt(rs.getString("carga_horaria")));
                curso.setPreco(parseDouble(rs.getString("preco")));
                listaDeCursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeCursos;
    }
    
    public void deleteCurso(int cursoId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from cursos where id=?");
            preparedStatement.setInt(1, cursoId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateCurso(Curso curso) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update cursos set nome=?, requisito=?, "
                            + "ementa=?, carga_horaria=?, preco=? where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, curso.getNome());
            preparedStatement.setString(2, curso.getRequisito());
            preparedStatement.setString(3, curso.getEmenta());
            preparedStatement.setInt(4, curso.getCarga_horaria());
            preparedStatement.setString(5, String.valueOf(curso.getPreco()));
            preparedStatement.setInt(6, curso.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
