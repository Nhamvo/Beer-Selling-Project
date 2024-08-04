/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import java.util.List;
import repositoties.GioHangRepository;
import service.GioHangBarcodeService;
import viewmodels.GioHangBarCodeViewModel;

/**
 *
 * @author Nham
 */
public class GioHangBarcodeImpl implements GioHangBarcodeService {

    GioHangRepository rs = new GioHangRepository();

    @Override
    public List<GioHangBarCodeViewModel> getList(String ma) {
        return rs.getListGioHangBarCodeViewModels(ma);
    }

}
