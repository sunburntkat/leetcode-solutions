class Twitter {

    HashMap<Integer, HashSet<Integer>> following = new HashMap<>();
    int time = 0;
    HashMap<Integer, List<int[]>> tweets = new HashMap<>();

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(new int[] { time, tweetId });
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<TweetPost> feed = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
        if (following.get(userId) != null) {
            for (int followee : following.get(userId)) {
                if (tweets.get(followee) == null)
                    continue;
                int size=tweets.get(followee).size();
                int[] firstTweet = tweets.get(followee).get(size-1);
                feed.add(new TweetPost(firstTweet[1], firstTweet[0], followee, size-1));
            }
        }
        if (!(tweets.get(userId) == null)) {
            int size=tweets.get(userId).size();
            int[] firstTweet = tweets.get(userId).get(size-1);
            feed.add(new TweetPost(firstTweet[1], firstTweet[0], userId, size-1));
        }
        for (int i = 0; i < 10 && !feed.isEmpty(); i++) {
            TweetPost tweetPost=feed.poll();
            result.add(tweetPost.tweetId);
            if(tweetPost.index<=0) continue;
            int[] nextTweet=tweets.get(tweetPost.userId).get(--tweetPost.index);
            feed.add(new TweetPost(nextTweet[1],nextTweet[0],tweetPost.userId, tweetPost.index));
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<>());
        }
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
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

class TweetPost {
    public int tweetId;
    public int time;
    public int userId;
    public int index;

    public TweetPost(int tweetId, int time, int userId, int index) {
        this.tweetId = tweetId;
        this.time = time;
        this.userId = userId;
        this.index = index;
    }
}