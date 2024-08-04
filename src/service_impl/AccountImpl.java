/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import javax.swing.JOptionPane;
import repositoties.Account;
import service.AccountService;
import view.TrangChu;

/**
 *
 * @author Nham
 */
public class AccountImpl implements AccountService {

    Account rs = new Account();

    @Override
    public int showAccount(String name, String passWord) {

        return rs.showAccount(name, passWord);

    }

    @Override
    public int checkEmail(String email) {
        return rs.checkEmail(email);
    }

    @Override
    public int signUp(String name, String email, String matkhau) {
        return rs.signUp(name, email, matkhau);
    }

}
