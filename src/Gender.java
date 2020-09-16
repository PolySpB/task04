public enum Gender {
    MAN("Мужчина"),
    WOMAN("Женщина");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
