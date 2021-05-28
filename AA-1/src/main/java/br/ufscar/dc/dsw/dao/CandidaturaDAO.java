package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Candidatura;

public class CandidaturaDAO extends GenericDAO {

    public static Candidatura setCandidatura(ResultSet rs) throws SQLException {
        Candidatura candidatura = new Candidatura();

        try {
            candidatura.setId(rs.getLong("c.id"));
            candidatura.setProfissional(ProfissionalDAO.setProfissional(rs));
            candidatura.setVaga(VagaDAO.setVaga(rs));
            candidatura.setCurriculo(rs.getString("c.curriculo"));
            candidatura.setStatus(rs.getString("c.status"));
            candidatura.setDataEntrevista(rs.getDate("c.data_entrevista"));
            candidatura.setLinkEntrevista(rs.getString("c.link_entrevista"));
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return candidatura;
    }

    public void insert(Candidatura candidatura) {
        String sql = "INSERT INTO candidatura (id_profissional, id_vaga, curriculo, status, data_entrevista, link_entrevista) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
            statement.setLong(1, candidatura.getProfissional().getId());
            statement.setLong(2, candidatura.getVaga().getId());
            statement.setString(3, candidatura.getCurriculo());
            statement.setString(4, candidatura.getStatus());
            statement.setDate(5, candidatura.getDataEntrevista());
            statement.setString(6, candidatura.getLinkEntrevista());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Candidatura> getAll() {
        List<Candidatura> listaCandidaturas = new ArrayList<>();
        String sql = "SELECT * FROM candidatura c, profissional p, usuario up, vaga v,"
                + " empresa e, usuario ue WHERE up.id = p.id_usuario AND ue. id = e.id_usuario AND"
                + "v.id_empresa = e.id AND c.id_vaga = v.id AND c.id_profissional = p.id";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                listaCandidaturas.add(setCandidatura(resultSet));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCandidaturas;
    }

    public void delete(Candidatura candidatura) {
        String sql = "DELETE FROM candidatura WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, candidatura.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Candidatura candidatura) {
        String sql = "UPDATE candidatura SET curriculo = ?, status = ?, data_entrevista = ?, link_entrevista = ? WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
            statement.setString(1, candidatura.getCurriculo());
            statement.setString(2, candidatura.getStatus());
            statement.setDate(3, candidatura.getDataEntrevista());
            statement.setString(4, candidatura.getLinkEntrevista());
            statement.setLong(5, candidatura.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Candidatura getByID(Long idCandidatura) {
        Candidatura candidatura = null;
        String sql = "SELECT * FROM candidatura c, profissional p, usuario up, vaga v,"
                + " empresa e, usuario ue WHERE up.id = p.id_usuario AND ue. id = e.id_usuario AND"
                + "v.id_empresa = e.id AND c.id_vaga = v.id AND c.id_profissional = p.id AND c.id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, idCandidatura);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                candidatura = setCandidatura(resultSet);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return candidatura;
    }

    public List<Candidatura> getAllByProfissional(Long idProfissional) {
        List<Candidatura> listaCandidaturas = new ArrayList<>();
        String sql = "SELECT * FROM candidatura c, profissional p, usuario up, vaga v,"
                + " empresa e, usuario ue WHERE up.id = p.id_usuario AND ue. id = e.id_usuario AND"
                + "v.id_empresa = e.id AND c.id_vaga = v.id AND c.id_profissional = p.id AND p.id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, idProfissional);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listaCandidaturas.add(setCandidatura(resultSet));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCandidaturas;
    }

    public List<Candidatura> getAllByVaga(Long idVaga) {
        List<Candidatura> listaCandidaturas = new ArrayList<>();
        String sql = "SELECT * FROM candidatura c, profissional p, usuario up, vaga v,"
                + " empresa e, usuario ue WHERE up.id = p.id_usuario AND ue. id = e.id_usuario AND"
                + "v.id_empresa = e.id AND c.id_vaga = v.id AND c.id_profissional = p.id AND v.id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, idVaga);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listaCandidaturas.add(setCandidatura(resultSet));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCandidaturas;
    }
}
