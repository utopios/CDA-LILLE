package exercice1;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IHM {
    private Scanner scanner;

    public  IHM() {
        scanner = new Scanner(System.in);
    }
    public void start() {
        String choix;
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    addStudentAction();
                    break;
                case "2":
                    getAllStudentsAction();
                    break;
                case "3":
                    getStudentsByClassIdAction();
                    break;
                case "4":
                    deleteStudentAction();
                    break;
            }
        }while (!choix.equals("0"));
    }

    private void menu() {
        System.out.println("1 - Ajouter un étudiant ");
        System.out.println("2 - Afficher la liste des étudiants");
        System.out.println("3 - Afficher les étudiants d'une classe");
        System.out.println("4 - Supprimer un étudiant");

    }

    private void addStudentAction()  {
        System.out.println("**** Ajouter un étudiant ****");
        System.out.print("Merci de saisir le nom : ");
        String lastName = scanner.nextLine();
        System.out.print("Merci de saisir le prénom : ");
        String firstName = scanner.nextLine();
        System.out.print("Merci de saisir la date du diplome : ");
        String dateDegreeString = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateDegree = null;
        try {
            dateDegree = dateFormat.parse(dateDegreeString);
        } catch (ParseException e) {
            dateDegree = new Date("01/01/2001");
        }
        System.out.print("Merci de saisir la classe : ");
        int classNumber = scanner.nextInt();
        scanner.nextLine();
        Student student = new Student(firstName, lastName, dateDegree, classNumber);
        try {
            if(student.save()) {
                System.out.println("Etudiant ajouté "+ student.getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getAllStudentsAction() {
        try {
            Student.getAll().forEach(e -> System.out.println(e));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getStudentsByClassIdAction() {
        try {
            System.out.print("Merci de saisir la classe : ");
            int classNumber = scanner.nextInt();
            scanner.nextLine();
            Student.getByClass(classNumber).forEach(e -> System.out.println(e));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteStudentAction() {
        System.out.print("Merci de saisir l'id de l'étudiant : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Student student = Student.getById(id);
            if(student != null) {
                if(student.delete()) {
                    System.out.println("Etudiant supprimé");
                }
            }
            else {
                System.out.println("Aucun étudiant avec cet id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

