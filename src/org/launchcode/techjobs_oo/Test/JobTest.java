package org.launchcode.techjobs_oo.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class JobTest {
    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;
    Job test_job5;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @Before
    public void createOnlyJobId(){
        test_job1 = new Job();
        test_job2 = new Job();
    }

    @Test
    public void testSettingJobId(){
        assertNotEquals(test_job1, test_job2);
    }

    @Before
    public void createTestJob(){
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals(test_job3.getName(), "Product tester");
        assertTrue(test_job3 instanceof Job);
        assertTrue(test_job3.getEmployer() instanceof Employer);
        assertTrue(test_job3.getLocation() instanceof Location);
        assertTrue(test_job3.getPositionType() instanceof PositionType);
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(test_job3.getEmployer().getValue(), "ACME");
        assertEquals(test_job3.getLocation().getValue(), "Desert");
        assertEquals(test_job3.getPositionType().getValue(), "Quality control");
        assertEquals(test_job3.getCoreCompetency().getValue(), "Persistence");
    }

    @Before
    public void createFieldIdenticalJobs(){
        test_job4 = new Job("name", new Employer("employer"), new Location("location"),
                new PositionType("Position type"), new CoreCompetency("Core"));
        test_job5 = new Job("name", new Employer("employer"), new Location("location"),
                new PositionType("Position type"), new CoreCompetency("Core"));
    }

    @Test
    public void testJobsForEquality(){
        assertNotEquals(test_job4, test_job5);
    }

    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams(){
        System.setOut(originalOut);
    }

    @Test
    public void jobToString(){
        String testString = test_job1.toString();
        assertEquals(testString.charAt(0), '\n');
        assertEquals(testString.charAt(testString.length()-1), '\n');
    }

    @Test
    public void jobToString2(){
        assertEquals(test_job1.toString(), "\nOOPS! This job does not seem to exist.\n");
    }

    @Test
    public void jobToString3(){
        assertEquals(test_job4.toString(), "\nID: " + test_job4.getId() + '\n' + "Name: " + test_job4.getName()
                + "\n" + "Employer: " + test_job4.getEmployer().toString() + '\n' + "Location: " + test_job4.getLocation().toString() + '\n' +
                "Position Type: " + test_job4.getPositionType().toString() + '\n' + "Core Competency: " + test_job4.getCoreCompetency().toString() + '\n');
    }
}
