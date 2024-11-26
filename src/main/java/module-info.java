module com.example.recipesharingapp2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.recipesharingapp2 to javafx.fxml;
    exports com.example.recipesharingapp2;
}