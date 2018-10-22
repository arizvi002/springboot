package ammar;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "balance")
    private int balance;
    public Employee() { }
    public Employee(int balance) {
        this.setBalance(balance);
    }
    public Employee(int id, int balance) {
        this.setId(id);
        this.setBalance(balance);

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", balance='" + balance + '\'' +
                '}';
    }
}
