package java_extend;

public class People {
    private String name;
    private char gender;

    public People() {
    }

    public People(String name) {
        this(name,'F');
    }

    public People(String name, char gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + this.name + '\'' +
                ", gender=" + this.gender +
                '}';
    }
}
