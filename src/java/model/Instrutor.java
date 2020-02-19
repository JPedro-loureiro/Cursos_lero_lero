/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.CursoDao;
import dao.InstrutorDao;
import dao.TurmaDao;
import java.util.List;

/**
 *
 * @author Joao_
 */
public class Instrutor {
    
    private int id;
    private String nome;
    private String email;
    private int valor_hora;
    private String login;
    private String senha;
    private String experiencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(int valor_hora) {
        this.valor_hora = valor_hora;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
    
    public float getValorAReceber(int id_instrutor){
        InstrutorDao instrutorDao = new InstrutorDao();
        Instrutor instrutor = instrutorDao.getInstrutorById(id_instrutor);
        float valor_hora = instrutor.getValor_hora();
        
        TurmaDao turmaDao = new TurmaDao();
        List<Turma> turmas = turmaDao.getTurmasByInstrutor(instrutor);
        
        CursoDao cursoDao = new CursoDao();
        Curso curso;
        int curso_id;
        float valor_total = 0;
        
        for(int i=0; i<turmas.size(); i++){
            curso_id = turmas.get(i).getCurso_id();
            curso = cursoDao.getCursoById(curso_id);
            
            valor_total += valor_hora * curso.getCarga_horaria();
        }
        return valor_total;
    }
}
