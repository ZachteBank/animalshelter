package com.bramkempen;

import com.animals.Animal;
import com.animals.Cat;
import com.animals.Dog;
import com.animals.Gender;
import javafx.application.Application;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;
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
        ToggleGroup genderGroup = new ToggleGroup();

        RadioButton genderMale = new RadioButton("Male");
        genderMale.setSelected(true);
        genderMale.setToggleGroup(genderGroup);

        RadioButton genderFemale = new RadioButton("Female");
        genderFemale.setToggleGroup(genderGroup);

        ArrayList<Node> genderNodes = new ArrayList<>();
        genderNodes.add(genderMale);
        genderNodes.add(genderFemale);

        TitledPane genderTitledPane = createTitledPane("Gender", genderNodes);
        grid.add(genderTitledPane, 0,2);
        //endregion

        //region Reserve Animal
        Text reserveAnimalText = new Text("Name: ");
        TextField reserveAnimalTextField = new TextField();
        Button reserveAnimalButton = new Button("Reserve selected animal");
        ArrayList<Node> animalNodes = new ArrayList<Node>();
        animalNodes.add(reserveAnimalText);
        animalNodes.add(reserveAnimalTextField);
        animalNodes.add(reserveAnimalButton);
        TitledPane reserveAnimalTitledPane = createTitledPane("Reserve animal", animalNodes);
        grid.add(reserveAnimalTitledPane, 1,2);
        //endregion

        //region BadHabits
        TextField badHabitsTextField = new TextField();
            badHabitsTextField.setDisable(true);
        TitledPane badHabitsTitledPane = createTitledPane("Bad habits", badHabitsTextField);
        grid.add(badHabitsTitledPane, 0,3);
        //endregion

        //region AddAnimal
        Button addAnimalButton= new Button("Add animal");
            addAnimalButton.setDisable(true);
        grid.add(addAnimalButton, 0,4);
        //endregion

        //region Species
        ObservableList<String> speciesOptions = FXCollections.observableArrayList(
                "Dog",
                        "Cat"
        );
        ComboBox<String> speciesBox = new ComboBox(speciesOptions);
        TitledPane speciesTitlePane = createTitledPane("Species", speciesBox);
        grid.add(speciesTitlePane, 0, 0);
        //endregion

        //region Listeners
        speciesBox.getSelectionModel()
                .selectedItemProperty()
                .addListener( (ObservableValue<? extends String> observable, String oldValue, String newValue) ->
                {
                    badHabitsTextField.setDisable(!newValue.equalsIgnoreCase("Cat"));
                    addAnimalButton.setDisable(false);
                });

        addAnimalButton.setOnAction(event -> {
            Animal animal;
            Gender gender = ((RadioButton)genderGroup.getSelectedToggle()).getText().equals(Gender.Male.toString()) ? Gender.Male : Gender.Female;
            if(speciesBox.getSelectionModel().selectedItemProperty().getValue().equalsIgnoreCase("Cat")){
                animal = new Cat(nameTextField.getText(),
                        gender,
                        badHabitsTextField.getText());
            }else{
                animal = new Dog(nameTextField.getText(), gender);
            }
            animalsOptions.add(animal);
            animalListView.refresh();
            System.out.println(animal.toString());
            System.out.println(animal.getClass().toString());
            System.out.println(gender.toString());
        });

        reserveAnimalButton.setOnAction(event -> {
            Animal animal = animalListView.getSelectionModel().getSelectedItem();
            if(animal != null){
                animal.reserve(reserveAnimalTextField.getText());
                animalListView.refresh();
            }
        });
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
