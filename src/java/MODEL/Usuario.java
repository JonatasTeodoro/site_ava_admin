/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.Date;

/**
 *
 * @author Jonatas Teodoro
 */
public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private Date dataCadastro;
    private String imagemPerfil;
    private String cidade;

    public Usuario(int id, String nome, String email, String telefone, String senha, Date dataCadastro, String imagemPerfil, String cidade) {
        this.id = id;
        this.nome = nome.toUpperCase();
        this.email = email.toLowerCase();
        this.telefone = telefone;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.imagemPerfil = imagemPerfil;
        this.cidade = cidade;
    }

    public Usuario() {
        id = 0;
        nome = new String();
        email = new String();
        telefone = new String();
        senha = new String();
        dataCadastro = new Date();
        imagemPerfil = new String();
        cidade = new String();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome.toUpperCase();
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email.toLowerCase();
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the imagemPerfil
     */
    public String getImagemPerfil() {
        return imagemPerfil;
    }

    /**
     * @param imagemPerfil the imagemPerfil to set
     */
    public void setImagemPerfil(String imagemPerfil) {
        this.imagemPerfil = imagemPerfil;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
