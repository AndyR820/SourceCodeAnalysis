package enums;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy
 * <p>
 * 子包状态：1 未被领取；2 已被领取；3  已过期；4 已退回
 */
public enum SubpacketStatusEnum {
    UNSNATCHED(1, "未被领取"), SNATCHED(2, "已被领取"), EXPIRED(3, "已过期"), RETURNED(4, "已退回");

    private Integer id;
    private String description;

    SubpacketStatusEnum(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public static SubpacketStatusEnum idOf(Integer id) {
        for (SubpacketStatusEnum redpacketTypeEnum : values()) {
            if (redpacketTypeEnum.getId().equals(id)) {
                return redpacketTypeEnum;
            }
        }
        throw new EnumException("Could not found this id.");
    }

    public static SubpacketStatusEnum nameOf(String name) {
        for (SubpacketStatusEnum redpacketTypeEnum : values()) {
            if (redpacketTypeEnum.getName().equalsIgnoreCase(name)) {
                return redpacketTypeEnum;
            }
        }
        throw new EnumException("Could not found this name.");
    }
    public static List<Integer> getIds() {
        List<Integer> result = new ArrayList<>();
        for (SubpacketStatusEnum redpacketTypeEnum : values()) {
            result.add(redpacketTypeEnum.getId());
        }
        return result;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name();
    }

    public String getDescription() {
        return this.description;
    }


    public static void main(String[] args) {
        SubpacketStatusEnum subpacketStatusEnum=idOf(2);
        System.out.println(subpacketStatusEnum.getId());
        System.out.println(subpacketStatusEnum.getName());
        System.out.println(subpacketStatusEnum.getDescription());




    }
}
