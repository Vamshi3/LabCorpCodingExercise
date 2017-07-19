package com.tek.interview.question.util;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import com.tek.interview.question.impl.Order;
import com.tek.interview.question.impl.OrderLine;

public class Calculator {

	public static double rounding(double value) {		
/*Implementing Rounding mode to round towards the "nearest neighbor" behaves as for HALF_DOWN if it's even*/
		BigDecimal val = new BigDecimal(value);
		val=	 val.setScale(2, RoundingMode.HALF_DOWN);
	return val.doubleValue();
	}

	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public void calculate(Map<String, Order> o) {

		double grandtotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			//grandtotal = 0;

			Order r = entry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			for (int i = 0; i < r.size(); i++) {

				// Calculate the taxes
				double tax = 0;

				OrderLine orderLine = r.get(i);
				if (orderLine.getItem().getDescription().toLowerCase().contains("imported")) {
					tax = rounding(orderLine.getItem().getPrice() * 0.15); // Extra 5% tax on
					// imported items
				} else {
					tax = rounding(orderLine.getItem().getPrice() * 0.10);
				}

				// Calculate the total price
				double totalprice = orderLine.getItem().getPrice() + tax;//Math.floor(tax);

				// Print out the item's total price
				System.out.println(orderLine.getQuantity() +" "+ orderLine.getItem().getDescription() + ": " + rounding(totalprice));

				// Keep a running total
				totalTax += tax;
				total += orderLine.getItem().getPrice();
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + rounding(totalTax));

			//total = total + totalTax;

			// Print out the total amount
			System.out.println("Total: " + rounding(total));
			grandtotal += total;
		}

		System.out.println("Sum of orders: " + rounding(grandtotal ));
	}
}