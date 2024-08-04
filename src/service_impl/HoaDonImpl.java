/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import repositoties.HoaDonRepository;
import service.HoaDonService;
import viewmodels.HoaDonViewModel;

/**
 *
 * @author Nham
 */
public class HoaDonImpl implements HoaDonService {

    private HoaDonRepository hd = new HoaDonRepository();

    @Override
    public String dateTime() {
        Date now = new Date();

// Chuyển đổi sang chuỗi thời gian theo định dạng
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = formatter.format(now);
        return formattedDate;
    }

    @Override
    public String dinhDangTien(float k) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        String formattedNumber = decimalFormat.format(k);
        return formattedNumber;
    }

    @Override
    public void insert(HoaDonViewModel h) {
        hd.add(h);

    }
}
