package org.launchcode.techjobs.oo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        Job job3 = new Job("Ice cream tester", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));
        Job emptyJob = new Job();

        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        jobs.add(emptyJob);

        for (Job job : jobs){
            System.out.println(job);
            try {
                System.out.println("Employer id: " + job.getEmployer().getId());
            }
            catch (NullPointerException e) {
                System.out.println("This job has no assigned employer.");
            }
            try {
                System.out.println("Location id: " + job.getLocation().getId());
            }
            catch (NullPointerException e) {
                System.out.println("This job has no assigned location.");
            }
            try {
                System.out.println("Position type id: " + job.getPositionType().getId());
            }
            catch (NullPointerException e) {
                System.out.println("This job has no assigned position type.");
            }
            try {
                System.out.println("Core competency id: " + job.getCoreCompetency().getId());
            }
            catch (NullPointerException e) {
                System.out.println("This job has no assigned core competency.");
            }
        }
    }
}
