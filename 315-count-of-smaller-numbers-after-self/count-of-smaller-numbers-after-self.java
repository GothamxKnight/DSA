class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        int []arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=i;
        int res[]=new int[n];
        divide(nums,0,n-1,res,arr);
        List<Integer> ans=new ArrayList<>();
        for(int a:res)ans.add(a);
        return ans;
    }
    static void divide(int []nums,int i,int j,int res[],int arr[]){
        if(i==j)return ;
        int mid=(i+j)/2;
        divide(nums,i,mid,res,arr);
        divide(nums,mid+1,j,res,arr);
        
        merge(nums,i,mid,j,res,arr);
    }
    static void merge(int[]nums,int i,int mid,int j,int []res,int[]arr){
        int arr1[]=new int[mid-i+1];
        int arr2[]=new int[j-mid];
        int len=mid-i+1,len2=j-mid;
        for(int k=0;k<mid-i+1;k++){
            arr1[k]=arr[k+i];
        }
        for(int k=0;k<len2;k++){
            arr2[k]=arr[mid+1+k];
        }
        int k=0,l=0;
        int count=0;
        while( k<len && l<len2){
            if(nums[arr1[k]]>nums[arr2[l]]){
                count++;
                arr[i++]=arr2[l];
                l++;
            }else{
                res[arr1[k]]+=count;
                arr[i++]=arr1[k];
                k++;
            }
        }
        while(k<len){
            res[arr1[k]]+=count;
            arr[i++]=arr1[k++];
        }
        while(l<len2){
            arr[i++]=arr2[l++];
        }
    }
}