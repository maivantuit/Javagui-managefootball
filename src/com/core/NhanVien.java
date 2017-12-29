package com.core;

import java.util.Date;

/**
 *
 * @author CỌP
 */
public class NhanVien implements IDoiBong{
    private String tenNhanVien;
    private String quocTich;
    private Boolean gioiTinh;
    private Date ngaySinh, ngayVaoLam;    
    public NhanVien() {
    }

    public NhanVien(String tenNhanVien, String quocTich, Boolean gioiTinh, Date ngaySinh, Date ngayVaoLam) {
        this.tenNhanVien = tenNhanVien;
        this.quocTich = quocTich;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
    }  
    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }   
    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
    //get lại các thuộc tính của interface IDoiBong, set không được. 
     public static double getPHU_CAP_MOT_NAM() {
        return PHU_CAP_MOT_NAM;
    }

    public static double getLUONG_CO_BAN() {
        return LUONG_CO_BAN;
    }
    private double tinhThamNien(){
        return (new Date().getTime()-ngayVaoLam.getTime())/(365*24*60*60)/1000;
    }
    private double tinhPhuCapThamNienm(){
        return tinhThamNien()*PHU_CAP_MOT_NAM;
    }
    @Override
    public double tinhLuong() {// vì phương thức này thừa kế từ IDoiBong, nên ghi đè phương thức tinhLuong() của interface IDoiBong
        return tinhPhuCapThamNienm();
    }
}
