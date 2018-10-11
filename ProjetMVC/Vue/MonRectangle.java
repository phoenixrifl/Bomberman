package Vue;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class MonRectangle{
    Image[] tabIm = new Image[5];

    Pane pane;
    Image im;
    ImageView imV;
    public MonRectangle(){
        this.im = new Image("Images/gris.jpg");
        this.imV = new ImageView(im);
        this.imV.setFitHeight(28);
        this.imV.setFitWidth(28);
        pane = new Pane();
        pane.getChildren().add(imV);
    }
    public void setImage(Image image){
        this.imV.setImage(image);
    }

}
