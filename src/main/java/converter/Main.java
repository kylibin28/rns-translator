package converter;

import converter.controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            primaryStage = new Stage();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Object.class.getResource("/fxml/sample.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Renaming");
            controller = loader.getController();

            controller.additionalInit(primaryStage);

            primaryStage.show();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
