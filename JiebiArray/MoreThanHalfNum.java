package JiebiArray;

import java.util.*;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/17
 * @description 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    /**
     * 时间复杂度O（n）
     * 空间复杂度O（1）
     * 分治法
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution3(int[] array){
        //TODO
        return 0;
    }
    /**
     * 时间复杂度O（n）
     * 空间复杂度O（1）
     * 加入数组中存在众数，那么众数一定大于数组的长度的一半。
     * 思想就是：如果两个数不相等，就消去这两个数，最坏情况下，每次消去一个众数和一个非众数，那么如果存在众数，最后留下的数肯定是众数。
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution2(int[] array) {
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times++;
            } else {
                if (result == array[i])
                    times++;
                else
                    times--;
            }
        }
        //最后留下来的肯定是众数 所以再次遍历计算他出现的次数
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (result == array[i])
                times++;
        }
        if (times > array.length / 2)
            return result;
        else
            return 0;
    }

    /**
     * 时间复杂度O（n）
     * 空间复杂度O（n）
     * 遍历数组 使用map对每个数值出现的值进行count 最后对map 进行sort后取出value最大的那个值
     *
     * @param array
     */
    public int MoreThanHalfNum_Solution1(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (countMap.get(array[i]) == null) {
                countMap.put(array[i], 1);
            } else {
                countMap.put(array[i], countMap.get(array[i]) + 1);
            }
        }
        printHashMap(countMap);
        int[] result = MostShowNum(countMap);
        if (result[1] > array.length / 2)
            return result[0];
        else
            return 0;
    }

    public int[] MostShowNum(Map<Integer, Integer> map) {
        // 通过ArrayList构造函数把map.entrySet()转换成list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> mapping1, Map.Entry<Integer, Integer> mapping2) {
                return mapping2.getValue() - mapping1.getValue();
            }
        });
        int[] result = new int[2];
//        System.out.println(list.get(0));
        result[0] = list.get(0).getKey();
        result[1] = list.get(0).getValue();
//        for (Integer key : map.keySet()) {
////            System.out.println(key + " ：" + map.get(key));
//            result = key;
//            times = map.get(key);
//            System.out.println(result+"\t"+times);
//        }
        return result;
    }

    public void printHashMap(Map<Integer, Integer> map) {
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.print(entry.getKey() + "　：" + entry.getValue() + "\t");
        }
        System.out.print("\n");
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        MoreThanHalfNum mt = new MoreThanHalfNum();
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
//        System.out.println(mt.MoreThanHalfNum_Solution1(array));
        System.out.println(mt.MoreThanHalfNum_Solution2(array));
    }

}
