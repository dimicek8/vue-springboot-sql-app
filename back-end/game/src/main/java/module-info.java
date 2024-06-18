module com.game.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.game.game to javafx.fxml;
    exports com.game.game;
}