package org.launchcode.techjobs_oo.Test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;
    Job test_job5;


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
}
