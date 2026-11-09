import java.util.*;
import java.util.stream.Collectors;

public class Institution {

private final List<Student> students;
private final List<Subject> subjects;
private final Supervisor defaultSupervisor;

public Institution(List<Student> students, List<Subject> subjects, Supervisor defaultSupervisor) {
    this.students = students;
    this.subjects = subjects;
    this.defaultSupervisor = defaultSupervisor;
}

public void enrolStudent(Student student) {
    students.add(student);
}

public void changeStudentSubject(String studentId, String subjectName) {
    Student student = students.stream()
            .filter(s -> s.id().equals(studentId))
            .findFirst()
            .orElseThrow();
    Subject newSubject = subjects.stream()
            .filter(sub -> sub.name().equalsIgnoreCase(subjectName))
            .findFirst()
            .orElseThrow();
    student.changePreferredSubject(newSubject);
}

public void reassignSupervisor(String subjectName, Supervisor newSupervisor) {
    subjects.stream()
            .filter(sub -> sub.name().equalsIgnoreCase(subjectName))
            .findFirst()
            .orElseThrow()
            .reassignSupervisor(newSupervisor);
}

public Map<String, String> generateReport() {
    int total = students.size();
    Map<String, Long> counts = students.stream()
            .collect(Collectors.groupingBy(s -> s.preferredSubject().name(), Collectors.counting()));

    Map<String, String> report = new LinkedHashMap<>();
    for (Subject subject : subjects) {
        long count = counts.getOrDefault(subject.name(), 0L);
        double percentage = (count * 100.0) / total;
        report.put(subject.name(), count + " students (" + String.format("%.1f", percentage) + "%)");
    }
    return report;
}
}