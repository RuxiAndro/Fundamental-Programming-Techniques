package Model;

public class Order {
    private int id;
    private int idClient;
    private int idProdus;
    private int cantitate;

    public Order()
    {

    }

    public Order(int idClient,int idProdus,int cantitate)
    {
        this.idClient=idClient;
        this.idProdus=idProdus;
        this.cantitate=cantitate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}
