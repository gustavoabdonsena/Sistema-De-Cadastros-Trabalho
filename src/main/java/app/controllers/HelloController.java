package app.controllers;

import app.database.CodeValidation;
import app.database.FileJSONRead;
import app.database.FileJSONWrite;
import app.database.UsuariosList;
import app.client.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;


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
    private TextField inputSalario;




    @FXML
    void createFuncionario(ActionEvent event)
    {

        if(CodeValidation.validate(inputCode.getText())){
            prompt.setText("Funcionário Já Existe!");
        }else {
            UsuariosList.createFuncionario(new Funcionario(
                    inputName.getText()
                    ,inputCode.getText()
                    ,inputCargo.getText()
                    ,3
                    ,Float.parseFloat(inputSalario.getText())));

            FileJSONWrite.createJSON();
            prompt.setText("Funcionário adicionado!");
        }



    }

    @FXML
    void loginFuncionario(ActionEvent event) {

        FileJSONRead.loadJSON();
        if(CodeValidation.validate(inputCode.getText())){
            prompt.setText("Entrada bem Sucedida (Colocar tela para excluir dependentes)");
        }else{
            prompt.setText("Usuário não encontrado!");
        }

    }



}