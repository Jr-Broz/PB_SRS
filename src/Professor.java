import java.util.ArrayList;

public class Professor  extends Person{

    private String title;
    private String department;
    private ArrayList<Section> teaches;


    public Professor(String name, String ssn, String title, String dept) {

        super(name, ssn);

        setTitle(title);
        setDepartment(dept);

        teaches = new ArrayList<Section>();

    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getTitle() {

        return  title;
    }
    public void setDepartment(String dept) {

        this.department = dept;
    }


    public String getDepartment() {

        return department;
    }


    public void display() {


        System.out.println("Professor Specific Information: ");
        System.out.println("Title: " + getTitle());
        System.out.println("Teaches for Dept. : " + getDepartment());
        displayTeachingAssignments();

    }

public String toString() {

        return getName() + "(" + getTitle() + "," + getDepartment() + ")";
}

public void displayTeachingAssignments() {

    System.out.println("Teaching assignments for " + getName() + " : ");


  if(teaches.size() == 0 ) {

      System.out.println("(none");
  }

  else for(Section s : teaches) {

      System.out.println("Course No. : " + s.getRepresentedCourse().getCourseNo());

      System.out.println("Section No,: " + s.getSectionNo());

      System.out.println("Course Name: " + s.getRepresentedCourse().getCourseName());

      System.out.println("Day and time: " + s.getDayOfWeek() + "- " + s.getTimeOfDay());

      System.out.println("---------------------");

  }
    }


    public void agreeToTeach(Section s ) {

        teaches.add(s);
        s.setInstructor(this);
    }
}
