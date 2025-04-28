package cat.itacademy.s04.t02.n01.fruits;

import jakarta.persistence.*;

@Entity
@Table(name = "fruits")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int quantity;
    public Fruit(long id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Fruit() {
    }

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
