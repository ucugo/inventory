package util;

import java.util.UUID;

/**
 * Created by Ugo on 01/05/2015.
 */
public class UUIDUtil {

    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        s = s.toLowerCase().replace("-", "");
        return s;
    }
}
