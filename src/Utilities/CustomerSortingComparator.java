/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.util.Comparator;
import viewmodels.KhachHangViewModel;

/**
 *
 * @author khact
 */
public class CustomerSortingComparator implements Comparator<KhachHangViewModel> {

    @Override
    public int compare(KhachHangViewModel o1, KhachHangViewModel o2) {
        int firstName = GetNameData.getFirstName(o1.getTenKH()).compareToIgnoreCase(GetNameData.getFirstName(o2.getTenKH()));
        int middleName = GetNameData.getMiddleName(o1.getTenKH()).compareToIgnoreCase(GetNameData.getMiddleName(o2.getTenKH()));
        int lastName = GetNameData.getLastName(o1.getTenKH()).compareToIgnoreCase(GetNameData.getLastName(o2.getTenKH()));
        if (firstName == 0) {
            if (middleName == 0) {
                return lastName;
            } else {
                return middleName;
            }
        }
        return firstName;
    }
}
