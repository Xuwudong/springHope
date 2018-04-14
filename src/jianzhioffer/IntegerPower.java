package jianzhioffer;

public class IntegerPower {
	public static void main(String[] args) {
		System.out.println(Power(2, -3));
	}

	public static double Power(double base, int exponent) {
		if (base == 0)
			throw new RuntimeException("base²»ÄÜÎªÁã£¡");
		double res = 1, cur = base;
		int exp;
		if (exponent > 0)
			exp = exponent;
		else if (exponent == 0) {
			return res;
		} else
			exp = -exponent;
		while (exp != 0) {
			if ((exp & 1) == 1)
				res *= cur;
			cur *= cur;
			exp >>= 1;
		}
		return exponent < 0 ? 1 / res : res;
	}
}
