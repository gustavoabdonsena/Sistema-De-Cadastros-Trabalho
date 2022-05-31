module com.example.av3final {
    requires javafx.controls;
    requires javafx.fxml;


    opens common to javafx.fxml;
    exports common;
}