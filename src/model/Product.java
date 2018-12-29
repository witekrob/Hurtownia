package model;

public class Product {
private String name;
private String producer;
private int numerId;
private int price;
private int quantity;


public Product() {}
public Product(String name,String producer,int numerId,int price, int quantity) {
	this.setName(name);
	this.setProducer(producer);
	this.setNumerId(numerId);
	this.setPrice(price);
	this.setQuantity(quantity);
	
}


public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getNumerId() {
	return numerId;
}
public void setNumerId(int numerId) {
	this.numerId = numerId;
}
public String getProducer() {
	return producer;
}
public void setProducer(String producer) {
	this.producer = producer;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

@Override
public String toString() {
	return "Product [name=" + name + ", producer=" + producer + ", numerId=" + numerId + ", price=" + price + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + numerId;
	result = prime * result + price;
	result = prime * result + ((producer == null) ? 0 : producer.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Product other = (Product) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (numerId != other.numerId)
		return false;
	if (price != other.price)
		return false;
	if (producer == null) {
		if (other.producer != null)
			return false;
	} else if (!producer.equals(other.producer))
		return false;
	return true;
}
}