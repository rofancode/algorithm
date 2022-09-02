class Solution {
    int[] w;
    int[] sum;
    int totalSum;
    int n;
    //sum[i] -> 시그마 w[i] 인 배일 
    //total sum 만들고, 
    //ramdom 숫자 (1~totalSum) 뽑아서 
    //해당 숫자가 범위 (w[a] < num && num < w[b] 인 a를 return )
    public Solution(int[] w) {
        this.w = w;
        this.n = w.length;
        this.sum = new int[n];
        
        sum[0] = w[0];
        for (int i = 1; i < n; i++)
            sum[i] += w[i] + sum[i - 1];
        
        totalSum = sum[n - 1]; 
        //System.out.println("totalSum>> "+totalSum);
    }
    
    public int pickIndex() {
        if (n == 1)
            return 0;
        //ramdomNum
        double target = this.totalSum * Math.random();
        //0 <= random < 1 -> target = idx
        // int w.length * w[i] <= 10^9 int 2^31 ~~ 2*10^9
        
        
        int idx = binSearch(target);
        //System.out.println("idx >> "+idx);
        return idx;
        
    }
    
    private int binSearch(double target) {
        //binary search 
        //sum[a] <target <= sum[a + 1]
        int left = 0;
        int right = n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            //System.out.println(left + " | "+ mid + "|" + right +"|"+target);
            if(target > this.sum[mid]) {
                left = mid + 1;
            }else 
                right = mid - 1;
        }
        return left;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */