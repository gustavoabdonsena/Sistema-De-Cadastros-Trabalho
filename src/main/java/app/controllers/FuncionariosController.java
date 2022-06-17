package app.controllers;

import app.Main;
import app.client.Funcionario;
import app.database.UsuariosList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FuncionariosController implements Initializable {

    @FXML
    private TableView<Funcionario> FuncionariosInfo;
    @FXML
    private TableColumn<Funcionario, String> NameColumn;
    @FXML
    private TableColumn<Funcionario, Integer> DependentesColumn;
    @FXML
    private TableColumn<Funcionario, Integer> SalaryColumn;
    @FXML
    private TableColumn<Funcionario, Double> BonusColumn;

    private ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        funcionarios.addAll(UsuariosList.getFuncionarios());

        NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        DependentesColumn.setCellValueFactory(new PropertyValueFactory<>("dependentes"));
        SalaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        BonusColumn.setCellValueFactory(new PropertyValueFactory<>("bonus"));

        FuncionariosInfo.setItems(funcionarios);
    }

    @FXML
    void deleteFuncionario(ActionEvent event) throws IOException {
        //Switch to "delete employee" page
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("delete.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("edit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
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
}
