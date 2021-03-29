package world.ucode.game;

import javafx.animation.AnimationTimer;

public interface InterfaceDino {
    /**
     * Animation Dino Run
     */
    public void animationRun();

    /**
     * Animation Dino Jump
     *
     * @return animationTimer
     */
    public AnimationTimer animationJump();
}
