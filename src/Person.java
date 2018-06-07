/**
 * Class Person defines worker with specific variables
 */
public class Person {
    /**
     * Person class variables
     */
    int ID;
    String firstName;
    String lastName;
    int age;
    int salary;

    /**
     * Person constructor allows to create new Person object with all class variables
     * @param ID // Person ID number which defines place in Person object array
     * @param firstName
     * @param lastName
     * @param age
     * @param salary
     */
    public Person(int ID, String firstName, String lastName, int age, int salary)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }
}
