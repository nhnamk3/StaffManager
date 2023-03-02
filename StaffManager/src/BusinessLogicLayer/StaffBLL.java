package BusinessLogicLayer;

import DataAccessLayer.StaffDAL;
import DataTransferObject.StaffDTO;

import java.sql.*;
import java.util.ArrayList;

public class StaffBLL {
    StaffDAL staffDAL = new StaffDAL();
    public boolean insert(StaffDTO staffDTO) {
        return staffDAL.insert(staffDTO);
    }

    public boolean update(int staffID, StaffDTO staffDTO) {
        return false;
    }

    public boolean delete(int personNumber) {
        return false;
    }

    ArrayList<StaffDTO> getAll() {
        ArrayList<StaffDTO> personList = new ArrayList<>();
        return personList;
    }

    public boolean checkLogin(String userName, String password) {
        return staffDAL.checkLogin(userName, password);
    }
}
