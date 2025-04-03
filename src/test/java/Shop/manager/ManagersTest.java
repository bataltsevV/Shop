package Shop.manager;

import Shop.negativeExceptions.DuplicateException;
import Shop.negativeExceptions.NotFoundException;
import Shop.shopsProducts.Product;
import Shop.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagersTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product product1 = new Product(1, "Rick", 12);
    Product product2 = new Product(2, "Batman", 45);
    Product product3 = new Product(3, "Titans", 15);

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
    }

    @Test
    public void testAddNotUniqueId() {
        Assertions.assertThrows(DuplicateException.class, () -> {
            manager.add(product2);
        });
    }

    @Test
    public void testGetProduct() {
        Product[] expected = {product1, product2, product3};
        Product[] actual = manager.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    //ДЗ - Исключительные ситуации и их обработка:
    @Test
    public void testDeleteProduct() {
        manager.deleteById(2);
        Product[] expected = {product1, product3};
        Product[] actual = manager.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotIdForDeleteProduct() {
        Assertions.assertThrows(NotFoundException.class, () -> {
                    manager.deleteById(10);
                });
    }

    @Test
    public void testSearchByName() {
        Product[] expected = {product1};
        Product[] actual = manager.searchByName("Rick");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSetSearchByName() {
        Product product4 = new Product(6, "Rock and Morty", 34);
        manager.add(product4);
        Product[] expected = {product1, product4};
        Product[] actual = manager.searchByName("Rick");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchById() {
        Product expected = product1;
        Product actual = manager.searchById(1);
        Assertions.assertEquals(expected, actual);
    }
}
