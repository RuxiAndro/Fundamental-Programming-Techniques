package Model;

public class Task {
    private int id;
    private int arrivalTime;
    private int serviceTime;

    public Task(int id,int arrivalTime,int serviceTime)
    {
        this.id=id;
        this.arrivalTime=arrivalTime; //timp sosire
        this.serviceTime=serviceTime; //timp servire
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    synchronized public int  getServiceTime() {
        return serviceTime;
    }

    synchronized public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", arrivalTime=" + arrivalTime +
                ", serviceTime=" + serviceTime +
                '}';
    }
}
