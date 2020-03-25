package vkami.countryinfo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;

public class CountryInfo extends Application {

    public final static String countryPath="src/vkami/countryinfo/";
    private BorderPane bp;
    private ComboBox comboB;
    private ImageView center;
    private Label label1;
    private Label label2;
    private GatherInformation dataBase;

    @Override
    public void start(Stage primaryStage) throws Exception{

        dataBase=new GatherInformation(countryPath + "res/countries.csv");
        ArrayList<String> countryNames=dataBase.getCountryNames();

        //COMBOBOX
        comboB=new ComboBox(FXCollections.observableArrayList(countryNames));
        comboB.getSelectionModel().select(0);
        comboB.setOnAction(new Refresh());


        HBox top=new HBox(comboB);
        top.setAlignment(Pos.CENTER);

        //PICTURE
        center=center=new ImageView();

        //LABELS
        label1=new Label("");
        label2=new Label("");

        HBox bottom=new HBox(15,label1, label2);
        bottom.setAlignment(Pos.CENTER);

        new Refresh().refresh();

        bp=new BorderPane();
        bp.setTop(top);
        bp.setCenter(center);
        bp.setBottom(bottom);

        bp.setPadding(new Insets(20));

        primaryStage.setTitle("Country Info");
        primaryStage.setScene(new Scene(bp, 700, 500));
        primaryStage.show();
    }

    private void setCenter(String imageFile) {

        Image img=null;

        try {
            img = new Image(new FileInputStream(imageFile));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        center.setImage(img);

        double x=0;
        double y=0;

        double imgY=img.getHeight();
        double imgX=img.getWidth();

        if ( imgX<imgY ) {
            if ( imgY>500 ) {
                y=500;
                x=imgX*(500*100/imgY*0.01);
            }
        } else {
            if ( imgY>500 ) {
                x=500;
                y=imgY*(500*100/imgX*0.01);
            }
        }
        center.setFitHeight(y);
        center.setFitWidth(x);
    }


    public static void main(String[] args) {
        launch(args);
    }


    class Refresh implements EventHandler {

        @Override
        public void handle(Event event) {
            refresh();
        }

        public void refresh() {
            for (Country act:dataBase.getOrszagok()) {

                if ( act.getCountry().equals(comboB.getValue()) ) {

                    setCenter(countryPath + "res/" + act.getImage());

                    label1.setText(act.getCapital());
                    label2.setText(act.getPopulation());
                }
            }
        }

    }
}

