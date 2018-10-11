package Modele;

public class Bombe {

    Personnage proprietaire;
	int largeurExplo;
	String couleur;
	Carte carte;
	int coordX;
	int coordY;
	int timeEx; //milli sec

	public Bombe(Personnage p,int lgEx,String couleur,Carte carte,int x, int y,int time){
		this.proprietaire=p;
		this.largeurExplo=lgEx;
		this.couleur=couleur;
		this.carte=carte;
		this.coordX=x;
		this.coordY=y;
		timeEx=time;
	}
	public Personnage getProprietaire(){
		return this.proprietaire;
	}
	public void setProprietaire(Personnage p){
		this.proprietaire=p;
	}
	public int getLargeurExplo(){
		return this.largeurExplo;
	}
	public void setLargeurExplo(int i){
		this.largeurExplo=i;
	}
	public String getCouleur(){
		return this.couleur;
	}
	public void setCouleur(String s){
		this.couleur=s;
	}
	public Carte getCarte(){
		return this.carte;
	}
	public void setCarte(Carte c){
		this.carte=c;
	}
	public int getCoordX(){
		return this.coordX;
	}
	public void setCoordX(int x){
		this.coordX=x;
	}
	public int getCoordY(){
		return this.coordY;
	}
	public void setCoordY(int y){
		this.coordY=y;
	}

}
