/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Joao_
 */
public class CursoPorInstrutor {
    
    String nome_instrutor;
    String nome_curso;
    int id_turma;

    public String getNome_instrutor() {
        return nome_instrutor;
    }

    public void setNome_instrutor(String nome_instrutor) {
        this.nome_instrutor = nome_instrutor;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public int getId_turma() {
        return id_turma;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }
    
}
