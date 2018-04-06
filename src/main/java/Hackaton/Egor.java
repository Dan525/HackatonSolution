package Hackaton;

import java.util.ArrayList;
import java.util.List;

public class Egor {
    public static int friendCount;
    private static List<Integer> friendList = new ArrayList<>();

    public static void addToFriendList(int id) {
        friendList.add(id);
    }

    public static List<Integer> getFriendList() {
        return friendList;
    }

    public static void printInfo() {
        System.out.println("Список id друзей Егора:");
        for (int friendId : friendList) {
            System.out.println(friendId);
        }
    }
}
