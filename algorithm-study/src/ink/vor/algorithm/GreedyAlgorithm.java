package ink.vor.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author muquanrui
 * @date 21/11/2021 11:10
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台,放入到Map
        HashMap<String,HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");


        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        ArrayList<String> selects = new ArrayList<>();

        while (allAreas.size() > 0) {
            String selectKey = null;
            int coverNum = 0;
            for (Map.Entry<String,HashSet<String>> entry: broadcasts.entrySet()) {
                HashSet<String> coverAreas = entry.getValue();
                coverAreas.retainAll(allAreas);
                if (coverNum < coverAreas.size()) {
                    coverNum = coverAreas.size();
                    selectKey = entry.getKey();
                }
            }
            allAreas.removeAll(broadcasts.get(selectKey));
            selects.add(selectKey);
        }

        System.out.println("得到的选择结果是" + selects);//[K1,K2,K3,K5]

    }
}
