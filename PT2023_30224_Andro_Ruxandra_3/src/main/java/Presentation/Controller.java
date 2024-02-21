package Presentation;

import DataAccess.ClientDAO;
import DataAccess.OrderDAO;
import DataAccess.ProductDAO;
import Model.Client;
import Model.Order;
import Model.Product;
import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.List;

public class Controller {
    View view;
    ClientView clientView;
    ProductView productView;
    OrderView orderView;

    ClientDAO clientDAO = new ClientDAO();
    ClientBLL clientBLL = new ClientBLL();
    OrderDAO orderDAO = new OrderDAO();
    OrderBLL orderBLL = new OrderBLL();

    ProductDAO productDAO = new ProductDAO();
    ProductBLL productBLL = new ProductBLL();

    public Controller() {
        view = new View();
        clientView = new ClientView();
        productView = new ProductView();
        orderView = new OrderView(this);


        view.getClient().addActionListener(e -> {
            updateClientsFields();
            ClientsFileds();
            clientView.setVisible(true);
        });

        clientView.getBox().addActionListener(e -> {
            ClientsFileds();
        });

        clientView.getBack().addActionListener(e -> {
            clientView.setVisible(false);
        });

        view.getProduct().addActionListener(e -> {
            productView.setVisible(true);
            updateProductsFields();
            ProductsFileds();

        });

        productView.getBack().addActionListener(e -> {
            productView.setVisible(false);
        });

        productView.getBox().addActionListener(e -> {
            ProductsFileds();
        });


        view.getOrder().addActionListener(e -> {
            updateProductsFields();
            updateClientsFields();
            orderView.setVisible(true);
        });

        orderView.getBack().addActionListener(e -> {
            updateProductsFields();
            updateClientsFields();
            orderView.setVisible(false);
        });


        clientView.addListenerAdd(new AddClient());
        clientView.addListenerEdit(new EditClient());
        clientView.addListenerDelete(new DeleteClient());

        productView.addListenerAddProduct(new AddProduct());
        productView.addListenerEditProduct(new EditProduct());
        productView.addListenerDeleteProduct(new DeleteProduct());

        orderView.addListenerOrder(new OrderProduct());

     /*   orderView.getOrder().addActionListener(e -> {
            Client client;
            Product product;
            int quantity;
            try {
                client = (Client) orderView.getBoxc().getSelectedItem();
                product = (Product) orderView.getBoxp().getSelectedItem();
                quantity = Integer.parseInt(orderView.getCantitate().getText());
            } catch (Exception exception) {
                errorMessage("Invalid number format!");
                return;
            }

            try {
                orderBLL.insert(client, product, quantity);
            } catch (Exception exception) {
                errorMessage(exception.getMessage());
                return;
            }
            updateProductsFields();
            updateClientsFields();
            success("Order placed");
        });*/

    }

    class AddClient implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Client client;
            try {
                String nume = "", email = "";
                Integer age = 0;
                nume = clientView.getNumetf().getText();
                email = clientView.getEmailtf().getText();
                age = Integer.parseInt(clientView.getAgetf().getText());
                client = new Client(nume, email, age);
            } catch (Exception exception) {
                errorMessage("Invalid number format!");
                return;
            }

