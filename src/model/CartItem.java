package model;

public class CartItem {
private Product prod;
private int quantity;


public CartItem() {}
public CartItem (Product prod,int quantity) {
	this.prod=prod;
	this.quantity=quantity;
}

public Product getProd() {
	return prod;
}
public void setProd(Product prod) {
	this.prod = prod;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
