package View;

import DataModels.Model;
import DataModels.Polinom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame{
    Model model;

    private static Polinom p1,p2;

    private JButton Addition;
    private JButton Substraction;
    private JButton Multiplication;
    private JButton Division;
    private JButton Derive;
    private JButton Integration;
    private JButton Clear;

    private JLabel firstLabel;
    private JLabel secondLabel;
    private JLabel resultLabel;

    private JTextField first;
    private JTextField second;
    private JTextField result;

    JPanel p=new JPanel();

    public View()
    {
        this.setTitle("Polynomial Calculator");
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(p);
        p.setLayout(null);
        p.setBackground(new Color(150,200,20));

        Addition=new JButton("+");
        Substraction=new JButton("-");
        Multiplication=new JButton("*");
        Division=new JButton("/");
        Derive=new JButton("D");
        Integration=new JButton("I");

        firstLabel=new JLabel("First Polinomial:");
        secondLabel=new JLabel("Second Polinomial:");
        resultLabel=new JLabel("Result:");

        first=new JTextField(5);
        second=new JTextField(5);
        result=new JTextField(5);

        Clear=new JButton("CLEAR");

        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                first.setText("");
                second.setText("");
                result.setText("");
            }
        });

        Addition.setBounds(300,100,70,30);
        Addition.setForeground(Color.BLACK);
        Addition.setFont(new Font("Arial",Font.BOLD,25));
        Addition.setBackground(new Color(200,100,0));

        Substraction.setBounds(400,100,70,30);
        Substraction.setForeground(Color.BLACK);
        Substraction.setFont(new Font("Arial",Font.BOLD,25));
        Substraction.setBackground(new Color(200,100,0));

        Multiplication.setBounds(300,150,70,30);
        Multiplication.setForeground(Color.BLACK);
        Multiplication.setFont(new Font("Arial",Font.BOLD,25));
        Multiplication.setBackground(new Color(200,100,0));

        Division.setBounds(400,150,70,30);
        Division.setForeground(Color.BLACK);
        Division.setFont(new Font("Arial",Font.BOLD,25));
        Division.setBackground(new Color(200,100,0));

        Derive.setBounds(300,200,70,30);
        Derive.setForeground(Color.BLACK);
        Derive.setFont(new Font("Arial",Font.BOLD,25));
        Derive.setBackground(new Color(200,100,0));

        Integration.setBounds(400,200,70,30);
        Integration.setForeground(Color.BLACK);
        Integration.setFont(new Font("Arial",Font.BOLD,25));
        Integration.setBackground(new Color(200,100,0));

        firstLabel.setBounds(30,50,150,30);
        firstLabel.setForeground(Color.BLACK);
        firstLabel.setFont(new Font("Arial",Font.BOLD,15));

        secondLabel.setBounds(30,150,150,30);
        secondLabel.setForeground(Color.BLACK);
        secondLabel.setFont(new Font("Arial",Font.BOLD,15));

        resultLabel.setBounds(30,250,150,30);
        resultLabel.setForeground(Color.BLACK);
        resultLabel.setFont(new Font("Arial",Font.BOLD,15));

        Clear.setBounds(300,250,175,30);
        Clear.setForeground(Color.BLACK);
        Clear.setFont(new Font("Arial",Font.BOLD,25));
        Clear.setBackground(new Color(200,100,0));

        first.setBounds(20,100,250,30);
        second.setBounds(20,200,250,30);
        result.setBounds(20,300,250,30);



        p.add(Addition);
        p.add(Substraction);
        p.add(Multiplication);
        p.add(Division);
        p.add(Derive);
        p.add(Integration);
        p.add(Clear);

        p.add(firstLabel);
        p.add(secondLabel);
        p.add(resultLabel);

        p.add(first);
        p.add(second);
        p.add(result);
    }

    public JTextField getFirst() {
        return first;
    }

    public void setFirst(JTextField first) {
        this.first = first;
    }

    public JTextField getSecond() {
        return second;
    }

    public void setSecond(JTextField second) {
        this.second = second;
    }

    public JTextField getResult() {
        return result;
    }

    public JTextField setResult(String rez) {
        result.setText(rez);
        return result;
    }

    public void addListenerAdd(ActionListener e)
    {
        Addition.addActionListener(e);
    }

    public void addListenerSub(ActionListener e)
    {
        Substraction.addActionListener(e);
    }

    public void addListenerMul(ActionListener e)
    {
        Multiplication.addActionListener(e);
    }

    public void addListenerDer(ActionListener e)
    {
        Derive.addActionListener(e);
    }

    public void addListenerInteg(ActionListener e)
    {
        Integration.addActionListener(e);
    }
}
