/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Qlsv;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maithuyha
 */
public class XuLySinhVien {
    public void ghiFileSV(SinhVien sv){
        FileOutputStream fout = null;
        AppendObjectOutputStream out = null;
        try {
            File f = new File("sinhvien.txt");
            boolean isAppend = f.exists();
            fout = new FileOutputStream(f, isAppend);
            out = new AppendObjectOutputStream(fout, isAppend);
            
            //thuc hien ghi doi tuong vao file
            out.writeObject(sv);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fout.close();
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(XuLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<SinhVien> docFileSV(){
        FileInputStream fin = null;
        ObjectInputStream in = null;
        List<SinhVien> kq = new ArrayList<>();
        try {
            
            File f = new File("sinhvien.txt");
            boolean isCheck = true;
            fin = new FileInputStream(f);
            in = new ObjectInputStream(fin);
            while(isCheck){
                try {
                    SinhVien sv = (SinhVien) in.readObject();
                    kq.add(sv);
                } catch (EOFException e) {
                    isCheck=false;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XuLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fin.close();
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(XuLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return kq;
    }
}
