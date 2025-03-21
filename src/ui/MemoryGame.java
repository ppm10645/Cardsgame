/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import memorygame.ArrayCardGenerator;
import memorygame.Card;
import memorygame.GenerateCardsException;

/**
 *
 * @author joao.pedro.pereira
 */
public class MemoryGame extends javax.swing.JFrame {

    private Card[][] cards;
    private JToggleButton[][] buttons;
    private Card lastSelectedCard = null;
    private JToggleButton lastSelectedButton = null;
    private int points;

    /**
     * Inicio de nova partida
     *
     * @param dificultade
     */
    private void startNewGame(int level) {

        try {
            //Crear un ArrayCardGenerator
            ArrayCardGenerator generator = new ArrayCardGenerator();
            int rows = level + 2;
            cards = generator.generateCards(rows, 4);
            //Resetear todos os togglebuttons
            for (JToggleButton[] row : buttons) {
                for (JToggleButton button : row) {
                    button.setSelected(false);
                    button.setText("");
                    button.setEnabled(true);
                }
            }
            //Poñer as cartas selecionadas como null
            lastSelectedCard = null;
            lastSelectedButton = null;
            points = 100;
            showGameStatus();
            //Captura de excepcions
        } catch (GenerateCardsException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro por nivel non permitido", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Texto para indicar o nivel de dificultade que se está xogando.
     */
    private void showGameStatus() {
        jLabel1.setText("Nivel: " + jComboBox1.getSelectedItem() + " | Puntos: " + points);
    }

    /**
     * Recorre o array para ocultar os togglebuttons que non están selecionados.
     */
    private void clearUnselectedButtons() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (!buttons[i][j].isSelected() && !buttons[i][j].getText().isEmpty()) {
                    buttons[i][j].setText("");
                }
            }
        }

    }

    /**
     * Comproba se queda algunha carta por acertar. Se non queda ningunha,
     * mostra unha mensaxe de victoria cos puntos.
     */
    private void checkGameOver() {

        for (Card[] row : cards) {
            for (Card cards : row) {
                if (!cards.isHit()) {
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(rootPane, "Noraboa! Acertaches todas as cartas, conseguindo " + points + " puntos!");
    }

    /**level
     * Destapa a carta que se atopa na fila e columan indicada
     *
     * @param filas
     * @param columnas
     */
    private void uncover(int row, int col) {
        clearUnselectedButtons();
        buttons[row][col].setText(cards[row][col].getText());
        
        if(lastSelectedCard == null) {
            lastSelectedCard = cards[row][col];
            lastSelectedButton = buttons[row][col];
            lastSelectedButton.setEnabled(false);
        } else {
            if(lastSelectedCard.isEquals(cards[row][col])){
                lastSelectedCard.setHit(true);
                cards[row][col].setHit(true);
                buttons[row][col].setEnabled(false);
                checkGameOver();
            } else {
                lastSelectedButton.setSelected(false);
                lastSelectedButton.setEnabled(true);
                buttons[row][col].setSelected(false);
                points--;
                showGameStatus();
            }
            lastSelectedCard = null;
        }

    }

    /**
     * Creates new form MemoryGame
     */
    public MemoryGame() {
        initComponents();

        buttons = new JToggleButton[3][4];

        buttons[0][0] = jToggleButton0_0;
        buttons[0][1] = jToggleButton0_1;
        buttons[0][2] = jToggleButton0_2;
        buttons[0][3] = jToggleButton0_3;
        buttons[1][0] = jToggleButton1_0;
        buttons[1][1] = jToggleButton1_1;
        buttons[1][2] = jToggleButton1_2;
        buttons[1][3] = jToggleButton1_3;
        buttons[2][0] = jToggleButton2_0;
        buttons[2][1] = jToggleButton2_1;
        buttons[2][2] = jToggleButton2_2;
        buttons[2][3] = jToggleButton2_3;

    }
    
    private void confirExitGame(){
        int response = JOptionPane.showConfirmDialog(this, "Seguro que queres sair?", "Sair", JOptionPane.YES_NO_OPTION);
        if(response == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelState = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jToggleButton0_1 = new javax.swing.JToggleButton();
        jToggleButton1_1 = new javax.swing.JToggleButton();
        jToggleButton0_0 = new javax.swing.JToggleButton();
        jToggleButton1_0 = new javax.swing.JToggleButton();
        jToggleButton1_2 = new javax.swing.JToggleButton();
        jToggleButton0_2 = new javax.swing.JToggleButton();
        jToggleButton0_3 = new javax.swing.JToggleButton();
        jToggleButton1_3 = new javax.swing.JToggleButton();
        jToggleButton2_0 = new javax.swing.JToggleButton();
        jToggleButton2_1 = new javax.swing.JToggleButton();
        jToggleButton2_2 = new javax.swing.JToggleButton();
        jToggleButton2_3 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonNewGame = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelState.setText("Estado do jogo");
        jPanel2.add(jLabelState);

        jToggleButton0_1.setText("2");

        jToggleButton1_1.setText("6");

        jToggleButton0_0.setText("1");

        jToggleButton1_0.setText("5");

        jToggleButton1_2.setText("7");

        jToggleButton0_2.setText("3");

        jToggleButton0_3.setText("4");

        jToggleButton1_3.setText("8");

        jToggleButton2_0.setText("9");

        jToggleButton2_1.setText("10");

        jToggleButton2_2.setText("11");

        jToggleButton2_3.setText("12");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToggleButton0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jToggleButton1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jToggleButton0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jToggleButton2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleButton1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleButton1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToggleButton1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nivel:");
        jPanel3.add(jLabel1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sinxelo", "Medio", "Dificil" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1);

        jButtonNewGame.setText("Nova Partida");
        jButtonNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewGameActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonNewGame);

        jButtonExit.setText("Saír");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonExit);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewGameActionPerformed
        
        String selectedLevel = (String)jComboBox1.getSelectedItem();
        
        if("Sinxelo".equals(selectedLevel)) {
        startNewGame(0);
    } else if ("Medio".equals(selectedLevel)){
        startNewGame(1);
    } else if ("Dificil".equals(selectedLevel)){
            
    }
    }//GEN-LAST:event_jButtonNewGameActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        confirExitGame();
    }//GEN-LAST:event_jButtonExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MemoryGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemoryGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemoryGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemoryGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemoryGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonNewGame;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelState;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToggleButton jToggleButton0_0;
    private javax.swing.JToggleButton jToggleButton0_1;
    private javax.swing.JToggleButton jToggleButton0_2;
    private javax.swing.JToggleButton jToggleButton0_3;
    private javax.swing.JToggleButton jToggleButton1_0;
    private javax.swing.JToggleButton jToggleButton1_1;
    private javax.swing.JToggleButton jToggleButton1_2;
    private javax.swing.JToggleButton jToggleButton1_3;
    private javax.swing.JToggleButton jToggleButton2_0;
    private javax.swing.JToggleButton jToggleButton2_1;
    private javax.swing.JToggleButton jToggleButton2_2;
    private javax.swing.JToggleButton jToggleButton2_3;
    // End of variables declaration//GEN-END:variables
}
