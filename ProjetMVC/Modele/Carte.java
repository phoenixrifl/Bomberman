package Modele;

import Controlleur.PersonnageCtrl;
import Vue.GridDisplay;

import java.util.Random;

public class Carte {
    private PersonnageCtrl player;
    private PersonnageCtrl player2;
	private Case[][] carte;
	private final int taille = 13;
	private GridDisplay gd = null;


	public Carte(GridDisplay gd){
		this.gd=gd;
		Random alea = new Random();
		double maxMurCassable = 3;
		double minMurCassable = 0.8;
		boolean terInvalide = false;
		player = new PersonnageCtrl(new Personnage("blanc", this,1));
		player2 = new PersonnageCtrl(new Personnage("rouge", this,2));

		while(!terInvalide){
			int nbreCase = taille*taille;
			int murCassable = aleaInt((int)(nbreCase * maxMurCassable), (int)(nbreCase*minMurCassable), alea);
			this.carte = new Case[taille][taille];
			for(int i=0;i<taille;i++){
				for(int j=0;j<taille;j++){
					carte[i][j]= new Case();

					if(i == 0 || j == 0 || i == taille-1 || j == taille-1 || i%2 == 0 && j%2 == 0){
						carte[i][j].setAccessible(false);
						carte[i][j].setMurSolide(true);
					}

					if(i == 1 && j == 1){
						carte[i][j].setAccessible(false);;

						carte[i][j].setPlayer(1);
					}
					if(i == 11 && j == 11){
						carte[i][j].setAccessible(false);;

						carte[i][j].setPlayer(2);
					}
				}
			}

			placerMurCassable(murCassable, alea);

			terInvalide = true;
		}
	}

	public GridDisplay getGridDisplay(){
		return gd;
	}

	public Case[][] getCarte(){
		return carte;
	}

	public PersonnageCtrl getPlayer(int i) {
		if(i==1)
			return player;
		else
			return player2;
	}


	public PersonnageCtrl getPlayer1() {
		return player;
	}

	public PersonnageCtrl getPlayer2() {
		return player2;
	}


	private int aleaInt(int max, int mini, Random alea){
		return alea.nextInt(max-mini+1)+mini;
	}

	private void placerMurCassable(int murCassable, Random alea){
		int cmpt = 0;
		int x, y;

		do{
			x = aleaInt(carte.length-1, 0, alea);
			y = aleaInt(carte.length-1, 0, alea);
			if((x==1 && y==1) || (x==1 && y==2) || (x==2 && y==1)||
					(x==11 && y==11) || (x==11 && y==10) || (x==10 && y==11) ){
			}
			else if(this.carte[x][y].isMurSolide() == true){

			}
			else {
				this.carte[x][y].setMurCassable(true);
				this.carte[x][y].setAccessible(false);
			}
			cmpt++;


		}while(cmpt != murCassable);

	}

/*	public void placerBonus(Case[][]carte){
        Random alea = new Random();
        int a = aleaInt(2,0,alea);

        switch(a){
            case 0: this.carte[x][y].setBonusBombe(true); break;
            case 1: this.carte[x][y].setBonusFlamme(true); break;
            case 2 : break;
            default: break;
        }
    }*/



	public void affichage(){
		for(int i=0;i<13;i++){
			System.out.println("");
			for(int j=0;j<13;j++){
				this.carte[i][j].affiche();
			}
		}
		System.out.println();


	}
}
