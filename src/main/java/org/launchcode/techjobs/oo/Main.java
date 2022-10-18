package org.launchcode.techjobs.oo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            JobField jf1 = new Employer("Keebler");
            System.out.println(jf1.getType());
        }
        catch (DuplicateJobFieldException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            JobField jf2 = new Location("Miami");
            System.out.println(jf2.getType());
        }
        catch (DuplicateJobFieldException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            JobField jf3 = new CoreCompetency("Taste");
            System.out.println(jf3.getType());
        }
        catch (DuplicateJobFieldException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            JobField jf4 = new PositionType("Baker");
            System.out.println(jf4.getType());
        }
        catch (DuplicateJobFieldException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        for (JobField jf : JobField.database) {
            System.out.println("ID: " + jf.getId() + " ... Position: " +
                    (JobField.database.indexOf(jf) + 1) + " ... Value: " +
                    jf.getValue());
        }

    }
}
