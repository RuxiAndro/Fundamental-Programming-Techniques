package DataModels;

import java.util.*;

public class Polinom {
    TreeMap<Integer,Double> polinom=new TreeMap<Integer,Double>();
    public Polinom()
    {
        this.polinom=new TreeMap<>();
    }

    public TreeMap<Integer, Double> getPolinom() {
        return polinom;
    }

    public void setPolinom(TreeMap<Integer, Double> polinom) {
        this.polinom = polinom;
    }

    public void adaugMonoamele(Monom m)
    {
        boolean ok=true;
        for (Map.Entry<Integer, Double> entry : polinom.entrySet())
            if(entry.getKey()==m.getGrad()) {
                m.setCoeficient(m.getCoeficient() + entry.getValue());
                ok = false;
            }
        if(ok=true)
            this.polinom.put(m.getGrad(),m.getCoeficient());
    }

    public void scadMonoamele(Monom m)
    {
        boolean ok=true;
        for (Map.Entry<Integer, Double> entry : polinom.entrySet())
            if(entry.getKey()==m.getGrad()) {
                m.setCoeficient(m.getCoeficient() - entry.getValue());
                ok = false;
            }
        if(ok=true)
            this.polinom.put(m.getGrad(),m.getCoeficient());
    }

    public void stergMonoamele(Monom m)
    {
        this.polinom.remove(m.getGrad());
    }


    //@Override
   /* public String toString() {
        return "Polinom{" +
                "monom =" + polinom +
                '}';
    }*/


    @Override
   public String toString()
    {
        String s="";
        for (Map.Entry<Integer, Double> entry : polinom.entrySet())
        {
            if(entry.getValue()>=0)
            //if(entry.getKey()>=0)
                //if(entry.getValue()==1)
                  s=s+"+"+entry.getValue()+"x^"+entry.getKey();
                else
                    s=s+entry.getValue()+"x^"+entry.getKey();
        }
        return s;
    }
}
