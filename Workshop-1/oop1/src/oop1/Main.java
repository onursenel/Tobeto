package oop1;

public class Main {

	public static void main(String[] args) {
		String mesaj = "vade oranı";

		// Product newleme
		Product product1 = new Product();
		// SET VALUE
//		product1.name = "Delonghi  Kahve Makinesi";
//		product1.unitPrice = 7500;
//		product1.discount = 7;
//		product1.unitInStock = 3;
//		product1.imageUrl = "xxx.jpg";
		
		
		product1.setName("Delonghi kahve makinesi");
		product1.setUnitPrice(7500);
		product1.setDiscount(7);
		product1.setUnitInStock(3);
		product1.setImageUrl("xxx.jpg");;

		// GET VALUE
//		System.out.println(product1.name);

		Product product2 = new Product();
		
//		product2.name = "smeg  Kahve Makinesi";
//		product2.unitPrice = 8500;
//		product2.discount = 8;
//		product2.unitInStock = 4;
//		product2.imageUrl = "yyy.jpg";
		
		product2.setName("smeg kahve makinesi");
		product2.setUnitPrice(8500);
		product2.setDiscount(8);
		product2.setUnitInStock(4);
		product2.setImageUrl("yyy.jpg");

		Product product3 = new Product();
//		product3.name = "kitchen  Kahve Makinesi";
//		product3.unitPrice = 9500;
//		product3.discount = 9;
//		product3.unitInStock = 2;
//		product3.imageUrl = "zzz.jpg";
		
		product3.setName("kitchen kahve makinesi");
		product3.setUnitPrice(9500);
		product3.setDiscount(9);
		product3.setUnitInStock(2);
		product3.setImageUrl("zzz.jpg");
		
		
		Product[] products =  {product1,product2,product3};
		
		System.out.println("<ul>");
		
		for (Product product : products) {
			System.out.println("<li>" + product.getName()+ "</li>");
			
		}
		
		System.out.println("<ul>");
		
		
		IndividualCustomer individualCustomer = new IndividualCustomer();
		individualCustomer.setId(1212121);
		individualCustomer.setPhone("051217218261");
		individualCustomer.setCustomeNumber("111111");
		individualCustomer.setFirstName("Onur");
		individualCustomer.setLastName("Şenel");
		
		
		CorporateCustomer corporateCustomer = new CorporateCustomer();
		corporateCustomer.setId(1);
		corporateCustomer.setCompanyName("TOBETO");
		corporateCustomer.setPhone("053232321");
		corporateCustomer.setTaxNumber("2222222");
		corporateCustomer.setCustomeNumber("54321");
		
		Customer[] customer = {individualCustomer , corporateCustomer };
		
		

	}

}
