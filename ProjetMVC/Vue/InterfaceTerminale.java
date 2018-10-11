package Vue;

import Modele.Carte;

public class InterfaceTerminale {

    private Carte carte;
    private final int taille = 13;

    public InterfaceTerminale(Carte carte){
        this.carte = carte;
        this.affiche();
    }

    public void affiche() {

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (carte.getCarte()[i][j].isAccessible())
                    System.out.print("[ ]");

                else if (carte.getCarte()[i][j].isMurCassable())
                    System.out.print("[-]");

                else if (carte.getCarte()[i][j].isMurSolide())
                    System.out.print("[#]");

                else if (carte.getCarte()[i][j].isBombe())
                    System.out.print("[O]");

                else if (carte.getCarte()[i][j].getPlayer() == 1)
                    System.out.print("[1]");

            }
        }
    }
}
