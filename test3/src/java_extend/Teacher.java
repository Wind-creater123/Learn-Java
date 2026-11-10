package java_extend;

public class Teacher extends People{
    private String skill;

    public Teacher() {
    }

    public Teacher(String name, char gender, String skill) {
        super(name, gender);
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "skill='" + skill + '\'' +
                '}';
    }
}
