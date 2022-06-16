package app;

import app.database.FileJSONRead;
import app.database.FileJSONWrite;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("first-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage.setResizable(false);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        //Método de carregamento do banco de dados
        FileJSONRead.loadJSON();
        launch();

    }

}