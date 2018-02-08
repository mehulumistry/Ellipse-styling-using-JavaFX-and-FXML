import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class NodeEllipse extends Application{

    private Stage primaryStage;




    public NodeEllipse(){

    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(NodeEllipse.class.getResource("node.fxml"));
        Parent rootLayout = loader.load();

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

        nodeController controller = loader.getController();


        controller.setNodeEllipseApp(this);


    }


    public boolean showColorEditBox(nodeEdit ne) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NodeEllipse.class.getResource("nodeProperties.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Node");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            nodePropertiesController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setColor(ne);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();



            return controller.isOkClicked();


        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }




    public static void main(String[] args) {


        launch(args);



    }

}

