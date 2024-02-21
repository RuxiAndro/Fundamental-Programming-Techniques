import DataModels.Monom;
import DataModels.Polinom;
import OperatiiMatematice.Operatii;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationsTest {
    @Test

    public void addTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new Monom(3,5);
        Monom m2=new Monom(2,3);
        p1.adaugMonoamele(m1);
        p1.adaugMonoamele(m2);

        Polinom p2=new Polinom();
        Monom m3=new Monom(2,4);
        Monom m4=new Monom(0,1);
        p2.adaugMonoamele(m3);
        p2.adaugMonoamele(m4);

        Polinom rez=new Polinom();
        Monom m5=new Monom(3,5);
        Monom m6=new Monom(2,7);
        Monom m7=new Monom(0,1);
        rez.adaugMonoamele(m7);
        rez.adaugMonoamele(m6);
        rez.adaugMonoamele(m5);

       assertEquals(Operatii.addPolinom(p1,p2).toString(),rez.toString());
       // assertEquals(Operatii.addPolinom(p1,p2),rez);
        //assertNotSame(rez,Operatii.addPolinom(p1,p2));
    }

    @Test
    public void addGresitTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new Monom(3,5);
        Monom m2=new Monom(2,3);
        p1.adaugMonoamele(m1);
        p1.adaugMonoamele(m2);

        Polinom p2=new Polinom();
        Monom m3=new Monom(2,4);
        Monom m4=new Monom(0,1);
        p2.adaugMonoamele(m3);
        p2.adaugMonoamele(m4);

        Polinom rez=new Polinom();
        Monom m5=new Monom(3,5);
        Monom m6=new Monom(5,2);
        Monom m7=new Monom(0,1);
        rez.adaugMonoamele(m7);
        rez.adaugMonoamele(m6);
        rez.adaugMonoamele(m5);

        assertEquals(Operatii.addPolinom(p1,p2).toString(),rez.toString());
       // assertNotSame(rez,Operatii.addPolinom(p1,p2));
    }

    @Test
    public void subTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new Monom(3,5);
        Monom m2=new Monom(2,3);
        p1.adaugMonoamele(m1);
        p1.adaugMonoamele(m2);

        Polinom p2=new Polinom();
        Monom m3=new Monom(2,4);
        Monom m4=new Monom(0,1);
        p2.adaugMonoamele(m3);
        p2.adaugMonoamele(m4);

        Polinom rez=new Polinom();
        Monom m5=new Monom(3,5);
        Monom m6=new Monom(2,-1);
        Monom m7=new Monom(0,-1);
        rez.adaugMonoamele(m7);
        rez.adaugMonoamele(m6);
        rez.adaugMonoamele(m5);

        assertEquals(Operatii.subPolinom(p1,p2).toString(),rez.toString());
        //assertNotSame(rez,Operatii.subPolinom(p1,p2));
    }

    @Test
    public void subGresitTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new Monom(3,5);
        Monom m2=new Monom(2,3);
        p1.adaugMonoamele(m1);
        p1.adaugMonoamele(m2);

        Polinom p2=new Polinom();
        Monom m3=new Monom(2,4);
        Monom m4=new Monom(0,1);
        p2.adaugMonoamele(m3);
        p2.adaugMonoamele(m4);

        Polinom rez=new Polinom();
        Monom m5=new Monom(3,5);
        Monom m6=new Monom(2,100);
        Monom m7=new Monom(0,-1);
        rez.adaugMonoamele(m7);
        rez.adaugMonoamele(m6);
        rez.adaugMonoamele(m5);

        assertEquals(Operatii.subPolinom(p1,p2).toString(),rez.toString());
        //assertNotSame(rez,Operatii.subPolinom(p1,p2));
    }

    @Test
    public void mulTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new Monom(3,5);
        Monom m2=new Monom(2,3);
        p1.adaugMonoamele(m1);
        p1.adaugMonoamele(m2);

        Polinom p2=new Polinom();
        Monom m3=new Monom(2,4);
        Monom m4=new Monom(0,1);
        p2.adaugMonoamele(m3);
        p2.adaugMonoamele(m4);

        Polinom rez=new Polinom();
        Monom m5=new Monom(5,20);
        Monom m6=new Monom(4,12);
        Monom m7=new Monom(3,5);
        Monom m8=new Monom(2,3);
        rez.adaugMonoamele(m8);
        rez.adaugMonoamele(m7);
        rez.adaugMonoamele(m6);
        rez.adaugMonoamele(m5);

       assertEquals(Operatii.mulPolinom(p1,p2).toString(),rez.toString());
       // assertNotSame(rez,Operatii.mulPolinom(p1,p2));
    }

    @Test
    public void mulGresitTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new Monom(3,5);
        Monom m2=new Monom(2,3);
        p1.adaugMonoamele(m1);
        p1.adaugMonoamele(m2);

        Polinom p2=new Polinom();
        Monom m3=new Monom(2,4);
        Monom m4=new Monom(0,1);
        p2.adaugMonoamele(m3);
        p2.adaugMonoamele(m4);

        Polinom rez=new Polinom();
        Monom m5=new Monom(8,-19);
        Monom m6=new Monom(4,12);
        Monom m7=new Monom(3,5);
        Monom m8=new Monom(2,3);
        rez.adaugMonoamele(m8);
        rez.adaugMonoamele(m7);
        rez.adaugMonoamele(m6);
        rez.adaugMonoamele(m5);

        assertEquals(Operatii.mulPolinom(p1,p2).toString(),rez.toString());
        // assertNotSame(rez,Operatii.mulPolinom(p1,p2));
    }

    @Test
    public void derTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new Monom(3,5);
        Monom m2=new Monom(2,3);
        p1.adaugMonoamele(m1);
        p1.adaugMonoamele(m2);


        Polinom rez=new Polinom();
        Monom m5=new Monom(1,6);
        Monom m6=new Monom(2,15);
        rez.adaugMonoamele(m5);
        rez.adaugMonoamele(m6);

        assertEquals(Operatii.derPolinom(p1).toString(),rez.toString());
        //assertNotSame(rez,Operatii.derPolinom(p1));
    }

    @Test
    public void derGresitTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new Monom(3,5);
        Monom m2=new Monom(2,3);
        p1.adaugMonoamele(m1);
        p1.adaugMonoamele(m2);


        Polinom rez=new Polinom();
        Monom m5=new Monom(1,6);
        Monom m6=new Monom(2,80);
        rez.adaugMonoamele(m5);
        rez.adaugMonoamele(m6);

        assertEquals(Operatii.derPolinom(p1).toString(),rez.toString());
        //assertNotSame(rez,Operatii.derPolinom(p1));
    }

    @Test
    public void integrationTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new Monom(3,5);
        Monom m2=new Monom(2,3);
        p1.adaugMonoamele(m1);
        p1.adaugMonoamele(m2);


        Polinom rez=new Polinom();
        Monom m5=new Monom(3,1);
        Monom m6=new Monom(4,1.25);
        rez.adaugMonoamele(m5);
        rez.adaugMonoamele(m6);

        assertEquals(Operatii.integPolinom(p1).toString(),rez.toString());
        //assertNotSame(rez,Operatii.integPolinom(p1));
    }

    @Test
    public void integrationGresitTest()
    {
        Polinom p1=new Polinom();
        Monom m1=new Monom(3,5);
        Monom m2=new Monom(2,3);
        p1.adaugMonoamele(m1);
        p1.adaugMonoamele(m2);


        Polinom rez=new Polinom();
        Monom m5=new Monom(3,1);
        Monom m6=new Monom(4,1.50);
        rez.adaugMonoamele(m5);
        rez.adaugMonoamele(m6);

        assertEquals(Operatii.integPolinom(p1).toString(),rez.toString());
        //assertNotSame(rez,Operatii.integPolinom(p1));
    }


}
