package com.core;

import java.util.Date;

/**
 *
 * @author CỌP
 */
public class CauThu extends NhanVien{
    private String viTriThiDau;
    private int soLuotTranThamGia, soBanThang;
    private double luongThoaThuan;
    public CauThu() {
    }
    public CauThu(String viTriThiDau, int soLuotTranThamGia, int soBanThang, double luongThoaThuan, String tenNhanVien, String quocTich, Boolean gioiTinh, Date ngaySinh, Date ngayVaoLam) {
        super(tenNhanVien, quocTich, gioiTinh, ngaySinh, ngayVaoLam);
        this.viTriThiDau = viTriThiDau;
        this.soLuotTranThamGia = soLuotTranThamGia;
        this.soBanThang = soBanThang;
        this.luongThoaThuan = luongThoaThuan;
    }

    public CauThu(String trim, int parseInt, int parseInt0, double parseDouble, String trim0, String trim1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getViTriThiDau() {
        return viTriThiDau;
    }

    public int getSoLuotTranThamGia() {
        return soLuotTranThamGia;
    }

    public int getSoBanThang() {
        return soBanThang;
    }

    public double getLuongThoaThuan() {
        return luongThoaThuan;
    }
    // 2 methods get của 2 thuộc tính interface IDoiBong, CauThu extends NhanVien implements IDoiBong.
    public static double getPHU_CAP_MOT_NAM() {
        return PHU_CAP_MOT_NAM;
    }

    public static double getLUONG_CO_BAN() {
        return LUONG_CO_BAN;
    }

    public void setViTriThiDau(String viTriThiDau) {
        this.viTriThiDau = viTriThiDau;
    }

    public void setSoLuotTranThamGia(int soLuotTranThamGia) {
        this.soLuotTranThamGia = soLuotTranThamGia;
    }

    public void setSoBanThang(int soBanThang) {
        this.soBanThang = soBanThang;
    }

    public void setLuongThoaThuan(double luongThoaThuan) {
        this.luongThoaThuan = luongThoaThuan;
    }
    @Override
    public double tinhLuong(){
        return super.tinhLuong() + luongThoaThuan;
    }
}
