import java.util.ArrayList;

public class Transcript {



    private ArrayList<TranscriptEntry> transcriptEntries;
    private Student studentOwner;



    public Transcript(Student s) {

        setStudentOwner(s);

        transcriptEntries = new ArrayList<TranscriptEntry>();
    }


    public void setStudentOwner(Student s) {

        studentOwner = s;
    }

    public Student getStudentOwner() {

        return studentOwner;
    }


    public boolean verifyCompletion(Course c ) {

        boolean outcome =  false;

        for(TranscriptEntry te: transcriptEntries) {

            Section s = te.getSection();

            if(s.isSectionOf(c)) {

                if(TranscriptEntry.passingGrade(te.getGrade())) {

                    outcome = true;
                    break;;

                }
            }
        }
        return outcome;

    }

public void addTranscriptEntry(TranscriptEntry te) {

        trasncriptEntries.add(te);
}

public void display() {


    System.out.println("Transcript for: " + getStudentOwner().toString());

    if(transcriptEntries.size() == 0 ) {

        System.out.println("(No entries)");
    }
    else for(TranscriptEntry te: transcriptEntries) {

        Section sec = te.getSection();

        Course c = sec.getRepresentedCourse();

        ScheduleOfClasses soc = sec.getOfferedIn();

        System.out.println("Semester: " + soc.getSemester());

        System.out.println("Course No.: " + c.getCourseNo());

        System.out.println("Credits: " + c.getCredits());
        System.out.println("Grade Received : " + te.getGrade());

        System.out.println("-----------------");


    }
    }

}
