package world.ucode.menu;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public interface InterfaceMenuBasic {
    /**
     * Label Dino
     */
    public Label label();

    /**
     * Image ground
     */
    public ImageView groundImgView();

    /**
     * Image dino
     */
    public ImageView dinoImgView();
    /**
     * Start button
     */
    public Button startBtn();

    /**
     * Result button
     */
    public Button resultsBtn();

    /**
     * Exit button
     */
    public Button exitBtn();

//    /**
//     * Installation
//     */
//    public void init();
}