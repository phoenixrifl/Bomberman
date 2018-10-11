package Controlleur;

import Modele.Bombe;
import Modele.Carte;
import Modele.Case;

import java.util.TimerTask;

public class BombeCtrl implements Runnable {
	Bombe bombe;
	public BombeCtrl(Bombe b){this.bombe=b;}


	public boolean explosionAux(Case c, Carte carte){
		if(c==null ||c.isMurSolide()){
			return false;
		}
		else if(c.isMurCassable()){
			c.setMurCassable(false);
			c.setAccessible(true);
			c.isMurCassable();
			c.placerBonus();
			if(!this.bombe.getProprietaire().isSuperMode())
				return false;
		}
		else if(c.isBonusFlamme()){
			c.setBonusFlamme(false);
			c.setFire(true);
			new Fire(c,this).start();
		}
		else if(c.isBonusBombe()){
			c.setBonusBombe(false);
			c.setFire(true);
			new Fire(c,this).start();
		}
		else if(c.isBonusTeteMort()){
			c.setBonusTeteMort(false);
			c.setFire(true);
			new Fire(c,this).start();
		}
		else if(c.isAccessible()){
			c.setFire(true);
			new Fire(c,this).start();
		}
		else{
			if(c.getPlayer()!=0){
				//mort du personnage qui se trouve sur la case
				if(c.getPlayer()==1){//mort J1
					carte.getPlayer1().perso.setMort(true);
				}
				if(c.getPlayer()==2){//mort J2
					carte.getPlayer2().perso.setMort(true);
				}
			}
		}
		return true;
	}
	public boolean explosion(){
		//zone de deflagration
		boolean res;
		//haut
		int i=this.bombe.getCoordX();
		while(i>=this.bombe.getCoordX()-this.bombe.getLargeurExplo()){
			System.out.println("haut");
			res= explosionAux(this.bombe.getCarte().getCarte()[i][this.bombe.getCoordY()],this.bombe.getCarte());
			if(res){
				i--;
			}
			else
				break;
		}
		//rayon bas
		i=this.bombe.getCoordX();
		while(i<=this.bombe.getCoordX()+this.bombe.getLargeurExplo()){
			res=explosionAux(this.bombe.getCarte().getCarte()[i][this.bombe.getCoordY()],this.bombe.getCarte());
			if(res){
				i++;
			}
			else
				break;
		}
		//rayon gauche
		i=this.bombe.getCoordY();
		while(i>=this.bombe.getCoordY()-this.bombe.getLargeurExplo()){
			res=explosionAux(this.bombe.getCarte().getCarte()[this.bombe.getCoordX()][i],this.bombe.getCarte());
			if(res){
				i--;
			}
			else
				break;
		}
		//rayon droit
		i=this.bombe.getCoordY();
		while(i<=this.bombe.getCoordY()+this.bombe.getLargeurExplo()){
			res =explosionAux(this.bombe.getCarte().getCarte()[this.bombe.getCoordX()][i],this.bombe.getCarte()) ;
			if(res){
				i++;
			}
			else
				break;
		}


		//une fois la bombe explosée
		this.bombe.getCarte().getCarte()[this.bombe.getCoordX()][this.bombe.getCoordY()].setBombe(false);
		/*this.after_explosion(true);
		new Fire(this).start();*/
		this.bombe.getCarte().getCarte()[this.bombe.getCoordX()][this.bombe.getCoordY()].setAccessible(true);
		this.bombe.getProprietaire().setBombeDrop(/*this.bombe.getProprietaire().getBombeDrop()*/-1);
		//affichage:
		this.bombe.getProprietaire().getCarte().getGridDisplay().affichage();
		return true;
	}

	public boolean no_fire(Case c){
		c.setFire(false);
		this.bombe.getProprietaire().getCarte().getGridDisplay().affichage();
		return true;
	}

	public void run() {
		try {
			Thread.sleep(1000);
			explosion();


		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		Thread t = new Thread(this);
		t.start();
	}
}