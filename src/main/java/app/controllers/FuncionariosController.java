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
    TableColumn<Funcionario, String> CodeColumn;
    @FXML
    TableColumn<Funcionario,String> CargoColumn;
    @FXML
    TableColumn<Funcionario, Integer> DependentesColumn;
    @FXML
    TableColumn<Funcionario, Double> SalaryColumn;

    ObservableList<Funcionario> funcionario = FXCollections.observableArrayList(
            new Funcionario("FNCIONARIO", "A~BCDEF", "GErente", 10, 2000)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        CodeColumn.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        CargoColumn.setCellValueFactory(new PropertyValueFactory<>("Cargo"));
        DependentesColumn.setCellValueFactory(new PropertyValueFactory<>("Dependentes"));
        SalaryColumn.setCellValueFactory(new PropertyValueFactory<>("Salary"));

        FuncionariosInfo.setItems(funcionario);
    }

    @FXML
    void deleteFuncionario(ActionEvent event) {
        int selectedID = FuncionariosInfo.getSelectionModel().getSelectedIndex();
        FuncionariosInfo.getItems().remove(selectedID);
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
