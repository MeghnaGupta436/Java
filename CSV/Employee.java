package Feb21.CSV;
import java.util.Date;

public class Employee {
    private int EMPLOYEE_ID;
    private String FIRST_NAME;
    private   String LAST_NAME;
    private String EMAIL;
    private   long PHONE_NUMBER;
    private String Date;
    private int JOB_ID;
    private   double SALARY;
    private String COMMISSION_PCT;
    int DEPARTMENT_ID;

    public Employee(int EMPLOYEE_ID, String FIRST_NAME, String LAST_NAME, String EMAIL, long PHONE_NUMBER, String date, int JOB_ID, double SALARY, String COMMISSION_PCT, int DEPARTMENT_ID) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.EMAIL = EMAIL;
        this.PHONE_NUMBER = PHONE_NUMBER;
        Date = date;
        this.JOB_ID = JOB_ID;
        this.SALARY = SALARY;
        this.COMMISSION_PCT = COMMISSION_PCT;
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }
    public Employee(int EMPLOYEE_ID,String FIRST_NAME,String LAST_NAME,double SALARY)
    {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.SALARY = SALARY;
    }
    public int getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public long getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public String getDate() {
        return Date;
    }

    public int getJOB_ID() {
        return JOB_ID;
    }

    public double getSALARY() {
        return SALARY;
    }

    public String getCOMMISSION_PCT() {
        return COMMISSION_PCT;
    }

    public int getDEPARTMENT_ID() {
        return DEPARTMENT_ID;
    }

    public void setEMPLOYEE_ID(int EMPLOYEE_ID) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public void setPHONE_NUMBER(long PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setJOB_ID(int JOB_ID) {
        this.JOB_ID = JOB_ID;
    }

    public void setSALARY(double SALARY) {
        this.SALARY = SALARY;
    }

    public void setCOMMISSION_PCT(String COMMISSION_PCT) {
        this.COMMISSION_PCT = COMMISSION_PCT;
    }

    public void setDEPARTMENT_ID(int DEPARTMENT_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }

    @Override
    public String toString() {
        return this.EMPLOYEE_ID+" "+this.FIRST_NAME+" "+this.LAST_NAME+" "+this.SALARY;
    }
}
