package app.controllers;

import app.Main;
import app.client.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import app.database.UsuariosList;

import java.io.IOException;

public class FuncionariosController {

    @FXML
    private ListView<Funcionario> listOfFuncionarios;

    @FXML
    void deleteFuncionario(ActionEvent event) {
        int selectedID = listOfFuncionarios.getSelectionModel().getSelectedIndex();
        listOfFuncionarios.getItems().remove(selectedID);
    }

    @FXML
    void registerNewEmployee(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sign-in.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

}
