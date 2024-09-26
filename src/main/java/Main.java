import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int friendsAmount;
        System.out.println("На скольких человек необходимо разделить счет?");

        while (true) {
                try {
                    friendsAmount = Integer.parseInt(scanner.nextLine());
                    if (friendsAmount > 1) {
                        break;
                    }
                    System.out.println("Для выполнения задачи необходимо, чтобы количество человек было > 1. Попробуйте снова:");

                } catch (NumberFormatException exception) {
                    System.out.println("Введенное значение не является целым числом. Попробуйте снова:");
                }
        }

        Calculator calculator = new Calculator(friendsAmount);
        calculator.addProduct();
        calculator.printProducts();
        calculator.PrintPaymentFromPerson();
    }
}
