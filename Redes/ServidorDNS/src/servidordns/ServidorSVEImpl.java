import java.rmi.RemoteException;


public class ServidorSVEImpl extends java.rmi.server.UnicastRemoteObject implements ServidorSVE{

    private String[] listaEmails= {"email"};
    
    public ServidorSVEImpl() throws RemoteException{
        super();
    }
    
    @Override
    public String consultarEmail(String email)throws java.rmi.RemoteException {
         for (int j = 0; j < listaEmails.length; j++) {
            String string = listaEmails[j];
            if(string.equals(email));
                return "Correto!";
         }
         return "Incorreto!";
    }
    
    
    
}
