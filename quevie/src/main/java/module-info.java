module com.frontline.quevie {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.frontline.quevie to javafx.fxml;
    exports com.frontline.quevie;
    exports com.frontline.quevie.userinterface;
    opens com.frontline.quevie.userinterface to javafx.fxml;
}