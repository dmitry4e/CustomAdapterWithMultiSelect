package homework.che.studentsbook;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

public class Student implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String male;
    private String group;
    boolean isSelected;


    public Student(String firstName, String lastName, String male, String group) {
        Random r=new Random();
        this.id= r.nextInt(9999+1);
        this.firstName = firstName;
        this.lastName = lastName;
        this.male = male;
        this.group = group;
        this.isSelected=false;

    }

    public Student() {
        Random r=new Random();
        this.id= r.nextInt(9999+1);
        this.firstName = "";
        this.lastName = "";
        this.male = "";
        this.group = "";
        this.isSelected=false;
    }
    public Student(int id, String firstName, String lastName, String male, String group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.male = male;
        this.group = group;
        this.isSelected=false;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", male='" + male + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
