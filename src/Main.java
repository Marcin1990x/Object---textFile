import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String fileName = "Person_list.txt"; // defines file name
        File file = new File(fileName); // defines file to open

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        Person[] personArray = new Person[0];

        while(br.ready()){ // loop which stops when line is null

            int ID = Integer.parseInt(br.readLine());
            String firstName = br.readLine();
            String lastName = br.readLine();
            int age = Integer.parseInt(br.readLine());
            int salary = Integer.parseInt(br.readLine());

            Person personTmp = new Person(ID, firstName, lastName, age, salary);
            personArray = addPerson(personArray, personTmp);
        }
        br.close(); // close the stream


        // Here you can create new Person object filling arguments firstName, lastName, age and salary
        // ID is automatically adding depends on object quantity in file
        Person p = new Person(freeID(personArray), "Darek", "Konek", 55, 3000);
        personArray = addPerson(personArray, p);
        savePersonToFile(p, fileName);
    }

    /**
     * This function allows to increment size ++ of person array and copy new person object into
     * @param personArray old version of person array
     * @param personToAdd new person object to add
     * @return returning new version of person object array
     */
    public static Person[] addPerson(Person[] personArray, Person personToAdd){

        Person[] newPersonArray = new Person[personArray.length + 1]; // new Person object array with incremented size
        System.arraycopy(personArray, 0, newPersonArray, 0, personArray.length); // Copy of old Person array to new
        newPersonArray[newPersonArray.length - 1] = personToAdd; // adding new person object to last position of new array
        return newPersonArray;
    }

    /**
     * This function allows to append new Person object to existing Person object array
     * @param person Person object which will be added
     * @param fileName File name here object will be added
     * @throws IOException
     */
    public static void savePersonToFile(Person person, String fileName) throws IOException{
        FileWriter fileWriter = new FileWriter(fileName, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println();
        printWriter.print(person.ID);
        printWriter.println();
        printWriter.print(person.firstName);
        printWriter.println();
        printWriter.print(person.lastName);
        printWriter.println();
        printWriter.print(person.age);
        printWriter.println();
        printWriter.print(person.salary);

        printWriter.close();
    }

    /**
     * This function allows to print on the screen all Person object variables
     * @param person person object which we want to print
     * @return returns String with text
     */
    public static String toString(Person person){
        return "ID: " + person.ID + " First name: " +person.firstName + " Last name: " + person.lastName
                + " Age: " + person.age + " Salary: " + person.salary;
    }

    /**
     * This function counts first free ID to use for creating new Person object
     * @param person Person object array
     * @return returns first free ID as int
     */
    public static int freeID(Person[] person){

        int freeID = person.length;
        return freeID;
    }
}


