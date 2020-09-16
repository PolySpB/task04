/**
 * Сортировка методом вставки.
 */
public class InsertionSort implements Sortable {
    private Person[] persons;

    public InsertionSort(Person[] persons) {
        this.persons = persons;
    }

    /**
     * Выполнение всех доступных сортировок: по возрасту, по имени, по полу.
     */
    @Override
    public void executeAllSorts() {
        sortByAge();
        sortByName();
        sortByGender();
    }

    /**
     * Сортировка по возрасту (от старшего к младшему).
     */
    public void sortByAge() {
        System.out.println("************************************************************");
        System.out.println("Insertion Sort by Age (old to young)");

        for (int i = 1; i < persons.length ; i++) {
            int tempAge = persons[i].getAge();
            Person tempPerson = persons[i];
            int j = i-1;

            while (j >= 0 && tempAge >= persons[j].getAge()) {
                persons[j+1] = persons[j];
                j = j-1;
            }
            persons[j+1] = tempPerson;
        }

        print(persons);
    }

    /**
     * Сортировка по имени (в алфавитном порядке).
     */
    public void sortByName() {
        System.out.println("************************************************************");
        System.out.println("Insertion Sort by Name (A to Z)");

        for (int i = 1; i < persons.length ; i++) {
            String tempName = persons[i].getName();
            Person tempPerson = persons[i];
            int j = i-1;

            while (j >= 0 && tempName.compareToIgnoreCase(persons[j].getName()) < 0) {
                persons[j+1] = persons[j];
                j = j-1;
            }
            persons[j+1] = tempPerson;
        }

        print(persons);
    }

    /**
     * Сортировка по полу (сначала мужчины, потом женщины).
     */
    public void sortByGender() {
        System.out.println("************************************************************");
        System.out.println("Insertion Sort by Gender (men then women)");

        for (int i = 0; i < persons.length ; i++) {
            Gender secondGender = Gender.WOMAN;
            Person tempPerson = persons[i];
            int j = i-1;

            while (j >= 0 && persons[j].getGender().equals(secondGender)) {
                persons[j+1] = persons[j];
                j = j-1;
            }
            persons[j+1] = tempPerson;
        }

        print(persons);
    }

    private void print(Person[] persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
