/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import viewmodels.HoaDonViewModel;

/**
 *
 * @author Nham
 */
public interface HoaDonService {

    String dateTime();

    String dinhDangTien(float k);

    void insert(HoaDonViewModel h);

}
