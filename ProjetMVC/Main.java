import Modele.Personnage;
        import Vue.GridDisplay;
        import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.Group;
        import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
        import javafx.scene.layout.*;
        import javafx.scene.media.Media;
        import javafx.scene.media.MediaPlayer;
        import javafx.scene.text.Font;
        import javafx.stage.Stage;

        import java.net.URL;


public class Main extends Application {

    private GridDisplay grid;
    int scoreJ1=0;
    int scoreJ2=0;
    int porteeJ1=1;
    int porteeJ2=1;
    int nbBombeJ1=1;
    int nbBombeJ2=1;
    boolean superModeJ1=false;
    boolean superModeJ2=false;

    BorderPane mainPanel = null;
    Label TopScoreVal1 =null;
    Label TopScoreVal2 =null;
    Label labelPorteeJ1=null;
    Label labelPorteeJ2=null;
    Label labelNbBombeJ1=null;
    Label labelNbBombeJ2=null;
    Label labelSuperModeJ1=null;
    Label labelSuperModeJ2=null;

    Scene sc= null;
    @Override
    public void start(Stage primaryStage) throws Exception{

        mainPanel = new BorderPane();
        Pane paneTop = new Pane();

        VBox VBG = new VBox(10);
        VBox VBD = new VBox(10);
        VBox VBT = new VBox();
        HBox HBTScore = new HBox(10);

        MenuBar menuBar = new MenuBar();
        menuBar.setPrefSize(2000,5);
        //HBT.setStyle("-fx-font-size: 15; -fx-background-color: #98b2ab");
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        MenuItem exit = new MenuItem("Exit");
        MenuItem resetScore = new MenuItem("Reset Score");
        menuFile.getItems().addAll(exit);
        menuEdit.getItems().addAll(resetScore);

        menuBar.getMenus().addAll(menuFile,menuEdit);

        Label TopTime = new Label("Temps :");
        Label TopTimeVal = new Label(" ");
        Label TopScore = new Label("Score : ");
        TopScoreVal1 = new Label(String.valueOf(scoreJ1));
        Label TopScoreM = new Label(" - ");
        TopScoreVal2 = new Label(String.valueOf(scoreJ2));
        Label musique = new Label("♫ :");
        Button musiquePause = new Button("Pause");
        musiquePause.setFont(Font.font ("Verdana", 13) );
        Button musiquePlay = new Button("Play");
        musiquePlay.setFont(Font.font ("Verdana", 13) );
        musiquePlay.setDisable(true);

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        exit.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        resetScore.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scoreJ1 =0;
                scoreJ2 =0;
                TopScoreVal1.setText(String.valueOf(scoreJ1));
                TopScoreVal2.setText(String.valueOf(scoreJ2));
            }
        });


        //Joueur 1 gauche
        Label J1 = new Label("Joueur 1");
        J1.setStyle("-fx-font-size: 15; -fx-background-color: #f06146");
        Label control1 = new Label("Contrôles");
        Label haut1 = new Label("Haut: Z");
        Label gauche1 = new Label("Gauche : Q");
        Label droite1 = new Label("Droite : D");
        Label bas1 = new Label("Bas : S");
        Label bombeJ1 = new Label("Bombe : A");
        labelPorteeJ1 = new Label("Portee : "+String.valueOf(porteeJ1));
        labelNbBombeJ1 = new Label("nb bombes : "+String.valueOf(nbBombeJ1));
        labelSuperModeJ1 = new Label("SPM : "+String.valueOf(superModeJ1));
        //Joueur 2 droite
        Label J2 = new Label("Joueur 2");
        J2.setStyle("-fx-font-size: 15;-fx-background-color: #78a3b2");
        Label control2 = new Label("Contrôles");
        Label haut2 = new Label("Haut: ↑");
        Label gauche2 = new Label("Gauche : ←");
        Label droite2 = new Label("Droite : →");
        Label bas2 = new Label("Bas : ↓");
        Label bombeJ2 = new Label("Bombe : M");
        labelPorteeJ2 = new Label("Portee : "+String.valueOf(porteeJ2));
        labelNbBombeJ2 = new Label("nb bombes : "+String.valueOf(nbBombeJ2));
        labelSuperModeJ2 = new Label("SPM : "+String.valueOf(superModeJ2));

        HBTScore.getChildren().addAll(TopTime,TopTimeVal,TopScore,TopScoreVal1,TopScoreM,TopScoreVal2, musique,musiquePause, musiquePlay);
        VBG.getChildren().addAll(J1,control1,haut1,gauche1,droite1,bas1,bombeJ1,labelPorteeJ1,labelNbBombeJ1,labelSuperModeJ1);
        VBD.getChildren().addAll(J2,control2,haut2,gauche2,droite2,bas2,bombeJ2,labelPorteeJ2,labelNbBombeJ2,labelSuperModeJ2);

        VBT.getChildren().addAll(menuBar, HBTScore);
        HBTScore.setStyle("-fx-font-size: 20; -fx-background-color: #98b2ab");
        paneTop.getChildren().addAll(VBT);

        //plateau du jeu
        // Group root = new Group();
        this.grid = new GridDisplay();
        //Region regionC = new Region();

        //musique
        try {
            final URL musicURL = getClass().getResource("Musiques/bomberman1.mp3");
            final Media media = new Media(musicURL.toExternalForm());
            final MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(100);
            mediaPlayer.play();


            musiquePause.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    mediaPlayer.pause();
                    musiquePause.setDisable(true);
                    musiquePlay.setDisable(false);
                }
            });
            musiquePlay.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    mediaPlayer.play();
                    musiquePause.setDisable(false);
                    musiquePlay.setDisable(true);
                }
            });
        }
        catch(Exception e){
            System.out.println("Installe les bonnes librairies svp");
        }
        //fin musique


        mainPanel.setTop(paneTop);
        mainPanel.setLeft(VBG);
        mainPanel.setCenter(grid.getDisplay());
        mainPanel.setRight(VBD);
        mainPanel.setStyle("-fx-background-color: gray");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(520);
        primaryStage.setTitle("Bomberman");
        Scene scene = new Scene(mainPanel, 560, 450);
        sc = scene;
        deplacementGraphique(scene,this.grid.getDisplay());
        primaryStage.setScene(scene);

        primaryStage.show();
    }
    public void deplacementGraphique(Scene scene,Group display){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                defaite();
                switch(keyEvent.getCode()){
                    case UP: grid.getCarte().getPlayer(2).deplacement("haut",2); break;
                    case LEFT: grid.getCarte().getPlayer(2).deplacement("gauche",2); break;
                    case RIGHT: grid.getCarte().getPlayer(2).deplacement("droite",2); break;
                    case DOWN: grid.getCarte().getPlayer(2).deplacement("bas",2); break;
                    case M: grid.getCarte().getPlayer(2).PoseBombe(); break;
                    case Z: grid.getCarte().getPlayer(1).deplacement("haut",1); break;
                    case Q: grid.getCarte().getPlayer(1).deplacement("gauche",1); break;
                    case D: grid.getCarte().getPlayer(1).deplacement("droite",1); break;
                    case S: grid.getCarte().getPlayer(1).deplacement("bas",1); break;
                    case A: grid.getCarte().getPlayer(1).PoseBombe(); break;
                }
                grid.affichage();
                miseAjourMode();
                //System.out.println(grid.getChildren().toString());
            }
        });
    }

    public void defaite() {
        if (grid.getCarte().getPlayer1().getPerso().isDead()) {//defaite J1
            scoreJ2++;
            TopScoreVal2.setText(String.valueOf(scoreJ2));
            newCarte();
        }
        if (grid.getCarte().getPlayer2().getPerso().isDead()) {//defaite J1
            scoreJ1++;
            TopScoreVal1.setText(String.valueOf(scoreJ1));
            newCarte();
        }

    }

    public void newCarte() {
        grid = new GridDisplay();
        deplacementGraphique(sc, this.grid.getDisplay());
        mainPanel.setCenter(grid.getDisplay());
    }
    public void miseAjourMode(){
        //Joueur 1
        porteeJ1 = this.grid.getCarte().getPlayer1().getPerso().getLgExplo();
        labelPorteeJ1 .setText("Portee : "+String.valueOf(porteeJ1));
        nbBombeJ1 = this.grid.getCarte().getPlayer1().getPerso().getNbreBombes()+1;
        labelNbBombeJ1.setText("nb bombes : "+String.valueOf(nbBombeJ1));
        superModeJ1 = this.grid.getCarte().getPlayer1().getPerso().isSuperMode();
        labelSuperModeJ1.setText("SPM : "+String.valueOf(superModeJ1));
        //Joueur 2
        porteeJ2 = this.grid.getCarte().getPlayer2().getPerso().getLgExplo();
        labelPorteeJ2.setText("Portee : "+String.valueOf(porteeJ2));
        nbBombeJ2 = this.grid.getCarte().getPlayer2().getPerso().getNbreBombes()+1;
        labelNbBombeJ2.setText("nb bombes : "+String.valueOf(nbBombeJ2));
        superModeJ2 = this.grid.getCarte().getPlayer2().getPerso().isSuperMode();
        labelSuperModeJ2.setText("SPM : "+String.valueOf(superModeJ2));
        System.out.println("porte1: "+ porteeJ1+", porte2: "+porteeJ2);

    }
    public static void main(String[] args) {
        launch(args);
    }
}