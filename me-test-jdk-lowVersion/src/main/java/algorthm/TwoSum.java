package algorthm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaohaojie
 * @date 2019-03-14 11:46
 */
public class TwoSum {


    public int reverse(int x) {

        return 0;
    }

    public int[] twoSum(int[] nums, int target) {
        int complement;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,7};
//        TwoSum sum = new TwoSum();
//        long starttime = System.nanoTime();
//        int[] result = sum.twoSum(nums,13);
//        System.out.println("consumed tiem is "+Long.toString(System.nanoTime() - starttime));
//
//        System.out.println(result[0]+","+result[1]);
        String s1=" ab"; String s2=" a"+" b"; String s3=" a"; String s4=" b"; String s5=" a"+" b";
        String s6 = new String(" a b");
        String s67 = new String(" a b");
        System.out.println(s6  == s67);
        System.out.println(s6.equals(s67));
        System.out.println("|"+s1);
        System.out.println("|"+s2);
        System.out.println("|"+s3);
        System.out.println("|"+s4);
        System.out.println("|"+s5);

        System.out.println(s5 == s2);
        System.out.println(s5.equals(s2));
        System.out.println(s2 == s6);
        System.out.println(s2.equals(s6));
        short s12 = 1;
        s12+=1;//+=做自动类型转换
    }
}

