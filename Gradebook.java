import java.io.*;

public class Gradebook {

    /* ATTRIBUTES *******************************************************/
    private String[] Roster;
    private String[] Assignments;
    private int[][] Grades;

    /* CONSTRUCTORS *****************************************************/
    /* Default constructor */
    public Gradebook() {}

    /* Constructor based on data from file */
    public Gradebook(String filename) throws FileNotFoundException, IOException {
        int numStudents = numLines(filename) - 1;
        String[] line;

        FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        Assignments = textReader.readLine().substring(21).split(",");
        Grades = new int[numStudents][Assignments.length];
        Roster = new String[numStudents];

        /* for each student, we fill out:
         *  	- the student's name in Roster
         *  	- the student's grades in the corresponding row of Grades
         */
        for (int i = 1; i <= numStudents; i++) {
            line = textReader.readLine().split(",");
            Roster[i - 1] = line[0] + " " + line[1];
            for (int j = 0; j < Assignments.length; j++) {
                Grades[i - 1][j] = Integer.parseInt(line[j + 2]);
            }
        }

        textReader.close();
    }

    public int numLines(String filename) throws FileNotFoundException, IOException {
        int lines = 0;
        FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        while (textReader.ready()) {
            textReader.readLine();
            lines++;
        }

        textReader.close();
        return lines;
    }


    /* GETTERS AND SETTERS ***********************************************/
    /**
     * @return the roster
     */
    public String[] getRoster() {
        return Roster;
    }

    /**
     * @return the assignments
     */
    public String[] getAssignments() {
        return Assignments;
    }

    /**
     * @return the grades
     */
    public int[][] getGrades() {
        return Grades;
    }

    /**
     * @param roster the roster to set
     */
    public void setRoster(String[] roster) {
        Roster = roster;
    }

    /**
     * @param assignments the assignments to set
     */
    public void setAssignments(String[] assignments) {
        Assignments = assignments;
    }

    /**
     * @param grades the grades to set
     */
    public void setGrades(int[][] grades) {
        Grades = grades;
    }

    /* OTHER METHODS *******************************************************/
    /* This is where your work starts
     * Please follow instructions below and in the lab description.
     */

    /* Method 1: named rowToString
     * 		• Inputs: an int value n that corresponds to a given row index
     * 			in Grades and an index in Roster.
     * 		• Output: a String corresponding to the row n taken in
     * 		• What it does: turns a given row into a string: student’s name followed
     * 			by this student’s grades, and finally this student’s average grade
     */
    public String rowToString(int n) {
        String result = "";
        result = Roster[n] + ", ";
        double sum =0.0;
        for(int i=0; i<Grades[n].length; i++){
            result += Grades[n][i] + " ";
            sum += Grades[n][i];
        }
        double avg = sum/Grades[n].length;
        result += (double)Math.round(avg*100)/100;
        return result;
    }

    /* Method 2: named averagePerAssignment
     * 		•	Inputs: nothing
     * 		•	Output: a 1D array of doubles of size Assignments.length
     * 		•	What it does: it computes and returns an array of the average
     * 				grades of all assignments, one average grade per assignment.
     */
    public double[] averagePerAssignment() {
        double[] result = new double[Assignments.length];
        for(int i=0; i<Grades[i].length;i++) {
            double sum = 0.0;
            for (int j = 0; j < Grades.length; j++){
                sum += Grades[j][i];
                if (j == Grades.length - 1) {
                    double avg = sum / Grades.length;
                    result[i] = (double) Math.round(avg * 100) / 100;
                }
            }
        }
        return result;
    }

    /* Method 3: named largestVariation
     * 		•	Inputs: nothing
     * 		•	Output: a string that corresponds to the name of a students
     * 		•	What it does: it checks, for each student, the variation between
     * 				their lowest and highest grade, and returns the name of the student
     * 				with the largest such variation.
     */
    public String largestVariation() {
        String result = "";
        double lowestG = 0.0;
        double highestG = 0.0;
        double variation = 0.0;
        double greatestV = 0.0;

        for(int i=0; i< Grades.length; i++){
            for(int j=0; j<Grades[i].length; j++){
                if(j == 0) {
                    lowestG = Grades[i][j];
                    highestG = Grades[i][j];
                }
                if(Grades[i][j] < lowestG){
                    lowestG = Grades[i][j];
                }
                if(Grades[i][j] > highestG){
                    highestG = Grades[i][j];
                }
                variation = highestG - lowestG;
            }
            if(variation> greatestV){
                greatestV=variation;
                result = Roster[i];
            }
        }
        return result;
    }

    /* Method 4: named sortStudentsByAverage
     * 		•	Inputs: nothing
     * 		•	Output: nothing
     * 		•	What it does: it sorts the students by highest to lowest average
     * 				of their grades. The execution of this method results in a reordering
     * 				of the Roster array as well as a corresponding reordering of the Grades
     * 				array, so that the rows of Grades still correspond to the correct student.
     * 		•	Note: you should use insertion sort.
     */
    public void sortStudentsByAverage() {
        //1st Calculate averages and store in array that matches the index for each student
        double[] avgs = new double[Roster.length];
        double sum= 0.0;
        double avg= 0.0;
        for(int i=0; i< Grades.length; i++){
            for(int j=0; j<Grades[i].length; j++){
                sum+= Grades[i][j];
            }
            avg = sum/Grades[i].length;
            avgs[i]= avg;
        }
        //Work with average to sort Grades and Roster using avgs index


    }

    /* Method 5: named sortStudentsByName
     * 		•	Inputs: nothing
     * 		•	Output: nothing
     * 		•	What it does: it sorts the students by alphabetical order of their last names
     * 				then first names (like a phone book or a dictionary). The execution of
     * 				this method results in a reordering of the Roster array as well as a
     * 				corresponding reordering of the Grades array, so that the rows of Grades
     * 				still correspond to the correct student.
     * 		•	Note: you should use selection sort.
     */
    public void sortStudentsByName() {
        // Your code goes here
    }

}
