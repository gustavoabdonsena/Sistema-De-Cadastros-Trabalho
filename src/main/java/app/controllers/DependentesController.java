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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class DependentesController {

    @FXML
    private Button add;
    @FXML
    private TextField dependentName;

    @FXML
    private ListView<String> dependentsList;

    @FXML
    private Button next;

    @FXML
    private Label prompt;

    ArrayList<Dependente> dependentes = new ArrayList<>();

    @FXML
    void addDependente() {
        int index = UsuariosList.getFuncionarios().size() - 1;

        if (dependentes.size() == UsuariosList.getFuncionarios().get(index).getDependentes() - 1)
        {
            add.setDisable(true);
            UsuariosList.getFuncionarios().get(index).setDependentesList(dependentes);
            FileJSONWrite.createJSON();
            next.setVisible(true);
        }
        else
        {
            dependentes.add(new Dependente(dependentName.getText()));
            dependentsList.getItems().add(dependentName.getText());
            prompt.setText("Dependente Adicionado!");
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

