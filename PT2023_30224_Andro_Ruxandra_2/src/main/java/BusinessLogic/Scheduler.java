package BusinessLogic;

import Model.Server;
import Model.Task;

import java.util.ArrayList;

public class Scheduler { //trimite clientii la cozi dupa timpul de asteptare in coada

    private ArrayList<Server> servers; //lista de cozi
    private int maxNoServers; //nr maxim de cozi
    public static int maxTasksPerServer; //nr maxim clienti in cozi
    private Strategy strategy=new ConcreteStrategyTime();

    public Scheduler(int maxNoServers,int maxTasksPerServer) //nr maxim cozi si oameni in cozi
    {
        this.maxNoServers=maxNoServers;
        this.servers=new ArrayList();
        this.maxTasksPerServer=maxTasksPerServer;///////
        for(int i=0;i<maxNoServers;++i)
        {//fac o noua coada
            Server server=new Server(maxTasksPerServer);
            servers.add(server);//in lista de cozi adaug coada nou creata
            Thread thread=new Thread(server);//creez thread pt noua coada
            thread.start(); //ii dau drumul la executie
        }
    }

    public void dispatchTask(Task t)
    {
        this.strategy.addTask(servers,t);
    }

    public ArrayList<Server> getServers() {
        return servers;
    }
}
