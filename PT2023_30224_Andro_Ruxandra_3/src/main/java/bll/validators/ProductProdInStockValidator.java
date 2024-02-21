package bll.validators;

import Model.Product;

public class ProductProdInStockValidator implements Validator<Product>{
    @Override
    public void validate(Product product) {
        if(product.getProdInStock()<0)
            throw new IllegalArgumentException("Nu mai sunt produse in stock");
    }
}
