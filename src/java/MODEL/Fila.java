/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Jonatas Teodoro
 */
public class Fila {

    private int idFila;
    private String nome;
    private boolean atual;
    private Usuario usuario;
    private String tipo;

    public Fila(int idFila, String nome, boolean atual, Usuario usuario, String tipo) {
        this.idFila = idFila;
        this.nome = nome;
        this.atual = atual;
        this.usuario = usuario;
        this.tipo = tipo;
    }

    public Fila() {
        idFila = 0;
        nome = new String();
        atual = false;
        usuario = new Usuario();
        tipo = new String();
    }

    /**
     * @return the idFila
     */
    public int getIdFila() {
        return idFila;
    }

    /**
     * @param idFila the idFila to set
     */
    public void setIdFila(int idFila) {
        this.idFila = idFila;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the atual
     */
    public boolean isAtual() {
        return atual;
    }

    /**
     * @param atual the atual to set
     */
    public void setAtual(boolean atual) {
        this.atual = atual;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the usuario to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
