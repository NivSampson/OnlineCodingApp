module com.example.atp_c {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atp_c to javafx.fxml;
    exports com.example.atp_c;
}