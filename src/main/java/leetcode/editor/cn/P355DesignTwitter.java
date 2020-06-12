//设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。
// 你的设计需要支持以下的几个
//功能： 
//
// 
// postTweet(userId, tweetId): 创建一条新的推文 
// getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由
// 最近的开始排序。
// 
// follow(followerId, followeeId): 关注一个用户 
// unfollow(followerId, followeeId): 取消关注一个用户 
// 
//
// 示例: 
//
// 
//Twitter twitter = new Twitter();
//
//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//twitter.getNewsFeed(1);
// 
// Related Topics 堆 设计 哈希表


package leetcode.editor.cn;

import java.util.*;

//Java：设计推特
public class P355DesignTwitter {
    public static void main(String[] args) {
        Twitter solution = new P355DesignTwitter().new Twitter();
        solution.follow(11, 21);
        solution.follow(11, 22);
        solution.follow(11, 23);
        List<Integer> followerList = solution.followerList(11);
        System.out.println(" 11： " + followerList.toString());

        solution.unfollow(11, 21);
        followerList = solution.followerList(11);
        System.out.println("取消关注后，11关注的人： " + followerList.toString());

        solution.postTweet(11, 31);
        solution.postTweet(11, 32);
        solution.postTweet(11, 33);

        solution.postTweet(22, 34);
        solution.postTweet(22, 35);

        List<Integer> tweetList1 = solution.tweetList(11);
        List<Integer> tweetList2 = solution.tweetList(22);
        System.out.println("tweet list for 11 : " + tweetList1.toString());
        System.out.println("tweet list for 22 : " + tweetList2.toString());

        List<Integer> newsFeedList = solution.getNewsFeed(11);
        System.out.println("11 result：" + newsFeedList.toString());
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Twitter {

        // 全局时间戳
        private int ts = 0;
        // 用户id以及用户信息【包括他发出的推文】
        private Map<Integer, User> userMap = new HashMap<>();


        /**
         * 用户：
         * 用户id
         * 用户关注了哪些人
         * 用户发出的推文列表【链表】
         * 发布推文的时间
         */
        private class User {
            int userId;
            HashSet<Integer> followUserSet;
            Tweet head;

            public User() {
                followUserSet = new HashSet<Integer>();
            }

            public User(int userId) {
                this();
                this.userId = userId;
                followUserSet.add(userId);
            }

            private void follow(int followId) {
                this.followUserSet.add(followId);
            }

            private void unfollow(int followId) {
                if (followId != userId) {
                    // 不能取消关注自己
                    // 如果followId不存在，则返回false
                    this.followUserSet.remove(followId);
                }
            }

            /**
             * 用户发布的推文，使用链表存储这用户的推文
             * 最新发布的在链表头部
             *
             * @param tweetId
             */
            private void post(int tweetId) {
                Tweet t = new Tweet(tweetId);
                t.next = head;
                // 保持head是链表头节点
                head = t;
            }
        }

        /**
         * 推文id
         * 发布推文的时间戳
         * 推文指向下一篇推文
         */
        private class Tweet {
            // 使用链表存储一个用户的动态
            int tweetId;
            int timestamp;
            Tweet next;

            public Tweet() {
            }

            public Tweet(int tweetId) {
                this.tweetId = tweetId;
                this.timestamp = ts;
                // 每次创建新的推文，就需要将ts这个全局计数器加1
                ts = ts + 1;
            }
        }


        /**
         * Initialize your data structure here.
         */
        public Twitter() {

        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            User user = userMap.get(userId);
            if (user == null) {
                // 用户之前不存在，新建
                // 并发布推文
                user = new User(userId);
                userMap.put(userId, user);
            }
            user.post(tweetId);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed.
         * Each item in the news feed must be posted by users who the user followed or by the user herself.
         * Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            // 队列【大顶堆】，按照用户发布推文的时间戳排序，最新->最旧排序
            PriorityQueue<Tweet> tweetByTimestampQueue = new PriorityQueue<>(new Comparator<Tweet>() {
                @Override
                public int compare(Tweet o1, Tweet o2) {
                    // 大 -> 小
                    return o2.timestamp - o1.timestamp;
                }
            });
            LinkedList<Integer> tweetList = new LinkedList<>();
            User user = userMap.get(userId);
            if (user == null) {
                // 用户不存在，取消
                return tweetList;
            }
            HashSet<Integer> followers = user.followUserSet;
            for (Integer id : followers) {
                // 获取被关注者列表，存入大顶堆
                User u = userMap.get(id);
                Tweet t = u.head;
                if (t != null) {
                    // 存储每个用户的推文链表的首节点
                    tweetByTimestampQueue.add(t);
                }
                // 优化点，不再将一个用户所有的推文全部放入大顶堆，只需要放入10条就可以
                // 或者大顶堆存储链表首节点【链表本来就是有序的，递减序列】
            }
            // tweetByTimestampQueue存储每个推文链表的首节点
            while (tweetByTimestampQueue.size() > 0) {
                if (tweetList.size() == 10) {
                    break;
                }
                // 合并多条链表
                // 广度优先遍历
                // 大顶堆的堆顶元素，即最大元素
                Tweet tweet = tweetByTimestampQueue.poll();
                tweetList.add(tweet.tweetId);
                Tweet next = tweet.next;
                if (next != null) {
                    tweetByTimestampQueue.add(next);
                }

            }
//            for (int i = 0; i < 10; i++) {
//                // 广度优先遍历
//                // 大顶堆的堆顶元素，即最大元素
//                Tweet tweet = tweetByTimestampQueue.poll();
//                if (tweet == null) {
//                    continue;
//                }
//                tweetList.add(tweet.tweetId);
//                Tweet next = tweet.next;
//                if (next != null) {
//                    tweetByTimestampQueue.add(next);
//                }
//            }

            return tweetList;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            // 关注人存在
            User user = userMap.get(followerId);
            if (user == null) {
                user = new User(followerId);
                userMap.put(followerId, user);
            }
            // 被关注人存在
            User followee = userMap.get(followeeId);
            if (followee == null) {
                followee = new User(followeeId);
                userMap.put(followeeId, followee);
            }
            user.follow(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            User follower = userMap.get(followerId);
            if (follower != null) {
                // 关注人如果不为空就取消关注，否则不做任何操作
                follower.unfollow(followeeId);
            }
        }


        private List<Integer> followerList(int followerId) {
            LinkedList<Integer> userList = new LinkedList<>();
            User follower = userMap.get(followerId);
            if (follower == null) {
                return userList;
            }
            userList.addAll(follower.followUserSet);
            return userList;
        }

        private List<Integer> tweetList(int followerId) {
            LinkedList<Integer> tweetList = new LinkedList<>();
            User u = userMap.get(followerId);
            if (u == null) {
                return tweetList;
            }
            Tweet t = u.head;
            while (t != null) {
                tweetList.add(t.tweetId);
                t = t.next;
            }
            return tweetList;
        }

    }
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
