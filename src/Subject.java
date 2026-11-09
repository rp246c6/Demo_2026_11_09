public class Subject {

    private final String id;
    private final String name;
    private Supervisor supervisor;

    public Subject(String id, String name, Supervisor supervisor) {
        this.id = id;
        this.name = name;
        this.supervisor = supervisor;
    }

    public String id() { return id; }
    public String name() { return name; }
    public Supervisor supervisor() { return supervisor; }

    public void reassignSupervisor(Supervisor newSupervisor) {
        this.supervisor = newSupervisor;
    }
}
