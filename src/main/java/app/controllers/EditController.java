package app.controllers;

import app.Main;
import app.database.FileJSONWrite;
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
import java.util.Objects;

public class EditController {

    @FXML
    private TextField inputCode;
    @FXML
    private Button search;
    @FXML
    private Button save;
    @FXML
    private Label prompt;

    @FXML
    private TextField inputNewSalary;

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("edit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void saveSalaryInfo(ActionEvent event) throws IOException {
        for (int i = 0; i < UsuariosList.getFuncionarios().size(); i++)
        {
            if (Objects.equals(UsuariosList.getFuncionarios().get(i).getCode(), inputCode.getText()))
            {
                UsuariosList.getFuncionarios().get(i).setSalary(Float.parseFloat(inputNewSalary.getText()));
                FileJSONWrite.createJSON();
                break;
            }
        }

        prompt.setText("Salário Atualizado!");

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void search(ActionEvent event) {
        for (int i = 0; i < UsuariosList.getFuncionarios().size(); i++)
        {
            if (Objects.equals(UsuariosList.getFuncionarios().get(i).getCode(), inputCode.getText()))
            {
                inputNewSalary.setVisible(true);
                save.setVisible(true);
                search.setDisable(true);
            }
        }
    }

    @FXML
    void backToFuncionarios(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }
}
