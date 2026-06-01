class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        List<Integer> list=new ArrayList<>();
        int tlimit=0,blimit=m,rlimit=n,llimit=0;
        int i=0,j=0;
        do{
            boolean flag=false;
            for(;j<rlimit;j++){
                flag=true;
                list.add(matrix[i][j]);
            }
            if(flag){
                tlimit++;
                j-=1;
                i+=1;
            }else{break;}
            flag=false;
            for(;i<blimit;i++){
                flag=true;
                list.add(matrix[i][j]);
            }
            if(flag){
                i-=1;
                rlimit--;
                j-=1;
            }else { break;}
            flag=false;
            for(;j>=llimit;j--){
                flag=true;
                list.add(matrix[i][j]);
            }
            if(flag){
                j+=1;
                blimit--;
                i-=1;
            }else{break;}
            flag=false;
            for(;i>=tlimit;i--){
                flag=true;
                list.add(matrix[i][j]);
            }
            if(flag){
                i+=1;
                j+=1;
                llimit++;
            }else{break;}
        }while(j<rlimit && i<blimit);
        return list;
    }
}