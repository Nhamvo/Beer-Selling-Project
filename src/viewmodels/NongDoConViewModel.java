/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Nham
 */
public class NongDoConViewModel {

    private String id;
    private String nongDoCon;

    public NongDoConViewModel() {
    }

    public NongDoConViewModel(String id, String nongDoCon) {
        this.id = id;
        this.nongDoCon = nongDoCon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNongDoCon() {
        return nongDoCon;
    }

    public void setNongDoCon(String nongDoCon) {
        this.nongDoCon = nongDoCon;
    }

    public Object[] dataRow() {
        return new Object[]{id, nongDoCon};
    }

}
