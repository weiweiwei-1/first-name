package Informal.mybatis.Controller.ExtrateOperate;

import org.apache.commons.lang3.StringUtils;

public class CompareSimilarity {
    public static Integer compare(String userInformation, String systemInformation) {
        if (StringUtils.isBlank(userInformation) || StringUtils.isBlank(systemInformation)) {
            return 0;
        }
        if (userInformation.contains(systemInformation) || systemInformation.contains(userInformation)) {
            return 100;
        }
        int ul = userInformation.length();
        int sl = systemInformation.length();
        int i = 0, j = 0;
        int similarityCount = 0;
        int slPoint = 0;
        for (i = 0; i < ul; i++) {
            for (j = slPoint; j < sl; j++) {
                if (userInformation.charAt(i) == systemInformation.charAt(j)) {
                    similarityCount++;
                    slPoint = j++;
                }
            }
        }
        int totalNumber = min(ul,sl);
        try {
           return (100*similarityCount)/totalNumber;
        } catch (ArithmeticException ae) {
            return 0;
        }

    }

    private static int min(int a, int b) {
        return a < b?a:b;
    }

    public static void main(String args[]) {
        System.out.println(compare("合工大","合工业学"));
    }
}

