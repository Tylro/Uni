/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author phamh
 */
public class Author {
    private int ID;
    private String name;
    private int birth;
    
    public Author () {
        super();
    }

    public Author(int ID, String name, int birth) {
        this.ID = ID;
        this.name = name;
        this.birth = birth;
    }

    public Author(String name, int birth) {
        this.name = name;
        this.birth = birth;
    }

    public Author(int ID, int birth) {
        this.ID = ID;
        this.birth = birth;
    }

    public Author(int ID) {
        this.ID = ID;
    }

    public Author(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getBirth() {
        return birth;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Author{" + "ID=" + ID + ", name=" + name + ", birth=" + birth + '}';
    }
    
    
}
