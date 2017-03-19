package test;

/**
 * Created by honaf on 2017/3/15.
 */

@Table("programmer")
public class Programmer {
    @Column(value = "id")
    public String id;
    @Column("name")
    public String name;
    @Column(value = "age", age = 25)
    public int age;

    public Programmer(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
