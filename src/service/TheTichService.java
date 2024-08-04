/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodels.TheTichViewModel;

/**
 *
 * @author Nham
 */
public interface TheTichService {

    public List<TheTichViewModel> getList();

    public String Add(TheTichViewModel n);
}
