package com.nthread.outthere.cracking;

public class VolumeOfHistogram {

	public int volumeOf(int... heights) { 
		int maxPos = 0;
		int maxHeight = 0;
		
		for ( int i = 0; i < heights.length; i++ ) {
			if ( heights[i] > maxHeight ) {
				maxHeight = heights[i];
				maxPos = i;
			}
		}
		
		return volumeOf(maxHeight, maxPos, true, heights) + volumeOf(maxHeight, maxPos, false, heights);
	}

	private int volumeOf(int maxHeight, int maxPos, boolean increasing, int[] heights) {
		int volume = 0;
		int depth = 0;
		for ( int i = increasing ? 0 : heights.length - 1; increasing ? i < maxPos : i > maxPos; i+= increasing ? 1 : -1 ) {
			if (heights[i] <= depth) {
				volume += depth - heights[i];
			}
			else {
				depth = heights[i];
			}
		}
		return volume;
	}
}
