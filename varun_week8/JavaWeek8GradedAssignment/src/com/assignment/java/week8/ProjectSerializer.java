package com.assignment.java.week8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProjectSerializer {
	
	Map<ProjectDetails, ArrayList<Employee>> projectMap1 = new HashMap<>();
    ArrayList<Employee> elist1 = new ArrayList<>();
    ArrayList<Employee> elist2 = new ArrayList<>();
    ArrayList<Employee> elist3 = new ArrayList<>();

    public ProjectSerializer() {
        // Initialize employee lists and project map
    }

    public void serializeProjectDetails(Map<ProjectDetails, ArrayList<Employee>> projectMap) {
        try (FileOutputStream fos = new FileOutputStream("projectData.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(projectMap);
            System.out.println("Serialized data is saved in projectData.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeProjectDetails() {
        try (FileInputStream fis = new FileInputStream("projectData.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            @SuppressWarnings("unchecked")
			Map<ProjectDetails, ArrayList<Employee>> projectMap = (Map<ProjectDetails, ArrayList<Employee>>) ois.readObject();
            for (Map.Entry<ProjectDetails, ArrayList<Employee>> entry : projectMap.entrySet()) {
                System.out.println("DeSerialized Data :");
                System.out.println("The Project " + entry.getKey() + " Has the following Employees");
                System.out.println("Employees .............");
                for (Employee employee : entry.getValue()) {
                    System.out.println(employee);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        ProjectSerializer projectSerializer = new ProjectSerializer();

        ProjectDetails project1 = new ProjectDetails("P1", "Music Synthesizer", 23);
        ProjectDetails project2 = new ProjectDetails("P2", "Vehicle Movement Tracker", 13);
        ProjectDetails project3 = new ProjectDetails("P3", "Liquid Viscosity Finder", 15);

        Employee e1 = new Employee("E001", "Harsha", "9383993933", "RTNagar", 1000);
        Employee e2 = new Employee("E002", "Harish", "9354693933", "Jayanagar", 2000);
        Employee e3 = new Employee("E003", "Meenal", "9383976833", "Malleswaram", 1500);
        projectSerializer.elist1.add(e1);
        projectSerializer.elist1.add(e2);
        projectSerializer.elist1.add(e3);

        Employee e4 = new Employee("E004", "Sundar", "9334593933", "Vijayanagar", 3000);
        Employee e5 = new Employee("E005", "Suman", "9383678933", "Indiranagar", 2000);
        Employee e6 = new Employee("E006", "Suma", "9385493933", "KRPuram", 1750);
        projectSerializer.elist2.add(e4);
        projectSerializer.elist2.add(e5);
        projectSerializer.elist2.add(e6);

        Employee e7 = new Employee("E007", "Chitra", "9383978933", "Koramangala", 4000);
        Employee e8 = new Employee("E008", "Suraj", "9383992133", "Malleswaram", 3000);
        Employee e9 = new Employee("E009", "Manu", "9345193933", "RTNagar", 2000);
        projectSerializer.elist3.add(e7);
        projectSerializer.elist3.add(e8);
        projectSerializer.elist3.add(e9);

        projectSerializer.projectMap1.put(project1, projectSerializer.elist1);
        projectSerializer.projectMap1.put(project2, projectSerializer.elist2);
        projectSerializer.projectMap1.put(project3, projectSerializer.elist3);

        projectSerializer.serializeProjectDetails(projectSerializer.projectMap1);
        projectSerializer.deserializeProjectDetails();
    }
    
}
