import java.util.ArrayList;

public class Main {

    public static ArrayList<Professor> faculty;
    public static ArrayList<Student> studentBody;
    public static ArrayList<Course> courseCatalog;

    public static ScheduleOfClasses scheduleOfClasses = new ScheduleOfClasses("SP2005");

    public static void main(String[] args) {

    Professor p1, p2, p3;
    Student s1, s2 ,s3;
    Course c1, c2, c3, c4, c5;
    Section sec1, sec2, sec3, sec4, sec5, sec6, sec7;

        p1 = new Professor("Jacquie Barker", "123-45-6785", "Adjunct Professor", "Information Technology");
        p2 = new Professor("John Smith", "567-81-2345", "Full Professor", "Chemistry");
        p3 = new Professor("Snidely Whiplash", "987-65-4321", "Full Professor", "Pyshical Education");

        faculty = new ArrayList<Professor>();
        faculty.add(p1);
        faculty.add(p2);
        faculty.add(p3);


        s1 = new Student("Joe Blow", "111-111-1111", "Math", "M.S");
        s2 = new Student("Fred Schnurd", "222-22-2222", "Information Technology", "PH.D");
        s3 = new Student("Mary Smith", "333-33-3333", "Physics", "B.S");

    studentBody = new ArrayList<Student>();

    studentBody.add(s1);
    studentBody.add(s2);
    studentBody.add(s3);






//-----------------------
//Course
//-------------------

        c1 = new Course("CMP101", "Beginning Computer Technology", 3.0);
        c2 = new Course("OBJ101", "Object Methods for Software Development", 3.0);
        c3 = new Course("CMP283", "Higher Level Languages (Java)", 3.0);
        c4 = new Course("CMP999", "Living brain Computer", 3.0);
        c5 = new Course("art101", "Beginning Basketweaving", 3.0);

        courseCatalog = new ArrayList<Course>();

        courseCatalog.add(c1);
        courseCatalog.add(c2);
        courseCatalog.add(c3);
        courseCatalog.add(c4);
        courseCatalog.add(c5);


        sec1 = c1.scheduleSection('M', "8:10 - 10:00 PM", "GOVT101", 30);
        sec2 = c1.scheduleSection('W', "6:10 - 8:00 PM", "GOVT202", 30);
        sec3 = c1.scheduleSection('R', "4:10 - 6:00 PM", "GOVT105", 25);
        sec4 = c1.scheduleSection('T', "6:10 - 8:00 PM", "SCI330", 25);
        sec5 = c1.scheduleSection('M', "6:10 - 8:00 PM", "GOVT101", 20);

        sec6 = c1.scheduleSection('R', "4:10 - 6:00 PM", "SCI241", 15);
        sec7 = c1.scheduleSection('M', "4:10 - 6:00 PM", "ARTS25", 40);


        scheduleOfClasses.addSection(sec1);
        scheduleOfClasses.addSection(sec2);
        scheduleOfClasses.addSection(sec3);
        scheduleOfClasses.addSection(sec4);
        scheduleOfClasses.addSection(sec5);
        scheduleOfClasses.addSection(sec6);
        scheduleOfClasses.addSection(sec7);


        p3.agreeToTeach(sec1);
        p2.agreeToTeach(sec2);
        p1.agreeToTeach(sec3);
        p3.agreeToTeach(sec4);
        p1.agreeToTeach(sec5);
        p2.agreeToTeach(sec6);
        p3.agreeToTeach(sec7);


        System.out.println("=========================================");
        System.out.println("Student Registration has begun.");
        System.out.println("=========================================");


        System.out.println("Student :" + s1.getName() + "is attempting to enroll in" + sec1.toString());

        EnrollmentStatus status = sec1.enroll(s1);
        reportStatus(status);

        attemptToEnroll(s1, sec2);

        attemptToEnroll(s2, sec2);

        attemptToEnroll(s2, sec3);

        attemptToEnroll(s2, sec7);
        attemptToEnroll(s3, sec1);

        sec1.postGrade(s1, "C+");
        sec1.postGrade(s3, "A");
        sec2.postGrade(s2, "B+");
        sec7.postGrade(s2, "A-");


        System.out.println("=================");
        System.out.println("schedule of classes");
        System.out.println("=================");
        System.out.println();
        scheduleOfClasses.display();


        System.out.println("================");
        System.out.println("Professor Information");
        System.out.println("=========================");
        System.out.println();

        p1.display();
        p2.display();
        p3.display();



    }

    private static void reportStatus(EnrollmentStatus s) {

        System.out.println("Status " + s.value());
        System.out.println();

    }

    private static void attemptToEnroll(Student s, Section sec) {

        System.out.println("Student" + s.getName() + "is attemption to enroll in " + sec.toString());
        reportStatus(sec.enroll(s));
    }

}