import java.io.*;
import java.net.Socket;

public class ClientApp {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.0.115", 8888);
        System.out.println("Server connected");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        new Thread(new ClientReceiveWork(bufferedReader)).start();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        new Thread(new ClientSendWork(bufferedWriter)).start();



    }

}


