package characters;

public class Student {
    private String name;
    private String house;

    public Student(String name, String house) {
        this.name = name;
        this.house = house;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}
