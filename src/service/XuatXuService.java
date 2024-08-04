/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodels.XuatXu;
import java.util.ArrayList;
import java.util.List;
import viewmodels.XuatXuViewModel;

/**
 *
 * @author Nham
 */
public interface XuatXuService {

    public List<XuatXuViewModel> getList();

    public String Add(XuatXuViewModel n);

}
