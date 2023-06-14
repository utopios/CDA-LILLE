package org.example;

public class Shop {
    public void update(Product product) throws QualityException {
        if(product.getQuality() <= 0 || product.getQuality() >= 50) {
            throw new QualityException();
        }
        if(product.getType().equals("laitier")) {
            if(product.getName().equals("brie vieilli")) {
                product.setQuality(product.getQuality()+1);
            }
            else {
                if(product.getSellIn() > 0) {
                    product.setQuality(product.getQuality() - 2);
                }
                else {
                    product.setQuality(product.getQuality() - 4);
                }
            }
        }
        else {
            if(product.getSellIn() > 0) {
                product.setQuality(product.getQuality() -1);
            }else {
                product.setQuality(product.getQuality() - 2);
            }
        }

        product.setSellIn(product.getSellIn() - 1);
    }
}
