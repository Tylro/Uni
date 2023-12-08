/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author phamh
 */
public class Book {
    private int ID;
    private String name;
    private int author_id;
    private int  release_year;
    
    public Book(){
        super();
    };

    public Book(int ID) {
        this.ID = ID;
    }

    
    public Book(String name, int author_id, int release) {
        this.name = name;
        this.author_id = author_id;
        this.release_year = release;
    }

    public Book(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Book(int ID, String name, int author_id) {
        this.ID = ID;
        this.name = name;
        this.author_id = author_id;
    }

    public Book(int ID, String name, int author_id, int release) {
        this.ID = ID;
        this.name = name;
        this.author_id = author_id;
        this.release_year = release;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public int getRelease() {
        return release_year;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public void setRelease(int release) {
        this.release_year = release;
    }

    @Override
    public String toString() {
        return "Book{" + "ID=" + ID + ", name=" + name + ", author_id=" + author_id + ", release=" + release_year + '}';
    }


    
    
}
