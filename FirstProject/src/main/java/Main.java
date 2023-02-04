import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //методи
        // testarray();
        // sometest();
        // sortarray();
        // calculator();
        //Person p = new Person("Іван", "Музичко");
        //System.out.println(p);
        //p.setFirstName("Василь");
        //System.out.println(p);

        //шлях підключення до бази данних
        String strCon = "jdbc:mariadb://localhost:3306/java_spu013";
        //перевіряє чи підключення є успішним
        try (Connection con = DriverManager.getConnection(strCon, "root", "")) {
            System.out.println("Connection is good");
            Boolean continueExe = true;
            System.out.println("1. Вивести список категорій\n" +
                    "2. Додати категорію\n" +
                    "3. Вихід");
            while (continueExe) {
                System.out.println("Виберіть дію");
                Scanner input = new Scanner(System.in);
                String action = input.nextLine();
                switch (action) {
                    case "1":
                        //запит для бази данних
                        String query = "SELECT * FROM categories";
                        //підготовка запиту
                        PreparedStatement command = con.prepareStatement(query);
                        //виконання запиту
                        ResultSet resultSet = command.executeQuery();
                        //next зчитує кожен рядок окремо
                        while (resultSet.next()) {
                            System.out.println("Id: " + resultSet.getString("id"));
                            System.out.println("Name: " + resultSet.getString("name"));
                        }
                        break;
                    case "2":
                        System.out.println("Введіть назву категорії");
                        String name = input.nextLine();
                        String insertQuery = "INSERT INTO categories (name, datetime) VALUES ('" + name + "' , NOW());";
                        PreparedStatement command2 = con.prepareStatement(insertQuery);
                        command2.executeQuery();
                        System.out.println("Додано нову категорію: " + name);
                        break;
                    case "3":
                        System.out.println("Вихід");
                        continueExe = false;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error connection " + ex.getMessage());
        }
    }

    //метод для рандому числа
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    //метод  перевірки масива на додатні і від'ємні числа
    public static void testarray() {
        int n = 10;
        int[] mas = new int[n];
        for (int i = 0; i < n; i++)
            mas[i] = getRandomNumber(-10, 20);

        for (int item : mas)
            System.out.printf("%d\t", item);
        int count = 0;
        for (int item : mas) {
            if (item >= 0) {
                count++;
            }
        }
        System.out.println("Додатніх чисел є " + count);
    }

    public static void sometest() {
        //int a = 10;
        //double, short, boolean, char, float  базові типи в java
//        Scanner input = new Scanner(System.in);
//        System.out.println("Вкажіть значення а ");
//        a = input.nextInt();
//        System.out.println("Hello world a = " + a);

//        String str;
//        Scanner input = new Scanner(System.in);
//        System.out.println("Введіть букви");
//        str= input.nextLine();
//        System.out.println(str);
    }

    //метод сортування масива
    public static void sortarray() {
        Person[] list = {
                new Person("Іван", "Музичко"),
                new Person("Андрій", "Шишкевич"),
                new Person("Аня", "Стрийко"),
                new Person("Олег", "Закуска"),
                new Person("Сергій", "Булочка")
        };

        for (Person p : list) {
            System.out.println(p);
        }

        Arrays.sort(list/*, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                    return o1.getLastName().compareTo(o2.getLastName());
            }
        }*/);
        System.out.println("Сортований список");

        for (Person p : list) {
            System.out.println(p);
        }
    }

    public static void calculator() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введіть перше число");
        int n1 = input.nextInt();
        System.out.println("Введіть друге число");
        int n2 = input.nextInt();
        int sum = 0;
        System.out.println("Виберіть дію");
        String action = input.next();

        switch (action) {
            case "+":
                sum = n1 + n2;
                System.out.println(n1 + action + n2 + " = " + sum);
                break;

            case "-":
                sum = n1 - n2;
                System.out.println(n1 + action + n2 + " = " + sum);
                break;

            case "*":
                sum = n1 * n2;
                System.out.println(n1 + action + n2 + " = " + sum);
                break;

            case "/":
                if (n2 == 0) {
                    System.out.println("На нуль ділити не можна! Вихід з програми.");
                    break;
                } else sum = n1 / n2;
                System.out.println(n1 + action + n2 + " = " + sum);
                break;
        }
    }
}