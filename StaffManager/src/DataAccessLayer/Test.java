package DataAccessLayer;

import DataTransferObject.StaffDTO;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        StaffDAL staffDAL = new StaffDAL();
        LocalDate localDate = LocalDate.of(2000, 1, 1);
        Date date = Date.valueOf(localDate);
        StaffDTO staffDTO = new StaffDTO(1, "Nguyễn Văn B", date, "Nhân viên", "nguyenVanB2000", "nvb000");
//        staffDAL.update(1, staffDTO);
//        staffDAL.insert(staffDTO);
        System.out.println(staffDAL.delete(16));
        /*ArrayList<StaffDTO> staffList = staffDAL.getAll();
        for (StaffDTO staff : staffList) {
            System.out.println(staff.toString());
        }*/
    }
}
