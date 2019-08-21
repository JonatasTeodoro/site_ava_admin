/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import MODEL.Fila;
import MODEL.Usuario;
import UTIL.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jonatas Teodoro
 */
public class FilaDAO extends Conexao {

    public FilaDAO() throws Exception {
    }

    public ArrayList<Fila> buscarFila(String tipo) {
        ArrayList<Fila> fila = new ArrayList<>();
        Fila obj;
        try {
            String sql = "select * from fila fil left join usuario usua on fil.id_usuario = usua.id_usuario where tipo like ? order by atual desc, id_fila";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setString(1, "%" + tipo + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                obj = new Fila();
                obj.setIdFila(rs.getInt("id_fila"));
                obj.setAtual(rs.getBoolean("atual"));
                obj.setNome(rs.getString("nome"));
                obj.setTipo(rs.getString("tipo"));
                fila.add(obj);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao buscarFila!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return fila;
        }
    }

    public boolean mudarTipo(int tipo) {
        boolean retorno = false;
        try {
            String sql = "update param_fila set tipo_atual=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1, tipo);

            retorno = ps.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println("Erro ao mudarTipo!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public int buscarParamFila() {
        int retorno = 0;
        try {
            String sql = "select * from param_fila";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                retorno = rs.getInt("tipo_atual");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao buscarParamFila!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public boolean cadastrarTopo(String nome, String tipo) {
        boolean retorno = false;
        try {
            String sql = "insert into fila(nome, atual, tipo) values(?, ?, ?)";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setString(1, nome);
            ps.setBoolean(2, true);
            ps.setString(3, tipo);

            retorno = ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("Erro ao cadastrarTopo!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public boolean falsificarTudo() {
        boolean retorno = false;
        try {
            String sql = "update fila set atual=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setBoolean(1, false);

            retorno = ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("Erro ao falsificarTudo!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public int buscarPosicao(int id) {
        int retorno = 0;
        try {
            String sql = "select * from fila fil left join usuario usua on fil.id_usuario = usua.id_usuario order by atual desc, id_fila";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getInt("id_usuario") == id) {
                    break;
                }
                retorno++;
            }
        } catch (Exception ex) {
            System.out.println("Erro ao buscarFila!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public boolean verificarSeTemVoo(int id) {
        boolean retorno = false;
        try {
            String sql = "select count(*) as quantidade from fila where id_usuario=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                retorno = rs.getInt("quantidade") > 0;
            }
        } catch (Exception ex) {
            System.out.println("Erro ao verificarSeTemVoo!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public int buscarQuantidadeFila() {
        int retorno = 0;
        try {
            String sql = "select count(*) as quantidade from fila";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                retorno = rs.getInt("quantidade");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao buscarQuantidadeFila!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public boolean agendar(String nome, String tipo) {
        boolean retorno = false;
        try {
            String sql = "insert into fila(nome, atual, tipo) values(?, ?, ?)";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setString(1, nome);
            ps.setBoolean(2, false);
            ps.setString(3, tipo);

            retorno = ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("Erro ao agendar!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public boolean excluirElementoFila(int id) {
        boolean retorno = false;
        try {
            String sql = "delete from fila where id_fila=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setInt(1, id);

            retorno = ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("Erro ao excluirElementoFila!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public boolean PilotoVoarAgora(int id) {
        boolean retorno = false;
        try {
            String sql = "update fila set atual=? where id_fila=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setBoolean(1, true);
            ps.setInt(2, id);

            retorno = ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("Erro ao PilotoVoarAgora!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }
}
