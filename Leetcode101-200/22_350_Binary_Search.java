// 不建议用二分
// 两个数组都排序，用指针
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] A = null;
        int[] B = null;

        if(m<n){
            A=nums1;
            B=nums2;
        }else {
            A=nums2;
            B=nums1;
        }

        m = A.length;
        n = B.length;

        if(m==0||n==0){
            return new int[0];
        }

        List<Integer> res = new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);

        int p1 = 0;
        int p2 = 0;

        while (p1<m && p2<n){
            if(A[p1] == B[p2]){
                res.add(A[p1]);
                if(p1<m){p1++;}
                if(p2<n){p2++;}
            }else if(A[p1] < B[p2]){
                if(p1<m){p1++;}
            }else {
                if(p2<n){p2++;}
            }
        }

        int[] r = new int[res.size()];
        int i = 0;
        for(Integer t : res){
            r[i] = t;
            i++;
        }

        return r;
    }
}
