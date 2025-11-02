package br.com.store;

import java.sql.SQLException;
import java.util.List;

import br.com.store.dao.ClienteDao;
import br.com.store.model.Client;

public class Main {
    public static void main(String[] args) throws SQLException {
        ClienteDao clienteDAO = new ClienteDao();
        List<Client> client = clienteDAO.list();

        for (Client c : client) {
            System.out.printf("ID: %d, Nome: %s, Email: %s\n", c.getId(), c.getName(), c.getEmail());

        }
    }

}