package gui;

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
import primitivos.AlgoritmosCirculos;
import primitivos.AlgoritmosRetas;
import primitivos.CirculoGr;
import primitivos.RetaGr;

public class CirculosRetas{

    public CirculosRetas(Stage stage){

        //define titulo da janela
        stage.setTitle("Circulos_Retas");

        // define largura e altura da janela
        stage.setWidth(500);
        stage.setHeight(500);

        // Painel para os componentes
        BorderPane pane = new BorderPane();

        // componente para desenho
        javafx.scene.canvas.Canvas canvas = new Canvas(500, 500);

        // componente para desenhar graficos
        GraphicsContext gc;
        gc = canvas.getGraphicsContext2D();


        DesenarArte(gc);

        // atributos do painel
        pane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        pane.setCenter(canvas);

        // cria e insere cena
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    public void DesenarArte(GraphicsContext gc) {
        int x = 250;
        int y = 250;

        DesenharCirculo(x, y, gc);
        DesenharCirculo(x-50, y, gc);
        DesenharCirculo(x+50, y, gc);
        DesenharCirculo(x-25, y+40, gc);
        DesenharCirculo(x+25, y+40, gc);
        DesenharCirculo(x-25, y-50, gc);
        DesenharCirculo(x+25, y-50, gc);


        DesenharLinha(gc, x-75, y+45, x+75, y+45);
        DesenharLinha(gc, x-75, y-45, x+75, y-45);
        DesenharLinha(gc, x-75, y-45, x-75, y+45);
        DesenharLinha(gc, x+75, y-45, x+75, y+45);

        DesenharLinha(gc, x-75, y-45, x+75, y+45);
        DesenharLinha(gc, x+75, y-45, x-75, y+45);
        DesenharLinha(gc, x-50, y-5, x+50, y-5);
        DesenharLinha(gc, x-75, y-45, x, y+85);

        DesenharLinha(gc, x, y+85, x+75, y-45);
        DesenharLinha(gc, x-75, y+45, x, y-95);
        DesenharLinha(gc, x+75, y+45, x, y-95);
        DesenharLinha(gc, x-75, y-45, x, y-95);

        DesenharLinha(gc, x+75, y-45, x, y-95);
        DesenharLinha(gc, x-75, y-45, x+75, y-45);
        DesenharLinha(gc, x-75, y-45, x+75, y-45);
        DesenharLinha(gc, x-75, y-45, x+75, y-45);
        DesenharLinha(gc, x-75, y-45, x+75, y-45);

        DesenharLinha(gc, x-75, y+45, x, y+85);
        DesenharLinha(gc, x+75, y+45, x, y+85);
    }

    public void DesenharCirculo(int x, int y, GraphicsContext gc )
    {
        CirculoGr.desenhar(gc, x, y, 50, Color.GREEN, "", 2, AlgoritmosCirculos.STROKELINE);
    }

    public void DesenharLinha(GraphicsContext gc ,int x0, int y0, int x1, int y1)
    {
        RetaGr.desenhar(gc, x0, y0, x1, y1, "", Color.RED,  1, AlgoritmosRetas.MIDPOINT);
    }




}
