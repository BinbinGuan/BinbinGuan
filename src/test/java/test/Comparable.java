package test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author GuanBin
 * @version Comparable.java, v1 2017/11/21 上午12:01 GuanBin Exp $$
 */
public class Comparable {
    public static void main(String[] args){
        Set<Integer> s=new HashSet<>();
        Integer b[] =new Integer[2];
        b[0]=0;
        b[1]=1;
        Integer a[] = {0,1,2,8,8,9,9,0} ;
        //加入set集合后去重
        Collections.addAll(s,a);
        System.out.println(s);


    }
}
