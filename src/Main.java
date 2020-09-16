import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static Person[] persons;

    public static void main(String[] args) throws Exception {
        persons = generatePersons();
        checkPersonValidity(new Person("Mary", 28, Gender.WOMAN));
        checkPersonValidity(new Person("John", 5, Gender.MAN));

        System.out.println("************************************************************");
        System.out.println("Original list of people");
        for (Person person : persons) {
            System.out.println(person);
        }
/*
        Person[] persons = new Person[10];
        persons[0] = new Person("Mary", 28, Gender.WOMAN);
        persons[1] = new Person("Max", 20, Gender.MAN);
        persons[2] = new Person("Alex", 20, Gender.MAN);
        persons[3] = new Person("Jane", 43, Gender.WOMAN);
        persons[4] = new Person("Bob", 59, Gender.MAN);
        persons[5] = new Person("Tom", 17, Gender.MAN);
        persons[6] = new Person("Rose", 23, Gender.WOMAN);
        persons[7] = new Person("Steven", 37, Gender.MAN);
        persons[8] = new Person("John", 5, Gender.MAN);
        persons[9] = new Person("Ana", 34, Gender.WOMAN);
*/

        Sortable comparatorSort = new ComparatorSort(persons);
        Sortable bubbleSort = new BubbleSort(persons);
        Sortable insertionSort = new InsertionSort(persons);

        List<Sortable> allSorts = new ArrayList<>();
        Collections.addAll(allSorts, comparatorSort, bubbleSort, insertionSort);

        for (Sortable element : allSorts) {
            element.executeAllSorts();
            Thread.sleep(1000);
        }

    }

    /**
     * Генерация исходного массива человек.
     * @return массив объектов типа Person
     */
    private static Person[] generatePersons() {
        final int DEFAULT_ARRAY_SIZE = 10_000;
        Person[] persons = new Person[DEFAULT_ARRAY_SIZE];
        String[] names = {"Jane", "Patrick", "John", "Paul", "Mary",
                          "Alex", "Max", "Bob", "Tom", "Rose",
                          "Steven", "John", "Ana", "Lisa", "Helen"};
        for (int i = 0; i < persons.length; i++) {
            int randomNameIndex = (int) (Math.random() * 15);
            int randomAge = (int) (Math.random() * (100 - 0 + 1) + 0);
            Gender gender;
            if (randomNameIndex == 0 || randomNameIndex == 4 || randomNameIndex == 9 ||
                randomNameIndex == 12 || randomNameIndex == 13 || randomNameIndex == 14) {
                gender = Gender.WOMAN;
            } else {
                gender = Gender.MAN;
            }

            Person person = new Person(names[randomNameIndex], randomAge, gender);
            persons[i] = person;
        }
        persons[8] = new Person("Mary", 28, Gender.WOMAN);

        return persons;
    }

    /**
     * Проверка, существует ли уже человек с таким же именем и возрастом в исходном массиве.
     * Если да, выбрасываем пользовательское исключение.
     * @param person человек, имя и возраст которого проверяем
     */
    private static void checkPersonValidity(Person person) {
        for (int i = 0; i < persons.length; i++) {
            try {
                if (persons[i].getName().equals(person.getName()) && persons[i].getAge() == person.getAge()) {
                    throw new MyException();
                }
            } catch (MyException e) {
                System.out.println("Person with name '" + person.getName() +
                        "' and age=" + person.getAge() +
                        " already exists in a database.");
            }
        }
    }
}
