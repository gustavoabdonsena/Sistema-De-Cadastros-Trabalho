package app.controllers;

import app.database.CodeValidation;
import app.database.FileJSON;
import app.database.UsuariosList;
import app.client.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;


public class HelloController {
    @FXML
    private Label prompt;
    @FXML
    private TextField inputName;

    @FXML
    private TextField inputCode;

    @FXML
    private TextField inputCargo;




    @FXML
    void createFuncionario(ActionEvent event)
    {

        if(CodeValidation.validate(inputCode.getText())){
            prompt.setText("Funcionário Já Existe!");
        }else {
            UsuariosList.createFuncionario(new Funcionario(inputName.getText(), inputCode.getText(),inputCargo.getText(),3,10000));

            FileJSON.createJSON();
            prompt.setText("Funcionário adicionado!");
        }



    }

    @FXML
    void loginFuncionario(ActionEvent event) {
        System.out.println("Entrou ");

    }



}