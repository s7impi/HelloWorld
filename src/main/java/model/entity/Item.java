package model.entity;

/**
 * @author asmolik
 */
public class Item {
    Product product;
    int quantity;

    public Item(Product product) {
        this.product = product;
        this.quantity = 1;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        ++quantity;
    }

    public void decrementQuantity() {
        if (quantity > 0)
            --quantity;
    }

    public int getTotal() {
        return product.getPrice() * quantity;
    }
}
