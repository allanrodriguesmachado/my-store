package br.com.store;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.store.dao.ClienteDao;
import br.com.store.model.Client;

public class Main {
    public static void main(String[] args) throws SQLException {
        ClienteDao clienteDAO = new ClienteDao();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- CRUD Clientes (Java Puro + JDBC) ---");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Gerenciar Clientes (Listar/Atualizar/Deletar)");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Nome: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Telefone: ");
                    String contact = sc.nextLine();
                    Client client = new Client(name, email, contact);
                    clienteDAO.save(client);
                    System.out.printf("Parabens %s Cadastro realizado com sucesso", name);
                    break;
                case 2:
                default:
                    break;
            }
        }

    }

}