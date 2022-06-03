module com.example.av3final {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    //localização do/dos FXML na pasta recources
    exports app;

    //localização das classes de controllers
    opens app.controllers to javafx.fxml;
}