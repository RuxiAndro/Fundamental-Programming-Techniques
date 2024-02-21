package BusinessLogic;

import Model.Server;
import Model.Task;
//import View.View;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Collections;

public class SimulationManager implements Runnable{ //contine bucla de simulare si cheama Scheduler pt a imparti clientii
    public static int timeLimit=100;
    public int maxProcessingTime=10;
    public int minProcessingTime=2;
    public int numberOfServers;
    public int numberOfClients;
    public int minArrivalTime=2;
    public int maxArrivalTime=10;
    public static int clientsInQueue=0;
   // public double avgServiceTime=0.0;
    public double avgWaitingTime=0.0;

    private Scheduler scheduler;
    private ArrayList<Task> generatedTasks=new ArrayList();
    public FileWriter writer;
   // private View view;

   public SimulationManager(int numberOfClients,int numberOfServers,int timpMax,int minArrivalTime,int maxArrivalTime,int minProcessingTime,int maxProcessingTime)//,View view)
   {
      // this.view=view;
       //view.setVisible(true);
       this.numberOfClients=numberOfClients;
       this.numberOfServers=numberOfServers;
       this.scheduler=new Scheduler(this.numberOfServers,this.numberOfClients);
       this.timeLimit=timpMax;
       this.minArrivalTime=minArrivalTime;
       this.maxArrivalTime=maxArrivalTime;
       this.minProcessingTime=minProcessingTime;
       this.maxProcessingTime=maxProcessingTime;
       this.generateRandomTasks(this.numberOfClients);
        for(int i=0;i<numberOfClients;i++)
            System.out.println(generatedTasks.get(i).toString());

   }

    private void generateRandomTasks(int cnt)
    {
        Random ran=new Random();
        for(int i=0;i<cnt;i++)
        {
            int sosire=ran.nextInt(this.maxArrivalTime-minArrivalTime+1)+minArrivalTime;
            int servire=ran.nextInt(this.maxProcessingTime-this.minProcessingTime+1)+minProcessingTime;
            Task task=new Task(i+1,sosire,servire);
            generatedTasks.add(task);
        }
        Collections.sort(generatedTasks,Comparator.comparing(Task::getArrivalTime));
    }

    public void run() {
        try {
            this.writer = new FileWriter("test3.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      /*  try{
            writer.write("Time:");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        int currentTime = 0;

        float avgServiceTime=0.0F;

        Task t;
        Iterator i3;
        for(i3=this.generatedTasks.iterator();i3.hasNext();avgServiceTime=avgServiceTime+t.getServiceTime()) {
            t = (Task) i3.next();
        }
        avgServiceTime=avgServiceTime/(float)numberOfClients;
        System.out.println("Avarage service time: "+avgServiceTime);

        ArrayList<Task> deleteTask = new ArrayList();
        int maxClientsInQueue=0,peakHour=0;

        while (currentTime < timeLimit) {
            Iterator i;
            Task task;
            Iterator i2;
            i2 = this.generatedTasks.iterator();
            while (i2.hasNext()) {
                task = (Task) i2.next();
                if (task.getArrivalTime() <= currentTime) {
                    scheduler.dispatchTask(task);
                    deleteTask.add(task);
                }
            }
            this.generatedTasks.removeAll(deleteTask);


            if(clientsInQueue>maxClientsInQueue)
            {
                maxClientsInQueue=clientsInQueue;
                peakHour=currentTime;
            }

           /* try{
                writer.write("Time:" + currentTime + "\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/

            //afisare in fisier


           try {
                Thread.sleep(1000);
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            float waitingTime=0.0F;
            Iterator i4;
            Server server;

            for(i4=this.scheduler.getServers().iterator(); i4.hasNext();waitingTime += (float)server.getT())
            {
                server=(Server)i4.next();
            }
            waitingTime /= (float)this.numberOfClients;
            //  System.out.println(waitingTime);

            try {
                writer.write("Timp " + currentTime + "\n Clientii care stau la coada: ");
                //    writer.write("BUNA");

                /*    for (i = generatedTasks.iterator(); i.hasNext(); ) {
                    task = (Task) i.next();
                    this.writer.write("" + task + " ");
                }*/
                for(int j=0;j<generatedTasks.size();j++)
                    this.writer.write(generatedTasks.get(j).toString());
                this.writer.write("\n");


                Iterator i1;
                int cnt = 1;
              /*  i1 = this.scheduler.getServers().iterator();
                while (i1.hasNext()) {
                    server = (Server) i1.next();
                    this.writer.write("Coada " + cnt + ": " + server + "\n");
                    ++cnt;
                }*/

              /*  for(i1=this.scheduler.getServers().iterator(); i1.hasNext(); this.writer.write("Coada " + cnt + ": " + server + "\n"),++cnt)
                {
                    server=(Server)i1.next();
                }*/
                for(int j=0;j<scheduler.getServers().size();j++) {
                    this.writer.write("Coada "+cnt+": ");
                    this.writer.write(scheduler.getServers().get(j).toString());
                    ++cnt;
                    this.writer.write("\n");
                }
                this.writer.write("\n");

            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }

            //afisare in consola
            System.out.println(currentTime);
            for(int j=0;j<generatedTasks.size();j++)
                System.out.println(generatedTasks.get(j).toString());
            System.out.println();
            for(int j=0;j<scheduler.getServers().size();j++)
                System.out.println(scheduler.getServers().get(j).toString());

            ++currentTime;

            avgWaitingTime=waitingTime;
         //  System.out.println("Peak hour: "+ peakHour);

        }

        System.out.println("Peak hour: "+ peakHour);
        try{
            writer.write("Avarage waiting time: "+ avgWaitingTime+"\n");
            writer.write("Avarage service time: "+ avgServiceTime+"\n");
           writer.write("Peak hour: "+ peakHour);
        }catch (IOException e6){
            e6.printStackTrace();
        }

        try{
            this.writer.close();
        }catch (IOException e5){
            e5.printStackTrace();
        }

    }

    public static void main(String[] args) {
       /* SimulationManager gen = new SimulationManager(6, 2, 15, 2, 10, 2, 7);//,new View());
        Thread t = new Thread(gen);
        t.start();*/

    /*  SimulationManager gen1=new SimulationManager(4,2,60,2,30,2,4);//,new View());
        Thread t1=new Thread(gen1);
        t1.start();*/

    /*  SimulationManager gen1=new SimulationManager(50,5,60,2,40,1,7);//,new View());
        Thread t1=new Thread(gen1);
        t1.start();*/

      SimulationManager gen1 = new SimulationManager(1000, 20, 200, 10, 100, 3, 9);//,new View());
        Thread t1 = new Thread(gen1);
        t1.start();

    }
}
