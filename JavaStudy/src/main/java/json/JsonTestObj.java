package json;

import com.alibaba.fastjson.JSON;

public class JsonTestObj {
    public static void main(String[] args) {
        /**
         * json字符串转化为对象
         */
        String jsonString = "{name:'Antony',age:'12',sex:'male',telephone:'88888'}";
        TestObj staff = JSON.parseObject(jsonString, TestObj.class);
        System.out.println(staff);

        /**
         * 对象转化为json字符串
         */
        String jsonStr = JSON.toJSONString(staff);
        System.out.println(jsonStr);

    }

}
