/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

/**
 *
 * @author Nham
 */
public interface AccountService {

    int showAccount(String name, String passWord);

    int checkEmail(String email);

    int signUp(String name, String email, String matkhau);

}
