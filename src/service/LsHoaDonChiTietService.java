/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodels.LsHoaDonChiTietViewModel;

/**
 *
 * @author Nham
 */
public interface LsHoaDonChiTietService {

    List<LsHoaDonChiTietViewModel> lists(String idHoaDon);

}