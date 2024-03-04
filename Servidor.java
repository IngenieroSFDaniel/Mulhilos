import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado.");

                executor.execute(new ClienteHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
class ClienteHandler implements Runnable {
    private Socket socket;

    public ClienteHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            String mensaje;
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println("Mensaje del cliente: " + mensaje);
                salida.println("Mensaje recibido: " + mensaje);
            }
            
            entrada.close();
            salida.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}