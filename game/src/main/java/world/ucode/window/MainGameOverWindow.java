package world.ucode.window;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MainGameOverWindow implements Window {
    private Pane pane;

    /**
     * Constructor MainGameOverWindow
     *
     * @param pane
     */
    public MainGameOverWindow(Pane pane) {
        this.pane = pane;
    }

    @Override
    public Scene create() {
        return new Scene(this.pane, 500, 500);
    }
}
