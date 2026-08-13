class NumArray {
    int []segtree;
    int n;
    public NumArray(int[] nums) {
        this.n=nums.length;
        segtree=new int[4*n];
        SegmentTree(nums,segtree,0,n-1,0);
    }
    
    public void update(int index, int val) {
        updateSeg(segtree,0,n-1,index,val,0);
    }
    
    public int sumRange(int left, int right) {
        return RangeSum(segtree,left,right,0,n-1,0);
    }
    static void SegmentTree(int []nums,int seg[],int low,int high,int pos){
        if(low==high){
            seg[pos]=nums[low];
            return ;
        }
        int mid=(low+high)/2;
        SegmentTree(nums,seg,low,mid,2*pos+1);
        SegmentTree(nums,seg,mid+1,high,2*pos+2);
        seg[pos]=seg[2*pos+1]+(pos*2+2<seg.length?seg[2*pos+2]:0);
    }
    static int RangeSum(int seg[],int left,int right,int low,int high,int pos){
        if(right<low || left>high)return 0;
        if(low>=left && high<=right)return seg[pos];
        int mid=(low+high)/2;
        return RangeSum(seg,left,right,low,mid,2*pos+1)+RangeSum(seg,left,right,mid+1,high,2*pos+2);
    }
    static void updateSeg(int[]seg,int low ,int high,int idx,int val,int pos){
        if(low==high){
            seg[pos]=val;
            return ;
        }
        int mid=(low+high)/2;
        if(idx<=mid){
            updateSeg(seg,low,mid,idx,val,2*pos+1);
        }else{
            updateSeg(seg,mid+1,high,idx,val,2*pos+2);
        }
        seg[pos]=seg[2*pos+1]+(2*pos+2<seg.length?seg[2*pos+2]:0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */