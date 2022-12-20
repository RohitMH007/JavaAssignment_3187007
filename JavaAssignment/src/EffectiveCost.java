import java.util.ArrayList;
import java.util.Scanner;

public class EffectiveCost {
	String itemName = null;
	float price = 0.0f;
	int quantity = 0;
	boolean raw = false;
	boolean made = false;
	float tax = 0.0f;

	void salestax() {
		float totalTax = 0.0f;
		if (raw)
			totalTax = 0.155f;
		if (made)
			totalTax = 0.205f;
		tax = totalTax * price * quantity;
	}

	public String toString() {
		float s = (quantity * price) + tax;
		System.out.println("QUANTITY " + "  " + "ITEM-NAME" + "  " + "       TOTAL");
		return quantity + "             " + itemName + "           at " + s + " (including Tax)";
	}

	public static class TotalCalculation {
		public static void main(String[] args) throws Exception {
			TotalCalculation C = new TotalCalculation();
			Scanner sc = new Scanner(System.in);
			ArrayList list = new ArrayList();
			int no = 1;
			while (true) {
				EffectiveCost T = new EffectiveCost();
				System.out.println("Add Product: " + no);
				System.out.println("Enter quantity: ");
				int qty = sc.nextInt();
				T.quantity = qty;
				System.out.print(" Enter itemName: ");
				String itemName = sc.next();
				T.itemName = itemName;
				System.out.print(" Enter price: ");
				float p = sc.nextFloat();
				T.price = p;
				System.out.print(" Is it Raw[y/n]: ");
				String r = sc.next();
				if (r.toLowerCase().equals("y"))
					T.raw = true;
				System.out.print(" It made[y/n]: ");
				String m = sc.next();
				if (m.toLowerCase().equals("y"))
					T.made = true;
				T.salestax();
				list.add(T);
				no++;
				System.out.print("Do you want to add another details [y/n]: ");
				String add = sc.next();
				System.out.println("\n");
				if (add.toLowerCase().equals("n"))
					break;
			}
			float totalPrice = 0.0f;
			float totalTax = 0.0f;
			float finalPrice = 0.0f;
			for (int i = 0; i < list.size(); i++) {
				EffectiveCost tax = (EffectiveCost) list.get(i);
				totalPrice += tax.price * tax.quantity;
				totalTax += tax.tax;
				System.out.println(tax);
				finalPrice = totalPrice + totalTax;
			}
			System.out.println("\n");
			// total tax
			System.out.println("Salestax :" + totalTax);
			// final price
			System.out.println("total:" + finalPrice);
		}
	}
}
