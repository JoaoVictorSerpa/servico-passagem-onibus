package dao; //  Data Access Object — objeto de acesso a dados.

import connection.ConnectionDB;
import model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// classe responsável por executar as operações de banco de dados para Cliente
public class ClienteDAO {

    // cadastra um novo cliente no banco de dados
    public void inserir(Cliente c) {
        String sql = "INSERT INTO Cliente (nome, cpf, email, data_nascimento) VALUES (?, ?, ?, ?)";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // preenche os parâmetros do comando SQL com os dados do cliente
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getDataNascimento());
            ps.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    // retorna todos os clientes cadastrados no banco
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // percorre cada linha do resultado e cria um objeto Cliente
            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("data_nascimento")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
        return lista;
    }

    // busca um cliente específico pelo id
    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM Cliente WHERE id_cliente = ?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // se encontrou o cliente, retorna ele
            if (rs.next()) {
                return new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("data_nascimento")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }
        // retorna null se não encontrou
        return null;
    }

    // atualiza os dados de um cliente existente
    public void atualizar(Cliente c) {
        String sql = "UPDATE Cliente SET nome = ?, cpf = ?, email = ?, data_nascimento = ? WHERE id_cliente = ?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getDataNascimento());
            ps.setInt(5, c.getIdCliente());
            ps.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    // remove um cliente do banco pelo id
    public void deletar(int id) {
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Cliente removido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao remover cliente: " + e.getMessage());
        }
    }
}