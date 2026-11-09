public class Student {
    private final String id;
    private final int age;
    private Subject preferredSubject;

    public Student(String id, int age, Subject preferredSubject) {
        this.id = id;
        this.age = age;
        this.preferredSubject = preferredSubject;
    }

    public String id() { return id; }
    public int age() { return age; }
    public Subject preferredSubject() { return preferredSubject; }

    public void changePreferredSubject(Subject newSubject) {
        this.preferredSubject = newSubject;
    }
}
