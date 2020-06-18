import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.event.ItemEvent;
import java.io.*;

public class Finestra extends JFrame {
    public JPanel panell;
    public JTextArea areaComentari;
    public JTextField textNom, textCognom, textDni;
    public JCheckBox check;
    public ButtonGroup grupB;
    public JComboBox comboDies, comboAny, comboMes;
    //dades default
    String dia = "01";
    String mes = "Gener";
    String any = "2021";
    String horari = "No seleccionat";
    String confirmacio = "Dades no confirmades";

    public Finestra() {
        setSize(500, 500);
        setTitle("Sistema de reserves by Sergi");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponents();

    }

    private void iniciarComponents() {
        colocarPanells();
        colocarEtiquetes();
        colocarBotons();
        colocarRadioB();
        colocarTextBox();
        colocarArea();
        colocarCheckBox();
        colocarDropDown();
    }

    private void colocarPanells() {
        panell = new JPanel();
        panell.setLayout(null);
        this.getContentPane().add(panell);
    }

    private void colocarEtiquetes() {
        JLabel etiquetaTitol = new JLabel("Sistema de reserves", SwingConstants.CENTER);
        etiquetaTitol.setBounds(0, 0, 500, 30);
        //etiquetaTitol.setBackground(Color.CYAN);
        etiquetaTitol.setOpaque(true);
        etiquetaTitol.setFont(new Font("arial", Font.BOLD, 20));
        panell.add(etiquetaTitol);

        JLabel etiquetaNom = new JLabel("Nom");
        etiquetaNom.setBounds(30, 50, 90, 25);
        etiquetaNom.setFont(new Font("arial", Font.BOLD, 18));
        //etiquetaNom.setBackground(Color.CYAN);
        etiquetaNom.setOpaque(true);
        panell.add(etiquetaNom);

        JLabel etiquetaCognom = new JLabel("Cognom");
        etiquetaCognom.setBounds(30, 80, 90, 25);
        etiquetaCognom.setFont(new Font("arial", Font.BOLD, 18));
        //etiquetaCognom.setBackground(Color.CYAN);
        etiquetaCognom.setOpaque(true);
        panell.add(etiquetaCognom);

        JLabel etiquetaDni = new JLabel("DNI");
        etiquetaDni.setBounds(30, 110, 90, 25);
        etiquetaDni.setFont(new Font("arial", Font.BOLD, 18));
        //etiquetaDni.setBackground(Color.CYAN);
        etiquetaDni.setOpaque(true);
        panell.add(etiquetaDni);

        JLabel etiquetaComentari = new JLabel("Comentaris extres", SwingConstants.CENTER);
        etiquetaComentari.setBounds(30, 170, 200, 25);
        etiquetaComentari.setFont(new Font("arial", Font.BOLD, 18));
        //etiquetaComentari.setBackground(Color.CYAN);
        etiquetaComentari.setOpaque(true);
        panell.add(etiquetaComentari);

        JLabel etiquetaHorari = new JLabel("Horari preferit", SwingConstants.CENTER);
        etiquetaHorari.setBounds(260, 170, 150, 25);
        etiquetaHorari.setFont(new Font("arial", Font.BOLD, 18));
        //etiquetaHorari.setBackground(Color.CYAN);
        etiquetaHorari.setOpaque(true);
        panell.add(etiquetaHorari);

        JLabel etiquetaDia = new JLabel("Dia");
        etiquetaDia.setBounds(260, 50, 90, 25);
        etiquetaDia.setFont(new Font("arial", Font.BOLD, 18));
        //etiquetaDia.setBackground(Color.CYAN);
        etiquetaDia.setOpaque(true);
        panell.add(etiquetaDia);

        JLabel etiquetaMes = new JLabel("Mes");
        etiquetaMes.setBounds(260, 80, 90, 25);
        etiquetaMes.setFont(new Font("arial", Font.BOLD, 18));
        //etiquetaMes.setBackground(Color.CYAN);
        etiquetaMes.setOpaque(true);
        panell.add(etiquetaMes);

        JLabel etiquetaAny = new JLabel("Any");
        etiquetaAny.setBounds(260, 110, 90, 25);
        etiquetaAny.setFont(new Font("arial", Font.BOLD, 18));
        //etiquetaAny.setBackground(Color.CYAN);
        etiquetaAny.setOpaque(true);
        panell.add(etiquetaAny);

    }

