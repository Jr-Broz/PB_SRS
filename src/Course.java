
import java.util.ArrayList;
import java.util.Collection;

public class Course {

private String courseNo;

private String courseName;
private double credits;
private ArrayList<Section> offeredAsSection;
private ArrayList<Course> prerequistes;


public Course(String cNo, String cName, double credits) {

    setCourseNo(cNo);
    setCourseName(cName);

    setCredits(credits);
offeredAsSection = new ArrayList<Section>();
prerequistes = new ArrayList<Course> ();

}


public void setCourseNo(String cNo){courseNo = cNo;}
public String getCourseNo() {return courseNo;}

public void setCourseName(String cName) {

    courseName = cName;
}

public String getCourseName() {

     return courseName;
}
public void setCredits(double c) {credits = c;}


public double getCredits() {return credits;}


public void display() {


    System.out.println("Course Information");
    System.out.println("Course No.: " + getCourseNo());
    System.out.println("Course Name.: " + getCourseName());
    System.out.println("Credits.: " + getCourseNo());
    System.out.println("Prerequise Courses " );

    for(Course c : prerequistes) {

        System.out.println(c.toString());
    }

    System.out.println();




}
public String toString() {

    return getCourseNo() + ": " + getCourseName();
 }


 public void addPrerequiste(Course c) {

    prerequistes.add(c);
 }

 public void addSection(Section s) {

    offeredAsSection.add(s);
 }

 public boolean hasPrerequistes() {

    if(prerequistes.size() > 0 )  return true;
    else return false;
 }


 public Collection<Course>getPrerequistes() {

    return prerequistes;
 }



 public Section scheduleSection(char day, String time, String room, int capacity) {

    Section s = new Section(offeredAsSection.size() + 1, day , time, this, room, capacity);


    addSection(s);

    return s;
}

}
