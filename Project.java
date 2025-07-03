import java.time.LocalDate;
//Rita Yousif
class Project {
    LocalDate startTime;
    LocalDate endTime;
    String projectName;


//this is the duration of the project with start time and end time
    public Project(LocalDate start, LocalDate end, String project) {
        this.startTime = start;
        this.endTime = end;
        this.projectName = project;
    }


}

