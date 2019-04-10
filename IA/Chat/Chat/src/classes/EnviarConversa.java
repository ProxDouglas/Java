package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EnviarConversa implements Runnable {

    private String conversa;
    private ArrayList<Usuarios> users;
    private PrintWriter pw;

    public EnviarConversa(String conversa) {
        this.conversa = conversa;
        users = Servidor.users;
    }    
    
    @Override
    public void run() {
        for(Usuarios usuario : users){
            try {
                pw = new PrintWriter(usuario.getSocket().getOutputStream());
                pw.println(conversa);
                pw.flush();
            } catch (IOException ex) {
                Logger.getLogger(EnviarConversa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
}
