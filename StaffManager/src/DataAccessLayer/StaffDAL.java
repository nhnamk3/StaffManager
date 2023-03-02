package DataAccessLayer;

import DataTransferObject.StaffDTO;

import java.sql.*;
import java.util.ArrayList;

public class StaffDAL {
    Connection connectDB = DbConnector.openConnector("staff_manager", "root", "");
    public boolean insert(StaffDTO staffDTO) {
        String sqlAdd = "INSERT INTO staff VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement cmd = connectDB.prepareStatement(sqlAdd);
            cmd.setInt(1, staffDTO.getStaffID());
            cmd.setString(2, staffDTO.getName());
            cmd.setDate(3, staffDTO.getDateBirth());
            cmd.setString(4, staffDTO.getPosition());
            cmd.setString(5, staffDTO.getUserName());
            cmd.setString(6, staffDTO.getPassword());
            boolean isSuccess = cmd.execute();
            return isSuccess;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(int staffID, StaffDTO staffDTO) {
        if (!delete(staffID)) return false;
        if (!insert(staffDTO)) return false;
        return true;
    }

    public boolean delete(int staffID) {
        if (getStaff(staffID) == null)  return false;
        try {
            String sqlDel = "DELETE FROM staff WHERE ID = ?";
            PreparedStatement cmd = connectDB.prepareStatement(sqlDel);
            cmd.setInt(1, staffID);
            cmd.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    ArrayList<StaffDTO> getAll() {
        ArrayList<StaffDTO> staffList = new ArrayList<>();
        Statement statement ;
        try {
            statement = connectDB.createStatement();
            String sqlSelectAll = "SELECT * FROM staff";
            ResultSet sqlResultAll = statement.executeQuery(sqlSelectAll);
            while (sqlResultAll.next()) {
                int staffID = sqlResultAll.getInt("ID");
                String staffName = sqlResultAll.getString("Họ và Tên");
                Date dateBirth = sqlResultAll.getDate("Ngày sinh");
                String position = sqlResultAll.getString("Chức vụ");
                String userName = sqlResultAll.getString("Tài khoản");
                String password = sqlResultAll.getString("Mật khẩu");
                staffList.add(new StaffDTO(staffID, staffName, dateBirth, position, userName, password));
            }
            return staffList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    StaffDTO getStaff(int staffID) {
        ArrayList<StaffDTO> staffList = getAll();
        for (StaffDTO staffDTO : staffList) {
            if (staffID == staffDTO.getStaffID()) {
                return staffDTO;
            }
        }
        return null;
    }
    public boolean checkLogin(String userName, String password) {
        String sqlCheck = "SELECT * FROM staff WHERE `Tài khoản` = " + userName + " and " + " `Mật khẩu` = " + password;
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCheck);
            if (resultSet.next()) return true;
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
