package ru.netology.repository.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
public class ProductRepositoryTest {
    Product book1 = new Book( 1, "Три мушкетера", 300, "Дюма");
    Product phone1 = new Smartphone(2, "3210", 5000, "Nokia" );
    Product phone2 = new Smartphone(3, "3310", 7500, "Nokia");
    Product phone3 = new Smartphone (4, "x10", 33400, "Nokia");
    Product book2 = new Book(5, "Двадцать лет спустя", 450, "Дюма");
    Product book3 = new Book(6, "Десять лет спустя", 740, "Дюма");

    @Test
    public void firstTest() {
        ProductRepository repo = new ProductRepository();
        repo.add(book1);
        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone3);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(2);
        repo.findAll();

        Product[] actual = repo.findAll();
        Product[] expected = { book1, phone2, phone3, book2, book3 };
        Assertions.assertArrayEquals(expected, actual);
    }
}
