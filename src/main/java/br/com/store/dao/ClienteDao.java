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

    public List<Client> list() {
        List<Client> clients = new ArrayList<>();
        
    }
}
