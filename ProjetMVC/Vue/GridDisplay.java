package Vue;

import Modele.*;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;



public class GridDisplay {


    private final int taille = 13;
    private Carte carte;
    public MonRectangle[][] rectangleArray;
    public  Image[] tabIm = new Image[11];
    private GridPane gridPane = new GridPane();
    private Group display = new Group(gridPane);


    public Group getDisplay() {
        return display;
    }

    public GridDisplay(){
        tabIm[0]=new Image("Images/case.png");
        tabIm[1]=new Image("Images/bloc.png");
        tabIm[2]=new Image("Images/murcassable.png");
        tabIm[3]=new Image("Images/player.png");
        tabIm[4]=new Image("Images/player2.png");
        tabIm[5]=new Image("Images/bombe.jpg");
        tabIm[6]=new Image("Images/contour.png");
        tabIm[7]=new Image("Images/bonusbombe.png");
        tabIm[8]=new Image("Images/flammes.png");
        tabIm[9]=new Image("Images/fire.png");
        tabIm[10]=new Image("Images/teteMort.png");

        carte = new Carte(this);
        rectangleArray = new MonRectangle[taille][taille];
        for(int i=0;i<taille;i++){
            for(int j=0;j<taille;j++){
                //System.out.println(" "+i+" "+j+" ");
                MonRectangle tmpRect = createPane();
                rectangleArray[i][j] = tmpRect;

                gridPane.add(tmpRect.pane, j, i);
            }
        }
        affichage();

    }


    public MonRectangle createPane(){

        MonRectangle rect = new MonRectangle();
        return rect;
    }

    public int fin(){
        if(this.carte.getPlayer1().getPerso().isDead()){
            return 1;
        }
        else if(this.carte.getPlayer2().getPerso().isDead()){
            return 2;
        }
        else return 0;
    }

    public Carte getCarte() {
        return carte;
    }


    public void affichage(){
        for(int i = 0; i<taille; i++){
            for(int j = 0; j<taille; j++){

                if(i == 0 || j == 0 || i == taille-1 || j == taille-1){
                    rectangleArray[i][j].setImage(tabIm[6]);
                }

                else if(carte.getCarte()[i][j].isAccessible()){
                    rectangleArray[i][j].setImage(tabIm[0]);

                }

                else if(carte.getCarte()[i][j].isMurSolide()){
                    //rectangleArray[i][j].setFill(Color.BLACK);
                    rectangleArray[i][j].setImage(tabIm[1]);
                }

                else if(carte.getCarte()[i][j].isMurCassable()){
                    //rectangleArray[i][j].setFill(Color.GREENYELLOW);
                    rectangleArray[i][j].setImage(tabIm[2]);
                }
                else if(carte.getCarte()[i][j].getPlayer() == 1) {
                    rectangleArray[i][j].setImage(tabIm[3]);

                }

                else if(carte.getCarte()[i][j].getPlayer()==2){
                        rectangleArray[i][j].setImage(tabIm[4]);
                    
                }
                if(carte.getCarte()[i][j].isBombe()){
                    //rectangleArray[i][j].setFill(Color.RED);
                    rectangleArray[i][j].setImage(tabIm[5]);
                }
                if(carte.getCarte()[i][j].isBonusBombe()&&(!carte.getCarte()[i][j].isFire())){
                    //rectangleArray[i][j].setFill(Color.RED);
                    rectangleArray[i][j].setImage(tabIm[7]);
                }
                if(carte.getCarte()[i][j].isBonusFlamme()&&(!carte.getCarte()[i][j].isFire())){
                    //rectangleArray[i][j].setFill(Color.RED);
                    rectangleArray[i][j].setImage(tabIm[8]);
                }
                if(carte.getCarte()[i][j].isFire()){
                    //rectangleArray[i][j].setFill(Color.RED);
                    rectangleArray[i][j].setImage(tabIm[9]);
                }
                if(carte.getCarte()[i][j].isBonusTeteMort()&&(!carte.getCarte()[i][j].isFire())){
                    //rectangleArray[i][j].setFill(Color.RED);
                    rectangleArray[i][j].setImage(tabIm[10]);
                }

            }
        }
        System.out.println();

    }

}