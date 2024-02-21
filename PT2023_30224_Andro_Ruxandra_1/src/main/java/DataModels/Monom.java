package DataModels;

public class Monom {
    private double coeficient;
    private int grad;

    public Monom(int p,double c) {
        this.coeficient = c;
        this.grad = p;
    }

    public Monom() {
        this.coeficient = 0.0;
        this.grad = 0;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public Monom addMonom(Monom m)
    {
        if(this.grad==m.getGrad())
        {
            Monom rez=new Monom(grad,this.coeficient+m.getCoeficient());
            return rez;
        }
        return null;
    }

    public Monom subMonom(Monom m)
    {
        if(this.grad==m.getGrad())
        {
            Monom rez=new Monom(grad,this.coeficient-m.getCoeficient());
            return rez;
        }
        else
        if(this.grad==0)
        {
            Monom rez=new Monom(grad,-m.getCoeficient());
            return rez;
        }
        return null;
    }

    public Monom mulMonom(Monom m)
    {
        return new Monom(this.grad+m.getGrad(),this.coeficient*m.getCoeficient());
    }

    public Monom divMonom(Monom m)
    {
        return new Monom(this.grad-m.getGrad(),this.coeficient/m.getCoeficient());
    }

    public Monom derivareMonom(Monom m)
    {
        if(grad>=1)
            return new Monom(this.grad-1,this.grad*this.coeficient);
        else
            return null;
    }

    public Monom integrareMonom(Monom m)
    {
        return new Monom(grad+1,this.coeficient/(this.grad+1));
    }

   // @Override
  //  public String toString() {
        /*return "Monom{" +
                "coeficient=" + coeficient +
                ", grad=" + grad +
                '}';*/
        //return coeficient+ "x^" +grad;
   // }
}