    private void colocarBotons() {

        JButton boto1 = new JButton("Reservar");


        boto1.setBounds(300, 350, 100, 50);
        panell.add(boto1);


        //event listener

        ActionListener oientReserva = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nom = textNom.getText();
                String cognom = textCognom.getText();
                String dni = textDni.getText();
                String comentaris = areaComentari.getText();
                escriureCoses(nom, cognom, dni, comentaris);
                posarDadesDefault();

            }
        };
        boto1.addActionListener(oientReserva);
    }

    private void colocarRadioB() {
        JRadioButton radioB1 = new JRadioButton("Esmorzar   (De 09h a les 12h)", false);
        radioB1.setBounds(260, 200, 200, 25);
        radioB1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                horari = "Esmorzar";
            }
        });
        panell.add(radioB1);

        JRadioButton radioB2 = new JRadioButton("Dinar           (De 12h a les 16h)", false);
        radioB2.setBounds(260, 240, 200, 25);
        radioB2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                horari = "Dinar";
            }
        });
        panell.add(radioB2);

        JRadioButton radioB3 = new JRadioButton("Sopar          (De 19h a les 23h)", false);
        radioB3.setBounds(260, 280, 200, 25);
        radioB3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                horari = "Sopar";
            }
        });
        panell.add(radioB3);


        grupB = new ButtonGroup();
        grupB.add(radioB1);
        grupB.add(radioB2);
        grupB.add(radioB3);

    }

    private void colocarTextBox() {
        textNom = new JTextField();
        textNom.setBounds(150, 50, 90, 25);
        panell.add(textNom);

        textCognom = new JTextField();
        textCognom.setBounds(150, 80, 90, 25);
        panell.add(textCognom);

        textDni = new JTextField();
        textDni.setBounds(150, 110, 90, 25);
        panell.add(textDni);


    }

    private void colocarArea() {
        areaComentari = new JTextArea();
        areaComentari.setBounds(30, 200, 200, 200);
        panell.add(areaComentari);


    }

    private void colocarCheckBox() {

        check = new JCheckBox();
        check.setBounds(60, 420, 250, 20);
        check.setText("Confirmo que les dades són correctes");
        panell.add(check);

        ActionListener oientCheck = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (check.isSelected()) {
                    confirmacio = "Dades confirmades";
                }
            }
        };
        check.addActionListener(oientCheck);
    }

    private void colocarDropDown() {
        //Només obre fins el dia 28 de cada mes
        String[] opcionsDies = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14"
                , "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"};
        comboDies = new JComboBox(opcionsDies);
        comboDies.setBounds(370, 50, 90, 25);
        panell.add(comboDies);
        dia = comboDies.getSelectedItem().toString();

        String[] opcionsMes = {"Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"};
        comboMes = new JComboBox(opcionsMes);
        comboMes.setBounds(370, 80, 90, 25);
        panell.add(comboMes);

        String[] opcionsAny = {"2021", "2022", "2023", "2024"};
        comboAny = new JComboBox(opcionsAny);
        comboAny.setBounds(370, 110, 90, 25);
        panell.add(comboAny);
        any = comboAny.getSelectedItem().toString();


        comboDies.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                JComboBox comboDies = (JComboBox) event.getSource();

                Object item = event.getItem();
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    dia = item.toString();

                }
            }
        });
        comboMes.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                JComboBox comboMes = (JComboBox) event.getSource();

                Object item = event.getItem();
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    mes = item.toString();

                }
            }
        });
        comboAny.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                JComboBox comboAny = (JComboBox) event.getSource();

                Object item = event.getItem();
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    any = item.toString();

                }
            }
        });


    }

    public void escriureCoses(String nom, String cognom, String dni, String comentaris) {

        try {
            FileWriter fw = new FileWriter("C:\\Users\\Sergi\\IdeaProjects\\projecte\\src\\main\\Reserves\\" + dni + nom + cognom + ".txt");
            fw.write("Nom:         " + nom + "\n" + "Cognom:      " + cognom +
                    "\n" + "DNI:         " + dni + "\n" + "Comentaris:  " + comentaris +
                    "\n" + "Horari:      " + horari + "\n" + "Confirmació: " + confirmacio +
                    "\n" + "Data:        " + dia + "\\" + mes + "\\" + any);

            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void posarDadesDefault() {
        textNom.setText("");
        textCognom.setText("");
        textDni.setText("");
        areaComentari.setText("");
        grupB.clearSelection();
        check.setSelected(false);
        comboDies.setSelectedIndex(0);
        comboMes.setSelectedIndex(0);
        comboAny.setSelectedIndex(0);
        confirmacio = "Dades no confirmades";
    }


}
