import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8080);

        System.out.println("Listning for connection on port 8080");

        while (true) {
//            final Socket clientSocket = server.accept();
//            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
//            BufferedReader reader = new BufferedReader(isr);
//            String line = reader.readLine();
//
//            while (!line.isEmpty()) {
//                System.out.println(line);
//                line = reader.readLine();
//            }
            try (Socket socket = server.accept()) {
                Date today = new Date();
                String httpResponse = "Http/1.1 200 OK\r\n\r\n" + today;
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
            //spin forever
        }
    }
}
