package primitivos;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class KochSnowFlake {
    int level = 0;

    public void init()
    {
        String levelStr = JOptionPane.showInputDialog("Digite o número de recurssões: ");
        level = Integer.parseInt(levelStr);


    }

    public void paint(GraphicsContext g)
    {
        drawSnow(g,level,20,280,280,280);
        drawSnow(g,level,280,280,150,20);
        drawSnow(g,level,150,20,20,280);
    }

    private void drawSnow (GraphicsContext g, int lev, int x1, int y1, int x5, int y5)
    {
        int deltaX, deltaY, x2, y2, x3, y3, x4, y4;

        if (lev == 0){
            //g.drawLine(x1, y1, x5, y5);
            RetaGr.desenhar(g, x1, y1, x5, y5, "", Color.RED,  2, AlgoritmosRetas.MIDPOINT);
        }
        if (lev != 0){
            deltaX = x5 - x1;
            deltaY = y5 - y1;

            x2 = x1 + deltaX / 3;
            y2 = y1 + deltaY / 3;

            x3 = (int) (0.5 * (x1+x5) + Math.sqrt(3) * (y1-y5)/6);
            y3 = (int) (0.5 * (y1+y5) + Math.sqrt(3) * (x5-x1)/6);

            x4 = x1 + 2 * deltaX /3;
            y4 = y1 + 2 * deltaY /3;

            drawSnow (g,lev-1, x1, y1, x2, y2);
            drawSnow (g,lev-1, x2, y2, x3, y3);
            drawSnow (g,lev-1, x3, y3, x4, y4);
            drawSnow (g,lev-1, x4, y4, x5, y5);
        }
    }

    public KochSnowFlake(Stage palco){

        // define titulo da janela
        palco.setTitle("Testa Reta");

        // define largura e altura da janela
        palco.setWidth(500);
        palco.setHeight(500);

        // Painel para os componentes
        BorderPane pane = new BorderPane();

        // componente para desenho
        javafx.scene.canvas.Canvas canvas = new Canvas(500, 500);

        // componente para desenhar graficos
        GraphicsContext gc;
        gc = canvas.getGraphicsContext2D();

        init();

        paint(gc);

        // atributos do painel
        pane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        pane.setCenter(canvas); // posiciona o componente de desenho

        // cria e insere cena
        Scene scene = new Scene(pane);
        palco.setScene(scene);
        palco.show();
    }
}
