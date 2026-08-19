class Solution {
    public int nextGreaterElement(int n) {
        int size=len(n);
        int arr[]=new int[size];
        for(int j=size-1;j>=0;j--){
            arr[j]=n%10;
            n/=10;
        }
        Stack<Integer> st=new Stack<>();
        boolean flag=false;
        for(int j=size-1;j>=0;j--){
            if(!st.isEmpty() && arr[j]<arr[st.peek()]){
                int idx=st.peek();
                while(!st.isEmpty() &&arr[j]<arr[st.peek()]){
                    idx=st.pop();
                }
                flag=true;
                int temp2=arr[idx];
                arr[idx]=arr[j];
                arr[j]=temp2;
                int temp[]=new int[size-j-1];
                int k=j+1,m=0;
                while(k<size){
                    temp[m++]=arr[k++];
                }
                Arrays.sort(temp);
                m=0;
                j=j+1;
                while(j<size){
                    arr[j++]=temp[m++];
                }
                break;
            }
            st.push(j);
        }
        if(!flag)return -1;
        long total=0;
        for(int a:arr){
            total=total*10+a;
        }
        if(total>Integer.MAX_VALUE)return -1;
        return (int)total;
    }
    static int len(int n){
        int cnt=0;
        while(n>0){
            cnt++;
            n/=10;
        }
        return cnt;
    }
}