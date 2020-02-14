/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import PageServelts.ServletInserirMatricula;
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
import model.Turma;
import util.DataBaseUtil;

/**
 *
 * @author Joao_
 */
public class TurmaDao {
    
    private Connection connection;

    public TurmaDao() {
        connection = DataBaseUtil.getConnection();
    }
    
    public void addTurma(Turma turma){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into "
                    + "turmas(instrutores_id, cursos_id, data_inicio, data_final, carga_horaria) "
                    + "values(?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, turma.getInstrutor_id());
            preparedStatement.setInt(2, turma.getCurso_id());
            preparedStatement.setDate(3, (Date) turma.getData_inicio());
            preparedStatement.setDate(4, (Date) turma.getData_fim());
            preparedStatement.setInt(5, turma.getCarga_horaria());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<Turma> getAllTurmas() {
        List<Turma> listaDeTurmas = new ArrayList<Turma>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from administrador");
            while (rs.next()) {
                Turma turma = new Turma();
                turma.setId(parseInt(rs.getString("id")));
                turma.setInstrutor_id(parseInt(rs.getString("intrutores_id")));
                turma.setCurso_id(parseInt(rs.getString("cursos_id")));
                
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    turma.setData_inicio(format.parse(rs.getString("data_inicio")));
                    turma.setData_fim(format.parse(rs.getString("data_final")));
                } catch (ParseException ex) {
                    Logger.getLogger(TurmaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                turma.setCarga_horaria(parseInt(rs.getString("carga_horaria")));
                listaDeTurmas.add(turma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeTurmas;
    }
    
    public void deleteTurma(int turmaId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from turmas where id=?");
            preparedStatement.setInt(1, turmaId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateTurma(Turma turma) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update turmas set instrutor_id=?, curso_id=?, "
                            + "data_inicio=?, data_final=?, carga_horaria=?, where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, turma.getInstrutor_id());
            preparedStatement.setInt(2, turma.getCurso_id());
            preparedStatement.setDate(3, (Date) turma.getData_inicio());
            preparedStatement.setDate(4, (Date) turma.getData_fim());
            preparedStatement.setInt(5, turma.getCarga_horaria());
            preparedStatement.setInt(6, turma.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
