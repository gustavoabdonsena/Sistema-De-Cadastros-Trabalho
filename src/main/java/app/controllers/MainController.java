package app.controllers;

import app.Main;
import app.client.Funcionario;
import app.database.CodeValidation;
import app.database.FileJSONRead;
import app.database.FileJSONWrite;
import app.database.UsuariosList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;

import java.io.IOException;


public class MainController {
    @FXML
    private Label prompt;
    @FXML
    private TextField inputName;

    @FXML
    private TextField inputCode;

    @FXML
    private TextField inputCargo;

    @FXML
    private TextField inputSalario;

    private Stage stage;
    private Scene scene;

    @FXML
    void signIn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sign-in.fxml"));
        scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logIn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("log-in.fxml"));
        scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backToFirst(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("first-scene.fxml"));
        scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void createFuncionario(ActionEvent event) throws IOException
    {
        try{
            if(CodeValidation.validate(inputCode.getText())){
                prompt.setText("Funcionário Já Existe!");
            }else {
                UsuariosList.createFuncionario(new Funcionario(
                        inputName.getText()
                        ,inputCode.getText()
                        ,inputCargo.getText()
                        ,3
                        ,Float.parseFloat(inputSalario.getText()
                )));

                FileJSONWrite.createJSON();
                prompt.setText("Funcionário adicionado!");

                //Switch to employee's info page
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
                scene = new Scene(fxmlLoader.load(), 800 , 450);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setTitle("Sistemas de Funcionários");
                stage.setScene(scene);
                stage.show();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.show();
            }
    }

    @FXML
    void loginFuncionario(ActionEvent event) throws IOException {

        FileJSONRead.loadJSON();
        if(CodeValidation.validate(inputCode.getText())){
            prompt.setText("Entrada bem Sucedida (Colocar tela para excluir dependentes)");
        }else{
            prompt.setText("Usuário não encontrado!");
        }

        //Switch to employee's info page
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
        scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();

    }
}