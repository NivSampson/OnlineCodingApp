
module com.example.new_java

{
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.new_java to javafx.fxml;
    exports com.example.new_java;
}