package display;

// java awt 
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javafx.geometry.Insets;
// javafx
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class windowNext {

    private Stage stageWindow;
    private Scene scene;
    private int width, height;
    private String TITLE;

    /**
     * Contructor
     * 
     * @param stageWindow
     * @param width
     * @param height
     * @param scene
     * @throws Exception
     */
    public windowNext(Stage stageWindow, int width, int height, String TITLE) throws Exception {
        this.stageWindow = stageWindow;
        this.width = width;
        this.height = height;
        this.TITLE = TITLE;

        stageWindow.setTitle(TITLE);
        stageWindow.setScene(scene);
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) throws IOException {
        this.scene = scene;
        /*
         * HBox hb = new HBox();
         * BackgroundFill bFill = new BackgroundFill(Color.RED, CornerRadii.EMPTY,
         * Insets.EMPTY);
         * Background bg = new Background(bFill);
         * hb.setBackground(bg);
         */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double scWidth = screenSize.getWidth() / 2;
        double scHeight = screenSize.getHeight() / 2;
        scene = new Scene(new AnchorPane(), scWidth, scHeight);
        // scene = new Scene(hb);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
