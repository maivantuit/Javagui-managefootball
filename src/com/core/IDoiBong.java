package com.core;// pakage com.core
/**
 *
 * @author CỌP
 */
/*
        Interface IDoiBong
        -static final double PHU_CAP_MOT_NAM= 1000000
        -static final double LUONG_CO_BAN = 1150000
        +double tinhluong();
        
        Class NhanVien implements IDoiBong
        - private String tenNhanVien;
        - private String quocTich;
        - private Boolean gioiTinh;
        - private Date ngaySinh, ngayVaoLam;   
        + NhanVien(){}
        + NhanVien(String tenNhanVien, String quocTich,
            Boolean gioiTinh, Date ngaySinh, Date ngayVaoLam){}
         //Implements khong co super, thuoc tinh khong su dung trong constructor
         //cua class NhanVien.
        + get and set fields and memods
        + 2 methods get 2 field from interface IDoiBong
        + double tinhThamNien(){}
        + double tinhPhuCapThamNienm(){}
        + @override : double tinhluong(){}
        // methods have body, 'cause method of class.
        
        Class CauThu extends NhanVien
        - private String viTriThiDau;
        - private int soLuotTranThamGia, soBanThang;
        - private double luongThoaThuan;
        + CauThu(){}
        + CauThu (String viTriThiDau, int soLuotTranThamGia, int soBanThang,
                double luongThoaThuan, String tenNhanVien,String quocTich,
                Boolean gioiTinh, Date ngaySinh, Date ngayVaoLam){}
        //Have fields of base class and have super.namefields 
        + get and set and 2 set of interface IDoiBong
        + double tinhLuong(){}
        
        Class HuanLuyenVien extends NhanVien
        - private int soNamKinhNghiem;
        - private double hesoLuong, phuCap;
        + HuanLuyenVien(){}
        + HuanLuyenVien(int soNamKinhNghiem, double hesoLuong, double phuCap,
                String tenNhanVien, String quocTich, Boolean gioiTinh,
                Date ngaySinh, Date ngayVaoLam){}
         // 'Cause inheritace class cause have super call fields
        + get and set, 2 get of interface IDoiBong
        + Override ('cause iheritance class, class implements interface): double tinhLuong (){}
        

        + Tao CSDL bang Sevices
        + Ket noi file sqljdbc4 vao Libralies.
*/
public interface IDoiBong {    
    public static final double PHU_CAP_MOT_NAM = 1000000;
    public static final double LUONG_CO_BAN = 1150000;    
    public double tinhLuong();
}
