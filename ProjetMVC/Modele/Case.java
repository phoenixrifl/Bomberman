package Modele;

import java.util.Random;

public class Case {
	private boolean accessible;
	private boolean murSolide;
	private boolean murCassable;
	private boolean bonusFlamme;
	private int nbreBonusFlamme;
	private boolean bonusBombe;
	private int nbreBonusBombe;
	private boolean bombe;
	private boolean fire;
	private boolean bonusTeteMort;
	private int player;

	public Case(){
		accessible = true;
		murSolide = false;
		murCassable = false;
		bonusFlamme = false;
		bonusBombe = false;
		bombe = false;
		nbreBonusBombe = 0;
		nbreBonusFlamme = 0;
		player = 0; //0 pas de perso/ 1 j1/ 2 j2

	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public boolean isAccessible() {
		return accessible;
	}

	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}

	public boolean isMurSolide() {
		return murSolide;
	}

	public void setMurSolide(boolean murSolide) {
		this.murSolide = murSolide;
	}

	public boolean isMurCassable() {
		return murCassable;
	}

	public void setMurCassable(boolean murCassable) {
		this.murCassable = murCassable;
	}

	public boolean isBonusFlamme() {
		return bonusFlamme;
	}

	public void setBonusFlamme(boolean bonusFlamme) {
		this.bonusFlamme = bonusFlamme;
	}

	public int getNbreBonusFlamme() {
		return nbreBonusFlamme;
	}

	public void setNbreBonusFlamme(int nbreBonusFlamme) {
		this.nbreBonusFlamme = nbreBonusFlamme;
	}

	public boolean isBonusBombe() {
		return bonusBombe;
	}

	public void setBonusBombe(boolean bonusBombe) {
		this.bonusBombe = bonusBombe;
	}

	public int getNbreBonusBombe() {
		return nbreBonusBombe;
	}

	public void setNbreBonusBombe(int nbreBonusBombe) {
		this.nbreBonusBombe = nbreBonusBombe;
	}

	public boolean isBombe() {
		return bombe;
	}

	public void setBombe(boolean bombe) {
		this.bombe = bombe;
	}

	public boolean isFire(){ return fire;}

	public void setFire(boolean fire){this.fire=fire;}

	public boolean isBonusTeteMort(){return bonusTeteMort;}

	public void setBonusTeteMort(boolean teteMort){this.bonusTeteMort=teteMort;}

	public void placerBonus(){
        Random alea = new Random();
        int a = alea.nextInt(3-0+1)+0;

        switch(a){
            case 0: this.setBonusBombe(true); break;
            case 1: this.setBonusFlamme(true); break;
            case 2 : this.setBonusTeteMort(true); break;
			case 3 :break;
            default: break;
        }
    }

    public void affiche(){

		if(isAccessible())
			System.out.print("[ ]");

		else if(isMurCassable())
			System.out.print("[-]");

		else if(isMurSolide())
			System.out.print("[#]");

		else if(isBombe())
			System.out.print("[O]");
		else if(isBonusBombe())
			System.out.print("[B]");
		else if(isBonusFlamme())
			System.out.println("[F]");
		else if(getPlayer() == 1)
			System.out.print("[1]");

		else if(getPlayer() == 2)
			System.out.print("[2]");

	}

}
