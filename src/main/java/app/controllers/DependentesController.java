package app.controllers;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DependentesController {

    @FXML
    private Label prompt;

    @FXML
    private VBox vbox;

    @FXML
    void addDependentes(ActionEvent event) {

    }

    /*@FXML
    void addDependentes(ActionEvent event) throws IOException
    {
        ArrayList<Dependente> dependentes = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(inputQtdDependentes.getText()); i++)
        {
            TextField inputDependente = (TextField) scene.lookup("#inputDependente" + i);
            Dependente dependente = new Dependente(inputDependente.getText());
            dependentes.add(dependente);
        }
        UsuariosList.getFuncionarios().get(-1).setDependentesList(dependentes);

        //Switch to employee's info page
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
        scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }*/

    @FXML
    void backToFirst(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("first-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }
}
