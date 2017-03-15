package test;

/**
 * Created by honaf on 2017/3/15.
 */

@Table(value = "programmer")
public class Programmer {
    @Column(value = "id")
    public String id;
    @Column(value = "name")
    public String name;

    public Programmer(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
