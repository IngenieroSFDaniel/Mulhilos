    private Socket socket

    public ClienteHandler(Socket Socket){
        this. Socket = Socket;
    }
    public void run()
        try {
        PrintWriter out = new PrintWriter(Socket.getOutputStream(), autoFlush: true);
        BufferedReader in = new  BufferedReader(new InputSreanReader(socket.getInputStream()));

        out.println(*¡Bienevenido a la tienda de camisetas!*);
        out.println(*¿Desea comprar unca camiseta?) (S/N):*);
        String respuesta .readLine();

        if (respuesta != null && respuesta.equalsIgnoreCase(anotherString *s*)){
            out.println(compra realizada con exito.Gracias por su compra);
        } else {
            out.print(Gracias por visitarnos);
        }

        socket.close();
        } cath (I0Exception e) {
        e.printStackTrace();
        }
    }
}