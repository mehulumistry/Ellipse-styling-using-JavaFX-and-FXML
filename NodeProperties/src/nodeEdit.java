import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

public class nodeEdit {

    private final ObjectProperty<Color> newColr;
    private final ObjectProperty<Color> newStrokeColr;

    private  Double strokeWidth;
   // private  final ObjectProperty<Color> newGradColr;





    public nodeEdit() {
        this(null,null,0);
    }

    public nodeEdit(Color newColr,Color newStrokeColr,int strokeWidth){

        this.newColr = new SimpleObjectProperty<Color>(newColr);
        this.newStrokeColr = new SimpleObjectProperty<Color>(newStrokeColr);
       // this.newGradColr = new SimpleObjectProperty<Color>(newGradColr);
        this.strokeWidth = new Double(strokeWidth);


    }





    public Color getNewColr() {
        return newColr.get();
    }


    public Color getNewStrokeColr() {
        return newStrokeColr.get();
    }

    public Double getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(Double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }


    public void setNewColr(Color newColr) {
        //newColr = newColr;

        this.newColr.set(newColr);

    }

//    public void setNewGradColr(Color newGradColr) {
//        //newColr = newColr;
//
//        this.newGradColr.set(newGradColr);
//
//    }
//
//    public Color getNewGradColr() {
//        return newGradColr.get();
//    }


    public void setNewStrokeColr(Color newStrokeColr) {
        //newColr = newColr;

        this.newStrokeColr.set(newStrokeColr);

    }

    public boolean isSelectedGradient(){



        return true;
    }


}
