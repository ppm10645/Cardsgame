/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memorygame;

/**
 *
 * @author joao.pedro.pereira
 */
public class ArrayCardGenerator implements CardGenerator {

    // Arrays coa información para as cartas
    private static final String[] words = new String[]{"Elefante", "Pataca", "Pera"};
    private static final int[] operators1 = new int[]{3, 5, 6};
    private static final int[] operators2 = new int[]{9, 2, 3};
    private static final char[] operations = new char[]{MathCard.SUM, MathCard.MULT, MathCard.SUB};

    @Override
    public Card[][] generateCards(int rows, int cols) throws GenerateCardsException {
        
        int totalCards = rows*cols;
        if (rows * cols > 12) {
            throw new GenerateCardsException("Se queres tantas cartas, debes mercar a versión PRO");
        } else {
            Card[][] card = new Card[rows][cols];
            
            for(int i = 0; i < card.length && totalCards > 0; i++, totalCards -= 2){
                insertPair(new Card[]{new TextCard(words[i]), new TextCard(words[i])}, card, rows, cols);
            }
            
            for (int i = 0; i < card.length && totalCards >0; i++, totalCards -= 2){
                insertPair(new Card[]{
                new MathCard(operators1[i], operators2[i], operations[i],"",MathCard.typeOperation),
                new MathCard(operators1[i], operators2[i], operations[i],"",MathCard.typeResult),
            }, card, rows, cols);
            }
            
            return card;
        }
    }

    /**
     * Inserta un array de duas cartas aleatoriamente nun array bidimensional de
     * cartas que ten o número de filas e de columnas indicado
     *
     * @param cardPair Array con dúas cartas
     * @param cards Array bidimensional no que se queren colocar as cartas
     * @param rows Número de filas
     * @param columns Número de columnas
     */
    private void insertPair(Card[] cardPair, Card[][] cards,
            int rows, int columns) {
        // Recorremos o array co par de cartas para colocar as dúas cartas
        for (int i = 0; i < 2; i++) {
            boolean cardInserted = false;
            do {
                // Xeramos aleatoriamente unha fila e unha columna para colocar
                // a carta
                int row = new java.util.Random().nextInt(rows);
                int column = new java.util.Random().nextInt(columns);
                // Se na posición xerada non hai ningunha carta, colocamos
                // a carta nesa posición e marcamos que está insertada
                if (cards[row][column] == null) {
                    cards[row][column] = cardPair[i];
                    cardInserted = true;
                }
            } while (!cardInserted);
        }
    }
}
