package app.controllers;

import app.database.UsuariosList;
import app.client.Funcionario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void createFuncionario() {
        UsuariosList.addFuncionario(new Funcionario());
        welcomeText.setText("Funcionário adicionado!");
    }


}