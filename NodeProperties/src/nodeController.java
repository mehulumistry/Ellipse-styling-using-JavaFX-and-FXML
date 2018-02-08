import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;


public class nodeController {


    @FXML
    Ellipse node;

    @FXML
    Label label;



    public NodeEllipse nodeEllipseApp;


    @FXML
    protected void initialize(){


        // taking default value from the node and give it to the layout
        node.setOnMouseClicked(event -> {


            if (event.getClickCount() == 2) {


                System.out.println("mouseClicked");





                nodeEdit ne = new nodeEdit((Color) node.getFill(), (Color) node.getStroke(), (int) node.getStrokeWidth());

                boolean isOkClicked = nodeEllipseApp.showColorEditBox(ne);

                if (isOkClicked) {


                    node.setFill(ne.getNewColr());
                    node.setStroke(ne.getNewStrokeColr());
                    node.setStrokeWidth(ne.getStrokeWidth());

                }
            }

        });

    }

    public void setNodeEllipseApp(NodeEllipse nodeEllipseApp) {
        this.nodeEllipseApp = nodeEllipseApp;



    }








}





