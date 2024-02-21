package OperatiiMatematice;

import DataModels.Monom;
import DataModels.Polinom;

import java.util.*;

public class Operatii {
    public static Polinom addPolinom(Polinom p1,Polinom p2)
    {
        Polinom rez=new Polinom();
        for (Map.Entry<Integer, Double> entry : p1.getPolinom().entrySet())
        {
            Monom m=new Monom(entry.getKey(), entry.getValue());
            rez.adaugMonoamele(m);
        }
        for (Map.Entry<Integer, Double> entry1 : p2.getPolinom().entrySet())
        {
            Monom m=new Monom(entry1.getKey(), entry1.getValue());
            rez.adaugMonoamele(m);
        }
        return rez;
    }

    public static Polinom subPolinom(Polinom p1,Polinom p2)
    {
        Polinom rez=new Polinom();
        for (Map.Entry<Integer, Double> entry : p1.getPolinom().entrySet())
        {
            Monom m=new Monom(entry.getKey(), entry.getValue());
            rez.scadMonoamele(m);
        }
        for (Map.Entry<Integer, Double> entry1 : p2.getPolinom().entrySet())
        {
            Monom m=new Monom(entry1.getKey(), -1.0*entry1.getValue());
            rez.adaugMonoamele(m);
        }
        return rez;
    }
    public static Polinom mulPolinom(Polinom p1,Polinom p2)
    {
        Polinom rez = new Polinom();
        for (Map.Entry<Integer, Double> entry : p1.getPolinom().entrySet())
            for (Map.Entry<Integer, Double> entry1 : p2.getPolinom().entrySet()) {
                Monom m=new Monom(entry.getKey()+ entry1.getKey(), entry.getValue()* entry1.getValue());
                rez.adaugMonoamele(m);
            }
        return rez;
    }

    public static Polinom derPolinom(Polinom p1)
    {
        Polinom rez = new Polinom();
        for (Map.Entry<Integer, Double> entry : p1.getPolinom().entrySet())
        {
            if(entry.getKey()==0)
            {
                Monom m=new Monom(0, 0);
                rez.adaugMonoamele(m);
            }
            else
            if(entry.getKey()==1)
            {
                Monom m=new Monom(0, entry.getValue());
                rez.adaugMonoamele(m);
            }
            else {
                Monom m = new Monom(entry.getKey() - 1, entry.getValue() * entry.getKey());
                rez.adaugMonoamele(m);
            }
        }
        return rez;
    }

    public static Polinom integPolinom(Polinom p1)
    {
        Polinom rez = new Polinom();
        for (Map.Entry<Integer, Double> entry : p1.getPolinom().entrySet())
        {
            if(entry.getKey()==0) {
                Monom m = new Monom(1, entry.getValue());
                rez.adaugMonoamele(m);
            }
            else {
                Monom m = new Monom(entry.getKey()+1,entry.getValue()/(entry.getKey()+1));
                rez.adaugMonoamele(m);
            }
        }
        return rez;
    }

}
