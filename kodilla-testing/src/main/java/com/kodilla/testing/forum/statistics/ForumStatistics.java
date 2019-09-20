package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;

    private double postsAveragePerUser;
    private double commentsAveragePerUser;
    private double commentsAveragePerPost;

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getPostsAveragePerUser() {
        return postsAveragePerUser;
    }

    public double getCommentsAveragePerUser() {
        return commentsAveragePerUser;
    }

    public double getCommentsAveragePerPost() {
        return commentsAveragePerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();

        if (numberOfUsers != 0) {
            postsAveragePerUser = (double) numberOfPosts / numberOfUsers;
            commentsAveragePerUser = (double) numberOfComments / numberOfUsers;
        }
        if (numberOfPosts != 0) {
            commentsAveragePerPost = (double) numberOfComments / numberOfPosts;
        }
    }
    public void showStatistics(){
        System.out.println("Number of users: "+numberOfUsers);
        System.out.println("Number of posts: "+numberOfPosts);
        System.out.println("Number of comments: "+numberOfComments);
        System.out.println("Average number of posts per user: "+postsAveragePerUser);
        System.out.println("Average number of comments per user: "+commentsAveragePerUser);
        System.out.println("Average number of comments per post: "+commentsAveragePerPost);
    }
}
