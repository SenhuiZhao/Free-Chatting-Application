import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

public class ServerReceiveWork implements Runnable {

    private Socket socket;
    private int client;

    private List<BufferedWriter> writerList;


    ServerReceiveWork(Socket socket, int client, List<BufferedWriter> writerList) {
        this.socket = socket;
        this.client = client;
        this.writerList = writerList;
    }

    @Override
    public void run() {

        String message = null;

        while (true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                message = br.readLine();
                System.out.println("Received message from Client " + client + " : " + message);

                for (BufferedWriter writer : writerList) {
                    writer.write("Client " + client + " : " + message);
                    writer.newLine();
                    writer.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
