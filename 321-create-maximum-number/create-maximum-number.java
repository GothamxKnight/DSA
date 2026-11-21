class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int res[]=new int[k];
        int m=nums1.length,n=nums2.length;
        int max[]=new int[k];
        for(int i=0;i<=k;i++){
            if(i<=m && k-i<=n){
                int arr1[]=helper(nums1,i);
                int arr2[]=helper(nums2,k-i);
                int []num=create_max(arr1,arr2);
                max_arr(max,num);
            }
        }
        return max;
    }
    static void max_arr(int[]max,int []num){
        boolean flag=false;
        for(int i=0;i<max.length;i++){
            if(num[i]>max[i]){
                flag=true;
                break;
            }else if(max[i]>num[i])break;
        }
        if(flag){
            for(int i=0;i<max.length;i++){
                max[i]=num[i];
            }
        }
    }
    static int[] create_max(int arr1[],int []arr2){
        int i=0;
        int j=0;
        int res[]=new int[arr1.length+arr2.length];
        int k=0;
        while(i<arr1.length && j<arr2.length){
            if(greater(arr1,i,arr2,j)){
                res[k++]=arr1[i++];
            }else{
                res[k++]=arr2[j++];
            }
        }
        while(i<arr1.length){
            res[k++]=arr1[i++];
        }
        while(j<arr2.length){
            res[k++]=arr2[j++];
        }
        return res;
    }
    static boolean greater(int[] arr1, int i, int[] arr2, int j) {
        while (i < arr1.length && j < arr2.length && arr1[i] == arr2[j]) {
            i++;
            j++;
        }
        return j == arr2.length || (i < arr1.length && arr1[i] > arr2[j]);
    }
    static int[] helper(int []nums,int k){
        Deque<Integer> dq=new ArrayDeque<>();
        int n=nums.length;
        int i=0;
        while(i<n){
            while(!dq.isEmpty() && dq.peekLast()<nums[i] && dq.size()+n-i>k){
                dq.pollLast();
            }
            dq.addLast(nums[i]);
            i++;
        }
        int res[]=new int[k];
        int j=0;
        while(j<k){
            res[j++]=dq.pollFirst();
        }
        return res;
    }
}