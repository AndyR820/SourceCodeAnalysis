package map;

import java.util.*;

public class mapStudy {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap <>();
        map.put("a","1");
        map.put("b","2");


    }

    public void first(Map<String,String> map){
        Collection <String> c=map.values();
        Iterator i = c.iterator();
        for(; i.hasNext() ;){
            System.out.println(i.next());//遍历出map内的所有value
        }
    }

    public void second(Map<String,String> map){
        for(Map.Entry<String, String> entry : map.entrySet()){
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey+":"+mapValue);
        }
    }

    public void third(Map<String,String> map){
//key
        for(String key : map.keySet()){
            System.out.println(key);
        }
//value
        for(String value : map.values()){
            System.out.println(value);
        }
    }



}
