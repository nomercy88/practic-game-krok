package world.ucode.game;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Ground implements InterfaceGround{
    protected Pane root;
    protected Image groundImg = new Image("Ground.png");
    protected ImageView groundOne = new ImageView(this.groundImg);
    protected ImageView groundTwo = new ImageView(this.groundImg);

    /**
     * Constructor
     * @param pane
     */
    public Ground(Pane pane) {
        this.root = pane;
        this.init();
    }

    /**
     * Initiation ground
     */
    protected void init() {
        groundOne.setLayoutY(750);
        groundOne.setLayoutX(0);
        groundTwo.setLayoutY(750);
        groundTwo.setLayoutX(1200);
        this.animation();
        root.getChildren().add(groundOne);
        root.getChildren().add(groundTwo);
    }

    /**
     * Animation ground
     */
    protected void animation() {
        Timeline t = new Timeline(
                new KeyFrame(Duration.seconds(9), new KeyValue(groundOne.translateXProperty(), -1200)),
                new KeyFrame(Duration.seconds(9), new KeyValue(groundTwo.translateXProperty(), -1200))
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }
}
