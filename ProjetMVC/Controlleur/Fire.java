package Controlleur;

import Modele.Case;

public class Fire implements Runnable{
    Case c;
    BombeCtrl bombeCtrl;

    public Fire(Case c, BombeCtrl b){
        this.c=c;
        bombeCtrl=b;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            this.bombeCtrl.no_fire(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        Thread t = new Thread(this);
        t.start();
    }
}
