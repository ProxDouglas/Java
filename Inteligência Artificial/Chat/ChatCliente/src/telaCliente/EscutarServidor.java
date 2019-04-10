package telaCliente;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


public class EscutarServidor implements Runnable{

    private Socket socket;
    private Scanner scanner;
    private JTextArea areaMsgn;
    
    public EscutarServidor(Socket socket,JTextArea areaMsgn) {
        try {
            this.socket = socket;
            this.areaMsgn = areaMsgn;
            this.scanner = new Scanner(this.socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(EscutarServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @Override
    public void run() {
        String linha;
        while(true){
            linha = scanner.nextLine();
            if(linha != null){
                areaMsgn.append(linha + "\n");
            }
        }
    }   
    
}
