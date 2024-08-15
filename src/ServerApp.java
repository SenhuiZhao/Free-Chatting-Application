import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerApp {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server started");
        int i = 1;

        List<BufferedWriter> writerList = new ArrayList<>();


        while (true) {
            Socket socket = serverSocket.accept();
            writerList.add(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            System.out.println("Client " + i + " connected");
            new Thread(new ServerReceiveWork(socket, i, writerList)).start();
            System.out.println("Client " + i + " ready to receive data");
            i++;
        }

    }
}
