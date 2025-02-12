module com.intermediate.calculatorapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.intermediate.calculatorapp to javafx.fxml;
    exports com.intermediate.calculatorapp;
}