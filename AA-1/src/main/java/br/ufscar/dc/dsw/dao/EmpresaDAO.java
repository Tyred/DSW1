package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Empresa;

public class EmpresaDAO extends GenericDAO {

    public static Empresa setEmpresa(ResultSet rs) throws SQLException {
        Empresa empresa = new Empresa();

        try {
            empresa.setId(rs.getLong("e.id"));
            empresa.setUsuario(UsuarioDAO.setUsuario(rs));
            empresa.setCNPJ(rs.getString("e.cnpj"));
            empresa.setDescricao(rs.getString("e.descricao"));
            empresa.setCidade(rs.getString("e.cidade"));
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return empresa;
    }

    public void insert(Empresa empresa) {
        String sql = "INSERT INTO empresa (id_usuario, cnpj, descricao, cidade) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
            statement.setLong(1, empresa.getUsuario().getId());
            statement.setString(2, empresa.getCNPJ());
            statement.setString(3, empresa.getDescricao());
            statement.setString(4, empresa.getCidade());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Empresa> getAll() {
        List<Empresa> listaEmpresas = new ArrayList<>();
        String sql = "SELECT * FROM empresa e, usuario u WHERE e.id_usuario = u.id";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                listaEmpresas.add(setEmpresa(resultSet));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaEmpresas;
    }

    public void delete(Empresa empresa) {
        String sql = "DELETE FROM empresa WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, empresa.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Empresa empresa) {
        String sql = "UPDATE empresa SET cnpj = ?, descricao = ?, cidade = ? WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
            statement.setString(1, empresa.getCNPJ());
            statement.setString(2, empresa.getDescricao());
            statement.setString(3, empresa.getCidade());
            statement.setLong(4, empresa.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Empresa getByID(Long idEmpresa) {
        Empresa empresa = null;
        String sql = "SELECT * FROM empresa e, usuario u WHERE e.id_usuario = u.id AND e.id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, idEmpresa);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                empresa = setEmpresa(resultSet);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empresa;
    }

    public Empresa getByID_Usuario(Long idEmpresa) {
        Empresa empresa = null;
        String sql = "SELECT * FROM empresa e, usuario u WHERE e.id_usuario = u.id AND e.id_usuario = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, idEmpresa);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                empresa = setEmpresa(resultSet);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empresa;
    }

    public Empresa getByEmail(String emailEmpresa) {
        Empresa empresa = new Empresa();
        String sql = "SELECT * FROM empresa e, usuario u WHERE e.id_usuario = u.id AND u.email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, emailEmpresa);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                empresa = setEmpresa(resultSet);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empresa;
    }
}
