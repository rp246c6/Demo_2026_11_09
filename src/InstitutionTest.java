import java.util.ArrayList;
import java.util.List;

public class InstitutionTest {
    public static void main(String[] args) {
        // Supervisors
        Supervisor tari = new Supervisor("SUP0", "Dr. Tari");
        Supervisor toth = new Supervisor("SUP1", "Dr. Toth");
        Supervisor boddu = new Supervisor("SUP2", "Dr. Boddu");
        Supervisor csuvarski = new Supervisor("SUP3", "Dr. Csuvarski");
        Supervisor urbancsok = new Supervisor("SUP4", "Dr. Urbancsok");

        // Subjects
        Subject math = new Subject("SUB1", "Mathematics", toth);
        Subject physics = new Subject("SUB2", "Physics", boddu);
        Subject chemistry = new Subject("SUB3", "Chemistry", csuvarski);
        Subject biology = new Subject("SUB4", "Biology", urbancsok);

        List<Subject> subjects = List.of(math, physics, chemistry, biology);

        // Students
        List<Student> students = List.of(
                new Student("ST001", 16, math),
                new Student("ST002", 17, physics),
                new Student("ST003", 18, chemistry),
                new Student("ST004", 16, biology),
                new Student("ST005", 19, math),
                new Student("ST006", 17, physics),
                new Student("ST007", 18, biology),
                new Student("ST008", 19, chemistry)
        );

        Institution institution = new Institution(new ArrayList<>(students), new ArrayList<>(subjects), tari);

        // Initial report
        System.out.println("Initial Report:");
        institution.generateReport().forEach((sub, rep) -> System.out.println(sub + " -> " + rep));

        // Change preference ST005: Math → Physics
        institution.changeStudentSubject("ST005", "Physics");
        System.out.println("\nAfter ST005 changes subject:");
        institution.generateReport().forEach((sub, rep) -> System.out.println(sub + " -> " + rep));

        // Supervisor reassignment for Physics
        Supervisor newPhysicsSup = new Supervisor("SUP5", "Dr. Newton");
        institution.reassignSupervisor("Physics", newPhysicsSup);
        System.out.println("\nPhysics supervisor now: " + physics.supervisor().name());

        // Assertion check
        assert physics.supervisor().name().equals("Dr. Newton") : "Supervisor reassignment failed!";
        assert institution.generateReport().get("Physics").contains("37.5") : "Report percentage mismatch!";
    }
}
