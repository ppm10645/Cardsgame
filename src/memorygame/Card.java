/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package memorygame;

/**
 *
 * @author joao.pedro.pereira
 */
public abstract class Card  {
    
    protected String text;
    protected boolean hit = false;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public Card(String text) {
        this.text = text;
    }
    
    /**
     * Metodo para saber se duas cartas son iguais
     * @param other
     * @return 
     */
    public abstract boolean isEquals(Card other);
    
}
