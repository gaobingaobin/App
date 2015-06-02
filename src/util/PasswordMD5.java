package util;

import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  

public class PasswordMD5 {
	 public String getMD5(byte[] source){
		 String s=null;
		 //�������ֽ�ת����16���Ʊ�ʾ���ַ�  
        char[] hexDigits={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};  
        try {  
            MessageDigest md=MessageDigest.getInstance("MD5"); 
            md.update(source);
            //MD5�ļ�������һ��128λ�ĳ����������ֽڱ�ʾΪ16���ֽ�  
            byte[] tmp=md.digest();
            //ÿ���ֽ���16���Ʊ�ʾ�Ļ���ʹ��2���ַ�(��4λһ��,��4λһ��)�����Ա�ʾ��16������Ҫ32���ַ�  
            char[] str=new char[16*2]; 
            int k=0;//ת������ж�Ӧ���ַ�λ��  
            for(int i=0;i<16;i++){//��MD5��ÿһ���ֽ�ת����16�����ַ�  
                byte byteOne=tmp[i]; 
                str[k++]=hexDigits[byteOne>>>4 & 0xf];//���ֽڸ�4λ����16����ת��  
                str[k++]=hexDigits[byteOne & 0xf];    //���ֽڵ�4λ����16����ת��  
            }  
            s=new String(str);  
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();  
        }  
        return s;
	 }
}