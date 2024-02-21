package Presentation;

import com.mysql.cj.xdevapi.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Vector;

public class CreateTable<T> extends JScrollPane {
    JTable table1;
    public CreateTable()
    {
        this.setVisible(true);
        this.setBounds(250,60,300,150);

    }

   /* public JTable createTable1(List<T> list)
    {
        if(list.size()==0)
            return null;
        Class type=list.get(0).getClass();
        Field[] fields= type.getDeclaredFields();
        String[] columnNames=new String[fields.length];
        String[][] data=new String[list.size()][fields.length];

        int j=0,i;
        for(Field field:fields)
        {
            field.setAccessible(true);
            columnNames[j++]=field.getName();
        }

        for(T list1:list)
        {
            i=0;
            for(Field field:fields)
            {
                try {
                    data[j][i] = field.get(list1).toString();
                }catch(IllegalAccessException e)
                {
                    e.printStackTrace();
                }
                i++;
            }
            j++;
        }

        JTable jTable=new JTable(data,columnNames);
        table1.setBounds(0,0,300,150);
        return table1;
    }*/

    JTable table;
    public JTable createTable(List<T> list) {
        //JTable table;
        Class<?> objectType = list.get(0).getClass();
        Field[] fields = objectType.getDeclaredFields();
        Vector columnNames = new Vector(fields.length);

        for (int i = 0; i < fields.length; i++) {
            columnNames.addElement(fields[i].getName());
        }
        Vector<Vector<Object>> data = new Vector<>();
        for (T object : list) {
            Vector<Object> rowData = new Vector(fields.length);
            for (int i = 0; i < fields.length; i++) {
                try {
                    fields[i].setAccessible(true);
                    rowData.addElement(fields[i].get(object));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            data.addElement(rowData);
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, renderer);
        return table;
    }

    public void updateT(List<T> list)
    {
        table=createTable(list);
        table.setVisible(true);
        this.setViewportView(table);
    }


}
