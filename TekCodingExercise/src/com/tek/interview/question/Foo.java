package com.tek.interview.question;
/*************************************************
 * Client Task: LabCorp Coding Exercise through TekSystems
 * Program: To remove bugs and display the expected output and refactor the code implementing OOPs Concepts.
 * Author Name : Vamshi Krishna
*****************************************************/
/*
 * This Code executes and displays the expected Output
 * 
 * 
*******Order 1*******
1 book: 13.74
1 music CD: 16.49
1 chocolate bar: 0.94
Sales Tax: 2.84
Total: 28.33
*******Order 2*******
1 imported box of chocolate: 11.5
1 imported bottle of perfume: 54.62
Sales Tax: 8.62
Total: 57.5
*******Order 3*******
1 Imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 10.73
1 box of imported chocolates: 12.94
Sales Tax: 8.77
Total: 67.98
Sum of orders: 153.81

 * 
 * */
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.tek.interview.question.impl.Item;
import com.tek.interview.question.impl.Order;
import com.tek.interview.question.impl.OrderLine;
import com.tek.interview.question.util.Calculator;

public class Foo {

	public static void main(String[] args) throws Exception {
		// For displaying correct Order Used LinkedHashMap 
		LinkedHashMap<String, Order> o = new LinkedHashMap<String, Order>();

		Order c = new Order();

		double grandTotal = 0;

		c.add(new OrderLine(new Item("book", (float) 12.49), 1));
		c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		c.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 1", c);

		// Reuse cart for an other order
		//fix c.clear();
		c = new Order();
		
		c.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		c.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		o.put("Order 2", c);

		// Reuse cart for an other order
		// c.clear();
		c = new Order();
		c.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
		c.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		c.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		c.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));// Corrected Imported Spelling

		o.put("Order 3", c);

		new Calculator().calculate(o);

	}
}
