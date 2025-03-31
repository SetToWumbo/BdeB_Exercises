import java.util.Random;

public class Test1 {
    public int numTest = 0;
    protected boolean passFail;
    protected String nomTest;
    protected double forceTest;
    public boolean testComplete;
    private String employeResponsable;
    private Random random = new Random();

    public Test1() {
        numTest++;
        nomTest = "Test";
        employeResponsable = "Personne";
    }

    public Test1(String nomTest, double forceTest, boolean testComplete, String employeResponsable) {
        numTest++;
        this.forceTest = forceTest;
        this.testComplete = testComplete;
        this.employeResponsable = employeResponsable;
    }


    public String getEmployeResponsable() {
        return employeResponsable;
    }

    public void setEmployeResponsable(String employeResponsable) {
        this.employeResponsable = employeResponsable;
    }

    public void tryTest() {
        passFail = random.nextBoolean();
    }


}