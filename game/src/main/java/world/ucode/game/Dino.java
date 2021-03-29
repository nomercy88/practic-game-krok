package world.ucode.game;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Dino {
    protected Pane root;
    protected Image dinoImg = new Image("Dino-left-up.png");
    protected ImageView dinoView = new ImageView(this.dinoImg);
    public AnimationTimer animationTimer;
    private boolean status = true;

    /**
     * Constructor Cactus
     *
     * @param pane
     */
    Dino(Pane pane) {
        this.root = pane;
        dinoView.setLayoutY(720);
        dinoView.setLayoutX(30);
        this.animationRun();
        this.animationJump();
        this.root.getChildren().add(dinoView);
    }

    /**
     * Animation Dino Run
     */
    public void animationRun() {
        Timeline t = new Timeline(
                new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent t) {
                        dinoView.setImage(new Image("Dino-left-up.png"));
                    }
                }),
                new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent t) {
                        dinoView.setImage(new Image("Dino-right-up.png"));
                    }
                })
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    /**
     * Animation Dino Jump
     *
     * @return animationTimer
     */
    public AnimationTimer animationJump() {
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (dinoView.getLayoutY() >= 580 && status) {
                    dinoView.setLayoutY(dinoView.getLayoutY() - 4);
                    if (dinoView.getLayoutY() <= 580)
                        status = false;
                } else if (!status) {
                    dinoView.setLayoutY(dinoView.getLayoutY() + 5);
                    if (dinoView.getLayoutY() >= 720) {
                        status = true;
                        animationTimer.stop();
                    }
                }
            }
        };
        return animationTimer;
    }
}
