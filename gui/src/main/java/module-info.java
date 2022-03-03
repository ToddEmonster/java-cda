module com.example.gui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    requires ColorLibrary;
    opens com.example.gui to javafx.fxml;
    exports com.example.gui;
}