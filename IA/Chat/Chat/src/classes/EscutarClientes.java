package classes;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EscutarClientes implements Runnable {
    
    private Scanner scanner;

    public EscutarClientes(Usuarios usuario) {
        try {
            this.scanner = new Scanner(usuario.getSocket().getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(EscutarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        String linha;
        while((linha = scanner.nextLine()) != null){          
            new Thread(new EnviarConversa(linha)).start();          
        }        
    }    
}
