package ch2.forkjoin.sort;

import java.util.Random;

/**
 * 类说明:
 */
public class MakeArray {

    //数组长度
    private static final int APPLY_LENGTH = 10;
    private static final int THRESHOLD = 47;

    public static int[] makeArray(){
        Random random = new Random();
        int[] arr = new int[APPLY_LENGTH];
        for (int i = 0; i < APPLY_LENGTH; i++) {
            arr[i] = random.nextInt(THRESHOLD * 4);
        }
        return arr;
    }
}
