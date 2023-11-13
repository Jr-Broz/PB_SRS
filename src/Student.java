import java.util.ArrayList;

public class Student  extends  Person {

    private String major;
    private String degree;
    private Transcript transcript;

    private ArrayList<Section> attends;


    public Student(String name, String ssm, String major, String degree) {

        super(name, ssm);

        this.setMajor(major);
        this.setDegree(degree);


        this.setTranscript(new Transcript(this));

        attends = new ArrayList<Section>();
    }

    public Student(String ssn) {
        this("TBD", ssn, "TBD", "TBD");


    }

    public void setMajor(String major) {

        this.major = major;
    }

    public String getMajor() {

        return major;
    }

    public void setDegree(String degree) {

        this.degree = degree;
    }

    public String getDegree() {

        return degree;
    }


    public setTranscript(Transcript t) {

        transcript = t;
    }

    public Transcript getTranscript() {

        return transcript;
    }

    public void display() {

        System.out.println("Student-Specific Information: ");
        System.out.println("Major:  " + this.getMajor());
        System.out.println("Degree:  " + this.getDegree());
        this.displayCourseSchedule();
        this.printTranscript();

        System.out.println();


    }

    public String toString() {

        return this.getName() + "( " + this.getSsn() + ") ( " + this.getDegree() + getMajor() + "]";


    }

    public void displayCourseSchedule() {

        System.out.println("Course Schedule for " + this.getName());


    for(Section s :attends)

    {

        if (s.getGrade(this) == null) {


            System.out.println("Course Nam: " + s.getRepresentedCourse().getCourseNo());
            System.out.println("Section No: " + s.getSectionNo());
            System.out.println("Course Name: " + s.getRepresentedCourse().getCourseNo());
            System.out.println("Meeting Day and Time Held: :  " + s.getDayOfWeek() + " - " + s.getTimeOfDay());
            System.out.println("Room Location " + s.getRoom());
            System.out.println("Professor Name: " + s.getInstructor().getName());

        }

    }
    }

    public  void addSection(Section s) {

        attends.add(s);
    }

    public void dropSection(Section s) {

        attends.remove(s);
    }

    public boolean isEnrolledIn(Section s ){

        if(attends.contains(s)) {

            return true;
        }
        else {

            return false;
        }

    }

    public boolean isCurrentlyEnrolledInSimilar(Section s1) {

        boolean foundMatch = false;

        Course c1 = s1.getRepresentedCourse();

        for(Section s2 : attends) {

            Course c2 = s2.getRepresentedCourse();

            if(c1 == c2){

                if(s2.getGrade(this) == null) {

                    foundMatch = true;
                    break;
                }
            }
        }
        return foundMatch;
    }

    public void printTranscript() {

        this.getTranscript().display();
    }


    public Collection<Section> getEnrolledSections() {

        return attends;
    }

}




