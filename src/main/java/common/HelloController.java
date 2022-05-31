package common;

import common.database.UsuariosList;
import common.gen.Funcionario;
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