package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class ChineseNum {
	private static final Character[] CN_NUMERIC = {
            'һ', '��', '��', '��', '��','��', '��', '��', '��',
            'Ҽ', '��', '��', '��', '��', '½', '��', '��','��',
            'ʮ', '��', 'ǧ', 'ʰ', '��', 'Ǫ', '��', '��', '��', '��', '��'};
     
    private static Map<Character, Integer> cnNumeric = null;
     
    static {
        cnNumeric = new HashMap<Character, Integer>(40, 0.85f);
        for ( int j = 0; j < 9; j++ )
            cnNumeric.put(CN_NUMERIC[j], j + 1);
        for ( int j = 9; j < 18; j++ )
            cnNumeric.put(CN_NUMERIC[j], j - 8);
        cnNumeric.put('��', 0);
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
     * @param c <br />
     * @return boolean true yes and false for not.
     */
    public static double isCNNumeric( char c ) {
        Integer i = cnNumeric.get(c);
        if ( i == null ) return (double) -1;
        return (double) i.intValue();
    }
     
     
    /**
     * a static method to turn the Chinese numeric to Arabic numbers.
     *
     * @param cnn
     * @param boolea flag
     * @return int
     */
    public static double cnNumericToArabic( String cnn, boolean flag ) {
 
        cnn = cnn.trim();
        if ( cnn.length() == 1 )
            return isCNNumeric(cnn.charAt(0));
         
        if ( flag ) cnn = cnn.replace('��', '��')
                .replace('Ǫ', 'ǧ').replace('ʰ', 'ʮ').replace('��', ' ');
        //System.out.println(cnn);
        int yi = -1, wan = -1, qian = -1, bai = -1, shi = -1;
        double val = (double) 0;
        yi = cnn.lastIndexOf('��');
        if ( yi > -1 ) {
            val += cnNumericToArabic( cnn.substring(0, yi), false ) * 100000000;
            if ( yi < cnn.length() - 1 )
                cnn = cnn.substring(yi + 1, cnn.length());
            else
                cnn = "";
             
            if ( cnn.length() == 1 ) {
                double arbic = isCNNumeric(cnn.charAt(0));
                if ( arbic <= 10 )
                    val += arbic * 10000000;
                cnn = "";
            }
        }
         
        wan = cnn.lastIndexOf('��');
        if ( wan > -1 ) {
            val += cnNumericToArabic( cnn.substring(0, wan), false ) * 10000;
            if ( wan < cnn.length() - 1 )
                cnn = cnn.substring(wan + 1, cnn.length());
            else
                cnn = "";
            if ( cnn.length() == 1 ) {
                double arbic = isCNNumeric(cnn.charAt(0));
                if ( arbic <= 10 )
                    val += arbic * 1000;
                cnn = "";
            }
        }
         
        qian = cnn.lastIndexOf('ǧ');
        if ( qian > -1 ) {
            val +=  cnNumericToArabic( cnn.substring(0, qian), false ) * 1000;
            if ( qian < cnn.length() - 1 )
                cnn = cnn.substring(qian + 1, cnn.length());
            else
                cnn = "";
            if ( cnn.length() == 1 ) {
                double arbic = isCNNumeric(cnn.charAt(0));
                if ( arbic <= 10 )
                    val += arbic * 100;
                cnn = "";
            }
        }
         
        bai = cnn.lastIndexOf('��');
        if ( bai > -1 ) {
            val += cnNumericToArabic( cnn.substring(0, bai), false ) * 100;
            if ( bai < cnn.length() - 1 )
                cnn = cnn.substring(bai + 1, cnn.length());
            else
                cnn = "";
            if ( cnn.length() == 1 ) {
                double arbic = isCNNumeric(cnn.charAt(0));
                if ( arbic <= 10 )
                    val += arbic * 10;
                cnn = "";
            }
        }
         
        shi = cnn.lastIndexOf('ʮ');
        if ( shi > -1 ) {
            if ( shi == 0 )
                val += 1 * 10;
            else
                val += cnNumericToArabic( cnn.substring(0, shi), false ) * 10;
            if ( shi < cnn.length() - 1 )
                cnn = cnn.substring(shi + 1, cnn.length());
            else
                cnn = "";
        }
         
        cnn = cnn.trim();
        if ( cnn.length() == 1 )
          val+= isCNNumeric(cnn.charAt(0));   
         
        return val;
    }
     
    public static double qCNNumericToArabic( String cnn ) {
        double val = 0.0;
        cnn = cnn.trim();
        for ( int j = 0; j < cnn.length(); j++ )
            val += isCNNumeric(cnn.charAt(j))
                * Math.pow(10,  - j - 1);
        return val;
    }
    public static double cnNumConvert(String expression){
    	if(expression.contains("��")){
    		return cnNumericToArabic(expression.substring(0,expression.lastIndexOf('��')), true)
    				+qCNNumericToArabic(expression.substring(expression.lastIndexOf('��')+1));
    	}
    	return cnNumericToArabic(expression,true);
    }
   public static void main(String[] args) {
       //System.out.println(cnNumericToArabic("һ���������߰�", true));
	   System.out.println(cnNumConvert("��ǧ�˰���"));
    }

}
