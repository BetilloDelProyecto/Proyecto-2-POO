package Partida;
import java.io.Serializable;

public class Ficha implements Serializable{
    int num;
    int color;
    boolean comodin;
    int posX = -1;
    int posY = -1;  
    
    public Ficha(int num, int color, boolean comodin) {
        this.num = num;
        this.color = color;
        this.comodin = comodin;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Ficha{" + "num=" + num + ", color=" + color + ", comodin=" + comodin + '}';
    }

    public int getColor() {
        return color;
    }

    public boolean isComodin() {
        return comodin;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setComodin(boolean comodin) {
        this.comodin = comodin;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    
}
