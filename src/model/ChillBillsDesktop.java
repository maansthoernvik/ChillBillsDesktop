package model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.time.TimeTracking;

import java.util.Timer;

/**
 * Created by MTs on 06/08/16.
 *
 * ZIS IS ZE MAIN CLAAZ!
 */

public class ChillBillsDesktop extends Application {

    /**
     * Mejn
     *
     * @param args
     */

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Overridden method from JavaFX 8. Starts the application with a new stage. Loads the account manager to show the
     * login view.
     *
     * @param primaryStage
     * @throws Exception
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new StackPane());

        AccountManager accManager = new AccountManager(scene, primaryStage);
        accManager.showLoginView();

        Timer dateUpdater = new Timer();
        dateUpdater.schedule(new TimeTracking(), 0, 5000);

        primaryStage.setScene(scene);       // Sets the current scene to what has been prepared.
        primaryStage.centerOnScreen();      // Centers the fucking thing.
        primaryStage.show();                // Show the finished stage.
    }
}