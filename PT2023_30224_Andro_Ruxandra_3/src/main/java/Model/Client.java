package Model;

public class Client {
    private int id;
    private String nume;
    private String email;
    private int age;

    public Client(String name,String email,int age)
    {
        this.nume=name;
        this.email=email;
        this.age=age;
    }

    public Client(int id,String name,String email,int age)
    {
        this.id=id;
        this.nume=name;
        this.email=email;
        this.age=age;
    }

    public Client()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
