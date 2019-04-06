package algorthm;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.*;

/**
 * @author zhaohaojie
 * @date 2019-03-16 15:41
 */
public class Solution {

    public int length(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 1.保存每个char与index的对应关系
     * 2.两个变量i,j，j是自增长的变量，i是出现相同的char时通过i的移动来改善算法
     * 3.ans = Math.max(j-i+1,ans)
     * 4.hashmap.put(char,++j);
     * @param s
     * @return
     */
    public int lengthOfLongestSubStrings(String s){
        int ans=0,length = s.length();
        HashMap<Character,Integer> map=new HashMap<>();// k-v: char of s : index of char, e.g. s="abcd"  a:0,
        for (int i=0,j=0;j<length;j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(j-1+1,ans);
            map.put(s.charAt(j++),j);
        }
        return ans;
    }
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int maxLength = 0;
        List<String> set = new ArrayList<>(length);
        for(int i=0;i<length;i++){
            for (int j=i+1;j<=length;j++){
                String tmp = s.substring(j-1,j);
                if(set.size()>0 && set.contains(tmp)){
                    if (maxLength>length -i-1){
                        return maxLength;
                    }
                    set.clear();
                    break;
                }

                set.add(tmp);
                if (set.size()>0 && set.size() >maxLength){
                    maxLength = set.size();
                }

                if (j==length ){
                    return maxLength;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long time = System.nanoTime();
        System.out.println(solution.lengthOfLongestSubstring2("abcaefg"));;
        System.out.println(System.nanoTime() - time);
        System.out.println("开始join");

        long time2 = System.nanoTime();
        System.out.println(solution.lengthOfLongestSubStrings("abcaefg"));;
        System.out.println(System.nanoTime() - time2);
    }
}

