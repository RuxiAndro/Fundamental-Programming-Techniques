package Controller;

import DataModels.Model;
import DataModels.Monom;
import DataModels.Polinom;
import OperatiiMatematice.Operatii;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import javax.swing.text.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model,View view)
    {
        this.model=model;
        this.view=view;

        view.addListenerAdd(new AddPolinom());
        view.addListenerSub(new SubPolinom());
        view.addListenerMul(new MulPolinom());
        view.addListenerDer(new DerPolinom());
        view.addListenerInteg(new IntegPolinom());
    }

    public static Polinom transform(String s)
    {
        Pattern pattern=Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
        Matcher matcher=pattern.matcher(s);
        Polinom polinom=new Polinom();

        while(matcher.find())
        {
            Monom monom=new Monom();
            monom.setCoeficient((double) Integer.parseInt(matcher.group(1)));
            monom.setGrad((Integer.parseInt(matcher.group(2))));
            polinom.adaugMonoamele(monom);
        }
        return polinom;
    }

    public static boolean transform1(String s)
    {
        Pattern pattern=Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
        Matcher matcher=pattern.matcher(s);
        Polinom polinom=new Polinom();

        while(matcher.find())
        {
            Monom monom=new Monom();
            monom.setCoeficient((double) Integer.parseInt(matcher.group(1)));
            monom.setGrad((Integer.parseInt(matcher.group(2))));
            polinom.adaugMonoamele(monom);
        }
        return true;
    }

    private static String printf(String s) {
        return s;
    }

    class AddPolinom implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String s1 = "", s2 = "";
            boolean ok=false;
            s1 = view.getFirst().getText();
            s2 = view.getSecond().getText();
            if(transform1((s1)) && transform1(s2)) {
                ok = true;
                model.setRez(Operatii.addPolinom(transform(s1), transform(s2)));
                view.getResult().setText(model.getRez().toString());
            }
            if(ok==false)
               view.setResult("Wrong input!");
        }
    }

    class SubPolinom implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String s1 = "", s2 = "";
            try {
                s1 = view.getFirst().getText();
                s2 = view.getSecond().getText();
                model.setRez(Operatii.subPolinom(transform(s1), transform(s2)));
                view.getResult().setText(model.getRez().toString());
            } catch (NumberFormatException e1) {
                view.setResult("Wrong input!");
            }
        }
    }

    class MulPolinom implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String s1 = "", s2 = "";
                s1 = view.getFirst().getText();
                s2 = view.getSecond().getText();
                model.setRez(Operatii.mulPolinom(transform(s1), transform(s2)));
                view.getResult().setText(model.getRez().toString());
        }
    }

    class DerPolinom implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String s1 = "", s2 = "";
                s1 = view.getFirst().getText();
                s2 = view.getSecond().getText();
                model.setRez(Operatii.derPolinom(transform(s1)));
                view.getResult().setText(model.getRez().toString());
        }
    }

    class IntegPolinom implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String s1 = "", s2 = "";
                s1 = view.getFirst().getText();
                s2 = view.getSecond().getText();
                model.setRez(Operatii.integPolinom(transform(s1)));
                view.getResult().setText(model.getRez().toString());
        }
    }

}
