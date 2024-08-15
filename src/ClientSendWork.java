import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClientSendWork implements Runnable {
    private BufferedWriter bufferedWriter;

    public ClientSendWork(BufferedWriter writer) {
        this.bufferedWriter = writer;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String message = "";
        System.out.println("Welcome to Free Chat App !");
        System.out.println("Feel free to type your message to chat with friends: ");
        while (true) {
            message = scanner.nextLine();
            try {
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
