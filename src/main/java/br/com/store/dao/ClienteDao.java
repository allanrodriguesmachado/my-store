package br.com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.store.model.Client;
import br.com.store.util.ConnectDB;

public class ClienteDao {
    public Client save(Client client) throws SQLException {
        String sql = "INSERT INTO clients (name, email, contact) VALUES (?, ?, ?)";

        try (Connection conn = ConnectDB.connection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getEmail());
            stmt.setString(3, client.getContact());

            stmt.executeUpdate();

            try (ResultSet result = stmt.getGeneratedKeys()) {
                if (result.next()) {
                    client.setId(result.getInt(1));
                }
            }
        }

        return client;
    }

    public List<Client> list() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT id, name, email, contact FROM clients WHERE ts_canceled IS NULL";

        try (Connection connection = ConnectDB.connection()) {
            var stmt = connection.prepareStatement(sql);
            var resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String contact = resultSet.getString("contact");

                clients.add(new Client(id, name, email, contact));
            }
        }

        return clients;
    }

    public List<Client> listId(Integer idClient) throws SQLException {
        List<Client> client = new ArrayList<>();
        String SQL = "SELECT id, name, email, contact FROM clients WHERE id = ? AND ts_canceled IS NULL";

        try (Connection conn = ConnectDB.connection()) {
            var stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, idClient);
            var result = stmt.executeQuery();

            System.out.println(idClient);

            while (result.next()) {
                Integer id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String contact = result.getString("contact");

                client.add(new Client(id, name, email, contact));
            }
        }

        return client;
    }

    public Client canceled(Integer id) throws SQLException {
        String SQL = "UPDATE clients SET ts_canceled = CURRENT_TIMESTAMP WHERE id = ?";

        try (Connection conn = ConnectDB.connection()) {
            var stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, id);

            stmt.executeUpdate();
        }

        return null;
    }
}
