package fatec.tg1.control;

import fatec.tg1.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author RaunieBruno
 */
public class DaoUsuario {
    private Connection conn;

    public DaoUsuario(Connection conexao) {
        this.conn = conexao;
    }

    public void inserir(Usuario u) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO tb_usuario(nome,email,senha) values(?,?,?)");
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void excluir(Usuario u) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("DELETE FROM tb_usuario where nome = ?");
            ps.setString(1, u.getNome());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void alterar(Usuario u) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE tb_usuario SET email = ?, senha = ? where nome = ?");
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Usuario consultar(String nome) {
        PreparedStatement ps = null;
        Usuario u = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tb_usuario where nome = ?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Usuario( rs.getString("email"),
                                 rs.getString("senha"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }

    
    
}
