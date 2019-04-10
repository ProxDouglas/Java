import java.rmi.Naming;

public class ServidorSVEServer {
    
    public ServidorSVEServer(){
        try{
            ServidorSVE s = new ServidorSVEImpl();
            Naming.rebind("rmi://127.0.0.1:1099/ServidorSVEServicos", s);
        }catch(Exception e){
            System.out.println("Trouble: " + e);
        }
    }
    
    public static void main(String[] args) {
        new ServidorSVEServer();
    }
}
