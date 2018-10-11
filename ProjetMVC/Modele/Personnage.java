package Modele;

import Controlleur.PersonnageCtrl;

public class Personnage {
    private Carte carte;
    private PersonnageCtrl persoctrl;
	private int posX, posY, nbreBombes, bombeDrop, lgExplo;
	private String couleur;
	private boolean mort;
	private boolean superMode; //bombe qui peut detruire plusieurs murs cassable

	public Personnage(String couleur, Carte carte,int i){
	    persoctrl=new PersonnageCtrl(this);
		this.couleur = couleur;
		this.superMode=false;
		this.carte = carte;
		if(i==1) {
			this.posX = 1;
			this.posY = 1;
		}
		else{
			this.posX = 11;
			this.posY = 11;
		}

		this.nbreBombes = 0;
		this.bombeDrop = 0;
		this.lgExplo = 1;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getNbreBombes() {
		return nbreBombes;
	}
	// si on prend le bonus bombe en plus
	public void setNbreBombes(int nbreBombes) {
		this.nbreBombes += nbreBombes;
	}

	public int getLgExplo() {
		return lgExplo;
	}
	// si on prend le bonus flamme en plus
	public void setLgExplo(int lgExplo) {
		this.lgExplo += lgExplo;
	}

	public String getCouleur() {
		return couleur;
	}

	public boolean isDead(){
		return this.mort;
	}

	public boolean isSuperMode(){return superMode;}

	public void setSuperMode(boolean spM){superMode=spM;}

	public void setMort(boolean b){
		System.out.println("je suis mort: "+this.couleur);
		this.mort = b;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public int getBombeDrop(){
		return this.bombeDrop;
	}
    public void setBombeDropBis(int nb){
	this.bombeDrop=nb;
    }
	public void setBombeDrop(int nb){
		this.bombeDrop += nb;
	}
	public Carte getCarte(){
		return this.carte;
	}
	public void setCarte(Carte c){
		this.carte=c;
	}

}
