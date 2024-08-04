/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import java.util.List;
import repositoties.GiamGiaThanhToanRepository;
import service.GiamGiaThanhToanService;
import viewmodels.GiamGiaThanhToanViewModel;

/**
 *
 * @author Nham
 */
public class GiamGiaThanhToanImpl implements GiamGiaThanhToanService {

    private GiamGiaThanhToanRepository rs = new GiamGiaThanhToanRepository();

    @Override
    public GiamGiaThanhToanViewModel searchBySdt(String timKiem, float tt) {
        return rs.timKiemSanPham(timKiem, tt);
    }

}
