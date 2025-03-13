/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memorygame;

/**
 *
 * @author joao.pedro.pereira
 */
public class MathCard extends Card {

    private int operator1, operator2;
    private char operation;
    public static final char SUM = '+';
    public static final char SUB = '-';
    public static final char MULT = '*';
    
    public static final int typeOperation = 0;
    public static int typeResult = 1;
    private int cardType;

    public int getOperator1() {
        return operator1;
    }

    public void setOperator1(int operator1) {
        this.operator1 = operator1;
    }

    public int getOperator2() {
        return operator2;
    }

    public void setOperator2(int operator2) {
        this.operator2 = operator2;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }
    
    
    

    public MathCard(int operator1, int operator2, char operation, String text, int cardType) {
        super(text);
        this.operator1 = operator1;
        this.operator2 = operator2;
        this.operation = operation;
        this.cardType = cardType;
    }

    @Override
    public boolean isEquals(Card other) {
        return other instanceof MathCard && this.getValue() == (((MathCard)other).getValue());
    }
    /**
     * Devolve o resultado da operación
     * @return 
     */
    private int getValue() {


        switch (operation) {
            case SUM:
                return operator1 + operator2;
            case SUB:
                return operator1 - operator2;
            case MULT:
                return operator1 * operator2;
        }
        return -1;
    }

}
