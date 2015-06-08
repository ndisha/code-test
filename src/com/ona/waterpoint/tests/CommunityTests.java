/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ona.waterpoint.tests;

import com.ona.waterpoint.Community;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
/**
 *
 * @author Isaac Mwongela(mwongelaima@gmail.com)
 */
public class CommunityTests {
    @Test
    public void testCreateCommunity() {
        Community community = new Community("Jaganath", 5, 2);
        assertEquals(community.getCommunityName(), "Jaganath");
        assertEquals(community.getTotalWaterPoints(), 5);
        assertEquals(community.getBrokenWaterPoints(), 2);
    }
    
    @Test
    public void testCommunityAfterUpdate() {
        Community community = new Community("Jaganath", 5, 2);
        int totalWP = community.getTotalWaterPoints();
        community.setTotalWaterPoints( totalWP + 1);
        int brokenWP = community.getBrokenWaterPoints();
        community.setBrokenWaterPoints(brokenWP + 1);
        community.setCommunityName("Pradesh");
        assertEquals(community.getTotalWaterPoints(), 6);
        assertEquals(community.getBrokenWaterPoints(), 3);
        assertEquals(community.getCommunityName(), "Pradesh");
    }
    
    @Test
    public void testBrokenWaterPointPercentage() {
        Community community1 = new Community("Jaganath", 5, 2);
        Community community2 = new Community("Pradesh", 5, 2);
        int brokenPerc1 = (int) (community1.getBrokenPercentage() * 100);
        int brokenPerc2 = (int) (community2.getBrokenPercentage() * 100);
        assertEquals(brokenPerc1, brokenPerc2);
        community2.setBrokenWaterPoints(3);
        assertTrue(community2.getBrokenPercentage() > community1.getBrokenPercentage());
    }

    @Test
    public void testRankCommunitiesOnBrokenPercentage() {
        Community community1 = new Community("Jaganath", 5, 2);
        Community community2 = new Community("Pradesh", 5, 3);
        Community community3 = new Community("Jeni", 10, 1);
        List<Community> list = new ArrayList<Community>();
        list.add(community1);
        list.add(community2);
        list.add(community3);
        Collections.sort(list);
        Collections.reverse(list);
        assertEquals(list.get(0).getCommunityName(), "Pradesh");
        assertEquals(list.get(1).getCommunityName(), "Jaganath");
        assertEquals(list.get(2).getCommunityName(), "Jeni");
    }
}
