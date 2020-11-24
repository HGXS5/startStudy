package test;

import java.util.Date;

public class Person {
    private Integer id;
    private String name = "小三";
    private Integer age;
    private Date startDate;
    private Date endDate;
    private String work;

    public Person(Integer id, String name, Integer age, Date startDate, Date endDate, String work) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.startDate = startDate;
        this.endDate = endDate;
        this.work = work;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", work='" + work + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
