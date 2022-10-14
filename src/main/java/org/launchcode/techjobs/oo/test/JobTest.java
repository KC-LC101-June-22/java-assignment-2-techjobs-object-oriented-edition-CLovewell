package org.launchcode.techjobs.oo.test;

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

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertNotNull(job.getName());
        assertEquals(job.getName(), "Product tester");
        assertNotNull(job.getEmployer());
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertNotNull(job.getLocation());
        assertEquals(job.getLocation().getValue(), "Desert");
        assertNotNull(job.getPositionType().getValue());
        assertEquals(job.getPositionType().getValue(), "Quality Control");
        assertNotNull(job.getCoreCompetency());
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertNotEquals(job1, job2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        String str = job.toString();
        assertEquals(str.charAt(0), '\n');
        assertEquals(str.charAt(str.length()-1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
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

    @Test
    public void testToStringHandlesEmptyField() {
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

    @Test
    public void testToStringHandlesJobWithOnlyIDField() {
        Job job = new Job();
        String str = job.toString();
        assertEquals(str, "OOPS! This job does not seem to exist.");
    }
}
