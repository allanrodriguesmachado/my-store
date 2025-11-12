package br.com.store;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.store.dao.ClienteDao;
import br.com.store.model.Client;

public class Main {
    public static void main(String[] args) throws SQLException {
        ClienteDao clienteDAO = new ClienteDao();
        Scanner sc = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n--- CRUD Clientes (Java Puro + JDBC) ---");
            System.out.println("1. Registar");
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
                    System.out.printf("Parabens %s, Cadastro realizado com sucesso", name);
                    break;
                case 2:

                    boolean runningTwo = true;

                    while (runningTwo) {
                        System.out.println("\n--- CRUD Clientes (Java Puro + JDBC) ---");
                        System.out.println("1. Listar");
                        System.out.println("2. Listar um cliente, infor o ID)");
                        System.out.println("3. Cancelar");
                        System.out.println("4. Sair");

                        System.out.print("Escolha uma opção: ");

                        int option2 = sc.nextInt();
                        switch (option2) {
                            case 1:
                                List<Client> listClient = clienteDAO.list();
                                for (Client c : listClient) {
                                    System.out.println("Id:: " + c.getId());

                                    System.out.println("Nome: " + c.getEmail());
                                }

                                break;
                            case 2:
                                System.out.println("Digite o ID do Cliente");
                                System.out.print("Digite: ");
                                int idClient = sc.nextInt();
                                sc.nextLine();
                                List<Client> clientId = clienteDAO.listId(idClient);

                                if (clientId.size() == 0) {
                                    System.out.println("Cliente nao localizado");
                                }

                                for (Client c : clientId) {
                                    System.out.println("Id:: " + c.getId());
                                    System.out.println("Nome: " + c.getEmail());
                                }
                                break;
                            case 3:
                                System.out.println("Digite o ID que deseja cancelar");
                                System.out.print("Digite: ");
                                int idCanceled = sc.nextInt();
                                sc.nextLine();
                                System.out.println("3. Cancelar");
                                clienteDAO.canceled(idCanceled);
                            default:
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("Opcao selecionada invalida");
                    break;
            }
        }

    }

}