package com.bramkempen;

import com.animals.Animal;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Animal shelter");


        //region Grid
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Scene scene = new Scene(grid,300,275);
        primaryStage.setScene(scene);
        //endregion

        //region Species
        ObservableList<String> speciesOptions = FXCollections.observableArrayList(
                "Dog",
                        "Cat"
        );
        ComboBox speciesBox = new ComboBox(speciesOptions);
        TitledPane speciesTitlePane = createTitledPane("Species", speciesBox);
        grid.add(speciesTitlePane, 0, 0);
        //endregion

        //region Name
        TextField nameTextField = new TextField();
        TitledPane nameTitledPane = createTitledPane("Name", nameTextField);
        grid.add(nameTitledPane, 0,1);
        //endregion

        //region Animals
        ObservableList<Animal> animalsOptions = FXCollections.observableArrayList();
        ListView<Animal> animalListView = new ListView<>(animalsOptions);
        TitledPane animalsTitledPane = createTitledPane("Animals", animalListView);
        animalsTitledPane.setMaxHeight(153);
        grid.add(animalsTitledPane, 1,0, 1, 2);
        //endregion

        //region Gender
        TextField badHabitsTextField = new TextField();
        TitledPane badHabitsTitledPane = createTitledPane("Bad habits", badHabitsTextField);
        grid.add(badHabitsTitledPane, 0,4);
        //endregion

        primaryStage.show();
    }

    private TitledPane createTitledPane(String name, ArrayList<Node> nodes){
        TitledPane titledPane = new TitledPane();
        titledPane.setText(name);
        titledPane.setCollapsible(false);

        HBox box = new HBox();
        box.getChildren().addAll(nodes);

        titledPane.setContent(box);

        return titledPane;
    }

    private TitledPane createTitledPane(String name, Node node){
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(node);
        return createTitledPane(name, nodes);
    }
}