package fatec.tg1.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author RaunieBruno
 */
public class Conexao {
    
    public  Connection connection;
    private String connectionString;      
    private String usuario;
    private String senha;
    private String driver;

    public Conexao(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    
    public Connection conectar() {
        if (connection == null) {
            try {
                Class.forName(driver);
                
                connection = DriverManager.getConnection(connectionString, usuario, senha);
                System.out.println("Conexão Ok");
                return (connection); 
            } catch (Exception ex) {
                System.out.println("Falha na Conexão"); 
                System.out.println(ex.getMessage());
            }
        }
        return connection;

    }

    public void fecharConexao() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
}
