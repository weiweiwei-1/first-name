package Informal.mybatis.Convert;

public class AgeJudge {
    public static boolean Judge(String age) {
        try{
            int ageNumber = Integer.valueOf(age);
            return 0 < ageNumber && ageNumber <= 120;
        } catch (Exception e) {
            return false;
        }
    }
}
