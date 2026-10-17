class Solution {
    public int nextBeautifulNumber(int n) {
        List<Integer> res=new ArrayList<>();
        int d[]=new int[7];
        for(int i=1;i<7;i++)d[i]=i;
        backtrack(0,res,d);
        Collections.sort(res);
        for(int a:res){
            if(a>n)return a;
        }
        return 1224444;
    }

    static void backtrack(int num,List<Integer> res,int d[]){
        if(num>1224444)return ;
        if(isvalid(num)){
            res.add(num);
        }
        for(int i=1;i<7;i++){
            if(d[i]>0){
                d[i]-=1;
                backtrack(num*10+i,res,d);
                d[i]+=1;
            }
        }
    }

    static boolean isvalid(int n) {
        int d[] = new int[7];
        while (n > 0) {
            d[n % 10]++;
            n /= 10;
        }
        for (int i = 1; i < 7; i++) {
            if (d[i] != 0 && d[i] != i)
                return false;
        }
        return true;
    }
}