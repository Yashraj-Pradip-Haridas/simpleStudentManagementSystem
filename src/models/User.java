package models;

public class User {
    //    id, sname, sage, scity
    private int id;
    private String sname;
    private int sage;
    private String scity;

    public User(String scity, int sage, String sname, int id) {
        this.scity = scity;
        this.sage = sage;
        this.sname = sname;
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

