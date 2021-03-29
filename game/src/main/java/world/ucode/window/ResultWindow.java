package world.ucode.window;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class ResultWindow implements Window {
    private Pane pane;

    /**
     * Constructor
     *
     * @param pane
     */
    public ResultWindow(Pane pane) {
        this.pane = pane;
    }

    @Override
    public Scene create() {
        return new Scene(this.pane, 500, 500);
    }
}
