package br.com.store;

import java.sql.SQLException;

import br.com.store.dao.ClienteDao;
import br.com.store.model.Client;

public class Main {
    public static void main(String[] args) throws SQLException {
        var client = new Client("Allan", "allan@developer.com.br", "11 958664570");

        var saveClient = new ClienteDao();

        saveClient.save(client);
    }
}