package com.nthread.outthere.projecteuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class EraSieve {
	HashMap<Long, List<Long>> positions = new HashMap<Long, List<Long>>();
	List<Long> primes = new ArrayList<Long>();
	long last = 1;
	
	public long nextPrime() {
		for ( long i = last+1; true; i++) {
			if (positions.containsKey(i) ) {
				for( long val : positions.remove(i) ) {
					addPosition(i, val);
				}
			}
			else {
				last = i;
				primes.add(i);
				addPosition(i, i);
				return i;
			}
		}
	}
	
	public Iterator<Long> iterator() {
		return new Iterator<Long>() {
			int pos = 0;
			
			@Override
			public boolean hasNext() {
				return true;
			}

			@Override
			public Long next() {
				if (pos < primes.size()) {
					return primes.get(pos++);
				}
				pos++;
				return nextPrime();
			}

			@Override
			public void remove() {
			}
			
		};
	}

	private void addPosition(long i, long val) {
		long next = i + val;
		List<Long> list = positions.get(next);
		if ( list == null ) {
			list = new ArrayList<Long>();
			
			positions.put(next, list);
		}
		list.add(val);
	}
}
