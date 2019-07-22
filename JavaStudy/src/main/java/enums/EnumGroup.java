package enums;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Andy
 * @Description: Enum学习
 * @Date: 331
 */
public enum EnumGroup {
    /**
     * 分组id与分组名称
     */
    GROUP_1(1, "1物化历"),
    GROUP_2(2, "2物化地"),
    GROUP_3(3, "3物生历"),
    GROUP_4(4, "4物政历"),
    GROUP_5(5, "5物历地"),
    GROUP_6(6, "6物生政"),
    GROUP_7(7, "7物生地"),
    GROUP_8(8, "8物政地"),
    GROUP_9(9, "9物化政");

    /** 枚举值 */
    private final Integer code;

    /** 枚举描述 */
    private final String message;

    /**
     * 构造方法
     * @param code
     * @param message
     */
    EnumGroup(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {
//        //通过code获取msg
//        System.out.println(getMsgByCode(20));
////        通过枚举<code>code</code>获得枚举
//        System.out.println(getByCode(1));
//        getAllEnum();
        System.out.println(geteunmByname("GROUP_3"));
        System.out.println(EnumGroup.GROUP_1.getCode());

    }
    /**
     * 通过code获取msg
     *
     * @param code 枚举值
     *
     * @return
     */
    public static String getMsgByCode(Integer code) {
        if (code == null) {
            return null;
        }
        EnumGroup enumList = getByCode(code);
        if (enumList == null) {
            return null;
        }
        return enumList.getMessage();
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     *
     * values() 方法将枚举转变为数组
     *
     * @return AuthGradeEnum
     */
    public static EnumGroup getByCode(Integer code) {
        for (EnumGroup enumList : values()) {
            if (enumList.getCode().equals(code)) {
                return enumList;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return List<AuthGradeEnum>
     */
    public static List<EnumGroup> getAllEnum() {
        List<EnumGroup> list = new ArrayList<>(values().length);
        for (EnumGroup enumList : values()) {
            list.add(enumList);
            System.out.println(enumList.name());
        }
        return list;
    }


    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public static List<Integer> getAllEnumCode() {
        List<Integer> list = new ArrayList<>(values().length);
        for (EnumGroup enumList : values()) {
            list.add(enumList.getCode());
        }
        return list;
    }

    /**
     * 根据名称定义枚举
     *
     * @return List<String>
     */
    public static Integer geteunmByname(String name) {
        return Enum.valueOf(EnumGroup.class,name).getCode();
    }


}