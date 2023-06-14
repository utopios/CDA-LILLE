package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTest {
    private Shop shop;
    private Product product;

    @BeforeEach
    void setUp() {
        shop = new Shop();
    }

    @Test
    void testUpdateShouldDecreaseQuality() {
        //Arrange
        product = Product.builder().quality(10).sellIn(10).name("p1").type("c1").build();
        //Act
        shop.update(product);

        Assertions.assertEquals(9, product.getQuality());
    }

    @Test
    void testUpdateShouldDecreaseSellIn() {
        //Arrange
        product = Product.builder().quality(10).sellIn(10).name("p1").type("c1").build();
        //Act
        shop.update(product);

        Assertions.assertEquals(9, product.getSellIn());
    }

    @Test
    void testUpdateShouldDecreaseQualityTwiceWhenSellInIs0() {
        //Arrange
        product = Product.builder().quality(10).sellIn(0).name("p1").type("c1").build();
        //Act
        shop.update(product);

        Assertions.assertEquals(8, product.getQuality());
    }

    @Test
    void testUpdateShouldRaiseQualityExceptionWhenQualityIsNegative() {
        //Arrange
        product = Product.builder().quality(-10).sellIn(0).name("p1").type("c1").build();
        //Act
        Assertions.assertThrowsExactly(QualityException.class, ()-> {
            shop.update(product);
        });
    }

    @Test
    void testUpdateShouldRaiseQualityExceptionWhenQualityIsMoreThan50() {
        //Arrange
        product = Product.builder().quality(50).sellIn(0).name("p1").type("c1").build();
        //Act
        Assertions.assertThrowsExactly(QualityException.class, ()-> {
            shop.update(product);
        });
    }

    @Test
    void testUpdateShouldIncreaseQualityWhewProductIsBrie() {
        //Arrange
        product = Product.builder().quality(10).sellIn(10).name("brie vieilli").type("laitier").build();
        //Act
        shop.update(product);

        Assertions.assertEquals(11, product.getQuality());
    }

    @Test
    void testUpdateShouldDecreaseQualityTwiceWhenProductTypeIsLaitier() {
        //Arrange
        product = Product.builder().quality(10).sellIn(0).name("p1").type("laitier").build();
        //Act
        shop.update(product);

        Assertions.assertEquals(8, product.getQuality());
    }
}
