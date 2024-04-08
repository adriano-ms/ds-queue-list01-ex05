package controller;

import br.edu.fateczl.queue.Queue;
import model.Client;

public class QueueController {

    public QueueController() {
        super();
    }

    public void insertClient(Queue<Client> queue, Client client) {
        queue.insert(client);
    }

    public Client callClient(Queue<Client> queue) throws Exception {
        return queue.remove();
    }
}
