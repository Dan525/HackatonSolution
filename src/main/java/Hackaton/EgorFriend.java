package Hackaton;

import java.util.List;

public class EgorFriend {
    public int id;
    public int egorFriendCount;
    private List<Integer> friendList;

    public EgorFriend(int id, int egorFriendCount, List<Integer> friendList) {
        this.id = id;
        this.egorFriendCount = egorFriendCount;
        this.friendList = friendList;
    }

    public List<Integer> getFriendList() {
        return friendList;
    }

    public void printInfo() {
        System.out.println("id: " + id);
        System.out.println("Список id друзей:");
        for (int friendId : friendList) {
            System.out.println(friendId);
        }
    }
}
