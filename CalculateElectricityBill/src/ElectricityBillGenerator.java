import java.util.Scanner;

public class ElectricityBillGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of units consumed: ");
        int unitsConsumed = sc.nextInt();
        double billAmount = calculateBill(unitsConsumed);
        System.out.println("Electricity Bill Amount:" + billAmount);
    }

    public static double calculateBill(int unitsConsumed) {
        double billAmount = 0;
        if (unitsConsumed <= 100) {
            billAmount = unitsConsumed * 2;
        } else if (unitsConsumed <= 150) {
            billAmount = 100 * 2 + (unitsConsumed - 100) * 3;
        } else if (unitsConsumed <= 200) {
            billAmount = 100 * 2 + 50 * 3 + (unitsConsumed - 150) * 4;
        } else if (unitsConsumed <= 250) {
            billAmount = 100 * 2 + 50 * 3 + 50 * 4 + (unitsConsumed - 200) * 5;
        } else if (unitsConsumed <= 300) {
            billAmount = 100 * 2 + 50 * 3 + 50 * 4 + 50 * 5 + (unitsConsumed - 250) * 6;
        } else if (unitsConsumed <= 500) {
            billAmount = 100 * 2 + 50 * 3 + 50 * 4 + 50 * 5 + 50 * 6 + (unitsConsumed - 300) * 7;
        } else {
            billAmount = 100 * 2 + 50 * 3 + 50 * 4 + 50 * 5 + 50 * 6 + 200 * 7 + (unitsConsumed - 500) * 8;
        }
        return billAmount;
    }
}



