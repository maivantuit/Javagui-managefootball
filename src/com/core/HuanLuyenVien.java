package com.core;

import java.util.Date;

/**
 *
 * @author CỌP
 */
public class HuanLuyenVien extends NhanVien{
    private int soNamKinhNghiem;
    private double hesoLuong, phuCap;

    public HuanLuyenVien() {
    }
    
    public HuanLuyenVien(int soNamKinhNghiem, double hesoLuong, double phuCap, String tenNhanVien, String quocTich, Boolean gioiTinh, Date ngaySinh, Date ngayVaoLam) {
        super(tenNhanVien, quocTich, gioiTinh, ngaySinh, ngayVaoLam);
        this.soNamKinhNghiem = soNamKinhNghiem;
        this.hesoLuong = hesoLuong;
        this.phuCap = phuCap;
    }

    public HuanLuyenVien(int parseInt, double parseDouble, double parseDouble0, int parseInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getSoNamKinhNghiem() {
        return soNamKinhNghiem;
    }

    public double getHesoLuong() {
        return hesoLuong;
    }

    public double getPhuCap() {
        return phuCap;
    }
    // 2 methods get của 2 thuộc tính interface IDoiBong, HuanLuyenVien extends NhanVien implements IDoiBong.
    public static double getPHU_CAP_MOT_NAM() {
        return PHU_CAP_MOT_NAM;
    }

    public static double getLUONG_CO_BAN() {
        return LUONG_CO_BAN;
    }

    public void setSoNamKinhNghiem(int soNamKinhNghiem) {
        this.soNamKinhNghiem = soNamKinhNghiem;
    }

    public void setHesoLuong(double hesoLuong) {
        this.hesoLuong = hesoLuong;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }
     @Override
    public double tinhLuong() {
        return super.tinhLuong() + hesoLuong*LUONG_CO_BAN+ phuCap; 
    }
    
}
