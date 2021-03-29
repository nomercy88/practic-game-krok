package world.ucode.game;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Cactus implements InterfaceCactus{
    protected Pane root;
    protected ImageView cactus;
    protected Image cactusOne = new Image("Cactus-1.png");
    protected Image cactusTwo = new Image("Cactus-2.png");
    protected Image cactusTree = new Image("Cactus-3.png");
    protected Image cactusFore = new Image("Cactus-4.png");
    protected Image cactusFive = new Image("Cactus-5.png");
    protected ArrayList<Image> listImage = new ArrayList<Image>();
    protected ArrayList<ImageView> listImageView = new ArrayList<ImageView>();

    /**
     * Constructor Cactus
     *
     * @param pane
     */
    Cactus(Pane pane) {
        this.root = pane;
        this.setListImage();
        this.setPositionImg();
        this.animation().start();

    }

    /**
     * Set ListImage
     */
    protected void setListImage() {
        listImage.add(cactusOne);
        listImage.add(cactusTwo);
        listImage.add(cactusTree);
        listImage.add(cactusFore);
        listImage.add(cactusFive);
    }

    /**
     * Set PositionImg
     */
    protected void setPositionImg() {
        for (int i = 0; i < listImage.size(); i++) {
            cactus = new ImageView();
            cactus.setImage(listImage.get(i));
            cactus.setLayoutY(720);
            cactus.setLayoutX(random());
            listImageView.add(cactus);
        }
        root.getChildren().addAll(listImageView);
    }

    /**
     * Random cactus
     *
     * @return double
     */
    private double random() {
        double result = 1200 + (int) (Math.random() * 15) * 100;

        for (ImageView y : listImageView) {
            if (Math.abs(result - y.getLayoutX()) < 250)
                result = -50;
        }
        return result;
    }

    /**
     * Animation cactus
     *
     * @return AnimationTimer
     */
    protected AnimationTimer animation() {
        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (ImageView i : listImageView) {
                    i.setLayoutX(i.getLayoutX() - 2.2);
                    if (i.getLayoutX() < -50) {
                        i.setLayoutX(random());
                    }
                }
            }
        };
        return animation;
    }
}
