/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import viewmodels.KhuyenMaiViewModel;

/**
 *
 * @author ADMIN
 */
public interface KhuyenMaiService {
    public ArrayList<KhuyenMaiViewModel>getList();
    public String Add(KhuyenMaiViewModel km);
    public String Update(KhuyenMaiViewModel km, String makhuyenmai);
    public ArrayList<KhuyenMaiViewModel>timKiemQlKhuyenMai(String timKiem);
    public ArrayList<KhuyenMaiViewModel>trangThai(int trangThai);
    
}
