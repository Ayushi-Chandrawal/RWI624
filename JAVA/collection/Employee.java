package COLLECTION;

public class Employee {
    public int eid;
    public String eName;
    public String ePosition;

    public Employee(int eid, String eName, String ePosition) {
        this.eid = eid;
        this.eName = eName;
        this.ePosition = ePosition;
    }

    public Employee() {
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getePosition() {
        return ePosition;
    }

    public void setePosition(String ePosition) {
        this.ePosition = ePosition;
    }

    @Override
    public String toString() {
        return "employee{" +
                "eid=" + eid +
                ", eName='" + eName + '\'' +
                ", ePosition='" + ePosition + '\'' +
                '}';
    }
}
