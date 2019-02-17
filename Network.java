import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

/**
 * Zachery Van Es
 */
public class Network {
    private UndirectedGraph<String> profileNetwork;
    private HashMap<String, Profile> profiles;
    private ArrayList<String> profileNames;
    private Stack<String> path;

    public Network() {
        profileNetwork = new UndirectedGraph<String>();
        profiles = new HashMap<String, Profile>();
        profileNames = new ArrayList<String>();
        path = new Stack<>();
    }

    public boolean checkLogin(String name) {
        boolean result = false;

        if (this.profileNames.contains(name)) {
            result = true;
        }

        return result;
    }

    public void addProfile(String name, String status) {
        Profile temp = new Profile(name, status);
        this.profiles.put(name, temp);
        this.profileNames.add(temp.getName());
        this.profileNetwork.addVertex(temp.getName());
    }

    public void addFriend(String firstName, String secondName, int distance) {
        if (this.profileNames.contains(secondName)) {
            this.profiles.get(secondName).addFriend(firstName);
            this.profiles.get(firstName).addFriend(secondName);
            this.profileNetwork.addEdge(firstName, secondName, distance);
        }
    }

    public void displayFriends(String name) {
        profiles.get(name).displayFriends();
    }

    public void displayProfiles() {
        for (String name : this.profileNames) {
            System.out.printf("\nName: %s\nStatus: %s\n", name, this.profiles.get(name).getStatus());
        }
    }

    public void EmergencyPhoneChain(String name) {
        Queue<String> temp = this.profileNetwork.getDepthFirstTraversal(name);

        System.out.printf("\nThe phone chain is as follows:\n");
        while (!temp.isEmpty()) {
            System.out.printf("-> %s ", temp.remove());
        }
        System.out.println();
    }

    public void ShortestPath(String name, String friend) {
        System.out.printf("\nThe cheapest path from " + name + " to " + friend + " is \n");
        double cost = this.profileNetwork.getCheapestPath(name, friend, this.path);
        printStack(this.path);
        System.out.printf("and has a cost of " + cost + ".\n");
        System.out.println();
    }

    public static void printStack(Stack<String> s) {
        while (!s.isEmpty())
            System.out.printf(s.pop() + " ");
        System.out.println();
    } // end printStack
}
