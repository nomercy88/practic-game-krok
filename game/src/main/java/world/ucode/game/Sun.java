package world.ucode.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Sun implements InterfaceSun{
    protected Pane root;
    protected Image sunImg = new Image("Sun.png");
    protected ImageView sunImgView = new ImageView(this.sunImg);
    /**
     * Sun constructor
     *
     * @param pane
     */
    public Sun(Pane pane) {
        this.root = pane;
        this.init();
    }
    /**
     * Initiation ground
     */
    protected void init() {
        sunImgView.setLayoutY(50);
        sunImgView.setLayoutX(50);
        root.getChildren().add(sunImgView);
    }
}
