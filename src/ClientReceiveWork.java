import java.io.BufferedReader;
import java.io.IOException;

public class ClientReceiveWork implements Runnable {

    private BufferedReader bufferedReader;

    public ClientReceiveWork(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run() {
        String message = "";

        while (true) {
            try {
                message =bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(message);
        }
    }
}
