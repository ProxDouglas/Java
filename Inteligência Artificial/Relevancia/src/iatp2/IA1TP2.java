package iatp2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IA1TP2 {
  public static void main(String[] args) throws IOException {
    
      Path train = Paths.get("train.csv");
    
      List<String> treino =  Files.readAllLines(train,StandardCharsets.ISO_8859_1);
      List<Integer> product = new ArrayList<>();
      List<Double> relevan = new ArrayList<>();
      List<Integer> id = new ArrayList<>();
      List<String> title = new ArrayList<>();
      List<String> setheme = new ArrayList<>();
      
      int t = 0;
      int count = 0;
      double relevancia = 0;
      double media = 0;
      double var = 0;
      double relevparcial = 0;
    // treinamento
    
    for (int i = 1; i<=(treino.size())-1 ; i++) {
           
        String tr = treino.get(i);     
        String [] a = tr.split(","); 
        String [] b = tr.split("\"");
        String [] c = tr.split("\",");
    
        id.add(t, Integer.parseInt(a[0]));
        product.add(t, Integer.parseInt(a[1]));
        title.add(t, b[1]);
        setheme.add(t, c[2]);
        relevan.add(t, Double.parseDouble(c[2]));
        t++; 
        
    }

    for (int j = 0; j <= (product.size())-1; j++){
        if(product.get(j) == 100017){
            
            count = count + 1;
            relevancia = relevan.get(j) + relevancia;
            System.out.println("relevancia: "+relevan.get(j));
            
        }           
    }
    
    media = relevancia / count;
    
    int j = 0;
    
    for (int i = 0; i <= (product.size())-1; i++){
        if(product.get(i) == 100017){
            
            relevparcial = (relevan.get(i) - media) * (relevan.get(i) - media);
            //System.out.println("relevancia: "+relevan.get(i));
            var = var + relevparcial;

            j++;
        }
    }
    
    var = (var / count); 
      
    System.out.println("Contador: "+count);
    System.out.println("Somatória: "+relevancia);
    System.out.println("Média: "+media);
    System.out.println("Variância: "+var);
      
      
      
      
 //  for (int j = 0; j <= (relevan.size())-1; j++){
              
   //           System.out.println(relevan.get(j));   
     //   }
  }
  
}
