vector<int> searchRange(vector<int>& nums, int target) {
    vector<int> result;
    int len = (int) nums.size();
    int start = 0, end = len-1;
    while (start <= end) {
        int mid = (start + end)/2;
        if (nums[mid] == target) {
            while (nums[--mid] == target);
            start = ++mid;
            while (nums[++mid] == target);
            end = mid-1;
            result.push_back(start);
            result.push_back(end);
            return result;
        }
        if (nums[mid] < target)  start = mid+1;
        if (nums[mid] > target)   end = mid-1;
    }
    result.push_back(-1);
    result.push_back(-1);
    return result;
 }