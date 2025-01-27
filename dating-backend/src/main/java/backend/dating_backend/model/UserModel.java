package backend.dating_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class UserModel {

    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private List<String> interests; // List to handle multiple interests

    public UserModel() {
    }

    // Constructor with fields
    public UserModel(String name, int age, String gender, List<String> interests) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.interests = interests;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", gender='" + gender + "', interests=" + interests + "}";
    }
}
