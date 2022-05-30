module com.example.av3final {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.av3final to javafx.fxml;
    exports com.example.av3final;
}