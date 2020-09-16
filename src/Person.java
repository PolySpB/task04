/**
 * Класс, описывающий данные о человеке.
 */
public class Person {
    private String name;
    private int age;
    private Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        if (0 <= age && age <= 100) {
            this.age = age;
        }
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (0 <= age && age <= 100) {
            this.age = age;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "{name=" + name +
                ",  age=" + age +
                ",  gender=" + gender + '}';
    }
}
