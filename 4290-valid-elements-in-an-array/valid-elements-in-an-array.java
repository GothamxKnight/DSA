class Solution {
    public List<Integer> findValidElements(int[] arr) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            boolean isvalidleft=true;
            boolean isvalidright=true;
            for(int j=0;j<i;j++){
                if(arr[j]>=arr[i])isvalidleft=false;
            }
            for(int k=i+1;k<arr.length;k++){
                if(arr[k]>=arr[i])isvalidright=false;
            }
            if(isvalidleft || isvalidright){
                list.add(arr[i]);
            }
        }
        return list;
    }
}