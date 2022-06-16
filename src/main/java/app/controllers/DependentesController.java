package app.controllers;

import app.Main;
import app.client.Dependente;
import app.database.FileJSONWrite;
import app.database.UsuariosList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class DependentesController {

    @FXML
    private Label prompt;
    @FXML
    private TextField dependentName;

    private ArrayList<Dependente> dependentes = new ArrayList<>();


    @FXML
    void addDependente(ActionEvent event) throws IOException
    {

        Dependente dependente = new Dependente(dependentName.getText());
        dependentes.add(dependente);
        prompt.setText("Dependente adicionado");

        UsuariosList.getFuncionarios().get(-1).setDependentesList(dependentes);

        FileJSONWrite.createJSON();
    }

    @FXML
    void backToFirst(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("first-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void next(ActionEvent event) throws IOException {
        //Switch to employee's info page
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }
}
