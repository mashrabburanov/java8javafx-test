import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class Main extends Application {
    public static void main(String args[]) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        /*
         * Creating components
         */
        BorderPane root = new BorderPane();
        VBox vBox = new VBox();
        GridPane grid = new GridPane();
        Label label = new Label("Hello, World!");
        Button buttonOne = new Button("one");
        Button buttonTwo = new Button("two");
        Button buttonThree = new Button("three");
        Button buttonFour = new Button("four");

        /*
         * Creating scene and setting size (size of window on start)
         */
        Scene scene = new Scene(root, 300, 300);

        /*
         * Setting preferable buttons width
         */
        buttonOne.setPrefWidth(60);
        buttonTwo.setPrefWidth(60);
        buttonThree.setPrefWidth(60);
        buttonFour.setPrefWidth(60);

        /*
         * Setting action to buttons via creating anonymous objects
         */
        buttonOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                label.setText(buttonOne.getText());
            }
        });

        buttonTwo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                label.setText(buttonTwo.getText());
            }
        });

        /*
         * Setting action to buttons via lambda functions
         */
        buttonThree.setOnAction((event) -> {
            label.setText(((Button) event.getSource()).getText());
        });

        buttonFour.setOnAction((event) -> {
            label.setText(((Button) event.getSource()).getText());
        });

        /*
         * Building components layouts and applying styles to them
         */
        grid.add(buttonOne, 0, 0);
        grid.add(buttonTwo, 0, 1);
        grid.add(buttonThree, 1, 0);
        grid.add(buttonFour, 1, 1);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label, grid);
        vBox.setMargin(label, new Insets(5, 10, 5, 10));
        vBox.setMargin(grid, new Insets(5, 10, 5, 10));

        root.setCenter(vBox);

        /*
         * Setting window scene, styles, and finaly showing window
         */
        stage.setTitle("Hi");
        stage.setScene(scene);
        stage.setMinHeight(300);
        stage.setMinWidth(300);
        stage.setResizable(false);
        stage.show();
        System.out.println("Test");
    }
}
