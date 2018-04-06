package Hackaton;

import java.util.*;

public class App 
{
    private static List<EgorFriend> egorFriendsPages = new ArrayList<>();
    private static Set<Integer> FriendsOfFriendsSet = allFriendsOfFriends(egorFriendsPages, new HashSet<>());

    public static void main(String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество друзей Егора: ");
        Egor.friendCount = in.nextInt();

        for (int i = 0; i < Egor.friendCount; i++) {

            in = new Scanner(System.in);
            System.out.print("Введите параметры " + (i+1) + "-го друга: ");
            String str = in.nextLine();
            List<Integer> friendParam = strToList(str, new ArrayList<>());

            EgorFriend egorFriend = new EgorFriend(friendParam.get(0), friendParam.get(1), friendParam.subList(2, friendParam.size()));
            egorFriendsPages.add(egorFriend);

            Egor.addToFriendList(friendParam.get(0));
        }
        allFriendsOfFriends(egorFriendsPages, FriendsOfFriendsSet);
        delEgorsFriendsFromAll(Egor.getFriendList(), FriendsOfFriendsSet);
        System.out.println("Количество друзей друзей Егора: " + FriendsOfFriendsSet.size());
    }

    public static List<Integer> strToList(String inputString, List<Integer> friendParam) {
        String[] numbers = inputString.split(" ");
        for (String number : numbers) friendParam.add(Integer.parseInt(number));
        return friendParam;
    }

    public static Set<Integer> allFriendsOfFriends(List<EgorFriend> egorFriendsObjects, Set<Integer> allFriendsOfFriendsSet) {
        for (int i = 0; i < egorFriendsObjects.size(); i++) {
            allFriendsOfFriendsSet.addAll(egorFriendsObjects.get(i).getFriendList());
        }
        return allFriendsOfFriendsSet;
    }

    public static Set<Integer> delEgorsFriendsFromAll(List<Integer> egorsFriendList, Set<Integer> allFriendsOfFriendsSet) {
        allFriendsOfFriendsSet.removeAll(Egor.getFriendList());
        return allFriendsOfFriendsSet;
    }
}
