package domain;

public class Readers {

    private long id;
    private String firstName;
    private String lastName;
    private Integer mobilePhone;
    private String address;

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
}
