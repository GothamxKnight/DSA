class Solution {
    public double separateSquares(int[][] squares) {
        double hi=0;
        double total_area=0;
        for(int []temp:squares){
            hi=Math.max(hi,temp[1]+temp[2]);
            total_area+=(double)temp[2]*(double)temp[2];
        }
        double low=Double.MAX_VALUE;
        for(int []temp:squares){
            low=Math.min(low,temp[1]);
        }
        while((hi-low)>1e-6){
            double mid=low+(hi-low)/2;
            double curr_area=area(squares,mid);
            if(curr_area*2<total_area){
                low=mid;
            }else{
                hi=mid;
            }
        }
        return low;
    }
    static double area(int[][]squares,double mid){
        double area=0;
        for(int []temp:squares){
            if(temp[1]>=mid)continue;
            double height=Math.min(mid-temp[1],(double)temp[2]);
            area+=height*temp[2];
        }
        return area;
    }
}