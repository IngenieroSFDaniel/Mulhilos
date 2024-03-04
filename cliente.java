import java.ioI0Exception∗;
import java.net.ServerSocket∗;
import java.net.socket*;

public class Cliente{
    public static void main (String [ ] args) {
        try {
            Socket socket = new Socket(host ”localhost” , port 5000);
            ClienteThread clienteThread = new ClienteThread(socket);
            clienteThread.start();
        } cath (I0Exception e) {
            e.printStackTrace();
        }
    }
}
