package com.project.perioddiary;

public class doctoruserclass {

    String demail ,dpassword ,dfullname,dmobilenumber ,dcity;

    public doctoruserclass() {

    }

    public doctoruserclass(String demail, String dpassword, String dfullname, String dmobilenumber, String dcity) {
        this.demail = demail;
        this.dpassword = dpassword;
        this.dfullname = dfullname;
        this.dmobilenumber = dmobilenumber;
        this.dcity = dcity;
    }

    public String getDemail() {
        return demail;
    }

    public void setDemail(String demail) {
        this.demail = demail;
    }

    public String getDpassword() {
        return dpassword;
    }

    public void setDpassword(String dpassword) {
        this.dpassword = dpassword;
    }

    public String getDfullname() {
        return dfullname;
    }

    public void setDfullname(String dfullname) {
        this.dfullname = dfullname;
    }

    public String getDmobilenumber() {
        return dmobilenumber;
    }

    public void setDmobilenumber(String dmobilenumber) {
        this.dmobilenumber = dmobilenumber;
    }

    public String getDcity() {
        return dcity;
    }

    public void setDcity(String dcity) {
        this.dcity = dcity;
    }
}
