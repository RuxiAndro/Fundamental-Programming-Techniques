package bll;

import DataAccess.OrderDAO;
import Model.Client;
import Model.Order;
import Model.Product;

public class OrderBLL {
    private OrderDAO orderDAO;
    private ClientBLL clientBLL;
    private ProductBLL productBLL;

    public OrderBLL() {
        orderDAO=new OrderDAO();
        productBLL=new ProductBLL();
        clientBLL=new ClientBLL();
    }

    /**
     * verifica clientul si produsul
     * @param c
     * @param p
     * daca nu e @param cantitate cat trebuie arunca exceptie
     */

   public void insert(Client c,Product p,int cantitate){
        if(cantitate<0)
            throw new IllegalArgumentException("Ati introdus o cantitate invalida! ");
        if(c.getId()==0|| c==null || p.getId()==0 ||p==null)
            throw new IllegalArgumentException("Selectati un client si un produs!");
        if(cantitate>p.getProdInStock())
            throw new IllegalArgumentException("Nu avem cantitatea dorita!");
        orderDAO.insert(new Order(c.getId(),p.getId(),cantitate));
        p.setProdInStock(p.getProdInStock()-cantitate);
        productBLL.update(p,p.getId());
    }
}
