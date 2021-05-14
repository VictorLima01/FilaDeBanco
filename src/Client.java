
public class Client {
    private String name;
    private int age;

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public boolean isElderly(){
        if(this.age >= 60){
            return true;
        }else {
            return false;
        }

    }

}