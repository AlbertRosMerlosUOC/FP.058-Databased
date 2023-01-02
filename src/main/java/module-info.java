module databased.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;

    exports databased.javafx;
    opens databased.javafx to javafx.fxml;
}