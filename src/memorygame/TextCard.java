/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memorygame;

/**
 *
 * @author joao.pedro.pereira
 */
public class TextCard extends Card{

    public TextCard(String text) {
        super(text);
    }

    @Override
    public boolean isEquals(Card other) {
        return other instanceof TextCard && this.text.equals(((TextCard)other).getText());
    }
    
}
