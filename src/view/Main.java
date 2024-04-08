package view;

import br.edu.fateczl.queue.Queue;
import controller.QueueController;
import model.Client;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {
            Queue<Client> simpleQueue = new Queue<>();
            Queue<Client> priorityQueue = new Queue<>();
            QueueController queueController = new QueueController();

            int count = 0;
            int nextId = 0;
            int option;
            do{
                System.out.println();
                System.out.println("----- Customer Service System -----");
                System.out.println("[1] Add client to the simple queue");
                System.out.println("[2] Add client to the priority queue");
                System.out.println("[3] Call a client");
                System.out.println("[0] Finalize");
                System.out.print(">> ");

                try {
                    option = Integer.parseInt(sc.nextLine());
                } catch(NumberFormatException e) {
                    option = -1;
                }

                switch (option) {
                    case 1:
                        queueController.insertClient(simpleQueue, registryClient(sc, nextId));
                        nextId++;
                        break;

                    case 2:
                        queueController.insertClient(priorityQueue, registryClient(sc, nextId));
                        nextId++;
                        break;

                    case 3:
                        if (count < 3 && !priorityQueue.isEmpty()) {
                            Client client = queueController.callClient(priorityQueue);
                            System.out.println("Calling client " + client);
                            count++;

                        } else if (!simpleQueue.isEmpty()) {
                            Client client = queueController.callClient(simpleQueue);
                            System.out.println("Calling client " + client);
                            count = 0;

                        } else {
                            System.out.println("There are no clients to call!");

                        }
                        break;

                    case 0:
                        System.out.println("Finalizing...");
                        break;

                    default:
                        System.out.println("Invalid operation!");
                }

            }while(option != 0);

        } catch(Exception e) {
            System.err.println(e.getMessage());

        }

    }

    public static Client registryClient(Scanner sc, int id)  {
        Client client = new Client();
        client.setId(id);
        System.out.print("Client name: ");
        client.setName(sc.nextLine());
        return client;

    }
}
