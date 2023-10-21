package com.ZipRecuiter.OA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class question_3 {
	public List<String> solve(List<String> id, List<String> messages) {
		Map<String, Integer> mp = new HashMap<>();

		for (String message : messages) {
			Set<String> st = new HashSet<>();
			int j = 0;
			while (j < message.length()) {
				if (message.charAt(j) != '@') {
					j++;
					continue;
				} else if (j + 2 < message.length() && message.substring(j + 1, j + 3).equals("id")) {
					String p = "";
					while (j < message.length() && message.charAt(j) != ' ') {
						p += message.charAt(j);
						j++;
					}
					p = p.substring(1); // Remove the "@" character
					tokenize(p, mp, st, ",");
				} else {
					j++;
				}
			}
		}

		List<Pair> pairs = new ArrayList<>();
		for (String i : id) {
			pairs.add(new Pair(i, mp.getOrDefault(i, 0)));
		}

		// Sort by count in descending order and then by ID in ascending order
		Collections.sort(pairs, (a, b) -> {
			if (a.getCount() == b.getCount()) {
				return a.getId().compareTo(b.getId());
			}
			return b.getCount() - a.getCount();
		});

		List<String> v = new ArrayList<>();
		for (Pair p : pairs) {
			v.add(p.getId() + "=" + p.getCount());
		}
		return v;
	}

	void tokenize(String s, Map<String, Integer> mp, Set<String> st, String del) {
		int start = 0;
		int end = -1 * del.length();
		do {
			start = end + del.length();
			end = s.indexOf(del, start);
			if (!st.contains(s.substring(start, end))) {
				mp.put(s.substring(start, end), mp.getOrDefault(s.substring(start, end), 0) + 1);
				st.add(s.substring(start, end));
			}
		} while (end != -1);
	}

	class Pair {
		private String id;
		private int count;

		public Pair(String id, int count) {
			this.id = id;
			this.count = count;
		}

		public String getId() {
			return id;
		}

		public int getCount() {
			return count;
		}
	}
}
