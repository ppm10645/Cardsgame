/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memorygame;

/**
 *
 * @author joao.pedro.pereira
 */
public interface CardGenerator {

    public Card[][] generateCards(int rows, int cols) throws GenerateCardsException;

}
