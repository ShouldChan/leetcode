package JiebiSort;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/9/9
 * @description 用数字休眠时常排序，谁醒来的时间早，谁就先输出
 */
public class ThreadSort {
    public void threadSort(int[] array) {
        for (int i : array) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(i);
                        System.out.println(i);
                    } catch (InterruptedException ignore) {

                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 5, 6, 1000*1000, 10, 5};
        ThreadSort ts = new ThreadSort();
        ts.threadSort(array);
    }
}
