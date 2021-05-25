package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.ufscar.dc.dsw.domain.Profissional;

public class ProfissionalDAO extends GenericDAO {

    public static Profissional setProfissional(ResultSet rs) throws SQLException {
        Profissional profissional = new Profissional();
        try {
            profissional.setId(rs.getLong("p.id"));
            profissional.setUsuario(UsuarioDAO.setUsuario(rs));
            profissional.setCPF(rs.getString("p.cpf"));
            profissional.setTelefone(rs.getString("p.telefone"));
            profissional.setSexo(rs.getString("p.sexo"));
            profissional.setDataNascimento(rs.getDate("p.data_nascimento"));

        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return profissional;
    }

    public void insert(Profissional profissional) {
        String sql = "INSERT INTO profissional (id_profissional, cpf, telefone, sexo, data_nascimento) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ;
            statement = conn.prepareStatement(sql);
            statement.setLong(1, profissional.getUsuario().getId());
            statement.setString(2, profissional.getCPF());
            statement.setString(3, profissional.getTelefone());
            statement.setString(4, profissional.getSexo());
            statement.setDate(5, profissional.getDataNascimento());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Profissional> getAll() {
        List<Profissional> listaProfissionals = new ArrayList<>();
        String sql = "SELECT * from profissional p, usuario u WHERE p.id_usuario = u.id";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                listaProfissionals.add(setProfissional(resultSet));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaProfissionals;
    }

    public void delete(Profissional profissional) {
        String sql = "DELETE FROM profissional where id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, profissional.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }

    public void update(Profissional profissional) {
        String sql = "UPDATE profissional SET cpf = ?, telefone = ?, sexo = ?, data_nascimento = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, profissional.getCPF());
            statement.setString(2, profissional.getTelefone());
            statement.setString(3, profissional.getSexo());
            statement.setDate(4, profissional.getDataNascimento());
            statement.setLong(5, profissional.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Profissional getbyID(Long id) {
        Profissional profissional = new Profissional();
        String sql = "SELECT * from profissional p, usuario u WHERE p.id_usuario = u.id AND id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                profissional = setProfissional(resultSet);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return profissional;
    }

    public Profissional getbyemail(String email) {
        Profissional profissional = new Profissional();
        String sql = "SELECT * from profissional p, usuario u WHERE p.id_usuario = u.id AND email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                profissional = setProfissional(resultSet);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return profissional;
    }
}