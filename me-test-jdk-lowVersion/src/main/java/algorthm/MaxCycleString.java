package algorthm;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zhaohaojie
 * @date 2019-03-20 21:53
 */
public class MaxCycleString {

    public String longestPalindrome(String s) {
        if (s.equals("")){
            return s;
        }
        int i=0,j=0,ans=0;
        String str="";
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int x =0;x<s.length();x++){
            map.put(s.charAt(x),x);
        }
        while(i<s.length()){
            //第一遍完整遍历s,放入s
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if ( ans < (map.get(c)-i+1) ){
                    ans = map.get(c)-i+1;
                    str = s.substring(i,map.get(c)+1);
                }
                i=i+1;
            }
        }
        //if str == ""; 取第一个字符
        if (str.equals("")){
            return s.substring(0,1);
        }
        return str;
    }

    public static void main(String[] args) {
        MaxCycleString m = new MaxCycleString();
        System.out.println(m.longestPalindrome("abcdaccccccc"));
    }
}

