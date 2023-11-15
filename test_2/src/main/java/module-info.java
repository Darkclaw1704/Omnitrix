module com.example.test_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.test_2 to javafx.fxml;
    exports com.example.test_2;
}