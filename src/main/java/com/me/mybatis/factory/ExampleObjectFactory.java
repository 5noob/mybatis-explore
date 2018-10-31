package com.me.mybatis.factory;

import com.me.mybatis.domain.Blog;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author OuyangJie
 * @Date 2018/10/31 9:46
 * @Description:
 */
public class ExampleObjectFactory extends DefaultObjectFactory {
    private Properties properties;

    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T object =  super.create(type, constructorArgTypes, constructorArgs);
        //在Mybatis自动实例化Blog类时（比如select时），可以搞一些事情
        //为什么只在这个create方法加一些逻辑，不在上一个create方法加，因为上一个create方法，还是调用了这个方法
        if(type == Blog.class){
            ((Blog) object).work();
        }
        return object;
    }

    @Override
    public void setProperties(Properties properties) {
        //这个properties来自mybatis-config.xml的设置
        /**
         * <objectFactory type="com.me.mybatis.factory.ExampleObjectFactory">
         *         <property name="someProperty" value="100" />
         *     </objectFactory>
         */

        this.properties = properties;
        System.out.println("==== setProperties这里也搞一些事情 =====");
        for(Map.Entry<Object, Object> entry: properties.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
