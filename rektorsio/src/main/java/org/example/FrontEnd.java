package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontEnd{

    JButton jButton = new JButton();
    JTextField txtBox = new JTextField("valami");
    JTextField txtBox2 = new JTextField("valami");
    JButton button = new JButton();

    public void MainWindow() {
        JFrame frame = new JFrame("JFrame Example");
        JPanel panel = new JPanel(new GridLayout(5, 1));
        JLabel label = new JLabel("JFrame By Example");

        button.setText("Button");

        jButton.setText("Leállítás");

        txtBox.setPreferredSize(new Dimension(500, 25));
        txtBox2.setPreferredSize(new Dimension(500, 25));

        //panel's list
        panel.add(label);
        panel.add(button);
        panel.add(txtBox);
        panel.add(txtBox2);
        panel.add(jButton);

        //frame
        frame.add(panel);
        //frame settings
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //services
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = txtBox.getText();
                String y = txtBox2.getText();
                System.out.println("A megadott input: "+x);
                BackEnd backEnd = new BackEnd();
                //example: https://pteehok.hu/
                backEnd.fun(x,y);
                //
            }
        });
    }

    public void FoundedItem(String fItem){
        //https://pte.hu/hu
        JFrame frame = new JFrame("JFrame Example");
        JPanel panel = new JPanel(new GridLayout(5, 1));
        //panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("JFrame By Example");
        JTextField txtOutBox3 = new JTextField("<...>");
        txtOutBox3.setPreferredSize(new Dimension(500, 25));
        panel.add(txtOutBox3);
        txtOutBox3.setText(fItem);
        System.out.println(txtOutBox3.getText());
        //frame
        frame.add(panel);
        //frame settings
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(panel);
        frame.setVisible(true);
    }

}
