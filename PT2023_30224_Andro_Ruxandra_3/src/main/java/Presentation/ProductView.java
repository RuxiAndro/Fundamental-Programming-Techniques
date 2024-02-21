package Presentation;

import Model.Client;
import Model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductView extends JFrame {
    private JLabel nume;
    private JLabel price;
    private JLabel prodInStock;
    private JLabel listaProduse;
    private JTextField numetf;
    private JTextField pricetf;
    private JTextField prodInStocktf;
    private JButton add;
    private JButton edit;
    private JButton delete;
    private JButton back;
    private  JComboBox box;
    private JPanel p;
    private CreateTable<Product> table;

    public ProductView()
    {
        this.setVisible(false);
        p=new JPanel();
        String[] selClient={"Alegeti produsul"};
        table=new CreateTable();
        nume=new JLabel("Nume");
        numetf=new JTextField(7);
        price=new JLabel("Price");
        pricetf=new JTextField(7);
        prodInStock=new JLabel("Numar produse in stock");
        prodInStocktf=new JTextField(7);
        box=new JComboBox(selClient);
        delete=new JButton("Delete");
        add=new JButton("Add");
        edit=new JButton("Edit");
        listaProduse=new JLabel("Clients list");
        back=new JButton("Back");
        p.setLayout(null);
        p.add(table);
        p.add(nume);
        p.add(numetf);
        p.add(price);
        p.add(pricetf);
        p.add(prodInStock);
        p.add(prodInStocktf);
        p.add(box);
        p.add(delete);
        p.add(add);
        p.add(edit);
        p.add(listaProduse);
        p.add(back);

        p.setPreferredSize (new Dimension (800, 500));
        p.setLayout (null);

        this.setTitle("Produs");
        //   p.setSize(800,500);
        p.setBackground(new Color(4,70,70));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(p);
        this.pack();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);


        nume.setBounds(10,25,50,25);
        numetf.setBounds(55,25,150,25);

        price.setBounds(10,60,50,25);
        pricetf.setBounds(55,60,150,25);

        prodInStock.setBounds(10,95,50,25);
        prodInStocktf.setBounds(55,95,150,25);

        box.setBounds(10,130,200,25);
        listaProduse.setBounds(10,170,100,25);

        add.setBounds(30,270,100,60);
        edit.setBounds(130,270,100,60);
        delete.setBounds(230,270,100,60);
        back.setBounds(500,400,100,60);
       // table.setBounds(0,150,400,200);
    }

    public JLabel getNume() {
        return nume;
    }

    public JLabel getPrice() {
        return price;
    }

    public JLabel getProdInStock() {
        return prodInStock;
    }

    public JLabel getListaProduse() {
        return listaProduse;
    }

    public JTextField getNumetf() {
        return numetf;
    }

    public JTextField getPricetf() {
        return pricetf;
    }

    public JTextField getProdInStocktf() {
        return prodInStocktf;
    }

    public JButton getAdd() {
        return add;
    }

    public JButton getEdit() {
        return edit;
    }

    public JButton getDelete() {
        return delete;
    }

    public JButton getBack() {
        return back;
    }

    public JComboBox getBox() {
        return box;
    }

    public JPanel getP() {
        return p;
    }

    public CreateTable<Product> getTable() {
        return table;
    }

    public void addListenerAddProduct(ActionListener e)
    {
        add.addActionListener(e);
        //setVisible(true);
    }

    public void addListenerEditProduct(ActionListener e)
    {
        edit.addActionListener(e);

    }

    public void addListenerDeleteProduct(ActionListener e)
    {
        delete.addActionListener(e);
    }
}
