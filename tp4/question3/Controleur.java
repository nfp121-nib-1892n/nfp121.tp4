package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Controleur extends JPanel  implements ActionListener {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(null /* null est à remplacer */);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
       boutons.add(push);  push.addActionListener(this); /* null est à remplacer */
        boutons.add(add);   add.addActionListener(this); /* null est à remplacer */
        boutons.add(sub);   sub.addActionListener(this); /* null est à remplacer */
        boutons.add(mul);   mul.addActionListener(this); /* null est à remplacer */
        boutons.add(div);   div.addActionListener(this); /* null est à remplacer */
        boutons.add(clear); clear.addActionListener(this); /* null est à remplacer */add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
         if (pile.estPleine())
            push.setEnabled(false);
        else if (pile.estVide()){
            push.setEnabled(true);
            clear.setEnabled(false);
            add.setEnabled(false);
            sub.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
        } else if (pile.taille() == 1){
            push.setEnabled(true);
            clear.setEnabled(true);
            add.setEnabled(false);
            sub.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
        } else {
            push.setEnabled(true);
            clear.setEnabled(true);
            add.setEnabled(true);
            sub.setEnabled(true);
            mul.setEnabled(true);
            div.setEnabled(true);
        }
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    public void actionPerformed(ActionEvent e) {
        JOptionPane optionPane = null;
        int nbr1 = 0, nbr2 = 0, res = 0;
        boolean sommetExiste = false;
        try{
            if(e.getSource() == push) {
                int txt = Integer.parseInt(this.donnee.getText());
                pile.empiler(txt);
            } else if(e.getSource() == add) {
                if(this.pile.sommet() != null) sommetExiste = true;
                nbr1 = pile.depiler();
                nbr2 = pile.depiler();
                res = nbr1 + nbr2;
                pile.empiler(res);
                this.donnee.setText(res + "");
            } else if(e.getSource() == sub) {
                if(this.pile.sommet() != null) sommetExiste = true;
                nbr1 = pile.depiler();
                nbr2 = pile.depiler();
                res = nbr1 - nbr2;
                pile.empiler(res);
                this.donnee.setText(res + "");
            } else if(e.getSource() == mul) {
                if(this.pile.sommet() != null) sommetExiste = true;
                nbr1 = pile.depiler();
                nbr2 = pile.depiler();
                res = nbr1 * nbr2;
                pile.empiler(res);
                this.donnee.setText(res + "");
            } else if(e.getSource() == div) {
                if(this.pile.sommet() != null) sommetExiste = true;
                nbr1 = pile.depiler();
                nbr2 = pile.depiler();
                res = nbr1 / nbr2;
                pile.empiler(res);
                this.donnee.setText(res + "");
            } else if(e.getSource() == clear) {
                while(!this.pile.estVide()) this.pile.depiler();
            }
        } catch(PilePleineException ex1) {
            optionPane = new JOptionPane(ex1.getMessage(), JOptionPane.ERROR_MESSAGE);  
        } catch(PileVideException ex2) {
            try{
            if(e.getSource() == add && sommetExiste) {
                this.pile.empiler(nbr1);
            } else if(e.getSource() == sub && sommetExiste) {
                this.pile.empiler(nbr1);
            } else if(e.getSource() == mul && sommetExiste) {
                this.pile.empiler(nbr1);
            } else if(e.getSource() == div && sommetExiste) {
                this.pile.empiler(nbr1);
            }
        } catch(Exception exn){}
            optionPane = new JOptionPane(ex2.getMessage(), JOptionPane.ERROR_MESSAGE);  
        } catch(Exception ex3) {
            optionPane = new JOptionPane("This is not a Number!!", JOptionPane.ERROR_MESSAGE);    
        } finally {
            if(optionPane != null){
                JDialog dialog = optionPane.createDialog("Failure");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
                dialog.dispose();
            }
            actualiserInterface();
            this.donnee.setText("");
            this.donnee.requestFocus();
        }
    }
}