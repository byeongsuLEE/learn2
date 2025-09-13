package geneic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 작성자  : lbs
 * 날짜    : 2025-09-13
 * 풀이방법
 **/


public class Generics<a extends Number> {

    Map<a, ? extends Number> map = new HashMap<>();

    private a number ;

    public Generics(a number) {
        this.number = number;
    }

    public Number resultNum(a numberB , a numberC){
        return numberB.doubleValue()+ numberC.doubleValue();
    }

    public void getNumType(){
        System.out.println(number.getClass());
    }

    public Map<a, ? extends Number> getMap(a key){
        return map;
    }
}
