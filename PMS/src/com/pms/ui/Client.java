package com.pms.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

import com.pms.pojo.Products;
import com.pms.service.*;

public class Client {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		boolean flag = true;

		ProductServiceInterface product = new ProductService();

		while (flag) {
			System.out.println("***Welcome to database***");
			System.out.println("1. Insert record");
			System.out.println("2. Update record");
			System.out.println("3. Delete record");
			System.out.println("4. Select record");
			System.out.println("5. Select all records");
			System.out.println("6. Exit");
			System.out.println();
			System.out.print("Enter the value: ");

			int n = in.nextInt();

			switch (n) {
			case 1:
				Products obj = new Products();

				System.out.print("Enter product id: ");
				obj.setPid(in.nextInt());

				System.out.print("Enter product name: ");
				obj.setPname(in.next());
				
				System.out.print("Enter product price: ");
				obj.setPrice(in.nextDouble());

				System.out.print("Enter product dom: ");
				obj.setDom(Date.valueOf(in.next()));
				
				System.out.println();
				
				if(!ProductService.inputValidation(obj.getPid())) {
					System.err.println("The product with given pid already exists!");
					System.out.println();
					break;
				}

				int status = product.insertProduct(obj);

				if (status == 1) {
					System.out.println("Record inserted succesfully");
				} 
				else {
					System.out.println("Record not inserted");
				}
				System.out.println();

				break;

			case 2:
				Products obj2 = new Products();

				System.out.print("Enter product id: ");
				obj2.setPid(in.nextInt());

				System.out.print("Enter product name: ");
				obj2.setPname(in.next());
				
				System.out.print("Enter product price: ");
				obj2.setPrice(in.nextDouble());

				System.out.print("Enter product dom: ");
				obj2.setDom(Date.valueOf(in.next()));
				
				System.out.println();
				
				if(!ProductService.inputValidationModify(obj2.getPid())) {
					System.err.println("The product with given pid does not exist!");
					System.out.println();
					break;
				}

				int status2 = product.updateProduct(obj2);

				if (status2 == 1) {
					System.out.println("Record updated succesfully");
				} 
				else {
					System.out.println("Record not updated");
				}
				System.out.println();

				break;

			case 3:
				System.out.print("Enter product id: ");
				
				System.out.println();
			
				int status3 = product.deleteProduct(in.nextInt());
				
				if(status3==1) {
					System.out.println("Record deleted successfully");
				}
				else {
					System.out.println("Record does not exist!!");
				}
				System.out.println();

				break;

			case 4:
				System.out.print("Enter product id: ");
				
				System.out.println();
				
				int input = in.nextInt();

				if(!ProductService.inputValidationModify(input)) {
					System.err.println("The product with given pid does not exist!");
					System.out.println();
					break;
				}

				Products obj3 = product.selectProduct(input);

				System.out.println(obj3);
				System.out.println();

				break;
				
			case 5: 
				System.out.println();
				
				List<Products> list = product.selectAll();
				
				Iterator<Products> itr = list.iterator();
				
				while(itr.hasNext()) {
					System.out.println(itr.next());
				}
				
				System.out.println();
				
;				break;

			case 6:
				System.out.println("Thanks for using the database!");
				product.close();
				flag = false;

				break;

			default:
				System.out.println("Please enter valid input!!");

				break;
			}
		}

		in.close();
	}

}