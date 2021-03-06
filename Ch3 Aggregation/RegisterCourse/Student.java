package Aggregation;

import java.text.DecimalFormat;

public class Student {
    private long stdId;
    private String stdName;
    private RegisteredCourse[] regisCourse;
    private Address stdAddr;

    public Student(long stdId, String stdName, RegisteredCourse[] regisCourse, Address stdAddr) {
        this.stdId = stdId;
        this.stdName = stdName;
        this.regisCourse = regisCourse;
        this.stdAddr = stdAddr;
    }

    public long getStdId() {
        return stdId;
    }

    public void setStdId(long stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public RegisteredCourse[] getRegisCourse() {
        return regisCourse;
    }

    public void setRegisCourse(RegisteredCourse[] regisCourse) {
        this.regisCourse = regisCourse;
    }

    public Address getStdAddr() {
        return stdAddr;
    }

    public void setStdAddr(Address stdAddr) {
        this.stdAddr = stdAddr;
    }

    public double gpax(){
        DecimalFormat fmt = new DecimalFormat("0.##");
        double gpax;
        int count = regisCourse.length;
        double sumCourse=0;
        double allCredit=0;
        for(int i=0;i<count;i++){
            allCredit=allCredit+regisCourse[i].getCourseCredit();
        }
        for(int j=0;j<count;j++){
            sumCourse=sumCourse+(regisCourse[j].getGrade()*regisCourse[j].getCourseCredit());
        }
        gpax=sumCourse/allCredit;
        gpax=Double.parseDouble(fmt.format(gpax));
        return gpax;
    }
    
    @Override
    public String toString() {
        return "Student{" + "stdId=" + stdId + ", stdName=" + stdName + ", regisCourse=" + regisCourse + ", stdAddr=" + stdAddr + '}';
    }
    
}
