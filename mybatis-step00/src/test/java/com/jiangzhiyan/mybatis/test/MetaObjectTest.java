package com.jiangzhiyan.mybatis.test;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MetaObjectTest {

    @Test
    public void metaObjectTest() {
        //第一次读取
        Teca teca = new Teca();

        List<Teca.Stu> objects = new ArrayList<>();
        objects.add(new Teca.Stu());

        teca.setName("jzy");
        teca.setStus(objects);

        MetaObject metaObject = SystemMetaObject.forObject(teca);
        System.out.println("GetterNames:" + JSON.toJSONString(metaObject.getGetterNames()));
        System.out.println("SetterNames:" + JSON.toJSONString(metaObject.getSetterNames()));
        System.out.println("name的get方法返回值类型:" + JSON.toJSONString(metaObject.getGetterType("name")));
        System.out.println("stus的set方法参数值类型:" + JSON.toJSONString(metaObject.getSetterType("stus")));
        System.out.println("name的hasGetter:" + metaObject.hasGetter("name"));
        System.out.println("stu.id(stu属性为对象)的hasGetter:" + metaObject.hasGetter("stu.id"));
        System.out.println("获取name的属性值:" + metaObject.getValue("name"));
        //重新设置属性值
        metaObject.setValue("name","jack");
        System.out.println("新name的属性值:" + metaObject.getValue("name"));
        //设置属性(集合)的元素值
        metaObject.setValue("stus[0].id","0001");
        System.out.println("获取stus集合的第一个元素的属性值:" + JSON.toJSONString(metaObject.getValue("stus[0].id")));
        System.out.println("对象的序列化:" + JSON.toJSONString(teca));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Teca {

        private String name;

        private double price;

        private List<Stu> stus;

        private Stu stu;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Stu {
             private String id;
        }
    }
}
