package com.kodilla.testing.forum.statistics;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestCalculateAdvStatistics {
    private ForumStatistics forumStatistics;
    private Statistics statisticsMock = mock(Statistics.class);
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of all tests");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("This is the end of all tests");
    }

    @Before
    public void beforeTest(){
        testCounter++;
        System.out.println("Preparing test No. " + testCounter);
        List<String> UserList = new ArrayList<>();
        for(int i=0; i<100; i++){
            UserList.add("User"+i);
        }
        when(statisticsMock.usersNames()).thenReturn(UserList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(1500);

        forumStatistics = new ForumStatistics();
    }
    @After
    public void afterTest() {
        System.out.println("Test No. " + testCounter + " completed");
    }

    @Test
    public void testCalculateAdvStatisticsWithZeroPosts(){

        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals((double) 0/100, forumStatistics.getPostsAveragePerUser(),0);
        assertEquals((double) 0/100, forumStatistics.getCommentsAveragePerUser(),0);
        assertEquals( 0, forumStatistics.getCommentsAveragePerPost(),0);

    }
    @Test
    public void testCalculateAdvStatisticsWithThousandPosts(){
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals((double) 1000/100, forumStatistics.getPostsAveragePerUser(),0);
        assertEquals((double) 1500/100, forumStatistics.getCommentsAveragePerUser(),0);
        assertEquals((double) 1500/1000, forumStatistics.getCommentsAveragePerPost(),0);

    }

    @Test
    public void testCalculateAdvStatisticsWithZeroComments(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals((double) 1000/100, forumStatistics.getPostsAveragePerUser(),0);
        assertEquals((double) 0/100, forumStatistics.getCommentsAveragePerUser(),0);
        assertEquals((double) 0/1000, forumStatistics.getCommentsAveragePerPost(),0);
    }

    @Test
    public void testCalculateAdvStatisticsLessCommentsThanPosts() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(500);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals((double) 1000 / 100, forumStatistics.getPostsAveragePerUser(),0);
        assertEquals((double) 500 / 100, forumStatistics.getCommentsAveragePerUser(),0);
        assertEquals((double) 500 / 1000, forumStatistics.getCommentsAveragePerPost(),0);
    }
    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts(){

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals((double) 1000 / 100, forumStatistics.getPostsAveragePerUser(),0);
        assertEquals((double) 1500 / 100, forumStatistics.getCommentsAveragePerUser(),0);
        assertEquals((double) 1500 / 1000, forumStatistics.getCommentsAveragePerPost(),0);
    }

    @Test
    public void testCalculateAdvStatisticsWithZeroUsers(){
        //Given
        List<String>listMock = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(listMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getPostsAveragePerUser(),0);
        assertEquals(0, forumStatistics.getCommentsAveragePerUser(),0);
        assertEquals((double) 1500 / 1000, forumStatistics.getCommentsAveragePerPost(),0);

    }

    @Test
    public void testCalculateAdvStatisticsWithHundredUsers(){
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals((double) 1000/100, forumStatistics.getPostsAveragePerUser(),0);
        assertEquals((double) 1500/100, forumStatistics.getCommentsAveragePerUser(),0);
        assertEquals((double) 1500/1000, forumStatistics.getCommentsAveragePerPost(),0);
    }
}
