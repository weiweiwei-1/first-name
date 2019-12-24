package Informal.mybatis.Model.DataStructure;

import org.junit.Test;

public class DataStructureTest {
    private DataStructure dataStructure=new DataStructure();
    @Test
    public void testMixSort(){
        int []a={1,3,6,7,8};
        int []b={2,4,6,7,8,9};
        dataStructure.mixArraySort(a,b);
    }
}
