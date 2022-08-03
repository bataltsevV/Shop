package Shop.repository;

import Shop.shopsProducts.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public Product[] getProducts() {
        return products;
    }

    public void save(Product newProduct) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = newProduct;
        products = tmp;
    }

    public void deleteById(int id) {
        Product[] tmp = new Product[products.length];
        int copyIndex = 0;
        for(Product product: products) {
            if (id != product.getId()) {
                tmp[copyIndex] = product;
                copyIndex = copyIndex + 1;
            }
        }
        products = new Product[copyIndex];
        for(int i=0; i < copyIndex; i++) {
            products[i] = tmp[i];
        }
    }
}
