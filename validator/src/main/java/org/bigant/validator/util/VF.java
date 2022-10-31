package org.bigant.validator.util;

import java.util.regex.Pattern;

/**
 * 工具类
 */
public class VF {

    /**
     * 非空字符串判断
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * 非空数组判断
     *
     * @param arr
     * @return
     */
    public static boolean isEmpty(Object[] arr) {
        return arr == null || arr.length == 0;
    }

    /**
     * 正则校验
     */
    public static boolean matches(String pattern, String content) {
        return Pattern.matches(pattern, content);
    }

    /**
     * 所有内容必须匹配正则
     */
    public static boolean matchesAll(String pattern, String[] contents) {
        for (String content : contents) {
            if (!VF.matches(pattern, content)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 内容必须配置所有正则
     *
     * @param patterns
     * @param content
     * @return
     */
    public static boolean matchesAll(String[] patterns, String content) {
        for (String pattern : patterns) {
            if (!VF.matches(pattern, content)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 内容匹配其中一个正则即可满足
     *
     * @param patterns
     * @param content
     * @return
     */
    public static boolean matchesAny(String[] patterns, String content) {
        for (String pattern : patterns) {
            if (VF.matches(pattern, content)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 多个内容有一个满足表达式即可
     *
     * @param pattern
     * @param contents
     * @return
     */
    public static boolean matchesAny(String pattern, String[] contents) {
        for (String content : contents) {
            if (VF.matches(pattern, content)) {
                return true;
            }
        }
        return false;
    }


}
