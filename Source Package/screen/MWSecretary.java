/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import screen.*;

/**
 *
 * @author willa
 */
public class MWSecretary extends MenuWindow {

    public MWSecretary(String name, String lastName, String Statut) {
        super(name, lastName, Statut);
    }

    private JMenu menuCreation;

    private JMenuItem itemAddCust;
    private JMenuItem createOrder;
    private JMenuItem createCat;
    private JMenuItem homePage;
    private JMenuItem createSpecie;
    
    @Override
    public void setMenu() {
     
        // Create the menu bar.
        menuBar = new JMenuBar();
        

        // Build the Home page Menu
        homePage = new JMenuItem("Home Page");
        homePage.setToolTipText("Return to the Homepage.");
        homePage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delMiddle();
            }
        });
        menuBar.add(homePage);

        //Build the Customer's menu.
        menuCreation = new JMenu("Creation");
        
        itemAddCust = new JMenuItem("Customer");
        itemAddCust.setToolTipText("Create a new Customer.");
        itemAddCust.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchCreateCustomer();
            }
        });
        menuCreation.add(itemAddCust);

        // Build the Order's menu.
        createOrder = new JMenuItem("Order");
        createOrder.setToolTipText("Create a new Order.");
        createOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchCreateOrder();
            }
        });
        menuCreation.add(createOrder);

        // Build the Category's menu.
        createCat = new JMenuItem("Category");
        createCat.setToolTipText("Create a new Category.");
        createCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchCreateCategory();
            }
        });
        menuCreation.add(createCat);
        
        // Build the Creation menu.
        
        createSpecie = new JMenuItem("Specie");
        createSpecie.setToolTipText("Create a new Specie.");
        createSpecie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchCreateSpecie();
            }
        });
        menuCreation.add(createSpecie);
        
        menuBar.add(menuCreation);
    }
    
     private void launchCreateCustomer() {
        try {
            middle.remove(0);
        } catch (ArrayIndexOutOfBoundsException exc) {
        }
        CreateCustomerInterface aux = new CreateCustomerInterface(this);
        aux.setBackground(Color.white);
        middle.add(aux, BorderLayout.CENTER);
        refreshMid();
    }
    
      private void launchCreateCategory() {
        try {
            middle.remove(0);
        } catch (ArrayIndexOutOfBoundsException exc) {
        }
        CreateCategoryInterface aux = new CreateCategoryInterface(this);
        aux.setBackground(Color.white);
        middle.add(aux, BorderLayout.CENTER);
        refreshMid();
    }

    private void launchCreateOrder() {
        try {
            middle.remove(0);
        } catch (ArrayIndexOutOfBoundsException exc) {
        }
        CreateOrderInterface aux = new CreateOrderInterface(this);
        aux.setBackground(Color.white);
        middle.add(aux, BorderLayout.CENTER);
        refreshMid();
    }
    
    private void launchCreateSpecie() {
        try {
            middle.remove(0);
        } catch (ArrayIndexOutOfBoundsException exc) {
        }
        CreateSpecieInterface aux = new CreateSpecieInterface(this);
        aux.setBackground(Color.white);
        middle.add(aux, BorderLayout.CENTER);
        refreshMid();
    }
    
}
