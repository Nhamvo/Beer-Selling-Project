/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Nham
 */
public class TheTichViewModel {

    private String id;
    private String theTich;

    public TheTichViewModel() {
    }

    public TheTichViewModel(String id, String theTich) {
        this.id = id;
        this.theTich = theTich;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTheTich() {
        return theTich;
    }

    public void setTheTich(String theTich) {
        this.theTich = theTich;
    }

    public Object[] dataRow() {
        return new Object[]{id, theTich};
    }

}
