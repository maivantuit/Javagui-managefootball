package com.database;

import com.core.CauThu;
import com.core.HuanLuyenVien;
import com.core.NhanVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author CỌP
 */
public class Database {

    private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String URL = "jdbc:derby://localhost:1527/QUANLYDOIBONGDB [maivantu on MAIVANTU]";
    // Được lấy từ Services => Database => Star Sever => Create Database => Nhập số liệu bảng đó => Sau đó copy đường JDBC: paste ở trên
    private static final String USER = "maivantu";
    private static final String PASS = "953003";

    private Connection cnn = null;
    private ResultSet rs = null;

    private Connection openConnection() {
        try {
            cnn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnn;
    }

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (cnn != null) {
                cnn.close();
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Database() {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int themNhanVien(
            int id, String tenNhanien, String quocTich, Boolean gioiTinh, 
            Date ngaySinh, Date ngayVaoLam, String viTriThiDau, int soTranThamGia, 
            int soBanThang, double luongThoaThuan, int soNamKinhNghiem, 
            double heSoLuong, double phuCap, int loaiNhanVien
        ){
        int affectedRows = 0;
        
        String insertSQL = "INSERT INTO NHANVIEN VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            openConnection();
            PreparedStatement preStmt = cnn.prepareStatement(insertSQL);
            
            preStmt.setInt(1, id);
            preStmt.setString(2,tenNhanien);
            preStmt.setString(3, quocTich);
            preStmt.setBoolean(4, gioiTinh);
            preStmt.setString(5, convertDateToString(ngaySinh));
            preStmt.setString(6,convertDateToString(ngayVaoLam));
            preStmt.setString(7, viTriThiDau);
            preStmt.setInt(8, soTranThamGia);
            preStmt.setInt(9, soBanThang);
            preStmt.setDouble(10, luongThoaThuan);
            preStmt.setInt(11, soNamKinhNghiem);
            preStmt.setDouble(12, heSoLuong);
            preStmt.setDouble(13, phuCap);
            preStmt.setInt(14, loaiNhanVien);
            
            affectedRows = preStmt.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return affectedRows;
    }
    public int capNhatNhanVien(
            int id, String tenNhanien, String quocTich, Boolean gioiTinh, 
            Date ngaySinh, Date ngayVaoLam, String viTriThiDau, int soTranThamGia, 
            int soBanThang, double luongThoaThuan, int soNamKinhNghiem, 
            double heSoLuong, double phuCap, int loaiNhanVien
        ){
        int affectedRows = 0;
        
        String updateSQL = "UPDATE NHANVIEN SET TENNV = ?, QUOCTICH = ?,"
                + " GIOITINH=? , NGAYSINH=?, NGAYVAOLAM=?, VITRITHIDAU=?,"
                + " SOTRANTHAMGIA=?, SOBANTHANG==?, LUONGTHOATHUAN=?,"
                + "NAMKINHNGHIEM=?, HESOLUONG=?, PHUCAP=?, LOAINV=?,"
                + " WHERE ID=?";
        
        try {
            openConnection();
            PreparedStatement preStmt = cnn.prepareStatement(updateSQL);
            
            
            preStmt.setString(1,tenNhanien);
            preStmt.setString(2, quocTich);
            preStmt.setBoolean(3, gioiTinh);
            preStmt.setString(4, convertDateToString(ngaySinh));
            preStmt.setString(5,convertDateToString(ngayVaoLam));
            preStmt.setString(6, viTriThiDau);
            preStmt.setInt(7, soTranThamGia);
            preStmt.setInt(8, soBanThang);
            preStmt.setDouble(9, luongThoaThuan);
            preStmt.setInt(10, soNamKinhNghiem);
            preStmt.setDouble(11, heSoLuong);
            preStmt.setDouble(12, phuCap);
            preStmt.setInt(13, loaiNhanVien);
            preStmt.setInt(14, id);
            affectedRows = preStmt.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return affectedRows;
    }
    public int xoaNhanVien(int id){
        int affectedRows = 0;
        
        String deleteSQL = "DELETE FROM NHANVIEN WHERE ID=?";
        
        try {
            openConnection();
            PreparedStatement preStmt = cnn.prepareStatement(deleteSQL);                        
           preStmt.setInt(1, id);
            affectedRows = preStmt.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return affectedRows;
    }
    public ArrayList getAll() {
        //arrReturn chua hai danh sach: nhanViens va iDs
        ArrayList<ArrayList> arrReturn = new ArrayList<>();
        //nhanViens chua danh sach nhan vien lay duoc tu co so du lieu
        ArrayList<NhanVien> nhanViens = new ArrayList<>();
        //iDs chua danh sasch ID cua cac nhan vien lay duoc tu co so du lieju
        ArrayList<String> iDs = new ArrayList<>();
        
        String getAllSQL = "SELECT * FROM NHANVIEN";
        try {
            openConnection();
            Statement stmt = cnn.createStatement();
            rs = stmt.executeQuery(getAllSQL);
            addToArrayList(nhanViens,iDs, rs, -1);
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }        
        arrReturn.add(nhanViens);
        arrReturn.add(iDs);
        return arrReturn;
    }
    public ArrayList getAllTheLoai(int loaiNhanVien) {
        //arrReturn chua hai danh sach: nhanViens va iDs
        ArrayList<ArrayList> arrReturn = new ArrayList<>();
        //nhanViens chua danh sach nhan vien lay duoc tu co so du lieu
        ArrayList<NhanVien> nhanViens = new ArrayList<>();
        //iDs chua danh sasch ID cua cac nhan vien lay duoc tu co so du lieju
        ArrayList<String> iDs = new ArrayList<>();
        
        String getAllTheLoaiSQL = "SELECT * FROM NHANVIEN WHERE LOAINV= ?";
        try {
            openConnection();
            PreparedStatement preStmt = cnn.prepareStatement(getAllTheLoaiSQL);
            preStmt.setInt(1, loaiNhanVien); 
            
            rs = preStmt.executeQuery();
            addToArrayList(nhanViens,iDs, rs, loaiNhanVien);
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }        
        arrReturn.add(nhanViens);
        arrReturn.add(iDs);
        return arrReturn;
    }
    private String convertDateToString(Date d) {
        return new SimpleDateFormat("yyyy-mm-dd").format(d);
    }
    //truy van du lieu va them vao danh sasch nhanViens cac nhan vien tuong ung
    // Tu co so du lieu, dong thoi them cac ID cua cac ban ghi cua cac nhan vien
    // -1 dai dien cho viec khong chi dinh loai nhan vien trong qua trinh truy van
    private void addToArrayList(ArrayList<NhanVien> nhanViens, ArrayList<String> iDs, ResultSet rs, int loaiNhanVien) {
         int index =-1;         
         boolean empType = false;
         while(loaiNhanVien==-1){
             empType= true;
         }
        try {
            while(rs.next()){
                iDs.add(""+rs.getInt("ID"));
                if(empType){
                    loaiNhanVien = rs.getInt("LOAINV");
                }
                switch (loaiNhanVien) {
                    case 1:
                        nhanViens.add(new CauThu(rs.getString("VITRITHIDAU"),
                                rs.getInt("SOTRANTHAMGIA"),
                                rs.getInt("SOBANTHANG"),rs.getDouble("LUONGTHOATHUAN"),
                                rs.getString("TENNV"),
                                rs.getString("QUOCTICH"),rs.getBoolean("GIOITINH"),
                                rs.getDate("NGAYSINH"),
                                rs.getDate("NGAYVAOLAM") ));
                        break;
                    case 2:
                        nhanViens.add(new HuanLuyenVien(rs.getInt("NAMKINHNGHIEM"),
                                rs.getDouble("HESOLUONG"),rs.getDouble("PHUCAP"),rs.getString("TENNV"),
                                rs.getString("QUOCTICH"),rs.getBoolean("GIOITINH"),rs.getDate("NGAYSINH"),
                                rs.getDate("NGAYVAOLAM") ));
                        break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
