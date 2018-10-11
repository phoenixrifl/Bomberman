package Controlleur;

import Modele.Bombe;
import Modele.Personnage;


import java.util.Scanner;

public class PersonnageCtrl {

    Personnage perso;

    public PersonnageCtrl(Personnage perso){
        this.perso = perso;
    }

    public void PoseBombe(){
        int x = perso.getPosX();
        int y = perso.getPosY();
        if(this.perso.getBombeDrop() > perso.getNbreBombes()){
            return;
        }
		/*else if(!this.carte.getCarte()[x][y].isAccessible()){
			return;
		}*/
        else{
            perso.getCarte().getCarte()[x][y].setBombe(true);
            perso.getCarte().getCarte()[x][y].setAccessible(false);
            this.perso.setBombeDrop(1);
          //  BombeCtrl bombe= new BombeCtrl(new Bombe(this.perso,this.perso.getLgExplo(),this.perso.getCouleur(),this.perso.getCarte(),x,y,0));
         new BombeCtrl(new Bombe(this.perso,this.perso.getLgExplo(),this.perso.getCouleur(),this.perso.getCarte(),x,y,0)).start();
            perso.getCarte().affichage();

        }
    }

    public boolean deplacement(String dep, int joueur) {
        int x = perso.getPosX();
        int y = perso.getPosY();

        System.out.println("Je suis actuellement en x = " + x + " y = " + y);

        switch (dep) {

            case "bas":
                System.out.println("bas ?");

                System.out.println(perso.getCarte().getCarte()[x + 1][y].isAccessible());
                if (perso.getCarte().getCarte()[x + 1][y].isAccessible()) {
                    perso.setPosX(x + 1);
                    perso.getCarte().getCarte()[x + 1][y].setPlayer(joueur);
                    perso.getCarte().getCarte()[x + 1][y].setAccessible(false);
                    perso.getCarte().getCarte()[x][y].setPlayer(0);
                    if (!perso.getCarte().getCarte()[x][y].isBombe()) {
                        perso.getCarte().getCarte()[x][y].setAccessible(true);
                    }
                    this.getBonus();
                    this.perso.getCarte().affichage();
                    System.out.println("je suis maintenant en " + perso.getPosX() + " ," + perso.getPosY());

                    return true;
                } else
                    System.out.println("je peux pas bas");

                break;

            case "haut":
                System.out.println("haut ?");

                if (perso.getCarte().getCarte()[x - 1][y].isAccessible()) {
                    perso.setPosX(x - 1);
                    perso.getCarte().getCarte()[x - 1][y].setPlayer(joueur);
                    perso.getCarte().getCarte()[x - 1][y].setAccessible(false);
                    perso.getCarte().getCarte()[x][y].setPlayer(0);
                    if (!perso.getCarte().getCarte()[x][y].isBombe()) {
                        perso.getCarte().getCarte()[x][y].setAccessible(true);
                    }
                    this.getBonus();

                    perso.getCarte().affichage();
                    System.out.println("je suis maintenant en " + perso.getPosX() + " ," + perso.getPosY());
                    return true;

                } else
                    System.out.println("je peux pas haut");
                break;

            case "gauche":
                System.out.println("gauche ?");

                if (perso.getCarte().getCarte()[x][y - 1].isAccessible()) {
                    perso.setPosY(y - 1);
                    perso.getCarte().getCarte()[x][y - 1].setPlayer(joueur);
                    perso.getCarte().getCarte()[x][y - 1].setAccessible(false);
                    perso.getCarte().getCarte()[x][y].setPlayer(0);
                    if (!perso.getCarte().getCarte()[x][y].isBombe()) {
                        perso.getCarte().getCarte()[x][y].setAccessible(true);
                    }
                    this.getBonus();

                    perso.getCarte().affichage();
                    System.out.println("je suis maintenant en " + perso.getPosX() + " ," + perso.getPosY());
                    return true;

                } else
                    System.out.println("je peux pas gauche");
                break;

            case "droite":
                System.out.println("droite ?");

                if (perso.getCarte().getCarte()[x][y + 1].isAccessible()) {
                    perso.setPosY(y + 1);
                    perso.getCarte().getCarte()[x][y + 1].setPlayer(joueur);
                    perso.getCarte().getCarte()[x][y + 1].setAccessible(false);
                    perso.getCarte().getCarte()[x][y].setPlayer(0);
                    if (!perso.getCarte().getCarte()[x][y].isBombe()) {
                        perso.getCarte().getCarte()[x][y].setAccessible(true);
                    }
                    this.getBonus();

                    perso.getCarte().affichage();
                    System.out.println("je suis maintenant en " + perso.getPosX() + " ," + perso.getPosY());
                    return true;

                } else
                    System.out.println("je peux pas droite");
                break;

            default:
                break;
        }
        return false;
    }

        public void getBonus(){
            int x = perso.getPosX();
            int y = perso.getPosY();

            if(perso.getCarte().getCarte()[x][y].isBonusBombe()){
                perso.getCarte().getCarte()[x][y].setBonusBombe(false);
                perso.setNbreBombes(1);
            }

            if(perso.getCarte().getCarte()[x][y].isBonusFlamme()){
                perso.getCarte().getCarte()[x][y].setBonusFlamme(false);
                perso.setLgExplo(1);
            }
            if(perso.getCarte().getCarte()[x][y].isBonusTeteMort()){
                perso.getCarte().getCarte()[x][y].setBonusTeteMort(false);
                int nb = (int) (Math.random() * 3);

                if(nb==0){
                    if(perso.getLgExplo()>1)
                        perso.setLgExplo(-1);
                }else if(nb==1){
                    if(perso.getNbreBombes()>1)
                        perso.setNbreBombes(-1);
                }else{
                    perso.setSuperMode(true);
                }

            }
    }



    public Personnage getPerso(){
        return this.perso;
    }
    
}
