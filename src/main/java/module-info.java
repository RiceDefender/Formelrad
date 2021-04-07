module application {
	requires transitive javafx.base;
    requires transitive javafx.controls;
    requires transitive javafx.graphics;
	requires transitive javafx.fxml;

    opens application to javafx.fxml;
    exports application;
}