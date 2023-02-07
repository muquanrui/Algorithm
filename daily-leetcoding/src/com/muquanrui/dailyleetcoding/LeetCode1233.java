package com.muquanrui.dailyleetcoding;

import java.util.*;

/**
 * @author muquanrui
 * @date 2023/2/8 01:39
 */

public class LeetCode1233 {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        Set<String> root = new HashSet<>();
        Arrays.sort(folder, (file1, file2) -> file1.length() - file2.length());
        for (String path : folder) {
            for (int i = 1; i < path.length(); i++) {
                char ch = path.charAt(i);
                if (i < path.length() - 1 && ch != '/') {
                    continue;
                }
                String curPath = i == path.length() - 1 ? path.substring(0, i + 1) : path.substring(0, i);
                if (root.contains(curPath)) {
                    folderSet.remove(path);
                    break;
                }
            }
            root.add(path);
        }
        return new ArrayList<>(folderSet);
    }
}
