package me.ele.shop.sdk.interfaces.entity.order;

import lombok.Data;
import me.ele.shop.sdk.interfaces.enumeration.order.OrderDetailGroupType;

import java.util.ArrayList;
import java.util.List;

//食物分组(蓝子)
@Data
public class Group {
    private String name = "";//分组名称
    private OrderDetailGroupType type;//分组类型，可以为 normal / extra / discount
    private List<Item> items = new ArrayList<>();//食物信息

}
