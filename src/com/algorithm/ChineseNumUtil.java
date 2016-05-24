package com.algorithm;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ChineseNumUtil {
	private static final Character[] CN_NUMERIC = { 'һ', '��', '��', '��', '��', '��', '��', '��', '��', 'Ҽ', '��', '��', '��',
			'��', '½', '��', '��', '��', 'ʮ', '��', 'ǧ', 'ʰ', '��', 'Ǫ', '��', '��', '��', '��', '��' };

	private static Map<Character, Integer> cnNumeric = null;

	// ����hashmap ����ӳ���ϵ
	static {
		cnNumeric = new HashMap<Character, Integer>(40, 0.85f);
		for (int j = 0; j < 9; j++)
			cnNumeric.put(CN_NUMERIC[j], j + 1);
		for (int j = 9; j < 18; j++)
			cnNumeric.put(CN_NUMERIC[j], j - 8);
		cnNumeric.put('��', 2);
		cnNumeric.put('ʮ', 10);
		cnNumeric.put('ʰ', 10);
		cnNumeric.put('��', 100);
		cnNumeric.put('��', 100);
		cnNumeric.put('ǧ', 1000);
		cnNumeric.put('Ǫ', 1000);
		cnNumeric.put('��', 10000);
		cnNumeric.put('��', 100000000);
	}

	/**
	 * check the given char is chinese numeric or not. <br />
	 *
	 * @param c
	 *            <br />
	 * @return boolean true yes and false for not.
	 */
	private static BigDecimal isCNNumeric(char c) {
		Integer i = cnNumeric.get(c);
		if (i == null)
			return new BigDecimal(-1);
		return new BigDecimal(i.intValue());
	}

	/**
	 * a static method to turn the Chinese numeric to Arabic numbers.
	 *
	 * @param cnn
	 * @param boolea
	 *            flag
	 * @return int
	 */
	private static BigDecimal cnNumericToArabic(String cnn, boolean flag) {

		cnn = cnn.trim();
		if (cnn.length() == 1)
			return isCNNumeric(cnn.charAt(0));// �ݹ����

		if (flag)
			cnn = cnn.replace('��', '��')// ����ͬ���ĵ�λ�Լ� ����Ĵ���
					.replace('Ǫ', 'ǧ').replace('ʰ', 'ʮ').replace('��', ' ');
		// System.out.println(cnn);
		int yi = -1, wan = -1, qian = -1, bai = -1, shi = -1;// �ж��Ƿ��иõ�λ
		BigDecimal val = new BigDecimal(0);
		yi = cnn.lastIndexOf('��');
		if (yi > -1) {
			val = val.add(cnNumericToArabic(cnn.substring(0, yi), false).multiply(new BigDecimal(100000000)));
			if (yi < cnn.length() - 1)
				cnn = cnn.substring(yi + 1, cnn.length());
			else
				cnn = "";

			if (cnn.length() == 1) {
				BigDecimal arbic = isCNNumeric(cnn.charAt(0));
				if (arbic.compareTo(new BigDecimal(10)) != 1)
					val = val.add(arbic.multiply(new BigDecimal(10000000)));
				cnn = "";
			}
		}

		wan = cnn.lastIndexOf('��');
		if (wan > -1) {
			val = val.add(cnNumericToArabic(cnn.substring(0, wan), false).multiply(new BigDecimal(10000)));
			;
			if (wan < cnn.length() - 1)
				cnn = cnn.substring(wan + 1, cnn.length());
			else
				cnn = "";
			if (cnn.length() == 1) {
				BigDecimal arbic = isCNNumeric(cnn.charAt(0));
				if (arbic.compareTo(new BigDecimal(10)) != 1)
					val = val.add(arbic.multiply(new BigDecimal(1000)));
				cnn = "";
			}
		}

		qian = cnn.lastIndexOf('ǧ');
		if (qian > -1) {
			val = val.add(cnNumericToArabic(cnn.substring(0, qian), false).multiply(new BigDecimal(1000)));
			;
			if (qian < cnn.length() - 1)
				cnn = cnn.substring(qian + 1, cnn.length());
			else
				cnn = "";
			if (cnn.length() == 1) {
				BigDecimal arbic = isCNNumeric(cnn.charAt(0));
				if (arbic.compareTo(new BigDecimal(10)) != 1)
					val = val.add(arbic.multiply(new BigDecimal(100)));
				cnn = "";
			}

		}

		bai = cnn.lastIndexOf('��');
		if (bai > -1) {
			val = val.add(cnNumericToArabic(cnn.substring(0, bai), false).multiply(new BigDecimal(100)));
			;
			if (bai < cnn.length() - 1)
				cnn = cnn.substring(bai + 1, cnn.length());
			else
				cnn = "";
			if (cnn.length() == 1) {
				BigDecimal arbic = isCNNumeric(cnn.charAt(0));
				if (arbic.compareTo(new BigDecimal(10)) != 1)
					val = val.add(arbic.multiply(new BigDecimal(10)));
				cnn = "";
			}
		}

		shi = cnn.lastIndexOf('ʮ');
		if (shi > -1) {
			if (shi == 0)
				val = val.add(new BigDecimal(10));
			else
				val = val.add(cnNumericToArabic(cnn.substring(0, shi), false).multiply(new BigDecimal(10)));
			if (shi < cnn.length() - 1)
				cnn = cnn.substring(shi + 1, cnn.length());
			else
				cnn = "";
		}

		cnn = cnn.trim();
		for (int j = 0; j < cnn.length(); j++)
			val = val.add(BigDecimal.valueOf(Math.pow(10, cnn.length() - j - 1)).multiply(isCNNumeric(cnn.charAt(j))));

		return val;
	}
	//format С������
	private static BigDecimal qCNNumericToArabic(String cnn) {
		BigDecimal val = BigDecimal.valueOf(0);
		cnn = cnn.trim();
		for (int j = 0; j < cnn.length(); j++)
			val = val.add(BigDecimal.valueOf(Math.pow(10,- j - 1)).multiply(isCNNumeric(cnn.charAt(j))));
		return val;
	}
	
	public static BigDecimal chineseNumToArabic(String expression){
		int pointer = -1;
		pointer = expression.indexOf("��");
			if(pointer > -1){
				return cnNumericToArabic(expression.substring(0,pointer), true)
						.add(qCNNumericToArabic(expression.substring(pointer+1)));
			}
			return cnNumericToArabic(expression, true);
	}
}
