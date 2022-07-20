package Shop.shopsProducts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestProduct {
    @Test
    public void testProduct() {
        Product newProduct = new Product(1, "Rick", 12);
        String[] expected = {"1", "Rick", "12"};
        String[] actual = {String.valueOf(newProduct.getId()), newProduct.getName(), String.valueOf(newProduct.getPrice())};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testBook() {
        Book newBook = new Book(5, "Witcher", 50, "A. Sapkovskiy");
        String[] expected = {"5", "Witcher", "50", "A. Sapkovskiy"};
        String[] actual = {String.valueOf(newBook.getBooksId()), newBook.getBooksName(), String.valueOf(newBook.getBooksPrice()), newBook.getBooksAuthor()};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSmart() {
        Smartphone newSmartphone = new Smartphone(6, "Galuksy", 100, "Samsang");
        String[] expected = {"6", "Galuksy", "100", "Samsang"};
        String[] actual = {String.valueOf(newSmartphone.getSmartphonesId()), newSmartphone.getSmartphonesName(), String.valueOf(newSmartphone.getSmartphonesPrice()), newSmartphone.getSmartphonesCreator()};
        Assertions.assertArrayEquals(expected, actual);
    }
}
