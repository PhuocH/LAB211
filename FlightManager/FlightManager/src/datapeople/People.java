package datapeople;

import java.util.Date;

public abstract class People {
<<<<<<< HEAD
    protected String id;
    protected String name;
    protected Date birthday;
=======
    private String id;
    private String name;
    private Date birthday;
    private Country country;
>>>>>>> 76195c2914f78230aa234ca9a2a1b9b42d018f98

    public People() {
        this.id = "";
        this.name = "";
    }
    
<<<<<<< HEAD
    public People(String id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
=======
    public People(String id, String name, Date birthday, String country) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.country = country;
>>>>>>> 76195c2914f78230aa234ca9a2a1b9b42d018f98
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

<<<<<<< HEAD
=======
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
>>>>>>> 76195c2914f78230aa234ca9a2a1b9b42d018f98

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", birthday=" + birthday + '}';
    }
}
