package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.setTitle("GridPane Experiment");
        ArrayList<GridPane> gridy = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            gridy.add(new GridPane());
        }
        ArrayList<ArrayList<Button>> buttony =new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            buttony.add(i, new ArrayList<Button>(9));
            for (int j = 0; j < 9; j++) {
                buttony.get(i).add(j,new Button());
            }
        }

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: white");
        gridPane.setMinSize(2000,2000);
        for (int i=0;i<3;i++ ){
            for(int j=0;j<3;j++){
                GridPane grid =gridy.get(3*i+j);
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int n= 3*k+l;
                        String a =Integer.toString(n);
                        Button button = buttony.get(3*i+j).get(3*k+l);

                        button.setStyle("-fx-border-color:black;-fx-background-color: transparent");
                        button.setOnAction(event -> {grid.setStyle("-fx-background-color: aqua;");});
                        grid.add(button,l,k,1,1);
                        grid.setPrefSize(600,600);

                    }
                }
                gridPane.add(grid,j,i,1,1);

            }
        }
        buttony.get(4).get(4).setStyle("-fx-background-color: darkcyan");
        gridy.get(3).setStyle("-fx-background-color: gold");
        Scene scene = new Scene(gridPane, 240, 100);
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.show();


    }


    public static void main(String[] args) {

        launch(args);

    }
}
