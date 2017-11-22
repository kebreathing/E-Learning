package medium;

import java.util.*;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/22 17:31
 */
public class Lit355 {

    // 设计Twitter
    // 1. 发推特： postTweet(userId, tweetId)
    // 2. 取推特： getNewsFeed(userId) 获得用户关注的最新的10天推特，并且要排序(从最新到最旧)
    // 3. 关注： follow(userId, followeeId) 后者为被关注者
    // 4. 取关： unfollow(followerId, followeeId）后者为被取消关注者

    Map<Integer, Set<Integer>> map = null;
    List<Integer> owners = null;
    List<Integer> tweets = null;

    public Lit355() {
        map = new HashMap<>();
        tweets = new ArrayList<>();
        owners = new ArrayList<>();
    }

    /**
     * Compose a new tweets.
     */
    public void postTweet(int userId, int tweetId) {
        tweets.add(tweetId);
        owners.add(userId);
        if (map.containsKey(userId) == false) {
            map.put(userId, new HashSet<>());
            map.get(userId).add(userId);
        }
    }

    /**
     * Retrieve the 10 most recent tweets ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (map.containsKey(userId) == false)
            return res;

        Set<Integer> followees = map.get(userId);
        for (int i = tweets.size() - 1; i >= 0 && res.size() < 10; i--) {
            if (followees.contains(owners.get(i))) {
                res.add(tweets.get(i));
            }
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new HashSet<>());
            map.get(followerId).add(followerId);
        }
        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new HashSet<>());
            map.get(followeeId).add(followeeId);
        }
        if (followerId == followeeId) return;
        map.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new HashSet<>());
            map.get(followerId).add(followerId);
        }
        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new HashSet<>());
            map.get(followeeId).add(followeeId);
        }
        if (followerId == followeeId) return;
        map.get(followerId).remove(followeeId);
    }
}
