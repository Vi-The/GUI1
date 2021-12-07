module com.example.gui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    //opens com.example.gui to javafx.fxml;
    //exports com.example.gui;
    exports com.example.gui;
    opens com.example.gui to javafx.fxml;
    exports com.example.domain;
    opens com.example.domain to javafx.fxml;
}