package com.amazon;

/**
 * https://leetcode.com/discuss/interview-question/2410886/Amazon-OA
 * 
 * Get the location of maximum and minimum elements.
If location of maximum element is left to location of minimum element then number of swaps = [ (n-1)-location of maximum element ] - [ location of minimum element - 0 ] -1.
Else number of swaps = [ (n-1)-location of maximum element ] - [ location of minimum element - 0 ] .

{
    int n = plates.size();
    int mn=INT_MAX,mx=INT_MIN;
    vector arr = plates;
    int min_idx,max_idx;
    for(int i=0;imx)
        {
            mx = arr[i];
            max_idx = i;
        }
        if(arr[i]min_idx)
    {
        ans += min_idx+(n-1-max_idx);
    }
    else
    {
       ans += min_idx;
       max_idx++;
       ans += (n-1-max_idx);
    }
    return ans;
}
 */
public class WeightPlatesReorder {


    
}
