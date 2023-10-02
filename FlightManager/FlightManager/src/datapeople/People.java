package datapeople;

import java.util.Date;

public abstract class People {
    private String id;
    private String name;
    private Date birthday;
    private Country country;

    public People() {
        this.id = "";
        this.name = "";
    }
    
    public People(String id, String name, Date birthday, String country) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", birthday=" + birthday + '}';
    }
}
