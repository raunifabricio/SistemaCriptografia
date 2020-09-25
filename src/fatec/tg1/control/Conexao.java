package fatec.tg1.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author RaunieBruno
 */
public class Conexao {
    
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_modseg","postgres","postgres");
        return conexao;
        
    }
    
}
