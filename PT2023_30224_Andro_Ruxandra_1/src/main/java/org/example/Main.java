package org.example;

import Controller.Controller;
import DataModels.Model;
import DataModels.Monom;
import DataModels.Polinom;
import View.View;

import static OperatiiMatematice.Operatii.*;

public class  Main {
    public static void main(String[] args) {
        Polinom p1=new Polinom();
        Monom m1=new Monom(3,5);
        Monom m2=new Monom(2,3);
        Monom m3=new Monom(1,1);
        Monom m4=new Monom(0,1);
        System.out.println(m1.toString());
        p1.adaugMonoamele(m1);
        p1.adaugMonoamele(m2);
        p1.adaugMonoamele(m3);
        p1.adaugMonoamele(m4);

        Polinom p2=new Polinom();
        Monom m5=new Monom(3,4);
        Monom m6=new Monom(1,2);
        Monom m7=new Monom(0,3);
        p2.adaugMonoamele(m5);
        p2.adaugMonoamele(m6);
        p2.adaugMonoamele(m7);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println("\n");

        System.out.println(addPolinom(p1,p2).toString());
        System.out.println(subPolinom(p1,p2).toString());
        System.out.println(mulPolinom(p1,p2).toString());
        System.out.println(derPolinom(p1).toString());
        System.out.println(integPolinom(p1).toString());

        View view=new View();
        Model model=new Model();
        Controller controller=new Controller(model,view);

        view.setVisible(true);
    }


}
//5x^3-4x^2+3x^1-2x^0
//-6x^3+5x^2+3x^1+5x^0

//2x^4+2x^3+1x^1
//6x^5+1x^3+2x^2+1x^1

//-2x^2+3x^7
//4x^2+12x^6