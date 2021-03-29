package world.ucode.game;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Cloud implements InterfaceCloud {
    protected Pane root;
    protected Image cloudMiniImg = new Image("Cloud.png");
    protected Image cloudBigImg = new Image("Cloud-min.png");
    protected ImageView cloudImageViewOne = new ImageView(this.cloudMiniImg);
    protected ImageView cloudImageViewTwo = new ImageView(this.cloudMiniImg);
    protected ImageView cloudImageViewTree = new ImageView(this.cloudBigImg);
    protected ImageView cloudImageViewFour = new ImageView(this.cloudMiniImg);
    protected ImageView cloudImageVieFive = new ImageView(this.cloudBigImg);
    protected ImageView cloudImageVieSix = new ImageView(this.cloudMiniImg);


    /**
     * Constructor Cloud
     *
     * @param pane Cloud
     */
    public Cloud(Pane pane) {
        this.root = pane;
        this.init();
    }

    /**
     * Initiation cloud
     */
    protected void init() {
        this.setImageLayoutXY();
        this.setAnimation();
        this.setImage();
    }

    /**
     * Images setLayoutX, setLayoutY
     */
    protected void setImageLayoutXY() {
        cloudImageViewOne.setLayoutX(700);
        cloudImageViewOne.setLayoutY(200);

        cloudImageViewTwo.setLayoutX(1400);
        cloudImageViewTwo.setLayoutY(130);

        cloudImageViewTree.setLayoutX(1000);
        cloudImageViewTree.setLayoutY(160);

        cloudImageViewFour.setLayoutX(2200);
        cloudImageViewFour.setLayoutY(200);

        cloudImageVieFive.setLayoutX(2500);
        cloudImageVieFive.setLayoutY(160);

        cloudImageVieSix.setLayoutX(3000);
        cloudImageVieSix.setLayoutY(130);
    }

    /**
     * Set images in root
     */
    protected void setImage() {
        root.getChildren().add(cloudImageViewOne);
        root.getChildren().add(cloudImageViewTwo);
        root.getChildren().add(cloudImageViewTree);
        root.getChildren().add(cloudImageViewFour);
        root.getChildren().add(cloudImageVieFive);
        root.getChildren().add(cloudImageVieSix);
    }


    /**
     * Animation ground
     */
    protected void setAnimation() {
        Timeline t = new Timeline(
                new KeyFrame(Duration.seconds(10), new KeyValue(cloudImageViewOne.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(10), new KeyValue(cloudImageViewTwo.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(10), new KeyValue(cloudImageViewTree.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(10), new KeyValue(cloudImageViewFour.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(10), new KeyValue(cloudImageVieFive.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(10), new KeyValue(cloudImageVieSix.translateXProperty(), -1500))
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }
}
