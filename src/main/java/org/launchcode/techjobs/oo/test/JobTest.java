package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;


/**
 * Created by LaunchCode
 */

@RunWith(JUnit4.class)
public class JobTest {

    @Before
    public void initialize() {

    }

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        try {
            Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                    new PositionType("Quality Control"), new CoreCompetency("Persistence"));
            assertNotNull(job.getName());
            assertEquals(job.getName(), "Product tester");
            assertNotNull(job.getEmployer());
            assertEquals(job.getEmployer().getValue(), "ACME");
            assertNotNull(job.getLocation());
            assertEquals(job.getLocation().getValue(), "Desert");
            assertNotNull(job.getPositionType());
            assertEquals(job.getPositionType().getValue(), "Quality Control");
            assertNotNull(job.getCoreCompetency());
            assertEquals(job.getCoreCompetency().getValue(), "Persistence");
        }
        catch (DuplicateJobFieldException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            fail("Tried to create duplicate job field");
        }
    }

    @Test
    public void testJobsForEquality() {
        try {
            Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                    new PositionType("Quality Control"), new CoreCompetency("Persistence"));

            Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                    new PositionType("Quality Control"), new CoreCompetency("Persistence"));
            assertNotEquals(job1, job2);
        }
        catch (DuplicateJobFieldException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            fail("Tried to create duplicate job field");
        }
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        try {
            Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                    new PositionType("Quality Control"), new CoreCompetency("Persistence"));

            String str = job.toString();
            assertEquals(str.charAt(0), '\n');
            assertEquals(str.charAt(str.length() - 1), '\n');
        }
        catch (DuplicateJobFieldException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            fail("Tried to create duplicate job field");
        }
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        try {
            Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                    new PositionType("Quality Control"), new CoreCompetency("Persistence"));
            String str = job.toString();
            str = str.substring(1, str.length() - 1);
            String[] fields = str.split("\n");
            assertEquals(6, fields.length);
            assertEquals("ID: " + job.getId(), fields[0]);
            assertEquals("Name: Product tester", fields[1]);
            assertEquals("Employer: ACME", fields[2]);
            assertEquals("Location: Desert", fields[3]);
            assertEquals("Position Type: Quality Control", fields[4]);
            assertEquals("Core Competency: Persistence", fields[5]);
        }
        catch (DuplicateJobFieldException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            fail("Tried to create duplicate job field");
        }
    }

    @Test
    public void testToStringHandlesEmptyField() {
        try {
            Job job = new Job();
            job.setCoreCompetency(new CoreCompetency("Persistence"));
            job.setLocation(new Location("Desert"));
            job.setName("Product tester");
            job.setPositionType(new PositionType("Quality Control"));
            String str = job.toString();
            str = str.substring(1, str.length() - 1);
            String[] fields = str.split("\n");
            assertEquals("Employer: Data not available", fields[2]);
        }
        catch (DuplicateJobFieldException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            fail("Tried to create duplicate job field");
        }
    }

    @Test
    public void testToStringHandlesJobWithOnlyIDField() {
        try {
            Job job = new Job();
            String str = job.toString();
            assertEquals(str, "\nOOPS! This job does not seem to exist.");
            job.setLocation(new Location(""));
            str = job.toString();
            assertEquals(str, "\nOOPS! This job does not seem to exist.");
        }
        catch (DuplicateJobFieldException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            fail("Tried to create duplicate job field");
        }
    }
}