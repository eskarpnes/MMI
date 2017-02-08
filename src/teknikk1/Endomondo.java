package teknikk1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import java.io.FileInputStream;

/**
 * Created by Erlend on 08.02.2017.
 */
public class Endomondo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Endomondo");

        FileInputStream input = new FileInputStream("images/man.JPG");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        Label running = new Label("RUNNING");
        Label duration = new Label("DURATION");
        Label time = new Label("0:57:24");
        Label distance = new Label("Distance\nkm");
        Label distancenum = new Label("12:30");
        Label heart_rate = new Label("Heart Rate\nbpm");
        Label rate = new Label("163");
        Label speed = new Label("AVG. SPEED\nkm/h");
        Label avgspeed = new Label("4:40");

        GridPane gridPane = new GridPane();

        gridPane.add(imageView, 0,0);
        gridPane.add(running, 3, 0);
        gridPane.add(duration, 0, 1);
        gridPane.add(time, 3,1);
        gridPane.add(distance, 0,2);
        gridPane.add(distancenum, 3,2);
        gridPane.add(heart_rate, 0,3);
        gridPane.add(rate, 1,3);
        gridPane.add(speed, 2,3);
        gridPane.add(avgspeed, 3,3);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
