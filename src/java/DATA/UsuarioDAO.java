/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import MODEL.Usuario;
import UTIL.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jonatas Teodoro
 */
public class UsuarioDAO extends Conexao {

    public UsuarioDAO() throws Exception {
    }

    public ArrayList<Usuario> buscarUsuarios() {
        Usuario obj;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            String sql = "select * from usuario";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                obj = new Usuario();
                obj.setNome(rs.getString("nome"));
                obj.setId(rs.getInt("id_usuario"));
                obj.setEmail(rs.getString("email"));
                obj.setCidade(rs.getString("cidade"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setDataCadastro(rs.getDate("data_cadastro"));
                obj.setImagemPerfil(rs.getString("img_perfil"));
                usuarios.add(obj);
            }

        } catch (Exception ex) {
            System.out.println("Erro no banco ao buscar usuários!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return usuarios;
        }
    }

    public boolean cadastraSorteado(Usuario obj) {
        boolean retorno = false;
        try {
            String sql = "insert into sorteado(nome, cidade, telefone) values(?, ?, ?)";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getCidade());
            ps.setString(3, obj.getTelefone());

            retorno = ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("Erro no banco ao cadastraSorteado!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public boolean deletaSorteado() {
        boolean retorno = false;
        try {
            String sql = "delete from sorteado";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            retorno = ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("Erro no banco ao deletaSorteado!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }
}
