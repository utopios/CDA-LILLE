package org.example;

public class Shop {
    public void update(Product product) throws QualityException {
        int q = 0;
        if(product.getQuality() <= 0 || product.getQuality() >= 50) {
            throw new QualityException();
        }
        if(product.getType().equals("laitier")) {
            if(product.getName().equals("brie vieilli")) {
                q = -1;
            }
            else {
                if(product.getSellIn() > 0) {
                    q = 2;
                }
                else {
                    q = (product.getQuality() >= 4) ? 4 : product.getQuality();
                }
            }
        }
        else {
            if(product.getSellIn() > 0) {
                q = 1;
            }else {
                q = (product.getQuality() >= 2) ? 2 : product.getQuality();
            }
        }
        product.setQuality(product.getQuality() - q);
        product.setSellIn(product.getSellIn() - 1);
    }
}
