package algorthm;

import java.util.*;

/**
 * @author zhaohaojie
 * @date 2019-03-17 16:44
 */
public class MedianNumber {

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int total = nums1.length + nums2.length;
//        List<Integer> list = new ArrayList<>();
//        for (int i=0;i<nums1.length;i++){
//            list.add(nums1[i]);
//        }
//        for (int i=0;i<nums2.length;i++){
//            list.add(nums2[i]);
//        }
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//        if(total % 2== 1){
//            return list.get((total-1)/2);
//        }else{
//            double i = list.get(total/2-1)+list.get(total/2);
//            return i/2;
//        }
//    }

    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] i1 = {1, 3};
        int[] i2 = {};
        MedianNumber medianNumber = new MedianNumber();
        System.out.println(medianNumber.findMedianSortedArrays2(i1,i2));
    }
}

