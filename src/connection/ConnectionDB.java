package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    // dados de conexão com o banco
    private static final String URL     = "jdbc:mysql://localhost:3306/catarinense";
    private static final String USUARIO = "root";
    private static final String SENHA   = "root"; // altere para sua senha do MySQL

    // retorna uma conexão ativa com o banco
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}