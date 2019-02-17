import java.util.Scanner;

/**
 * Zachery Van Es
 */
public class NetworkApp {
    Network network = new Network();

    public NetworkApp() {
        this.network = new Network();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        NetworkApp networkApp = new NetworkApp();
        String input = "";

        System.out.printf("Welcome to the network\n");
        while (!input.matches("quit")) {
            do {
                System.out.printf("Please enter login, sign up, or quit to continue\n");
                input = scan.nextLine();
                input = input.toLowerCase();
            } while (!input.matches("login|sign up|quit"));

            switch (input) {
                case "login":
                    networkApp.login();
                    break;
                case "sign up":
                    networkApp.signUp();
                    break;
            }
        }
        System.out.printf("Goodbye");
    }

    public void login() {
        Scanner scan = new Scanner(System.in);

        System.out.printf("Enter your name: \n");
        String name = scan.nextLine();

        if (!this.network.checkLogin(name)) {
            System.out.printf("That name is not in the system\n");
        } else {
            System.out.printf("%s has logged on\n", name);
            String input = "";
            while (!input.matches("quit")) {
                System.out.printf("\n(logged in as %s)\nChoose one of the options below\n>Add friend\n>Friends\n>Search Profiles\n>Emergency phone chain\n>Find the shortest path\n>Quit\n", name);
                input = scan.nextLine();
                input = input.toLowerCase();

                switch (input) {
                    case "add friend":
                        System.out.printf("Begging to add friend\n");
                        addFriend(name);
                        break;
                    case "friends":
                        System.out.printf("Showing friends\n");
                        friends(name);
                        break;
                    case "search profiles":
                        System.out.printf("Looking for other members\n");
                        searchProfiles();
                        break;
                    case "emergency phone chain":
                        System.out.printf("Phone chain starting\n");
                        emergencyPhoneChain(name);
                        break;
                    case "find the shortest path":
                        System.out.printf("Calculating shortest path\n");
                        findTheShortestPath(name);
                        break;
                }
            }

        }


    }

    public void signUp() {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter your name: \n");
        String name = scan.next();
        System.out.printf("Enter your status: \n");
        String status = scan.next();
        System.out.printf("%s is the name\n%s is the status\n", name, status);

        this.network.addProfile(name, status);
    }

    public void addFriend(String name) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter your new friends name:\n");
        String friend = scan.nextLine();
        if (this.network.checkLogin(friend) && !friend.matches(name)) {
            System.out.printf("How far are you from %s in kilometers?\n", friend);
            int distance = scan.nextInt();
            this.network.addFriend(name, friend, distance);
        } else {
            System.out.printf("Your friend is not in the network\n");
        }
    }

    public void friends(String name) {
        this.network.displayFriends(name);
    }

    public void searchProfiles() {
        this.network.displayProfiles();
    }

    public void emergencyPhoneChain(String name) {
        this.network.EmergencyPhoneChain(name);
    }

    public void findTheShortestPath(String name) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Who do you want to travel to?\n");
        String friend = scan.nextLine();
        if (this.network.checkLogin(friend) && !friend.matches(name)) {
            this.network.ShortestPath(name, friend);
        } else {
            System.out.printf("Your friend is not in the network\n");
        }
    }

}
