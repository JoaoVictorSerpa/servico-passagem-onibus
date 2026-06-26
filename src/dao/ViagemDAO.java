package dao;

import connection.ConnectionDB;
import model.Viagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// classe responsável por executar as operações de banco de dados para Viagem
public class ViagemDAO {

    // cadastra uma nova viagem no banco de dados
    public void inserir(Viagem v) {
        String sql = "INSERT INTO Viagem (data_partida, data_chegada, status, id_onibus, id_rota, id_motorista) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // preenche os parâmetros com os dados da viagem
            ps.setString(1, v.getDataPartida());
            ps.setString(2, v.getDataChegada());
            ps.setString(3, v.getStatus());
            ps.setInt(4, v.getIdOnibus());
            ps.setInt(5, v.getIdRota());
            ps.setInt(6, v.getIdMotorista());
            ps.executeUpdate();
            System.out.println("Viagem inserida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir viagem: " + e.getMessage());
        }
    }

    // retorna todas as viagens cadastradas no banco
    public List<Viagem> listar() {
        List<Viagem> lista = new ArrayList<>();
        String sql = "SELECT * FROM Viagem";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // percorre cada linha e cria um objeto Viagem
            while (rs.next()) {
                Viagem v = new Viagem(
                        rs.getInt("id_viagem"),
                        rs.getString("data_partida"),
                        rs.getString("data_chegada"),
                        rs.getString("status"),
                        rs.getInt("id_onibus"),
                        rs.getInt("id_rota"),
                        rs.getInt("id_motorista")
                );
                lista.add(v);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar viagens: " + e.getMessage());
        }
        return lista;
    }

    // busca uma viagem específica pelo id
    public Viagem buscarPorId(int id) {
        String sql = "SELECT * FROM Viagem WHERE id_viagem = ?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // se encontrou a viagem, retorna ela
            if (rs.next()) {
                return new Viagem(
                        rs.getInt("id_viagem"),
                        rs.getString("data_partida"),
                        rs.getString("data_chegada"),
                        rs.getString("status"),
                        rs.getInt("id_onibus"),
                        rs.getInt("id_rota"),
                        rs.getInt("id_motorista")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar viagem: " + e.getMessage());
        }
        return null;
    }

    // atualiza os dados de uma viagem existente
    public void atualizar(Viagem v) {
        String sql = "UPDATE Viagem SET data_partida = ?, data_chegada = ?," +
                " status = ?, id_onibus = ?, id_rota = ?, id_motorista = ? WHERE id_viagem = ?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, v.getDataPartida());
            ps.setString(2, v.getDataChegada());
            ps.setString(3, v.getStatus());
            ps.setInt(4, v.getIdOnibus());
            ps.setInt(5, v.getIdRota());
            ps.setInt(6, v.getIdMotorista());
            ps.setInt(7, v.getIdViagem());
            ps.executeUpdate();
            System.out.println("Viagem atualizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar viagem: " + e.getMessage());
        }
    }

    // remove uma viagem do banco pelo id
    public void deletar(int id) {
        String sql = "DELETE FROM Viagem WHERE id_viagem = ?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Viagem removida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao remover viagem: " + e.getMessage());
        }
    }
}