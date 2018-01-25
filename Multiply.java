给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

图在剑指offer的313页

public class Solution {
    public int[] multiply(int[] A) {
        //剑指offer的方法，画出来剑指offer上面的图更容易理解一些
        int length = A.length;
        int[] B = new int[length];
        
        if(length != 0){
            //计算下三角
            B[0] = 1;
            for(int i = 1;i < length;i++)
                B[i] = B[i-1] * A[i-1];
            
            //计算上三角
            int temp = 1;
            for(int j = length -2;j >= 0;j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;

    }
}
