function checkTarget(nums, target) {
    for(i = 0; i <nums.length; i++) {
        for(j = i+1; j<nums.length; j++) {
            if(nums[i] + nums[j] === target) {
                return[i, j];
            }
        }
    }
}
console.log(checkTarget([3,3,9,5,4], 9))



