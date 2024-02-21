/*package View;

import Model.Server;
import Model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JButton start;

    private JLabel nrClients;
    private JLabel nrServers;
    private JLabel maxArrTime;
    private JLabel minArrTime;
    private JLabel maxServiceTime;
    private JLabel minServiceTime;
    private JLabel simulationTime;


    private JTextField nrClientsField;
    private JTextField nrServersField;
    private JTextField maxArrTimeField;
    private JTextField minArrTimeField;
    private JTextField maxServiceTimeField;
    private JTextField minServiceTimeField;
    private JTextField simulationTimeField;
  //  private JTextArea output;

    JPanel p=new JPanel();

    public View()
    {
        this.setTitle("Queues management");
        this.setSize(850,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(p);
        p.setLayout(null);
        p.setBackground(new Color(150,200,20));

        nrClients=new JLabel("Nr of clients:");
        nrServers=new JLabel("Nr of servers:");
        minArrTime=new JLabel("Min arrival time:");
        maxArrTime=new JLabel("Max arrival time:");
        minServiceTime=new JLabel("Min service time:");
        maxServiceTime=new JLabel("Max service time:");


        nrClientsField=new JTextField(10);
        nrServersField=new JTextField(5);
        minArrTimeField=new JTextField(5);
        maxArrTimeField=new JTextField(5);
        minServiceTimeField=new JTextField(5);
        maxServiceTimeField=new JTextField(5);
        simulationTimeField=new JTextField(5);
       // output=new JTextArea(20,20);

        start=new JButton("START");

        p.add(nrClients);
        p.add(nrClientsField);
        p.add(nrServers);
        p.add(nrServersField);

        p.add(minArrTime);
        p.add(minArrTimeField);
        p.add(maxArrTime);
        p.add(maxArrTimeField);
        p.add(minServiceTime);
        p.add(minServiceTimeField);
        p.add(maxServiceTime);
        p.add(maxServiceTimeField);
        p.add(simulationTime);

        p.add(simulationTime);
        p.add(simulationTimeField);
        p.add(start);
      //  p.add(output);

        nrClients.setBounds(80,30,100,40);
        nrClients.setFont(new Font("Arial",Font.BOLD,12));
        nrClientsField.setBounds(250,30,150,30);

        nrServers.setBounds(80,70,100,40);
        nrServers.setFont(new Font("Arial",Font.BOLD,12));
        nrServersField.setBounds(250,70,150,30);

        minArrTime.setBounds(80,110,100,40);
        minArrTime.setFont(new Font("Arial",Font.BOLD,12));
        minArrTimeField.setBounds(250,110,150,30);

        maxArrTime.setBounds(80,150,100,40);
        maxArrTime.setFont(new Font("Arial",Font.BOLD,12));
        maxArrTimeField.setBounds(250,150,150,30);

        minServiceTime.setBounds(80,190,100,40);
        minServiceTime.setFont(new Font("Arial",Font.BOLD,12));
        minServiceTimeField.setBounds(250,190,150,30);

        maxServiceTime.setBounds(80,230,100,40);
        maxServiceTime.setFont(new Font("Arial",Font.BOLD,12));
        maxServiceTimeField.setBounds(250,230,150,30);

        simulationTime.setBounds(80,270,100,40);
        simulationTime.setFont(new Font("Arial",Font.BOLD,12));
        simulationTimeField.setBounds(250,270,150,30);

        start.setBounds(80,330,100,40);
        start.setFont(new Font("Arial",Font.BOLD,12));
        start.setForeground(Color.BLACK);
        start.setBackground(new Color(200,100,0));

      //  output.setBounds(100,380,600,200);



    }

    public JButton getStart() {
        return start;
    }

    public void setStart(JButton start) {
        this.start = start;
    }

    public JLabel getNrClients() {
        return nrClients;
    }

    public void setNrClients(JLabel nrClients) {
        this.nrClients = nrClients;
    }

    public JLabel getNrServers() {
        return nrServers;
    }

    public void setNrServers(JLabel nrServers) {
        this.nrServers = nrServers;
    }

    public JLabel getMaxArrTime() {
        return maxArrTime;
    }

    public void setMaxArrTime(JLabel maxArrTime) {
        this.maxArrTime = maxArrTime;
    }

    public JLabel getMinArrTime() {
        return minArrTime;
    }

    public void setMinArrTime(JLabel minArrTime) {
        this.minArrTime = minArrTime;
    }

    public JLabel getMaxServiceTime() {
        return maxServiceTime;
    }

    public void setMaxServiceTime(JLabel maxServiceTime) {
        this.maxServiceTime = maxServiceTime;
    }

    public JLabel getMinServiceTime() {
        return minServiceTime;
    }

    public void setMinServiceTime(JLabel minServiceTime) {
        this.minServiceTime = minServiceTime;
    }

    public JLabel getSimulationTime() {
        return simulationTime;
    }

    public void setSimulationTime(JLabel simulationTime) {
        this.simulationTime = simulationTime;
    }

    public JTextField getNrClienstField() {
        return nrClientsField;
    }

    public void setNrClienstField(JTextField nrClienstField) {
        this.nrClientsField = nrClienstField;
    }

    public JTextField getNrServersField() {
        return nrServersField;
    }

    public void setNrServersField(JTextField nrServersField) {
        this.nrServersField = nrServersField;
    }

    public JTextField getMaxArrTimeField() {
        return maxArrTimeField;
    }

    public void setMaxArrTimeField(JTextField maxArrTimeField) {
        this.maxArrTimeField = maxArrTimeField;
    }

    public JTextField getMinArrTimeField() {
        return minArrTimeField;
    }

    public void setMinArrTimeField(JTextField minArrTimeField) {
        this.minArrTimeField = minArrTimeField;
    }

    public JTextField getMaxServiceTimeField() {
        return maxServiceTimeField;
    }

    public void setMaxServiceTimeField(JTextField maxServiceTimeField) {
        this.maxServiceTimeField = maxServiceTimeField;
    }

    public JTextField getMinServiceTimeField() {
        return minServiceTimeField;
    }

    public void setMinServiceTimeField(JTextField minServiceTimeField) {
        this.minServiceTimeField = minServiceTimeField;
    }

    public JTextField getSimulationTimeField() {
        return simulationTimeField;
    }

    public void setSimulationTimeField(JTextField simulationTimeField) {
        this.simulationTimeField = simulationTimeField;
    }*/

   /* public JTextArea getOutput() {
        return output;
    }*/

  /*  public void setStartActionListener(ActionListener actionListener)
    {
        start.addActionListener(actionListener);
    }


}*/
