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
        testarray();
        sometest();
        sortarray();
        //Person p = new Person("Іван", "Музичко");
        //System.out.println(p);
        //p.setFirstName("Василь");
        //System.out.println(p);

        //шлях підключення до бази данних
        String strCon = "jdbc:mariadb://localhost:3306/java_spu013";
        //перевіряє чи підключення є успішним
        try (Connection con = DriverManager.getConnection(strCon, "root", "")) {
            System.out.println("Connection is good");
            //запит для бази данних
            String query = "SELECT * FROM categories";
            //підготовка запиту
            PreparedStatement command = con.prepareStatement(query);
            //виконання запиту
            ResultSet resultSet = command.executeQuery();
            //next зчитує кожен рядок окремо
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
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
}
