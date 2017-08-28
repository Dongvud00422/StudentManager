/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.studentsmanager;

import java.util.*;

/**
 *
 * @author Ducdongpro
 */
public class StudentsManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Students> student = new ArrayList<Students>();
        Students student01 = new Students("Nguyễn Văn A", "11/11/1111", "nva@fpt.vn");
        Students student02 = new Students("Tạ Văn B", "22/12/1222", "tvb@fpt.vn");
        Students student03 = new Students("Trần Văn C", "01/01/1900", "tvc@2gmail.com");
        student.add(student01);
        student.add(student02);
        student.add(student03);

        Scanner scan = new Scanner(System.in);
        String choice;
// print out menu
        for (;;) {
            System.out.println("\t Student Manager ");
            System.out.println("==============================");
            System.out.println("1. Display all students");
            System.out.println("2. Add student");
            System.out.println("3. Edit student info");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.println("==============================");
            System.out.print("Your choice : ");
            choice = scan.nextLine();
            switch (choice) {
                // print out all stuudent
                case "1":
                    System.out.println(" ");
                    for (Students s : student) {
                        System.out.println(s.getName() + " " + s.getEmail() + " " + s.getBirthday());
                    }
                    System.out.println("\nPress Enter to back the Menu");
                    scan.nextLine();

                    break;
                // add stuudent
                case "2":
                    System.out.print("How many student you wana add : ");
                    int addLength = scan.nextInt();
                    int maxLenght = student.size() + addLength;
                    scan.nextLine();
                    for (int i = student.size(); i < maxLenght; i++) {
                        System.out.print("Student Name : ");
                        String name = scan.nextLine();
                        System.out.print("Student email : ");
                        String email = scan.nextLine();
                        System.out.print("Student birthday : ");
                        String birthday = scan.nextLine();
                        Students newStudent = new Students(name, birthday, email);
                        student.add(newStudent);
                    }
                    System.out.println("Success !!!");
                    System.out.println("\nPress Enter to back the Menu");
                    scan.nextLine();
                    break;
                // edit student info
                case "3":
                    System.out.println("Find student by info (name, email) :");
                    String mod = scan.nextLine();
                    for (Students s : student) {
                        int index = student.indexOf(s);
                        if (mod.equalsIgnoreCase(s.getName()) || mod.equalsIgnoreCase(s.getEmail())) {
                            System.out.println("Student found : " + s.getName() + "   " + s.getEmail() + "    " + s.getBirthday());
                            System.out.println("Editing");
                            System.out.print("Name : ");
                            String name = scan.nextLine();
                            System.out.print("Email : ");
                            String email = scan.nextLine();
                            System.out.println("Birthday : ");
                            String birthday = scan.nextLine();
                            student.get(index).setName(name);
                            student.get(index).setEmail(email);
                            student.get(index).setBirthday(birthday);
                        }
                    }
                    break;
                // delete student by name or email
                case "4":
                    System.out.println("Find student by info (name, email) :");
                    String del = scan.nextLine();
                    for (Students s : student) {
                        int index = student.indexOf(s);
                        if (del.equalsIgnoreCase(s.getName()) || del.equalsIgnoreCase(s.getEmail())) {
                            System.out.println("Student found : " + s.getName() + "   " + s.getEmail() + "    " + s.getBirthday());
                            System.out.print("Press Y to DELETE , N to back the Menu : ");
                            String delChoice = scan.nextLine();
                            if (delChoice.equalsIgnoreCase("y")) {
                                student.remove(index);
                                System.out.println("Success !!! \n");

                            } else if (del.equalsIgnoreCase("n")) {
                                break;
                            }
                        }
                    }
                    break;
                // exit program
                case "5":
                    System.exit(0);
                default:
                    System.out.println("\nYour choice is not exist. Please try again !!!\n");
            }
        }
    }
}
