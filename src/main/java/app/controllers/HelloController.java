package app.controllers;

import app.database.FileJSON;
import app.database.UsuariosList;
import app.client.Funcionario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import org.json.simple.JSONObject;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void createFuncionario() {
        UsuariosList.addFuncionario(new Funcionario("Joao","XBCE","Gerente",3,7000));
        //UsuariosList.addFuncionario(new Funcionario("Jorge","XBCE","Estagiário",3,5));
        UsuariosList.addFuncionario(new Funcionario("Pedro","ABCDE","Vendedor",3,1200));
        UsuariosList.addFuncionario(new Funcionario("ALBERTO","XYZ","Vendedor",3,1200));

        FileJSON.createJSON();
        welcomeText.setText("Funcionário adicionado!");
        UsuariosList.deleteArray();
    }


}