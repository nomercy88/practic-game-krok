package world.ucode.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import world.ucode.menu.MenuGameOver;
import world.ucode.window.GameWindow;

public class Game implements InterfaceGame {
    protected Pane root = new Pane();
    protected Stage primaryStage;
    protected Dino dino = new Dino(this.root);
    protected Cactus cactus = new Cactus(this.root);
    protected boolean one = true;
    /**
     * Game constructor
     *
     * @param primaryStage
     */
    public Game(Stage primaryStage) {
        this.primaryStage = primaryStage;
        new Sun(root);
        new Cloud(root);
        new Score(root);
        new Ground(root);
        this.event();
        this.collision();
    }

    /**
     * Start
     */
    public void start() {
        primaryStage.setScene(new GameWindow(this.root).create());
        event();
        primaryStage.centerOnScreen();
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #C0C0C0, #ffffff);");
    }

    /**
     * Event jump
     */
    private void event() {
        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent key) {
                if (key.getCode() == KeyCode.SPACE)
                    dino.animationTimer.start();
            }
        });
    }

    /**
     * Collision
     */
    private void collision() {
        int i =0;
        Timeline t = new Timeline(
                new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent t) {
                        for (ImageView i : cactus.listImageView) {
                            if (dino.dinoView.getBoundsInParent().intersects(i.getLayoutX() + 0, i.getLayoutY() + 0,
                                    i.getBoundsInParent().getWidth() - 16,
                                    i.getBoundsInParent().getHeight() - 16) && one) {
                                one = false;
                                new MenuGameOver(primaryStage).start();
                            }
                        }
                    }
                })
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }
}
