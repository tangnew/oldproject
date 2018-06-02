package com.exam.utils;

import java.util.UUID;

/**
 * 
 * Created by JW.
 * User: JW
 * Date: Sep 26, 2016 
 * Time: 3:34:56 PM
 *
 * com.gmm.utils.UuidUtil
 */
public final class UuidUtil {
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
