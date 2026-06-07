module br.com.poo.registrationsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.base;

    exports br.com.poo.registrationsystem;
    opens br.com.poo.registrationsystem to javafx.fxml;

    exports br.com.poo.registrationsystem.controller;
    opens br.com.poo.registrationsystem.controller to javafx.fxml;

    exports br.com.poo.registrationsystem.validation;
    opens br.com.poo.registrationsystem.validation to javafx.fxml;
    exports br.com.poo.registrationsystem.users;
    opens br.com.poo.registrationsystem.users to javafx.fxml;
}