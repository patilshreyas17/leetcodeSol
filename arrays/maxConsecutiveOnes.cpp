class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int global = 0;
        int local = 0;
        for(int i =0; i<nums.size();i++){
            if(nums[i]==1){
                local +=1;
                if(global<local)global = local;
            }else{
                local = 0 ;
            }
        }
        return global;
    }
};