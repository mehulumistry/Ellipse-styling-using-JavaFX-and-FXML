import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class nodePropertiesController{




    @FXML
    ColorPicker nodeColor;

    @FXML
    ColorPicker strokeColor;
    @FXML
    Slider strokeWidth;
    @FXML
    CheckBox setStroke;

    @FXML
    Button ok;
    @FXML
    Ellipse innerEllipse;

    @FXML
    ColorPicker innerColor;

    @FXML
    CheckBox gradientColor;

    @FXML
    Button labelEdit;



    private Stage dialogStage;
    private boolean okClicked = false;
    private boolean defaultClicked = false;


    private nodeEdit nodeProp ;



    // ADD here for changing innner element

    @FXML
    protected void initialize() {




        labelEdit.setOnAction(event -> {



            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NodeEllipse.class.getResource("labelProperties.fxml"));
            AnchorPane page = null;
            try {
                page = (AnchorPane) loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Node");
            dialogStage.initModality(Modality.WINDOW_MODAL);

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);



            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            //  showLabelEditBox(le);


        });


        innerColor.setDisable(true);

        nodeColor.setOnAction(event -> {


            innerEllipse.setFill(nodeColor.getValue());

        });

        innerColor.setOnAction(event -> {


            RadialGradient gradient = new RadialGradient(0,
                    .1,
                    innerEllipse.getCenterX(),
                    innerEllipse.getCenterY(),
                    innerEllipse.getRadiusX(),
                    false,
                    CycleMethod.NO_CYCLE,
                    new Stop(0,nodeColor.getValue()),
                    new Stop(1, innerColor.getValue()));


            innerEllipse.setFill(gradient);

        });

        strokeColor.setOnAction(event -> {


            innerEllipse.setStroke(strokeColor.getValue());

        });





        strokeWidth.valueProperty().addListener(new ChangeListener<Number>() {



            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                innerEllipse.setStrokeWidth((Double) newValue);

                nodeProp.setStrokeWidth((Double) newValue);

            }
        });



        setStroke.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {

                if(setStroke.isSelected()){

                    innerEllipse.setStrokeWidth(nodeProp.getStrokeWidth());


                }
                else
                    innerEllipse.setStrokeWidth(0);


            }
        });


        gradientColor.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {

                if(gradientColor.isSelected()){

                    innerColor.setDisable(false);

                    RadialGradient gradient = new RadialGradient(0,
                            .1,
                            innerEllipse.getCenterX(),
                            innerEllipse.getCenterY(),
                            innerEllipse.getRadiusX(),
                            false,
                            CycleMethod.NO_CYCLE,
                            new Stop(0,nodeColor.getValue()),
                            new Stop(1, innerColor.getValue()));


                    innerEllipse.setFill(gradient);


                }

                else{
                    innerColor.setDisable(true);
                  //  innerEllipse.setFill(nodeProp.getNewColr());
                }

            }
        });









    }


    // Edit Label

public void showLabelEditBox(labelEdit le) throws IOException {


    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(NodeEllipse.class.getResource("nodeProperties.fxml"));
    AnchorPane page = (AnchorPane) loader.load();

    // Create the dialog Stage.
    Stage dialogStage = new Stage();
    dialogStage.setTitle("Edit Node");
    dialogStage.initModality(Modality.WINDOW_MODAL);

    Scene scene = new Scene(page);
    dialogStage.setScene(scene);

    // Set the person into the controller.
   // labelPropertiesController controller = loader.getController();

    //controller.setDialogStage(dialogStage);
   // controller.setColor(ne);

    // Show the dialog and wait until the user closes it
    dialogStage.showAndWait();

    //return controller.isOkClicked;
}


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    // it sets the new color from color piker

    public void setColor(nodeEdit ne){

        this.nodeProp = ne;


        nodeColor.setValue(ne.getNewColr());
        strokeWidth.setValue(nodeProp.getStrokeWidth());
        strokeColor.setValue(ne.getNewStrokeColr());
        nodeProp.setStrokeWidth(strokeWidth.getValue());



        if(gradientColor.isSelected()) {



            RadialGradient gradient = new RadialGradient(0,
                    .1,
                    innerEllipse.getCenterX(),
                    innerEllipse.getCenterY(),
                    innerEllipse.getRadiusX(),
                    false,
                    CycleMethod.NO_CYCLE,
                    new Stop(0,nodeColor.getValue()),
                    new Stop(1, innerColor.getValue()));


            innerEllipse.setFill(gradient);

        }
        else {
            innerEllipse.setFill(ne.getNewColr());
        }
        innerEllipse.setStroke(ne.getNewStrokeColr());
        innerEllipse.setStrokeWidth(ne.getStrokeWidth());









    }

    public boolean isOkClicked() {
        return okClicked;
    }




    // update the getter and setter methods here

    @FXML
    private void handleOk() {


        nodeProp.setNewColr(nodeColor.getValue());
        nodeProp.setNewStrokeColr(strokeColor.getValue());


        okClicked = true;
        dialogStage.close();
    }


    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    // for default handling

    @FXML
    private void handleDefault() {

        nodeColor.setValue(Color.WHITE);
        innerEllipse.setFill(Color.WHITE);



        innerEllipse.setStroke(Color.BLACK);

        strokeColor.setValue(Color.BLACK);
        innerEllipse.setStrokeWidth(1);


        strokeWidth.setValue(1);
        defaultClicked = true;
        //dialogStage.close();
    }

}

