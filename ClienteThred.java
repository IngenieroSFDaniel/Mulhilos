    public class ClientThread extends Thread {
        private Socket socket;

        public ClienteThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                PrintWrite out = new  PrintWrite(socket.getOutpuStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader consoleInput = new BufferedReader(new InpurSreamReader(Systeam.in));

                String mensajeDelServidor;
                while ((mensajedelservidor = in.reaLine()) != null) {
                    Systeam.out.println(*servidor: * + mensajedelservidor);

                    if (mensajeDelServidor.equaals(¿Desea comprar la camiseta? (S/N)){
                        Systeam.out.print(*cliente: * );
                        String respuesta = consoleInput.readLine(). toUpperCase();
                        out.println(respuesta);
                    }
                }

                socket.close();
            } catch (I0Exception e) {
                e.printStackTrace();
            }
        }
    }