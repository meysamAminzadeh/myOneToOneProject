package model.BL.to;

import model.BL.to.MobileTO;

public class PersonTO {


    private long id;
    private String name;
    private String family;
    private MobileTO mobileTO;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public MobileTO getMobileTO() {
        return mobileTO;
    }

    public void setMobileTO(MobileTO mobileTO) {
        this.mobileTO = mobileTO;
    }








}
