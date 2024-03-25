package LcSecond.linkedList;

import DataStruct.ListNode;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/design-twitter/description/">No 355 设计简化版twitter</a>
 **/
public class Twitter {

    /**
     * 我的粉丝
     **/
    HashMap<Integer, HashSet<Integer>> follower;
    /**
     * 我的关注
     **/
    HashMap<Integer, HashSet<Integer>> followee;

    /**
     * 整体的事件流
     */
    ListNode newsFeedAll;

    /**
     * tweetId对应的author
     */
    HashMap<Integer, Integer> author;

    public Twitter() {
        follower = new HashMap<>();
        followee = new HashMap<>();
        newsFeedAll = new ListNode(-9999);
        author = new HashMap<>();
    }

    /**
     * 发布推特时，更新事件流，更新tweetId-作者
     **/
    public void postTweet(int userId, int tweetId) {
        author.put(tweetId, userId);
        ListNode tweet = new ListNode(tweetId);
        tweet.next = newsFeedAll.next;
        newsFeedAll.next = tweet;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        ListNode cur = newsFeedAll.next;
        while (cur != null && result.size() < 10) {
            // 如果cur来源是 作者本人 或者是 作者的关注列表
            int tweedId = cur.val;
            int writer = author.get(tweedId);
            if (writer == userId || (followee.get(userId) != null && followee.get(userId).contains(writer))) {
                result.add(tweedId);
            }
            cur = cur.next;
        }
        return result;
    }


    public void follow(int followerId, int followeeId) {
        // 2 的粉丝列表++
        follower.putIfAbsent(followeeId, new HashSet<>());
        follower.get(followeeId).add(followerId);

        // 1 的关注列表++
        followee.putIfAbsent(followerId, new HashSet<>());
        followee.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        // 1取关2，先从各自的粉丝、关注列表中移除
        follower.putIfAbsent(followeeId, new HashSet<>());
        follower.get(followeeId).remove(followerId);
        followee.putIfAbsent(followerId, new HashSet<>());
        followee.get(followerId).remove(followeeId);
    }

    @Test(description = "")
    public void test() throws Exception {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        List<Integer> x = twitter.getNewsFeed(1);
        show(x);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        x = twitter.getNewsFeed(1);
        show(x);
        twitter.unfollow(1, 2);
        x = twitter.getNewsFeed(1);
        show(x);
    }


    public void show(List<Integer> res) {
        System.out.println("===");
        System.out.println(StringUtils.join(res, "→"));
    }

    @Test(description = "")
    public void test123() throws Exception {
        String[] cmds = new String[]{"Twitter", "postTweet", "getNewsFeed", "follow", "getNewsFeed", "unfollow", "getNewsFeed"};
        ArrayList<Integer[]> p = new ArrayList<>();

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        List<Integer> x = twitter.getNewsFeed(1);
        show(x);
        twitter.follow(2, 1);
        x = twitter.getNewsFeed(2);
        show(x);
        twitter.unfollow(2, 1);
        x = twitter.getNewsFeed(2);
        show(x);
    }
}

