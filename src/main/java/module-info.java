module com.example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;
            
            requires com.dlsc.formsfx;
    requires java.sql;

    opens com.registro to javafx.fxml;
    exports com.registro;
    exports com.registro.Controller;
    opens com.registro.Controller to javafx.fxml;
}