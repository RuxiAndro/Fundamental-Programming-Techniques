package DataModels;

public class Model {
    private Polinom p1,p2,rez;
    public Model()
    {
        p1=new Polinom();
        p2=new Polinom();
        rez=new Polinom();
    }

    public Polinom getP1() {
        return p1;
    }

    public void setP1(Polinom p1) {
        this.p1 = p1;
    }

    public Polinom getP2() {
        return p2;
    }

    public void setP2(Polinom p2) {
        this.p2 = p2;
    }

    public Polinom getRez() {
        return rez;
    }

    public void setRez(Polinom rez) {
        this.rez = rez;
    }

}
