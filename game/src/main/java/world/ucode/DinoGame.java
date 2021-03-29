package world.ucode;

import javafx.application.Application;
import world.ucode.menu.MenuBasic;
import world.ucode.window.MainBasicWindow;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DinoGame extends Application {
    /**
     * Start program
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        primaryStage.setScene(new MainBasicWindow(pane).create());
        primaryStage.setTitle("dino-KROK");
        primaryStage.getIcons().add(new Image("Dino-stand.png"));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
        new MenuBasic(pane, primaryStage);
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
