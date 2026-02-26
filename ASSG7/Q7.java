
import java.util.HashSet;

// At NITC, there are three popular student clubs: Debate Club, Coding Club, and Cycling
// Club. Students can join multiple clubs based on their interests. The Student Affairs Office
// needs a system to manage student memberships across these clubs efficiently. Your
// task is to design a club management system that ensures each student has only one
// Student object instance in memory, regardless of how many clubs they join. This
// prevents data redundancy and ensures consistency across all club memberships.
// Use a HashSet to manage the students and do the needful overriding in the Student
// class.

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id; // Assuming ID is unique for each student
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id); // Hash code based on unique ID
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', id=" + id + "}";
    }
}

class Club {
    public String clubName;
    private HashSet<Student> members;

    public String getClubName() {
        return clubName;
    }

    public Club(String clubName) {
        this.clubName = clubName;
        this.members = new HashSet<>();
    }

    public void addMember(Student student) {
        if (members.add(student)) {
            System.out.println(student + " has joined " + clubName);
        } else {
            System.out.println(student + " is already a member of " + clubName);
        }
    }

    public void displayMembers() {
        System.out.println("Members of " + clubName + ":");
        for (Student member : members) {
            System.out.println(member);
        }
    }
}

// ClubManager class to manage clubs and students

class ClubManager {
    private HashSet<Student> allStudents;
    private HashSet<Club> allClubs;

    public ClubManager() {
        this.allStudents = new HashSet<>();
        this.allClubs = new HashSet<>();
    }

    public void addStudent(Student student) {
        if (allStudents.add(student)) {
            System.out.println(student + " has been added to the system.");
        } else {
            System.out.println(student + " already exists in the system.");
        }
    }

    public void addClub(Club club) {
        if (allClubs.add(club)) {
            System.out.println(club + " has been added to the system.");
        } else {
            System.out.println(club + " already exists in the system.");
        }
    }

    public void enrollStudentInClub(Student student, Club club) {
        if (allStudents.contains(student) && allClubs.contains(club)) {
            club.addMember(student);
        } 
        else if(!allClubs.contains(club)){
            System.out.println(club + " does not exist in the system.");
        }
        else {
            System.out.println("Student does not exist in the system.");
        }
    }

    public Student findStudentById(int id) {
        for (Student student : allStudents) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Student not found
    }

    public Club findClubByName(String clubName) {
        for (Club club : allClubs) {
            if (club.getClubName().equals(clubName)) {
                return club;
            }
        }
        return null; // Club not found
    }
}

public class Q7 {
    
    public static void main(String[] args) {

        ClubManager clubManager = new ClubManager();

        clubManager.addClub( new Club("Debate Club"));
        clubManager.addClub( new Club("Coding Club"));
        clubManager.addClub( new Club("Cycling Club"));

        clubManager.addStudent(new Student("Alice", 1));
        clubManager.addStudent(new Student("Bob", 2));
        clubManager.addStudent(new Student("Charlie", 3));
        clubManager.addStudent(new Student("Alice", 1)); // This will not be added due to duplicate ID

        // Enroll students in clubs
        
        clubManager.enrollStudentInClub(clubManager.findStudentById(1), clubManager.findClubByName("Debate Club"));
        clubManager.enrollStudentInClub(clubManager.findStudentById(3), clubManager.findClubByName("Cycling Club"));
        clubManager.enrollStudentInClub(clubManager.findStudentById(2), clubManager.findClubByName("Coding Club"));
        clubManager.enrollStudentInClub(clubManager.findStudentById(1), clubManager.findClubByName("Coding Club")); // Alice joins Coding Club as well

        System.out.println("\nStudents in the club:");
        clubManager.findClubByName("Debate Club").displayMembers();
        clubManager.findClubByName("Coding Club").displayMembers();
        clubManager.findClubByName("Cycling Club").displayMembers();
    }
}
