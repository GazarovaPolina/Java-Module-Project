import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
        ArrayList<Product> productsList = new ArrayList<>();
        int friendsAmount;

        Calculator(int friendsAmount) {
            this.friendsAmount = friendsAmount;
        }

        void addProduct() {
            Scanner scanner = new Scanner(System.in);
            String productName;
            String inputValue;
            double productPrice;

            while (true) {

                System.out.println("Введите любой символ для продолжения добавления товаров или \"завершить\":");
                inputValue =  scanner.nextLine();

                if (inputValue.equalsIgnoreCase("завершить")) {
                    break;
                }
                System.out.println("Введите название товара:");
                productName = scanner.nextLine();

                System.out.println("Введите его стоимость:");

                while (true){
                    inputValue = scanner.nextLine();

                    if (isPriceFormatRight(inputValue)) {
                        productPrice = Double.parseDouble(inputValue);
                        break;
                    }
                    else {
                        System.out.println("Недопустимое значение стоимости. Попробуйте снова:");
                    }
                }

                productsList.add(new Product(productName, productPrice));
                System.out.println("Товар добавлен");
            }
        }

        boolean isPriceFormatRight(String price) {
            double productPrice;
            try {
                productPrice = Double.parseDouble(price);
            }
            catch (NumberFormatException exception) {
                return false;
            }
            if (productPrice <= 0) {
                return  false;
            }
            return true;
        }

        void printProducts() {
            System.out.println("\nДобавленные товары:");
            for (Product product : productsList) {
                System.out.println(product.getName());
            }
        }

        void PrintPaymentFromPerson() {
            double payment = 0;
            for (Product product : productsList) {
                payment += product.getPrice();
            }
            payment /=  friendsAmount;
            int lastDigit = (int) Math.floor(payment) % 10;
            String rub;
            switch (lastDigit) {
                case 1:
                    rub = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    rub = "рубля";
                    break;
                default:
                    rub = "рублей";
                    break;
            }
            System.out.println("\nКаждый человек должен заплатить " + String.format("%.2f", payment) + " " + rub);

        }
}
