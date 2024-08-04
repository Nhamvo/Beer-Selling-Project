/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import view.ViewThuongHieu;
import viewmodels.ThuongHieuViewModel;

/**
 *
 * @author Nham
 */
public interface ThuongHieuService {

    public List<ThuongHieuViewModel> getList();

    public String Add(ThuongHieuViewModel n);

}
