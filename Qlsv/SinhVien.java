/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Qlsv;

import java.io.Serializable;

/**
 *
 * @author maithuyha
 */
public class SinhVien implements Serializable{
    String maSV;
    String hoTen;
    String gioiTinh;
    String ngaySinh;
    double dtb;

    public SinhVien() {
    }

    public SinhVien(String maSV, String hoTen, String gioiTinh, String ngaySinh, double dtb) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.dtb = dtb;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "maSV=" + maSV + 
                ", hoTen=" + hoTen + 
                ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", dtb=" + dtb + '}';
    }
}




