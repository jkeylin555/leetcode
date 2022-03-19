package DFS;

public class PartitionEqualSubset {
	public boolean partion(int[] nums, int prefix, int target, int level) {
		if (prefix + nums[level] == target) {
			return true;
		}
		if (level == nums.length - 1 ) {
			return false;
		}
		boolean left = false;
		if (prefix + nums[level] < target) {
			 left = partion(nums, prefix + nums[level], target, level + 1);
		}

		boolean right =partion(nums, prefix, target, level + 1);
		return left || right;
	}
    public static void main(String[] args) {
		int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
		int[] nums2 = {14,9,8,4,3,2};
		PartitionEqualSubset partitionEqualSubset = new PartitionEqualSubset();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0) {
			System.out.println(false);
		}
		boolean result = partitionEqualSubset.partion(nums, 0, sum/2, 0);
		System.out.println(result);
	}
}