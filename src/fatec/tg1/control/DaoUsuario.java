package fatec.tg1.control;

import java.sql.Connection;


/**
 *
 * @author RaunieBruno
 */
public class DaoUsuario {
    private Connection conn;

    public DaoUsuario(Connection conexao) {
        this.conn = conexao;
    }

    
    
}
