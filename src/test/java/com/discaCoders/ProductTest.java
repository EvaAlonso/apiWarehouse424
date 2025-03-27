package com.discaCoders;


import com.discaCoders.apiWarehouse424.Entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductTest {

    @Test
     void testIncreaseQuantity() {
    Product product = new Product(1, "Guantes", 20, 3);
    product.increaseQuantity(30);
    assertEquals(50, product.getQuantity(), "La cantidad deberia ser 50");
}
@Test
void testDecreaseQuantity() {
    Product product = new Product(2, "Mono de trabajo", 20, 599.99);
    product.decreaseQuantity(5);
    assertEquals(15, product.getQuantity(), "La cantidad debería ser 15 después de disminuir en 5.");
}

@Test
void testDecreaseQuantityNotEnoughStock() {
    Product product = new Product(3, "Zapatos de trabajo", 2, 299.99);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        product.decreaseQuantity(5);
    });
    assertEquals("No hay suficiente stock", exception.getMessage());
}

@Test
void testIncreaseQuantityNegativeAmount() {
    Product product = new Product(4, "Cascos aislantes de ruido", 10, 199.99);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        product.increaseQuantity(-5);
    });
    assertEquals("La cantidad debe ser positiva y mayor a cero", exception.getMessage());
}

}