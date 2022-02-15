package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T355 {
    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */
    static class Twitter {
        Map<Integer, ArrayList<Integer>> users = new HashMap<>();
        ArrayList<ArrayList<Integer>> news = new ArrayList<>();

        /**
         * Initialize your data structure here.
         */
        public Twitter() {

        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            ArrayList<Integer> message = new ArrayList<>();
            message.add(userId);
            message.add(tweetId);
            news.add(message);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            int num = 10;
            ArrayList<Integer> res = new ArrayList<>();

            for (int i = news.size() - 1; i >= 0; i--) {
                if (num <= 0) {
                    break;
                }
                int owner = news.get(i).get(0);
                if (owner == userId ||
                        users.containsKey(userId) &&
                        users.get(userId).contains(owner)){
                    res.add(news.get(i).get(1));
                    num--;
                }
            }

            return res;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            addUser(followerId);
//            addUser(followeeId);
            if (followerId == followeeId) {
                return;
            }
            if (!users.get(followerId).contains(followeeId)) {
                users.get(followerId).add(followeeId);
            }
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
//            addUser(followerId);
//            addUser(followeeId);
            if (users.containsKey(followerId) &&
                    users.get(followerId).contains(followeeId)) {
                users.get(followerId).remove(users.get(followerId).indexOf(followeeId));
            }
        }

        public void addUser(int userId) {
            if (!users.containsKey(userId)) {
                users.put(userId, new ArrayList<>());
            }
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        twitter.getNewsFeed(1);

        // 用户1关注了用户2.
        twitter.follow(1, 2);

        // 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
        twitter.getNewsFeed(1);

        // 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        // 因为用户1已经不再关注用户2.
        twitter.getNewsFeed(1);
    }
}
