/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jonatas Teodoro
 */
public class Conexao {
    private Connection Conexao;

    public Conexao() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/ava_app";
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        Conexao = DriverManager.
                getConnection(url, "postgres", "#Guia02654560*");
    }

    public Connection getConexao() {
        return Conexao;
    }

    public void fechaConexao() {
        try {
            Conexao.close();
        } catch (Exception ex) {
            System.out.println("Erro ao fechar conexao!Erro: " + ex.getMessage());
        }
    }
}
