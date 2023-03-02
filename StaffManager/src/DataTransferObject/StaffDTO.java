package DataTransferObject;

import java.sql.Date;

public class StaffDTO {
    private int staffID;
    private String name;
    private Date dateBirth;
    private String userName;
    private String password;
    private String position;

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public StaffDTO() {
    }

    public StaffDTO(int staffID, String name, Date dateBirth, String position, String userName, String password) {
        this.staffID = staffID;
        this.name = name;
        this.dateBirth = dateBirth;
        this.userName = userName;
        this.password = password;
        this.position = position;
    }

    @Override
    public String toString() {
        return "staffDTO{" +
                "staffID=" + staffID +
                ", name='" + name + '\'' +
                ", dateBirth=" + dateBirth +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
