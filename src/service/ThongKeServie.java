/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodels.ThongKeViewModel;

/**
 *
 * @author Nham
 */
public interface ThongKeServie {

    List<ThongKeViewModel> getListThongKe(String sql);

    String kq(String kq);

}
