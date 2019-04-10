package classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class outroTeste {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("/home/matheus.flausino/teste.txt")).useDelimiter("\\s");
        ArrayList<String> nomes = new ArrayList<>();
        String nome = "";
        String telefone;
        String cpf;
        double valor;
        int i = 0;

        while (scanner.hasNext()) {
            nome = scanner.next();
            if (nome.equals("")) {
                scanner.next();
                scanner.next();
                nome = scanner.next();
            }

            if (nome.equals("Próximo")) {
                scanner.next();
                nome = scanner.next();
            }
            nome = nome.replaceAll("\\w", "");
            System.out.println("nome : " + nome);
            telefone = scanner.next();
            System.out.println("telefone : " + telefone);
            cpf = scanner.next();
            System.out.println("cpf : " + cpf);
            valor = Double.parseDouble(scanner.next());
            System.out.println("valor : " + valor);
        }
    }
}
