/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.tg1.control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Bruno Yuji
 */
public class ModuloConexao {
    //criando um método responsável por estabelecer
    //uma conexão com o banco
    
    public static Connection conector() {
        //criando uma variável especial para estabelecer uma conexão com o banco
        java.sql.Connection conexao = null;
        //carregando o driver correspondente ao banco
        String driver = "com.mysql.cj.jdbc.Driver";
        //armazenando informações referente ao banco de dados
        String url = "jdbc:mysql://localhost:3306/db_modseg?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "@#28n95BYY";
        //estabelecendo a conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;

        } catch (Exception e) {
            //a linha abaixo serve de apoio para esclarecer o erro
            //System.out.println(e);
            return null;
        }

    }
    
}
