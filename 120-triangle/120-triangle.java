class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // i + 1 의 element는 i번째 element 고려한다는거야 
        //최소값을 더해서 누적하고
        // target의 i - 1 번째 줄, Top의 element 더해주면 되겠다.  
        int rLen = triangle.size();
        if (rLen == 1)
            return triangle.get(0).get(0);
        int cLen = 0;
        for (int r = 1; r < triangle.size(); r++) {
            cLen = triangle.get(r).size();
            for (int c = 0; c < cLen; c++) {
                int sum = triangle.get(r).get(c);
                
                if (c == 0) {
                    sum += triangle.get(r - 1).get(c) ;
                } else if (c == cLen - 1){
                    sum += triangle.get(r - 1).get(c - 1) ;
                } else {
                    sum += Math.min(triangle.get(r - 1).get(c - 1), triangle.get(r - 1).get(c));
                }
                
                triangle.get(r).set(c, sum);
            }
        }
        int min = 2000001; //triangle[i][j] <= 10000 ,  triangle.size <= 200 
        for (int i = 0; i < cLen; i++) {
            min = Math.min(min, triangle.get(rLen - 1).get(i));
        }
        return min;
    }
    
    //T.C (N^2) N = number of rows
    //S.C (1)
}