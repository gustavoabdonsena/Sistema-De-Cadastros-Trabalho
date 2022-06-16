package app.controllers;

import app.Main;
import app.client.Dependente;
import app.database.UsuariosList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    @FXML
    private Button add;
    @FXML
    private Button next;

    private ArrayList<Dependente> dependentes = new ArrayList<>();


    @FXML
    void addDependente()
    {
        if (dependentes.size() == UsuariosList.getFuncionarios().get(-1).getDependentes())
        {
            UsuariosList.getFuncionarios().get(-1).setDependentesList(dependentes);
            add.setDisable(true);
            next.setVisible(true);
        }
        else
        {
            dependentes.add(new Dependente(dependentName.getText()));
            prompt.setText("Dependente adicionado");
        }
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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }
}
