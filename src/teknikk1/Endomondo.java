package teknikk1;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
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
        Label running = new Label("RUNNING ");
        running.setStyle("-fx-font-size: 30");

        Label duration = new Label(" DURATION");
        duration.setStyle("-fx-font-size: 20");

        Label time = new Label("0:57:24 ");
        time.setStyle("-fx-font-size: 60; -fx-font-weight: bolder");

        Label distance = new Label(" Distance\n km");
        distance.setStyle("-fx-font-size: 20");

        Label distancenum = new Label("12.30 ");
        distancenum.setStyle("-fx-font-size: 50; -fx-font-weight: bolder");

        Label heart_rate = new Label(" Heart Rate\n bpm");
        heart_rate.setStyle("-fx-font-size: 20");

        Label rate = new Label("163 ");
        rate.setStyle("-fx-font-size: 35; -fx-font-weight: bolder");

        Label speed = new Label(" AVG. SPEED\n km/h");
        speed.setStyle("-fx-font-size: 20");

        Label avgspeed = new Label("4:40 ");
        avgspeed.setStyle("-fx-font-size: 35; -fx-font-weight: bolder");

        Rectangle r00 = new Rectangle(250, 75);
        r00.setFill(Color.WHITE);

        Rectangle r01 = new Rectangle(250, 75);
        r01.setFill(Color.WHITE);

        Rectangle r10 = new Rectangle(500, 75);
        r10.setFill(Color.WHITESMOKE);

        Rectangle r20 = new Rectangle(500, 75);
        r20.setFill(Color.WHITESMOKE);

        Rectangle r30 = new Rectangle(247, 75);
        r30.setFill(Color.WHITESMOKE);

        Rectangle r32 = new Rectangle(247, 75);
        r32.setFill(Color.WHITESMOKE);


        GridPane gridPane = new GridPane();

        gridPane.getColumnConstraints().add(new ColumnConstraints(150));
        gridPane.getColumnConstraints().add(new ColumnConstraints(97));
        gridPane.getColumnConstraints().add(new ColumnConstraints(147));
        gridPane.getColumnConstraints().add(new ColumnConstraints(97));

        gridPane.setStyle("-fx-background-color: #ffffff");

        gridPane.add(r00, 0,0,2,1);
        gridPane.add(r01, 2,0,2,1);
        gridPane.add(r10, 0,1,4,1);
        gridPane.add(r20, 0,2,4,1);
        gridPane.add(r30, 0,3,2,1);
        gridPane.add(r32, 2,3, 2, 1);
        gridPane.add(imageView, 0,0);
        gridPane.add(running, 2, 0, 2,1);
        gridPane.setHalignment(running, HPos.RIGHT);
        gridPane.add(duration, 0, 1);
        gridPane.setValignment(duration, VPos.TOP);
        gridPane.add(time, 2,1,2,1);
        gridPane.setHalignment(time, HPos.RIGHT);
        gridPane.add(distance, 0,2);
        gridPane.setValignment(distance, VPos.TOP);
        gridPane.add(distancenum, 2,2,2,1);
        gridPane.setHalignment(distancenum, HPos.RIGHT);
        gridPane.add(heart_rate, 0,3);
        gridPane.setValignment(heart_rate, VPos.TOP);
        gridPane.add(rate, 1,3);
        gridPane.setHalignment(rate, HPos.RIGHT);
        gridPane.add(speed, 2,3);
        gridPane.setValignment(speed, VPos.TOP);
        gridPane.add(avgspeed, 3,3);
        gridPane.setHalignment(avgspeed, HPos.RIGHT);


        gridPane.setHgap(3);
        gridPane.setVgap(6);

        Scene scene = new Scene(gridPane, 520, 350, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
