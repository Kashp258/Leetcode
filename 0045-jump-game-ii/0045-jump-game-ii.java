class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int l = 0;  
        int r = 0; 
        for (int i = 0; i < nums.length - 1; i++) { 
            l = Math.max(l, i + nums[i]);
            if (i == r) { 
                r = l;   
                jumps++;  
            }
        }
        return jumps; 
    }
}