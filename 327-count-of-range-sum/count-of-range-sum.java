class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        Set<Long>set=new HashSet<>();
        Long sum=0L;
        set.add(0L);
        set.add(0L-lower);
        set.add(0L-upper);
        for(int a:nums){
            sum+=a;
            set.add(sum);
            set.add(sum-lower);
            set.add(sum-upper);
        }
        ArrayList<Long> list=new ArrayList<>(set);
        Collections.sort(list);
        HashMap<Long,Integer>map=new HashMap<>();
        int i=0;
        for(Long a:list){
            map.put(a,i++);
        }
        int []segTree=new int[4*list.size()];
        int total=0;
        Long totalsum=0L;
        modified(segTree,0,map.get(0L),0,list.size()-1);
        for(int a:nums){
            totalsum+=a;
            int ub=map.get(totalsum-lower);
            int lb=map.get(totalsum-upper);
            int index=map.get(totalsum);
            total+=query(segTree,0,ub,lb,0,list.size()-1);
            modified(segTree,0,index,0,list.size()-1);
        }
        return total;
    }
    static void modified(int[]segTree,int node,int index,int L,int R){
        if(L==R){
            segTree[node]+=1;
            return ;
        }
        int mid=L+(R-L)/2;
        if(index>=L && index<=mid){
            modified(segTree,2*node+1,index,L,mid);
        }else{
            modified(segTree,2*node+2,index,mid+1,R);
        }
        segTree[node]=segTree[2*node+1]+segTree[2*node+2];
    }
    static int query(int segTree[],int index,int ub,int lb,int L,int R){
        if(R<lb || L>ub){
            return 0;
        }
        if(L>=lb && R<=ub){
            return segTree[index];
        }
        int mid=L+(R-L)/2;
        return query(segTree,2*index+1,ub,lb,L,mid)+query(segTree,2*index+2,ub,lb,mid+1,R);
    }
}