            try {
                clientBLL.insert(client);
            } catch (Exception exception) {
                errorMessage("Nu a putut fi inserat");
            }
            updateClientsFields();
        }
    }

    class EditClient implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Client c;
            Client ca = (Client) clientView.getBox().getSelectedItem();
            int id = ca.getId();
            if (id == 0)
                errorMessage("Selectati un client!");
            try {
                c = new Client(clientView.getNumetf().getText(), clientView.getEmailtf().getText(), Integer.parseInt(clientView.getAgetf().getText()));
            } catch (Exception exception) {
                errorMessage("Invalid number format!");
                return;
            }
            try {
                clientBLL.update(c, id);
            } catch (Exception exception) {
                errorMessage(exception.getMessage());
                return;
            }
            success("Client editat");
            updateClientsFields();
        }
    }

    class DeleteClient implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Client client = (Client) clientView.getBox().getSelectedItem();
            if (client.getId() == 0) {
                errorMessage("Selectati clientul dorit!");
            }
            try {
                clientBLL.delete(client.getId());
            } catch (Exception exception) {
                errorMessage(exception.getMessage());
            }
            success("Client sters!");
            updateClientsFields();


        }
    }

    class AddProduct implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String nume = "";
            Integer price = 0, prodInStock = 0;
            nume = productView.getNumetf().getText();
            price = Integer.parseInt(productView.getPricetf().getText());
            prodInStock = Integer.parseInt(productView.getProdInStocktf().getText());
            Product product = new Product(nume, price, prodInStock);
            try {
                productBLL.insert(product);
            } catch (Exception exception) {
                errorMessage(exception.getMessage());
            }
            updateProductsFields();
        }
    }

    class EditProduct implements ActionListener {

        public void actionPerformed(ActionEvent e) {

                Product p;
                Product pa = (Product) productView.getBox().getSelectedItem();
                int id = pa.getId();
                if (id == 0)
                    errorMessage("Selectati un produs!");
                try {
                    p = new Product(productView.getNumetf().getText(), Integer.parseInt(productView.getPricetf().getText()),Integer.parseInt(productView.getProdInStocktf().getText()));
                } catch (Exception exception) {
                    errorMessage("Invalid number format!");
                    return;
                }
                try {
                    productBLL.update(p, id);
                } catch (Exception exception) {
                    errorMessage(exception.getMessage());
                    return;
                }
                success("Produs editat");
                updateProductsFields();
        }
    }

    class DeleteProduct implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Product product = (Product) productView.getBox().getSelectedItem();
            if (product.getId() == 0) {
                errorMessage("Selectati produsul dorit!");
            }
            try {
                productBLL.delete(product.getId());
            } catch (Exception exception) {
                errorMessage(exception.getMessage());
            }
            success("Produs sters!");
            updateProductsFields();
        }
    }

    class OrderProduct implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            Client client;
            Product product;
            int quantity;
            try {
                client = (Client) orderView.getBoxc().getSelectedItem();
                product = (Product) orderView.getBoxp().getSelectedItem();
                quantity = Integer.parseInt(orderView.getCantitatetf().getText());
            } catch (Exception exception) {
                errorMessage("Invalid number format!");
                return;
            }

            try {
                orderBLL.insert(client, product, quantity);
            } catch (Exception exception) {
                errorMessage(exception.getMessage());
                return;
            }
            updateProductsFields();
            updateClientsFields();
            success("Comanda finalizata");

            try {
                List<Order> orders=orderDAO.findAll();
                int id=orders.get(orders.size()-1).getId();
                FileWriter file=new FileWriter("order"+id+".txt");
                file.write("Client: "+client.getNume()+"\nProdus: "+product.getName()+"\nCantitate: "+quantity+"\nPret: "+product.getPrice()*quantity+" RON");
                file.close();

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void ClientsFileds() {
        Client c = (Client) clientView.getBox().getSelectedItem();
        if (c.getId() == 0) {
            clientView.getAgetf().setText("");
            clientView.getNumetf().setText("");
            clientView.getEmailtf().setText("");
        } else {
            clientView.getAgetf().setText("" + c.getAge());
            clientView.getNumetf().setText(c.getNume());
            clientView.getEmailtf().setText(c.getEmail());
        }
    }

    private void updateClientsFields() {
        List<Client> clients = clientDAO.findAll();
        // clientView.getTable().createTable(clients);//mi lista goala????
        clientView.getTable().updateT(clients);
        clients.add(0, new Client("Alegeti clientul", "", 0));
        clientView.getBox().setModel(new DefaultComboBoxModel(clients.toArray()));
        orderView.getBoxc().setModel(new DefaultComboBoxModel(clients.toArray()));
        // clientView.revalidate();
        //  clientView.repaint();

    }

    public void ProductsFileds() {
        Product p = (Product) productView.getBox().getSelectedItem();
        if (p.getId() == 0) {
            productView.getPricetf().setText("");
            productView.getNumetf().setText("");
            productView.getProdInStocktf().setText("");
        } else {
            productView.getPricetf().setText("" + p.getPrice());
            productView.getNumetf().setText(p.getName());
            productView.getProdInStocktf().setText("" + p.getProdInStock());
        }
    }

  /*  public void ProductsFiledsOrder() {
        Order o = (Order) orderView.getBoxp().getSelectedItem();
        if (o.getId() == 0) {
            orderView.get().setText("");
            productView.getNumetf().setText("");
            productView.getProdInStocktf().setText("");
        } else {
            productView.getPricetf().setText("" + p.getPrice());
            productView.getNumetf().setText(p.getName());
            productView.getProdInStocktf().setText("" + p.getProdInStock());
        }
    }*/

    private void updateProductsFields() {
        List<Product> products = productDAO.findAll();
         productView.getTable().updateT(products);
        products.add(0, new Product("Alegeti produsul", 0, 0));
        productView.getBox().setModel(new DefaultComboBoxModel(products.toArray()));
        orderView.getBoxp().setModel(new DefaultComboBoxModel(products.toArray()));
    }

    public void errorMessage(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void success(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message+" !", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

}



