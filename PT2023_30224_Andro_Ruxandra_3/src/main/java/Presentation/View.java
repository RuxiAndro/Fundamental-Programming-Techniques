package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JPanel p;
    private JFrame frame;
    private  JButton client;
    private JButton product;
    private JButton order;
    private JLabel clientl;
    private JLabel productl;
    private   JLabel orderl;
    private JLabel title;

    public View()
    {

        this.setSize(800,500);
        this.setTitle("Orders management");
        //this.setBackground(new Color(170,20,250));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p=new JPanel();
        p.setBounds(0, 0, 800, 500);
       // p.setBackground(new Color(170,20,250));
        p.setBackground(new Color(4,70,70));
        this.getContentPane().add(p);
        p.setLayout(null);
        this.add(p);
        this.setVisible(true);

        title=new JLabel("Orders management");
        title.setBounds(50, 10, 300, 100);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        p.add(title);

        client=new JButton("Clienti");
        client.setBounds(150, 200, 150, 150);
        client.setFont(new Font("Arial", Font.BOLD, 16));
        client.setBackground(new Color(200,100,0));
        p.add(client);

        product=new JButton("Produse");
        product.setBounds(350, 200, 150, 150);
        product.setFont(new Font("Arial", Font.BOLD, 16));
        product.setBackground(new Color(200,100,0));
        p.add(product);

        order=new JButton("Comenzi");
        order.setBounds(550, 200, 150, 150);
        order.setFont(new Font("Arial", Font.BOLD, 16));
        order.setBackground(new Color(200,100,0));
        p.add(order);
    }

    public JPanel getP() {
        return p;
    }

    public void setP(JPanel p) {
        this.p = p;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getClient() {
        return client;
    }

    public void setClient(JButton client) {
        this.client = client;
    }

    public JButton getProduct() {
        return product;
    }

    public void setProduct(JButton product) {
        this.product = product;
    }

    public JButton getOrder() {
        return order;
    }

    public void setOrder(JButton order) {
        this.order = order;
    }

    public JLabel getClientl() {
        return clientl;
    }

    public void setClientl(JLabel clientl) {
        this.clientl = clientl;
    }

    public JLabel getProductl() {
        return productl;
    }

    public void setProductl(JLabel productl) {
        this.productl = productl;
    }

    public JLabel getOrderl() {
        return orderl;
    }

    public void setOrderl(JLabel orderl) {
        this.orderl = orderl;
    }

    public void addListenerClient(ActionListener e)
    {
        client.addActionListener(e);
    }

}
