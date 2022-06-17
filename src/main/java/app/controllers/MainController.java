package app.controllers;

import app.Main;
import app.client.Dependente;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


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
    @FXML
    private TextField inputQtdDependentes;

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
                        ,Integer.parseInt(inputQtdDependentes.getText())
                        ,Float.parseFloat(inputSalario.getText())
                ));

                if (Integer.parseInt(inputQtdDependentes.getText()) > 0)
                {
                    //Switch to "add dependents" page
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("dependentes-sign-in.fxml"));
                    scene = new Scene(fxmlLoader.load(), 800 , 450);
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setTitle("Sistemas de Funcionários");
                    stage.setScene(scene);
                    stage.show();

                    FileJSONWrite.createJSON();
                    prompt.setText("Funcionário adicionado!");
                }
                else
                {
                    //Switch to employee's info page
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
                    scene = new Scene(fxmlLoader.load(), 800 , 450);
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setTitle("Sistemas de Funcionários");
                    stage.setScene(scene);
                    stage.show();

                    FileJSONWrite.createJSON();
                    prompt.setText("Funcionário adicionado!");
                }


            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
            }
    }

    @FXML
    void deleteFuncionario(ActionEvent event) throws IOException {
        //Switch to "delete employee" page
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("delete.fxml"));
        scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void removeFuncionario(ActionEvent event) throws IOException {
        //Delete employee from database
        if(CodeValidation.validate(inputCode.getText())){

            for (Funcionario funcionario:UsuariosList.getFuncionarios())
            {
                if (Objects.equals(funcionario.getCode(), inputCode.getText()))
                {
                    UsuariosList.deleteFuncionario(funcionario);
                    FileJSONWrite.createJSON();
                    break;
                }
            }

            //Switch to employee's info page
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
            scene = new Scene(fxmlLoader.load(), 800 , 450);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Sistemas de Funcionários");
            stage.setScene(scene);
            stage.show();

        }else{
            prompt.setText("Funcionário Inexistente!");
        }

    }

    @FXML
    void loginFuncionario(ActionEvent event) throws IOException {

        if(CodeValidation.validate(inputCode.getText())){
            prompt.setText("Entrada bem Sucedida");
            //Switch to employee's info page
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
            scene = new Scene(fxmlLoader.load(), 800 , 450);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Sistemas de Funcionários");
            stage.setScene(scene);
            stage.show();

        }else{
            prompt.setText("Usuário não encontrado!");
        }

    }
}