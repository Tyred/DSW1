package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.ufscar.dc.dsw.domain.Vaga;

public class VagaDAO extends GenericDAO {

    public static Vaga setVaga(ResultSet rs) throws SQLException {
        Vaga vaga = new Vaga();

        try {
            vaga.setId(rs.getLong("v.id"));
            vaga.setEmpresa(EmpresaDAO.setEmpresa(rs));
            vaga.setDescricao(rs.getString("v.descricao"));
            vaga.setRemuneracao(rs.getDouble("v.remuneracao"));
            vaga.setDataLimite(rs.getDate("v.data_limite"));
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return vaga;
    }

    public void insert(Vaga vaga) {
        String sql = "INSERT INTO vaga (id_empresa, descricao, remuneracao, data_limite) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
            statement.setLong(1, vaga.getEmpresa().getId());
            statement.setString(2, vaga.getDescricao());
            statement.setDouble(3, vaga.getRemuneracao());
            statement.setDate(4, vaga.getDataLimite());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Vaga> getAll() {
        List<Vaga> listaVagas = new ArrayList<>();
        String sql = "SELECT * FROM vaga v, empresa e, usuario u WHERE v.id_empresa = e.id AND e.id_usuario = u.id";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                listaVagas.add(setVaga(resultSet));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaVagas;
    }

    public List<Vaga> getAllOpen() {
        List<Vaga> listaVagas = new ArrayList<>();
        String sql = "SELECT * FROM vaga v, empresa e, usuario u WHERE v.id_empresa = e.id AND e.id_usuario = u.id AND DATE(v.data_limite) >= CURDATE()";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                listaVagas.add(setVaga(resultSet));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaVagas;
    }

    public void delete(Vaga vaga) {
        String sql = "DELETE FROM vaga WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, vaga.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Vaga vaga) {
        String sql = "UPDATE vaga SET descricao = ?, remuneracao = ?, data_limite = ? WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
            statement.setString(1, vaga.getDescricao());
            statement.setDouble(2, vaga.getRemuneracao());
            statement.setDate(3, vaga.getDataLimite());
            statement.setLong(4, vaga.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Vaga getByID(Long idVaga) {
        Vaga vaga = null;
        String sql = "SELECT * FROM vaga v, empresa e, usuario u WHERE v.id_empresa = e.id AND e.id_usuario = u.id AND v.id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, idVaga);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                vaga = setVaga(resultSet);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vaga;
    }

    public List<Vaga> getAllByEmpresa(Long idEmpresa) {
        List<Vaga> listaVagas = new ArrayList<>();
        String sql = "SELECT * FROM vaga v, empresa e, usuario u WHERE v.id_empresa = e.id AND e.id_usuario = u.id AND e.id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, idEmpresa);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listaVagas.add(setVaga(resultSet));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaVagas;
    }
}
