class Twitter {

    HashMap<Integer, HashMap<Integer, Boolean>> following = new HashMap<>();
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
        PriorityQueue<int[]> feed = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        if (!(following.get(userId) == null)) {
            for (int followee : following.get(userId).keySet()) {
                if (tweets.get(followee) == null)
                    continue;
                int tweetCount = Math.min(tweets.get(followee).size(), 10);
                for (int i = tweets.get(followee).size() - 1; i >= tweets.get(followee).size() - tweetCount; i--) {
                    feed.add(tweets.get(followee).get(i));
                }
            }
        }
        if (!(tweets.get(userId) == null)) {
            int tweetCount = Math.min(tweets.get(userId).size(), 10);
            for (int i = tweets.get(userId).size() - 1; i >= tweets.get(userId).size() - tweetCount; i--) {
                feed.add(tweets.get(userId).get(i));
            }
        }
        for (int i = 0; i < 10 && !feed.isEmpty(); i++) {
            result.add(feed.poll()[1]);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) {
            following.put(followerId, new HashMap<>());
        }
        following.get(followerId).put(followeeId, true);
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