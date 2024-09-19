import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String professorName;
    private int year;
    private List<Student> students = new ArrayList<>();

    // constructor de couse
    public Course(String courseName, String professorName, int year) {
        this.courseName = courseName;
        this.professorName = professorName;
        this.year = year;
    }

    // inscribir estudiante
    public void enroll(Student student) {
        students.add(student);
        System.out.println("Matriculado: " + student.firstName + " " + student.lastName + " en " + courseName);
        student.changeYearIfApproved();
    }

    // sobrecarga para inscribir estudiantes
    public void enroll(Student[] studentsArray) {
        for (Student student : studentsArray) {
            enroll(student);
        }
    }

    // para dar de baja a un estudiante
    public void unEnroll(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            System.out.println("Se dio de baja: " + student.firstName + " " + student.lastName + " de " + courseName);
        } else {
            System.out.println("No se encuentra el alumno : " + student.firstName + " " + student.lastName);
        }
    }

    // contar el número de estudiantes
    public int countStudents() {
        return students.size();
    }

    // se obtiene la mejor calificación
    public int maxGradeStudent() {
        int maxGrade = -1;  
        for (Student student : students) {
            if (student.getGrade() > maxGrade) {
                maxGrade = student.getGrade(); 
            }
        }
        return maxGrade;
    }


    // imprime la información del curso
    
    public void printCourseInfo() {
        System.out.println("Curso: " + courseName);
        System.out.println("Profesor: " + professorName);
        System.out.println("Año actual: " + year);
        System.out.println("Total de estudiantes: " + countStudents());
    }

    public static void main(String[] args) {
        // uso del constructor de student
        Student student1 = new Student("Kristopher", "Jaramillo", 010101, 75, 1);
        Student student2 = new Student("Libertad", "Rivas", 010102, 85, 2);
        Student student3 = new Student("Adrian", "Lascurain", 010103, 65, 1);
        Student student4 = new Student("Pedro", "Picapiedra", 010104, 40, 3);

        // se crea un nuevo curso
        Course course = new Course("Programación orientada a objetos", "JC Valencia", 2024);

        // inscribe alumnos
        course.enroll(student1);
        course.enroll(student2);

        // inscribe un array de alumnos
        Student[] moreStudents = {student3, student4};
        course.enroll(moreStudents);

        // muestra la info del curso después de inscribir a los estudiantes
        course.printCourseInfo();

        // borrar a un estudiante
        course.unEnroll(student4);

        // muestra la mejor calificación después de las modificaciones
        System.out.println("Mejor calificación: " + course.maxGradeStudent());
    }
}