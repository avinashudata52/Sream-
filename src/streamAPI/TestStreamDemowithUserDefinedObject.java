package streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class Product
{
	private int productId;
	private String productName;
	private double price;
	private String category;

	public Product(int productId, String productName, double price, String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.category = category;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public double getPrice() {
		return price;
	}
	public String getCategory() {
		return category;
	}
	@Override
	public String toString() {
		return "Prouct [productId=" + productId + ", productName=" + productName + ", price=" + price + ", category="
				+ category + "]";
	}
	
	
}

public class TestStreamDemowithUserDefinedObject {
	
	public static void main(String args[])
	{
		// First I will save 5 objects into a list
		List<Product> listOfProducts = new ArrayList();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Product do you want save");
		int nop = sc.nextInt();
		for(int i=0; i<nop; i++)
		{
			System.out.println("Enter the product Id");
			int productId = sc.nextInt();
			
			System.out.println("Enter the product name");
			String productName = sc.next();
			
			System.out.println("Enter the product price");
			double price = sc.nextDouble();
			
			System.out.println("Enter the product categeory");
			String categeory = sc.next();
			
			
			//I am constructinh object of product by calling parameterized constructor
			Product pObj = new Product(productId,productName,price,categeory);
			
			//adding produsct object into list for every iteration of 
			listOfProducts.add(pObj);
		}
			System.out.println(listOfProducts);
		
	
		// We will get all the objects from list using stream API
		listOfProducts.stream().forEach(p->System.out.println(p));
		
		
		//without Stream API.....
		System.out.println("enter the product id to search");
		int searchId = sc.nextInt();
		for(Product p:listOfProducts)
		{
			if(p.getProductId()==searchId)
			{
				System.out.println(p);
				break;
			}
		}
		
		//with stream API
		listOfProducts.stream().filter(p->p.getProductId()==searchId)
		.forEach(p->System.out.println(p));
//		// we will fetch single product object based on productId;
		// we can search list product using prodcutName
//		
		System.out.println("Enter product name to search");
		String pname = sc.next();
		List<Product> list= new ArrayList();
		/*for(int i=0; i<listOfProducts.size(); i++)
		{
			Product p = listOfProducts.get(i);
			String name = p.getProductName();
			if(name.equals(pname));
			{
				list.add(p);	
			}
		}
		System.out.println(list);*/
		
		List<Product> newList = listOfProducts.
		stream().
		filter(p->p.getProductName().
		equalsIgnoreCase(pname))
		.collect(Collectors.toList());
		
		System.out.println(newList);
		
//		// we can sort our products objects based low price to high price and high price to low price.
//		// creating object of Comparator
//		Comparator<Product> cmp1=(p1,p2)->p1.getPrice()->p2.getPrice()?1:-1;
		
//		listOfProducts.stream().
//		sorted((p1,p2)->p1.getPrice()-> p2.getPrice()?1:-1)
//		.forEach(p->System.out.println(p));
//		
		// we can fetch product whose price is high.
		// we can calculate total cost of product
		// we can fetch all distinct product object.
		
		Set<String> ProductName = listOfProducts.stream()
		.map(p->p.getProductName())
		.collect(Collectors.toSet());
		
		ProductName.forEach(n->System.out.println(n));
		// we can update product name,price,categeory based on productId.
		
		//with Stream API
		System.out.println("Enter id to update");
		int ProdId = sc.nextInt();
		
		System.out.println("Enter the name of the product to update");
		int pn = sc.nextInt();
		
		System.out.println("Enter the price to update");
		int pprice = sc.nextInt();
		
		System.out.println("Enter the categeory to update");
		String categeory = sc.next();
		
		for(int i=0; i<listOfProducts.size(); i++)
		{
//		int i;
		Product p = listOfProducts.get(i);
		int id=p.getProductId();
		if(id==ProdId)
		{
			p.setPrice(pprice);
			p.setCategory(categeory);
			p.setProductId(pn);
			listOfProducts.set(i,p);
		}
	}
			System.out.println(listOfProducts);
	
			listOfProducts.stream().filter(p->p.getProductId()==prodId)
			.peek(p->{ p.setCategory(categeory);
			p.setPrice(pprice);
			p.setProductName(pname);
			}
			forEach(p->System.out.println(p));

			
			// remove method
			System.out.println("Enter id to remove");
			int delId = sc.nextInt();
			listOfProducts.removeIf(p->p.getProductId()==delId);
			//boolean removeif(Predicte p) --- Collection<Interface>
			System.out.println(listOfProducts);
	}
}
