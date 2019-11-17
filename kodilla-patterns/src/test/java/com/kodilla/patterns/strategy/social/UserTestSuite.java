package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User maja = new Millenials("Maja");
        User tomek = new YGeneration("Tomek");
        User patryk = new ZGeneration("Patryk");

        //When
        String majaSharesOn = maja.sharePost();
        String tomekSharesOn = tomek.sharePost();
        String patrykSharesOn = patryk.sharePost();
        //Then
        Assert.assertEquals("Facebook", majaSharesOn);
        Assert.assertEquals("Snapchat", tomekSharesOn);
        Assert.assertEquals("Twitter", patrykSharesOn);

    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User maja = new Millenials("Maja");
        //When
        String majaSharesOn = maja.sharePost();
        System.out.println("Maja used to share on " + majaSharesOn);
        maja.setSocialPublisher(new TwitterPublisher());
        majaSharesOn = maja.sharePost();
        System.out.println("But now Maja shares on " + majaSharesOn);

        //Then
        Assert.assertEquals("Twitter", majaSharesOn);

    }
}
