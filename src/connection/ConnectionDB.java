/**
 * Sistema de Passagens de Ônibus - Catarinense
 * Disciplina: Banco de Dados - UNIVALI
 * Autores: Salomão Patrick França Alves Panas, João Victor Serpa
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// classe responsável por criar a conexão com o banco de dados MySQL
public class ConnectionDB {

    // dados de conexão com o banco
    private static final String URL     = "jdbc:mysql://localhost:3306/catarinense";
    private static final String USUARIO = "root";
    private static final String SENHA   = "1234";

    // retorna uma conexão ativa com o banco
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}