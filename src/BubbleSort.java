/**
 * Сортировка методом пузырка.
 */
public class BubbleSort implements Sortable {
    private Person[] persons;

    public BubbleSort(Person[] persons) {
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
        System.out.println("Bubble Sort by Age (old to young)");

        int n = persons.length;
        Person temp;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n-i; j++) {
                if (persons[j-1].getAge() < persons[j].getAge()) {
                    temp = persons[j-1];
                    persons[j-1] = persons[j];
                    persons[j] = temp;
                }
            }
        }

        print(persons);
    }

    /**
     * Сортировка по имени (в алфавитном порядке).
     */
    public void sortByName() {
        System.out.println("************************************************************");
        System.out.println("Bubble Sort by Name (A to Z)");

        int n = persons.length;
        Person temp;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n-i; j++) {
                if (persons[j-1].getName().compareToIgnoreCase(persons[j].getName()) > 0) {
                    temp = persons[j-1];
                    persons[j-1] = persons[j];
                    persons[j] = temp;
                }

            }
        }

        print(persons);
    }

    /**
     * Сортировка по полу (сначала мужчины, потом женщины).
     */
    public void sortByGender() {
        System.out.println("************************************************************");
        System.out.println("Bubble Sort by Gender (men then women)");

        int n = persons.length;
        Person temp;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n-i; j++) {
                if (persons[j-1].getGender().equals(Gender.WOMAN)) {
                    temp = persons[j-1];
                    persons[j-1] = persons[j];
                    persons[j] = temp;
                }
            }
        }

        print(persons);
    }

    private void print(Person[] persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
