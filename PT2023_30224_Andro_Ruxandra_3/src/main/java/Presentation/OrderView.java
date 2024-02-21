package Presentation;

import Model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OrderView extends JFrame {

    private JLabel listaClienti1;
    private JLabel listaProduse;
    private JLabel cantitate;
    private JTextField cantitatetf;

    private JButton order;
    private JButton back;
    private  JComboBox boxp;
    private  JComboBox boxc;

    private Controller controller;

  //  private CreateTable<Client> table;

    public OrderView(Controller c)
    {
        this.setVisible(false);
        JPanel p;
        p=new JPanel();
        String[] selClient={"Alegeti clientul"};

        listaClienti1=new JLabel("Lista clienti");
        listaProduse=new JLabel("Lista produse");

        this.controller = c;
        boxc=new JComboBox(selClient);

        cantitate=new JLabel("Cantitate");
        cantitatetf=new JTextField(7);

        back=new JButton("Back");
        order=new JButton("Comanda");

        p.setPreferredSize (new Dimension (800, 500));
        p.setLayout (null);

        p.add(boxc);
        p.add(getBoxp());
        p.add(back);
        p.add(cantitate);
        p.add(cantitatetf);
        p.add(order);
        p.add(listaProduse);
        p.add(listaClienti1);

        this.setTitle("Order");
        p.setBackground(new Color(4,70,70));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(p);
        this.pack();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);


        listaProduse.setBounds(50,25,100,25);

        listaClienti1.setBounds(50,125,100,25);
        boxc.setBounds(10,130,500,25);

        cantitatetf.setBounds(350,25,100,25);
       // cantitate.setBounds(320,200,100,25);

        back.setBounds(500,400,100,60);
        order.setBounds(300,400,100,60);
    }

    public JLabel getListaClienti1() {
        return listaClienti1;
    }

    public void setListaClienti1(JLabel listaClienti1) {
        this.listaClienti1 = listaClienti1;
    }

    public JLabel getListaProduse() {
        return listaProduse;
    }

    public void setListaProduse(JLabel listaProduse) {
        this.listaProduse = listaProduse;
    }

    public JLabel getCantitate() {
        return cantitate;
    }

    public void setCantitate(JLabel cantitate) {
        this.cantitate = cantitate;
    }

    public JTextField getCantitatetf() {
        return cantitatetf;
    }

    public void setCantitatetf(JTextField cantitatetf) {
        this.cantitatetf = cantitatetf;
    }

    public JButton getOrder() {
        return order;
    }

    public void setOrder(JButton order) {
        this.order = order;
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public JComboBox getBoxp() {
        if(boxp == null) {
            String[] selProd={"Alegeti produsul"};
            boxp = new JComboBox(selProd);
            boxp.setBounds(10,70,500,25);

            boxp.addActionListener(e -> {
                controller.ProductsFileds();
            });
        }
        return boxp;
    }

    public JComboBox getBoxc() {
        return boxc;
    }

    public void setBoxc(JComboBox boxc) {
        this.boxc = boxc;
    }

    public void addListenerOrder(ActionListener e)
    {
        order.addActionListener(e);

    }


}
