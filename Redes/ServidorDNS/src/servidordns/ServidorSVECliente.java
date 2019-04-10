import java.rmi.Naming;

public class ServidorSVECliente {
  

public class CalculatorClient {
    
}
    public static void main(String[] args) {
        try {
            ServidorSVE s = (ServidorSVE)
            Naming.lookup("rmi://localhost/ServidorSVEServicos");
            System.out.println(s.consultarEmail("email"));
        }catch(Exception e){
            System.out.println("Trouble: " + e);
        }
    }
    
}
