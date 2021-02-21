package domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "reader")
public class Reader {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="firstName")
    private String firstName;

    @Column(name ="lastName")
    private String lastName;

    @Column(name ="mobilePhone")
    private Integer mobilePhone;

    @Column(name ="address")
    private String address;


    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<Book> bookList;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(Integer mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

}
