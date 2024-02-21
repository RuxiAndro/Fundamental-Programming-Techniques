package BusinessLogic;

import Model.Server;
import Model.Task;

import java.util.Iterator;
import java.util.List;

public class ConcreteStrategyTime implements Strategy{
    public ConcreteStrategyTime()
    {

    }

    public void addTask(List<Server> servers, Task t)
    {
        int timpMin=Integer.MAX_VALUE;
        Server a=null;
        Iterator i= servers.iterator();
        while(i.hasNext())
        {
            Server server=(Server) i.next();
            if(server.getWaitingPeriod().get()<timpMin)
            {
                timpMin=server.getWaitingPeriod().get();
                a=server;
            }
        }
        a.addTask(t);
    }
}
