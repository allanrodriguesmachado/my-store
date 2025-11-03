package br.com.store;

import java.sql.SQLException;

import br.com.store.dao.ClienteDao;
import br.com.store.model.Client;

public class Main {
    public static void main(String[] args) throws SQLException {
        ClienteDao clienteDAO = new ClienteDao();

        var client = clienteDAO.list();
        var clientID = clienteDAO.listId(4);

        for (Client c : clientID) {
            System.out.printf("ID: %d, Nome: %s, Email: %s\n", c.getId(), c.getName(), c.getEmail());

        }

    
    }

}