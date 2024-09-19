public class Student {
    String firstName;
    String lastName;
    int registration;
    int grade;
    int year;

    // 1er constructor para los atributos
    public Student(String firstName, String lastName, int registration, int grade, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
        this.grade = grade;
        this.year = year;
    }

    // 2do constructor para nombre y matricula
    public Student(String firstName, String lastName, int registration) {
        this(firstName, lastName, registration, 0, 1);
    }

    // 3er constructor para el nombre
    public Student(String firstName, String lastName) {
        this(firstName, lastName, 0, 0, 1);
    }

    public void printFullName() {
        System.out.println(firstName + " " + lastName);
    }

    public boolean isApproved() {
        return grade >= 60;
    }

    public int changeYearIfApproved() {
        if (isApproved()) {
            year++;
            System.out.println("Felicidadeeees!! " + firstName + " " + lastName + " fuiste promovido al grado " + year);
        }
        return year;
    }

    public int getGrade() {
        return grade;
    }
}
