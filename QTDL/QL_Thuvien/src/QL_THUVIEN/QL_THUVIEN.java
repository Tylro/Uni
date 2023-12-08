/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QL_THUVIEN;

import dao.AuthorDAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.Author;
import dao.BookDAO;
import model.Book;

/**
 *
 * @author phamh
 */
public class QL_THUVIEN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Danh sach chuc nang:");
        System.out.printf("%-3s%-30s%-3s%-30s\n", "1.", "Them Tac gia moi", "7.", "Them Sach moi");
        System.out.printf("%-3s%-30s%-3s%-30s\n", "2.", "Thay doi thong tin Tac gia", "8.", "Sua thong tin Sach");
        System.out.printf("%-3s%-30s%-3s%-30s\n", "3.", "Xoa Tac gia", "9.", "Xoa Sach");
        System.out.printf("%-3s%-30s%-3s%-30s\n", "4.", "Tim ten Tac gia theo ID", "10.", "Tim Sach theo ID");
        System.out.printf("%-3s%-30s%-3s%-30s\n", "5.", "Tim ten Tac gia theo nam sinh", "11.", "Tim Sach theo nam xuat ban");
        System.out.printf("%-3s%-30s%-3s%-30s\n", "6.", "Liet ke tat ca Tac gia", "12.", "Liet ke tat ca Sach");

        System.out.print("Nhap ma[1-12] chuc nang can thuc hien: ");
        String CN = scanner.nextLine();
        System.err.println(CN);
        System.out.flush();
        switch (CN) {
            case "1" -> {
                System.out.println("Nhap ten Tac gia moi:");
                String name = scanner.nextLine();
                System.out.println("Nhap nam sinh:");
                int birth = scanner.nextInt();
                Author tacgia = new Author(name, birth);
                AuthorDAO.getInstance().insert(tacgia);
            }
            case "2" -> {
                System.err.println("Nhap ID Tac gia can sua:");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.err.println("Nhap ten moi:");
                String name2 = scanner.nextLine();
                System.err.println("Nhap nam sinh moi:");
                int birth2 = scanner.nextInt();
                Author tacgia = new Author(id, name2, birth2);
                AuthorDAO.getInstance().update(tacgia);
            }

            case "3" -> {
                System.out.println("Nhap ID Tac gia muon xoa:");
                int id3 = scanner.nextInt();
                Author tacgia = new Author(id3);
                AuthorDAO.getInstance().delete(tacgia);
            }
            case "6" -> {
                ArrayList<Author> list = AuthorDAO.getInstance().selectAll();
                for (Author tacgia6 : list) {
                    System.err.println(tacgia6.toString());
                }
            }
            case "4" -> {
                System.out.println("Nhap ID Tac gia can tim:");
                int id4 = scanner.nextInt();
                Author find = new Author(id4);

                Author tacgia4 = AuthorDAO.getInstance().selectByID(find);
                System.out.println(tacgia4);
            }
            case "5" -> {
                System.out.println("Nhap nam sinh Tac gia can tim:");
                String nam = scanner.nextLine();
                ArrayList<Author> list = AuthorDAO.getInstance().selectByCondition(nam);
                for (Author tacgia : list) {
                    System.out.println(tacgia.toString());
                }
            }
            case "7" -> {
                System.out.println("Nhap ten Sach moi:");
                String name7 = scanner.nextLine();
                System.out.println("Nhap ID Tac gia:");
                int au_id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhap nam phat hanh:");
                int rl = scanner.nextInt();
                Book sach7 = new Book(name7, au_id, rl);
                BookDAO.getInstance().insert(sach7);
            }
            case "8" -> {
                System.out.println("Nhap ID Sach can sua:");
                int id8 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhap ten Sach:");
                String name8 = scanner.nextLine();
                System.out.println("Nhap ID Tac gia:");
                int au_id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhap nam phat hanh:");
                int rl = scanner.nextInt();
                Book sach = new Book(id8, name8, au_id, rl);
                BookDAO.getInstance().update(sach);
            }
            case "9" -> {
                System.out.println("Nhap ID Sach can xoa:");
                int id9 = scanner.nextInt();
                Book sach = new Book(id9);
                BookDAO.getInstance().delete(sach);
            }
            case "10" -> {
                System.out.println("Nhap ID Sach can tim:");
                int id5 = scanner.nextInt();
                Book find = new Book(id5);
                
                Book sach = BookDAO.getInstance().selectByID(find);
                System.out.println(sach);
            }
            case "11" -> {
                System.out.println("Nhap nam phat hanh Sach can tim:");
                String nam = scanner.nextLine();
                ArrayList<Book> list = BookDAO.getInstance().selectByCondition(nam);
                for (Book sach : list) {
                    System.out.println(sach.toString());
                }
            }
            case "12" -> {
                ArrayList<Book> list = BookDAO.getInstance().selectAll();
                for (Book sach : list) {
                    System.out.println(sach.toString());
                }
            }

        }

    }
}
