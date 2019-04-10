package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static ArrayList<Usuarios> users;
    private ServerSocket socketServer;
   
    public Servidor() throws IOException {
        this.socketServer = new ServerSocket(20021);
        this.users = new ArrayList<>();
    }

    public void iniciarServico() throws IOException {
        while (true) {
            Socket socket = socketServer.accept();
            Scanner s = new Scanner(socket.getInputStream());
            String nomeUser = s.nextLine();
            Usuarios user = new Usuarios(nomeUser, socket);           
            users.add(user);           
            new Thread(new EscutarClientes(user)).start();
        }
    }
    
    public static void main(String[] args) {
        try {
            Servidor servidor = new Servidor();
            servidor.iniciarServico();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
