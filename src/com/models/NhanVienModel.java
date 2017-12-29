package com.models;

import com.core.CauThu;
import com.core.HuanLuyenVien;
import com.core.NhanVien;
import com.database.Database;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author CỌP
 */
public class NhanVienModel {
    private int ID, soTranThamGia,soBanThang, soNamKinhNghiem, loaiNhanVien;
    private String tenNhanVien, quocTich, viTriThiDau;
    private Boolean gioiTinh;
    private Date ngaySinh, ngayVaoLam;
    private double luongThoaThuan, heSoLuong, phuCap;
    
    Database db = new Database();
    
    public NhanVienModel() {
    }

    public NhanVienModel(int ID, int soTranThamGia, int soBanThang, int soNamKinhNghiem, 
            int loaiNhanVien, String tenNhanVien, String quocTich, String viTriThiDau,
            Boolean gioiTinh, Date ngaySinh, Date ngayVaoLam, double luongThoaThuan, 
            double heSoLuong, double phuCap) {
        this.ID = ID;
        this.soTranThamGia = soTranThamGia;
        this.soBanThang = soBanThang;
        this.soNamKinhNghiem = soNamKinhNghiem;
        this.loaiNhanVien = loaiNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.quocTich = quocTich;
        this.viTriThiDau = viTriThiDau;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.luongThoaThuan = luongThoaThuan;
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }

    public int getID() {
        return ID;
    }

    public int getSoTranThamGia() {
        return soTranThamGia;
    }

    public int getSoBanThang() {
        return soBanThang;
    }

    public int getSoNamKinhNghiem() {
        return soNamKinhNghiem;
    }

    public int getLoaiNhanVien() {
        return loaiNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public String getViTriThiDau() {
        return viTriThiDau;
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

    public double getLuongThoaThuan() {
        return luongThoaThuan;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public Database getDb() {
        return db;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setSoTranThamGia(int soTranThamGia) {
        this.soTranThamGia = soTranThamGia;
    }

    public void setSoBanThang(int soBanThang) {
        this.soBanThang = soBanThang;
    }

    public void setSoNamKinhNghiem(int soNamKinhNghiem) {
        this.soNamKinhNghiem = soNamKinhNghiem;
    }

    public void setLoaiNhanVien(int loaiNhanVien) {
        this.loaiNhanVien = loaiNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public void setViTriThiDau(String viTriThiDau) {
        this.viTriThiDau = viTriThiDau;
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

    public void setLuongThoaThuan(double luongThoaThuan) {
        this.luongThoaThuan = luongThoaThuan;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }

    public void setDb(Database db) {
        this.db = db;
    }
    public int add(NhanVien nv, int id){
        if(nv instanceof CauThu){
            CauThu cauThu = (CauThu)nv;
            return db.themNhanVien(id, cauThu.getTenNhanVien(), cauThu.getQuocTich(),
                    cauThu.getGioiTinh(), cauThu.getNgaySinh(), cauThu.getNgayVaoLam(), 
                    ((CauThu) cauThu).getViTriThiDau(),((CauThu) cauThu).getSoLuotTranThamGia(), 
                    ((CauThu) cauThu).getSoBanThang(), ((CauThu) cauThu).getLuongThoaThuan(),
                    0,0, 0, 1);                    
                    
        }else{
            HuanLuyenVien huanLuyenVien = (HuanLuyenVien)nv;
            return db.themNhanVien(id, huanLuyenVien.getTenNhanVien(), huanLuyenVien.getQuocTich(),
                    huanLuyenVien.getGioiTinh(), huanLuyenVien.getNgaySinh(), 
                    huanLuyenVien.getNgayVaoLam(),"",0,0,0,huanLuyenVien.getSoNamKinhNghiem(),
                    huanLuyenVien.getHesoLuong(),huanLuyenVien.getPhuCap(),2);
        }
    }
    
    public int update(NhanVien nv, int id){
        if(nv instanceof CauThu){
            CauThu cauThu = (CauThu)nv;
            return db.capNhatNhanVien(id, cauThu.getTenNhanVien(), cauThu.getQuocTich(),
                    cauThu.getGioiTinh(), cauThu.getNgaySinh(), cauThu.getNgayVaoLam(), 
                    ((CauThu) cauThu).getViTriThiDau(),((CauThu) cauThu).getSoLuotTranThamGia(), 
                    ((CauThu) cauThu).getSoBanThang(), ((CauThu) cauThu).getLuongThoaThuan(),
                    0,0, 0, 1);                    
                    
        }else{
            HuanLuyenVien huanLuyenVien = (HuanLuyenVien)nv;
            return db.capNhatNhanVien(id, huanLuyenVien.getTenNhanVien(), huanLuyenVien.getQuocTich(),
                    huanLuyenVien.getGioiTinh(), huanLuyenVien.getNgaySinh(), 
                    huanLuyenVien.getNgayVaoLam(),"",0,0,0,huanLuyenVien.getSoNamKinhNghiem(),
                    huanLuyenVien.getHesoLuong(),huanLuyenVien.getPhuCap(),2);
        }
    }
    public int delete(int id){
        return db.xoaNhanVien(id);
    }
    public ArrayList getAll(){
        return db.getAll();
    }
    public ArrayList getAllTheLoai(int loaiNhanVien){
        return db.getAllTheLoai(loaiNhanVien);
    }

    public void add(HuanLuyenVien huanLuyenVien) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(CauThu cauThu, boolean gioiTinh, Date convertStringToDate, Date convertStringToDate0, int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
