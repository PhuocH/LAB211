package datapeople;

import java.util.Date;

public abstract class People {
    protected String id;
    protected String name;
    protected Date birthday;

    public People() {
        this.id = "";
        this.name = "";
    }
    
    public People(String id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
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


    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", birthday=" + birthday + '}';
    }
}
