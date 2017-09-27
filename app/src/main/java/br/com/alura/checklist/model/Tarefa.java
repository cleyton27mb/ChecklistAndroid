package br.com.alura.checklist.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cleyton on 20/09/17.
 */

public class Tarefa implements Serializable {
    private Long id;
    private String nome;
    private String tarefa;
    private String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return  getId()+" - " + getNome() +" - " + getTarefa()+ " - " + getData();
    }
}