package bll;

import DataAccess.ProductDAO;
import Model.Client;
import bll.validators.ProductNameValidator;
import bll.validators.ProductPriceValidator;
import bll.validators.ProductProdInStockValidator;
import bll.validators.Validator;

import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBLL {
    private List<Validator<Product>> validators;
    private ProductDAO productDAO;
    public ProductBLL() {
        validators=new ArrayList<Validator<Product>>();
        validators.add(new ProductNameValidator());
        validators.add(new ProductPriceValidator());
        validators.add(new ProductProdInStockValidator());

        productDAO=new ProductDAO();
    }

    public Product findById(int id)
    {
        Product product=productDAO.findById(id);
        if(product==null)
            throw new IllegalArgumentException("Produsul cu id-ul %d "+id+" nu exista !");
        return product;
    }

    public void insert(Product product){
        for(Validator validator:validators){
            validator.validate(product);
        }
        productDAO.insert(product);
    }


  /* public int insertClient(Client client){
        for(Validator validator:validators){
            validator.validate(client);
        }
       return ClientDAO.insert1(client);
    }
*/

    public void update(Product product,int id){
        Product actualProd=productDAO.findById(id);
        if(actualProd==null)
            throw new IllegalArgumentException("Produsul nu exista!");
        for(Validator validator:validators){
            validator.validate(product);
        }
        productDAO.update(product,id);
    }

    public void delete(int id){
        productDAO.delete(id);
    }

    public List<Product> findAll(){
        return productDAO.findAll();
    }
}
