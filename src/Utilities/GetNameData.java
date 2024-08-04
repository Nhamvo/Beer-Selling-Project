/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

/**
 *
 * @author khact
 */
public class GetNameData{

    public static String getLastName(String name) {
        String lastName = name.substring(0, name.indexOf(" "));
        return lastName;
    }

    public static String getFirstName(String name) {
        String firstName = name.substring(name.lastIndexOf(" "), name.length());
        return firstName;
    }

    public static String getMiddleName(String name) {
        String MiddleName = name.substring(name.indexOf(" "), name.lastIndexOf(" "));
        return MiddleName;
    }
    
}
