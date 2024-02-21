package bll.validators;

import Model.Product;

public class ProductNameValidator implements Validator<Product>{
    @Override
    public void validate(Product product) {
        if(product.getName().length()==0)
            throw new IllegalArgumentException("Introduceti un nume!");
    }
}
