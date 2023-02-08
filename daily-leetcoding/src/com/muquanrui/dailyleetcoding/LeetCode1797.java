package com.muquanrui.dailyleetcoding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2023/2/9 00:20
 */

public class LeetCode1797 {
    class AuthenticationManager {
        private int timeToLive;
        private Map<String, Integer> map;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            map = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime);
        }

        public void renew(String tokenId, int currentTime) {
            if (removeExpiredTokens(tokenId, currentTime)) {
                return;
            }
            map.put(tokenId, currentTime);
        }

        public int countUnexpiredTokens(int currentTime) {
            int count = 0;
            Set<String> set = new HashSet<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() + timeToLive <= currentTime) {
                    set.add(entry.getKey());
                    continue;
                }
                count++;
            }
            for (String tokenId : set) {
                removeExpiredTokens(tokenId, currentTime);
            }
            return count;
        }

        private Boolean removeExpiredTokens(String tokenId, int currentTime) {
            if (!map.containsKey(tokenId)) {
                return true;
            }
            int generatedTime = map.get(tokenId);
            if (generatedTime + timeToLive <= currentTime) {
                map.remove(tokenId);
                return true;
            }
            return false;
        }
    }
}
