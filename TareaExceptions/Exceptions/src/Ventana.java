import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class Ventana implements ActionListener {
    JFrame ventana;
    JPanel panel;
    JButton boton1;
    JButton boton2;
    JButton boton3;
    int secuencia = 1;


    public Ventana() {
        ventana = new JFrame("Tarea Excepciones");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();

        ventana.setPreferredSize(new DimensionUIResource(400, 400));
        ventana.pack();
        ventana.setVisible(true);
    }
    private void iniciarComponentes() {
        colocarPanel();
        colocarBotones();

    }
    private void colocarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        ventana.add(panel);
    }

    private void colocarBotones() {
        boton1 = new JButton("Boton 1");
        boton2 = new JButton("Boton 2");
        boton3 = new JButton("Boton 3");

        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
    
        boton1.setBounds(100,50,200,70);
        boton2.setBounds(100,150,200,70);
        boton3.setBounds(100,250,200,70);

        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
    }
    private void colocarDialogo() {
        JDialog dialogo = new JDialog();
        JPanel panelDialogo = new JPanel();
        panelDialogo.setLayout(null);
        JLabel excepcion = new JLabel();
        excepcion.setText("Falló en el orden de los botones");
        excepcion.setBounds(30,50,470,100);
        excepcion.setForeground(Color.BLACK);
        excepcion.setOpaque(true);
        excepcion.setBackground(Color.RED);
        excepcion.setFont(new Font("cooper black", 0, 30));
        dialogo.setTitle("Excepción");
        dialogo.setVisible(true);
        dialogo.setSize(520,200);
        panelDialogo.add(excepcion);
        dialogo.add(panelDialogo);
        dialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(boton1)){
            if(secuencia == 1)
                secuencia++;
            else
                try {
                    throw new Exception("El boton selecionado altera el orden");
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    colocarDialogo();
                    secuencia = 1;
                }
        }
        if(e.getSource().equals(boton2)){
            if(secuencia == 2)
                secuencia ++;
            else
                try {
                    throw new Exception("El boton selecionado altera el orden");
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    colocarDialogo();
                    secuencia = 1;
                }
        }
        if(e.getSource().equals(boton3)) {
            if(secuencia == 3)
                secuencia = 1;
            else
                try {
                    throw new Exception("El boton selecionado altera el orden");
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    colocarDialogo();
                    secuencia = 1;
                }
        }
    }
}
