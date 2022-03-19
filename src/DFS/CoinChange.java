package DFS;

import java.util.Arrays;

public class CoinChange {
	static int res = Integer.MAX_VALUE;
	public void coinChange(int[] coins, int amount, int level, int num) {
		if (level == 0) {
			if (amount % coins[level] == 0) {
				res = Math.min(res, amount / coins[level] + num);
			}
			return;
		}
		for (int i = amount/coins[level]; i >= 0; i--) {
			coinChange(coins, amount - coins[level] * i, level - 1, num + i);
		}
	}
	public static void main(String[] args) {
		int[] coins = {270,373,487,5,62};
		CoinChange coinChange = new CoinChange();
		coinChange.coinChange(coins, 8121, coins.length - 1, 0);
		System.out.println(res);
	}
}



