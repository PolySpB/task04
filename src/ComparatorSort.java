import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Сортировка с использованием компараторов:
 * 1. Сортируем по полу (сначала мужчины, потом женщины).
 * 2. В этом же списке сортируем людей по возрасту: мужчин от старшего к младшему и женщин от старшей к младшей.
 * 3. В последнюю очередь сортируем по имени (в алфавитном порядке).
 */

public class ComparatorSort implements Sortable {
    private Person[] persons;

    public ComparatorSort(Person[] persons) {
        this.persons = persons;
    }

    /**
     * Выполнение всех доступных сортировок: по возрасту, по имени, по полу.
     */
    @Override
    public void executeAllSorts() {
        List<Person> personsList = Arrays.asList(persons);
        System.out.println("************************************************************");
        System.out.println("Sorts implementation with Comparator: " +
                "Sort by gender (men then women) , then by age (old to young) and then by name.");
        Comparator<Person> comparator = new CompareByGender().thenComparing(
                new CompareByAge().thenComparing(new CompareByName()));
        personsList.sort(comparator);
        print(personsList);
    }

    private void print(List<Person> personsList) {
        for (Person person : personsList) {
            System.out.println(person);
        }
    }

    /**
     * Сортировка по полу (сначала мужчины, потом женщины).
     */
    public class CompareByGender implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getGender().compareTo(p2.getGender());
        }
    }

    /**
     * Сортировка по возрасту (от старшего к младшему).
     */
    public class CompareByAge implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p2.getAge() - p1.getAge();
        }
    }

    /**
     * Сортировка по имени (в алфавитном порядке).
     */
    public class CompareByName implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }
}
