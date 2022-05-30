package com.example.av3final;

import com.example.av3final.database.UsuariosList;
import com.example.av3final.gen.Funcionario;
import javafx.event.ActionEvent;
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