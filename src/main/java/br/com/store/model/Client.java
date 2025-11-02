package br.com.store.model;

public class Client {
    private Integer id;
    private String name;
    private String email;
    private String contact;

    public Client(String name, String email, String contact) {
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    public Client(Integer id, String name, String email, String contact) {
        this(name, email, contact);
        this.id = id;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return this.contact;
    }
}
