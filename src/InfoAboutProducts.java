/*Разработать класс для хранения информации о товарах:
        Наименование, производитель, количество_единиц, цена
        и реализовать алгоритм работы с массивом данных объектов, в котором
        требуется:
        – определить товары с максимальным количеством единиц;
        – определить среднюю цену товаров и количество товаров с ценой ниже
        средней;
        – упорядочить список по убыванию цен товаров;
        – организовать поиск по наименованию товара, исправление одного из полей и вывод полной информации о товаре после редактирования.*/
import java.util.Scanner;

class Product {
    String name;
    String manufacturer;
    int amount;
    double price;
}

public class InfoAboutProducts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("count");
        int count = sc.nextInt();
        sc.nextLine();
        Product[] products = new Product[count];
        for (int i = 0; i < count; i++) {
            products[i] = new Product();
            System.out.println("Name=>");
            products[i].name = sc.nextLine();
            System.out.println("Manufacturer=>");
            products[i].manufacturer = sc.nextLine();
            System.out.println("Amount=>");
            products[i].amount = sc.nextInt();
            System.out.println("Price=>");
            products[i].price = sc.nextDouble();
            sc.nextLine();
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Name = " + products[i].name + " Manufacturer = " + products[i].manufacturer +
                    " Amount = " + products[i].amount + " Price = " + products[i].price);
        }

        //определить товары с максимальным количеством единиц
        int productWithGreatestAmount = 0;
        int greatAmount = products[productWithGreatestAmount].amount;
        for (int i = 0; i < count; i++) {
            if (products[i].amount > greatAmount) {
                productWithGreatestAmount = i;
                greatAmount = products[productWithGreatestAmount].amount;
            }
        }
        System.out.println("Product with greatest amount");
        System.out.println("Name = " + products[productWithGreatestAmount].name + " Manufacturer = " +
                products[productWithGreatestAmount].manufacturer + " Amount = " +
                products[productWithGreatestAmount].amount + " Price = " + products[productWithGreatestAmount].price);

        //определить среднюю цену товаров и количество товаров с ценой ниже средней
        //здесь я сделал так, чтобы выводило данные товаров, у к-рых прайс больше авг, а не их кол-во
        double allPrice = 0;
        for (int i = 0; i < count; i++) {
            allPrice = allPrice + products[i].price;
        }
        System.out.println("AvgPrice = " + allPrice / count);
        for (int i = 0; i < count; i++) {
            if (products[i].price > allPrice / count) {
                System.out.println("Products with prices more than average");
                System.out.println("Name = " + products[i].name + " Manufacturer = " + products[i].manufacturer +
                        " Amount = " + products[i].amount + " Price = " + products[i].price);
            }
        }

        //упорядочить список по убыванию цен товаров
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - 1 - i; j++) {
                if (products[j].price < products[j + 1].price) {
                    Product rab = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = rab;
                }
            }
        }
        System.out.println("Sorted by decrease in prices");
        for (int i = 0; i < count; i++) {
            System.out.println("Name = " + products[i].name + " Manufacturer = " + products[i].manufacturer +
                    " Amount = " + products[i].amount + " Price = " + products[i].price);
        }

        /* организовать поиск по наименованию товара, исправление одного из полей и вывод полной информации о товаре
        после редактирования */
        int searchIndex = -1;
        System.out.println("Enter name ");
        String nameSearch = sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (products[i].name.equals(nameSearch))
                searchIndex = i;
        }
        if (searchIndex!=-1) {
            System.out.println("Найден товар ");
            System.out.println("Name = " + products[searchIndex].name + " Manufacturer = " + products[searchIndex].manufacturer +
                    " Amount = " + products[searchIndex].amount + " Price = " + products[searchIndex].price);
            System.out.println("Какое поле хотите исправить ");
            System.out.println("name, manufacturer, amount, price ");
            String redPole = sc.nextLine();
            switch (redPole) {
                case "name": {
                    System.out.println("New name ");
                    String newName = sc.nextLine();
                    products[searchIndex].name = newName;
                    break;
                }
                case "manufacturer": {
                    System.out.println("New manufacturer ");
                    String newManufacturer = sc.nextLine();
                    products[searchIndex].manufacturer = newManufacturer;
                    break;
                }
                case "amount": {
                    System.out.println("New amount ");
                    int newAmount = sc.nextInt();
                    products[searchIndex].amount = newAmount;
                    break;
                }
                case "price": {
                    System.out.println("New price ");
                    double newPrice = sc.nextDouble();
                    products[searchIndex].price = newPrice;
                    break;
                }
            }
            System.out.println("Отредактированная информация о товаре ");
            System.out.println("Name = " + products[searchIndex].name + " Manufacturer = " + products[searchIndex].manufacturer +
                    " Amount = " + products[searchIndex].amount + " Price = " + products[searchIndex].price);
        }
        else {
            System.out.println("Ничего не найдено ");
        }
    }
}

