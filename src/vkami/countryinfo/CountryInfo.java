package vkami.countryinfo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CountryInfo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("Hello World");
        //primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

