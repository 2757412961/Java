package main.java.edu.zju.zjh.core.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2021/4/8 9:37
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Generic {

    public Map<String, User> generic(Integer i, List<Boolean> lb) {
        System.out.println("invoke generic!");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method generic = Generic.class.getDeclaredMethod("generic", Integer.class, List.class);
        generic.setAccessible(true);

        Type[] genericParameterTypes = generic.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#" + genericParameterType);
        }

        Type genericReturnType = generic.getGenericReturnType();
        System.out.println("@" + genericReturnType);
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(" " + actualTypeArgument);
            }
        }

    }

}
