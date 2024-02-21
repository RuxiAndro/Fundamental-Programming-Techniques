package Model;

import BusinessLogic.Scheduler;
import BusinessLogic.SimulationManager;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Iterator;

public class Server implements Runnable{
    private BlockingQueue<Task> clienti;
    private AtomicInteger waitingPeriod;
    private int t=0;

    public Server(int maxTasksPerServer)
    {
        this.clienti=new ArrayBlockingQueue<>(Scheduler.maxTasksPerServer);
        this.waitingPeriod=new AtomicInteger(0);
    }

    public void addTask(Task newTask)
    {
        ++SimulationManager.clientsInQueue;
        this.clienti.add(newTask);
        this.waitingPeriod.addAndGet(newTask.getServiceTime());
    }

    public BlockingQueue<Task> getClienti() {
        return clienti;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }


    public int getT() {
        return t;
    }


    public void run()
    {
        int timpCurent=0;

        while(true)
        {
            try{
                if(clienti.peek()==null)
                {
                    Thread.sleep(1000);
                }
                else
              //  if(clienti.peek()!=null)
                {
                    t=t+waitingPeriod.get();
                    int timpServire=((Task)clienti.peek()).getServiceTime();
                    for(int i=0;i<timpServire;++i)
                    {
                        Thread.sleep(1000);
                        waitingPeriod.decrementAndGet();
                        ((Task) clienti.peek()).setServiceTime(((Task)clienti.peek()).getServiceTime()-1);
                        if(((Task)clienti.peek()).getServiceTime()==0)
                            clienti.remove(((Task)clienti.peek()));
                    }
                        --SimulationManager.clientsInQueue;
                }
            }catch (InterruptedException e) //Exception
            {
                e.printStackTrace();
            }
        }
    }

    public String toString()
    {
        if(clienti.size()==0)
            return "Casa inchisa!";
        else
        {
            String s="";
            Task t;
         /*   for(Iterator i= clienti.iterator();i.hasNext();s = s + t + " ")
            {
                t=(Task)i.next();
            }*/
            Iterator i= clienti.iterator();
            while(i.hasNext())
            {
                t=(Task)i.next();
                s = s + t + " ";
            }
            return s;
        }
    }


}
