package scrabble.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import scrabble.*;
import scrabble.exceptions.BadWordPlacementException;

public class ScrabbleApplication extends Application {

    private ScrabbleController scrabbleController;
    private Scrabble scrabble;

    @Override
    public void start(Stage primaryStage) throws IOException, BadWordPlacementException {
        primaryStage.setTitle("Scrabble!");
        primaryStage
                .getIcons()
                .add(new Image(ScrabbleApplication.class.getResourceAsStream("logo.png")));

        primaryStage.setMinWidth(1070);
        primaryStage.setMinHeight(750);

        FXMLLoader fxmlLoader =
                new FXMLLoader(ScrabbleApplication.class.getResource("scrabble.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        scrabbleController = fxmlLoader.getController();

        primaryStage.setScene(scene);
        primaryStage.show();

        scrabble = new Scrabble(scrabbleController);
    }
}
