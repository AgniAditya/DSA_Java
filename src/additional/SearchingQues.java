// https://www.geeksforgeeks.org/allocate-minimum-number-pages/

public class SearchingQues {
    public static void main(String[] args) {
        int N=3;
        int[] pages={15,17,20};
        int M=2;
        System.out.println(Search(pages, N, M));
    }

    static int Search(int[] pages,int N,int M){
        if(M==N){
            return pages[0];
        }
        if(M==1){
            int sum=0;
            for(int i:pages){
                sum=sum+i;
            }
            return sum;
        }
        int start=0;
        int end=0;
        for(int i : pages){
            start=Math.max(start,i);
            end=end+i;
        }
        while(start<end){
            int mid=start+(end-start)/2;
            int sum=0;
            int count=1;
            for(int i : pages){
                if(sum + i > mid){
                    sum=i;
                    count++;
                }
                else{
                    sum=sum+i;
                }
            }
            if(count>M){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return end;
    }
}