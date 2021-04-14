package com.project.perioddiary;

public class patientuserclass {
    String pemail ,ppassword ,pfullname,pmobilenumber ;

    public patientuserclass() {
           }

    public patientuserclass(String pemail, String ppassword, String pfullname, String pmobilenumber) {
        this.pemail = pemail;
        this.ppassword = ppassword;
        this.pfullname = pfullname;
        this.pmobilenumber = pmobilenumber;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    public String getPpassword() {
        return ppassword;
    }

    public void setPpassword(String ppassword) {
        this.ppassword = ppassword;
    }

    public String getPfullname() {
        return pfullname;
    }

    public void setPfullname(String pfullname) {
        this.pfullname = pfullname;
    }

    public String getPmobilenumber() {
        return pmobilenumber;
    }

    public void setPmobilenumber(String pmobilenumber) {
        this.pmobilenumber = pmobilenumber;
    }
}
