package com.learn.naval;


import javax.persistence.*;


@NamedQueries(
        {
                @NamedQuery(
                        name = "findUserByName",
                        query = "from User u"
                )
        }
)



@Entity

@Table(name = "u_table")
public class User {

    @Id
    private int id;
    private  String name,place;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
