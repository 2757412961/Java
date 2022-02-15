package edu.zju.zjh.core.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zjh
 * @date : 2021/4/7 19:43
 * @Email : 2757412961@qq.com
 * @update:
 */

/*
 * pojo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;

    private String name;

    private int age;

    private void test() {

    }
}
