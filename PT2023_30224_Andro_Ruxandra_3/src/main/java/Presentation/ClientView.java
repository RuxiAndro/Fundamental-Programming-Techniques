package Presentation;

import Model.Client;
import com.mysql.cj.xdevapi.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientView extends JFrame {
    private JLabel nume;
    private JLabel email;
    private JLabel age;
    private JLabel listaClienti;
    private JTextField numetf;
    private JTextField emailtf;
    private JTextField agetf;
    private JButton add;
    private JButton edit;
    private JButton delete;
    private JButton back;
    private  JComboBox box;
    private JPanel p;
    private CreateTable<Client> table;

    public ClientView()
    {
        this.setVisible(false);
        p=new JPanel();
        String[] selClient={"Alegeti clientul"};
        table=new CreateTable();
        nume=new JLabel("Nume");
        numetf=new JTextField(7);
        email=new JLabel("Email");
        emailtf=new JTextField(7);
        age=new JLabel("Age");
        agetf=new JTextField(7);
        box=new JComboBox(selClient);
        delete=new JButton("Delete");
        add=new JButton("Add");
        edit=new JButton("Edit");
        listaClienti=new JLabel("Clients list");
        back=new JButton("Back");
        p.setLayout(null);
        p.add(table);
        p.add(nume);
        p.add(numetf);
        p.add(email);
        p.add(emailtf);
        p.add(age);
        p.add(agetf);
        p.add(box);
        p.add(delete);
        p.add(add);
        p.add(edit);
        p.add(listaClienti);
        p.add(back);

        p.setPreferredSize (new Dimension (800, 500));
        p.setLayout (null);

        this.setTitle("Client");
     //   p.setSize(800,500);
        p.setBackground(new Color(4,70,70));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(p);
        this.pack();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);


        nume.setBounds(10,25,50,25);
        numetf.setBounds(55,25,150,25);

        email.setBounds(10,60,50,25);
        emailtf.setBounds(55,60,150,25);

        age.setBounds(10,95,50,25);
        agetf.setBounds(55,95,150,25);

        box.setBounds(10,130,200,25);
        listaClienti.setBounds(10,170,100,25);

        add.setBounds(30,270,100,60);
        edit.setBounds(130,270,100,60);
        delete.setBounds(230,270,100,60);
        back.setBounds(500,400,100,60);
    }

    public JLabel getNume() {
        return nume;
    }

    public void setNume(JLabel nume) {
        this.nume = nume;
    }

    public JLabel getEmail() {
        return email;
    }

    public void setEmail(JLabel email) {
        this.email = email;
    }

    public JLabel getAge() {
        return age;
    }

    public void setAge(JLabel age) {
        this.age = age;
    }

    public JTextField getNumetf() {
        return numetf;
    }

    public void setNumetf(JTextField numetf) {
        this.numetf = numetf;
    }

    public JTextField getEmailtf() {
        return emailtf;
    }

    public void setEmailtf(JTextField emailtf) {
        this.emailtf = emailtf;
    }

    public JTextField getAgetf() {
        return agetf;
    }

    public void setAgetf(JTextField agetf) {
        this.agetf = agetf;
    }

    public JButton getAdd() {
        return add;
    }

    public void setAdd(JButton add) {
        this.add = add;
    }

    public JButton getEdit() {
        return edit;
    }

    public void setEdit(JButton edit) {
        this.edit = edit;
    }

    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    public JComboBox getBox() {
        return box;
    }

    public void setBox(JComboBox box) {
        this.box = box;
    }

    public JPanel getP() {
        return p;
    }

    public void setP(JPanel p) {
        this.p = p;
    }

    public CreateTable<Client> getTable() {
        return table;
    }

    public void setTable(CreateTable<Client> table) {
        this.table = table;
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public void addListenerAdd(ActionListener e)
    {
        add.addActionListener(e);
        //setVisible(true);
    }

    public void addListenerEdit(ActionListener e)
    {
        edit.addActionListener(e);

    }

    public void addListenerDelete(ActionListener e)
    {
        delete.addActionListener(e);

    }


}
