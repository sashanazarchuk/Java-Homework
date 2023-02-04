//створення класу і імплементація інтерфейсу Comparable
public class Person implements Comparable {
    private String firstName;
    private String lastName;

    //конструктор
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //метод для сортування
    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            //сортування по прізвищу
            int result = this.lastName.compareTo(p.lastName);
            if (result == 0)
                //сортування по імені
                result = this.firstName.compareTo(p.firstName);
            return result;
        }
        return 0;
    }


    //гетер і сетер
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //метод для відображення прізвища та імені
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
