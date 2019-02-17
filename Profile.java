import java.util.ArrayList;

/**
 * Zachery Van Es
 */
public class Profile {
    private String name;
    private String status;
    private ArrayList<String> friends;

    public Profile(String name, String status) {
        this.name = name;
        this.status = status;
        this.friends = new ArrayList<String>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addFriend(String friend) {
        friends.add(friend);
    }

    public void removeFriend(String friend) {
        friends.remove(friend);
    }

    public void displayFriends() {
        for (String friend : this.friends) {
            System.out.printf("%s \n", friend);
        }
    }

    public String toString() {
        return this.name + "\n" + "Current Status: " + this.status + "\n";
    }

    public boolean equals(Profile other) {
        boolean result = false;
        if (this.name.equals(other.getName()))
            result = true;

        return result;
    }

}
