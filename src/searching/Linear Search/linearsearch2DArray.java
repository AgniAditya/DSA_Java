public class linearsearch2DArray {

    public static boolean searchIn2DArray(int[][] arr,int target) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr={
            {1,2,3},
            {4,5,6},
            {8,9,0}
        };
        int target=3;
        System.out.println(searchIn2DArray(arr, target));
    }
}