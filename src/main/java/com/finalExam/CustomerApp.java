package com.finalExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerApp extends JFrame {
    private DatabaseManager dbManager;
    private JLabel lblId, lblLastName, lblFirstName, lblPhone;
    private JButton btnNext;

    public CustomerApp() {
        dbManager = new DatabaseManager();

        setTitle("Customer");
        setLayout(new GridLayout(5, 2));

        lblId = new JLabel("ID: ");
        lblLastName = new JLabel("Last Name: ");
        lblFirstName = new JLabel("First Name: ");
        lblPhone = new JLabel("Phone: ");

        JButton btnPrevious = new JButton ("Previous");
        btnNext = new JButton("Next");

        add(lblId);
        add(new JLabel());
        add(lblLastName);
        add(new JLabel());
        add(lblFirstName);
        add(new JLabel());
        add(lblPhone);
        add(new JLabel());
        add(btnPrevious);
        add(btnNext);

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextCustomer();
            }
        });

        showNextCustomer();

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void showNextCustomer() {
        if (dbManager.next()) {
            lblId.setText("ID: " + dbManager.getCustomerId());
            lblLastName.setText("Last Name: " + dbManager.getCustomerLastName());
            lblFirstName.setText("First Name: " + dbManager.getCustomerFirstName());
            lblPhone.setText("Phone: " + dbManager.getCustomerPhone());
        }
    }

    public static void main(String[] args) {
        new CustomerApp();
    }
}
