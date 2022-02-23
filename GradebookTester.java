import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GradebookTester {
    private Gradebook g;

    @Before
    public void setUp() throws Exception{
        g = new Gradebook("Gradebook.csv");
    }

    @Test
    public void rowToString() {
        String output = "Peter Parker, 62 96 62 62 99 67 71 74.14";
        assertEquals(output, g.rowToString(0));
    }

    @Test
    public void averagePerAssignment() {
        double [] E = {76.93, 80.93, 75.37, 80.27, 81.80, 80.53, 80.67};
        assertArrayEquals(E, g.averagePerAssignment(), 0.01);
    }

    @Test
    public void largestVariation() {
    }

    @Test
    public void sortStudentsByAverage() {
    }

    @Test
    public void sortStudentsByName() {
    }
}