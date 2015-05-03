package util;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Ugo on 01/05/2015.
 */
public class UrlUtils {
    public static String appendQueryParam(String url, String name, String value) {
        String sep = "?";
        if (url.contains(sep))
            sep = "&";
        return url + sep + encode(name) + "=" + encode(value);
    }

    public static void appendQueryParam(StringBuilder url, String name, String value) {
        String sep = "?";
        if (url.indexOf("?") >= 0) {
            sep = "&";
        }
        url.append(sep).append(encode(name)).append("=").append(encode(value));
    }

    public static String encode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not supported");
        }
    }

    public static String buildQueryString(Map<String, String> params) {
        boolean first = true;
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            if (!first) {
                result.append("&");
            }
            first = false;
            result.append(encode(param.getKey())).append("=").append(encode(param.getValue()));
        }
        return result.toString();
    }

    public static Map<String, String[]> splitQueryString(String query) {
        if (query == null || query.length() == 0)
            return new LinkedHashMap<String, String[]>();
        if (query.charAt(0) == '?')
            query = query.substring(1);
        String[] pairs = query.split("&");
        Map<String, String[]> params = new LinkedHashMap<String, String[]>();
        for (String pair : pairs) {
            String[] nameValue = pair.split("=");
            String name, value;
            if (nameValue.length == 1) {
                name = nameValue[0];
                value = "";
            }
            else {
                name = nameValue[0];
                value = nameValue[1];
            }
            name = decode(name);
            value = decode(value);
            String[] values = params.get(name);
            if (values == null)
                values = new String[] { value };
            else
                values = (String[]) ArrayUtils.add(values, value);
            params.put(name, values);
        }
        return params;
    }
    public static final String buildUrl(String baseUrl, NameValuePair... nameValuePairs){
        StringBuilder urlBuilder = new StringBuilder(baseUrl);
        for(NameValuePair nameValuePair : nameValuePairs){
            urlBuilder.append(StringUtils.contains("url", "?")?"&":"?");
            urlBuilder.append(nameValuePair.getName()).append("=").append(nameValuePair.getValue());
        }
        return urlBuilder.toString();
    }
    public static String decode(String urlPart) {
        try {
            return URLDecoder.decode(urlPart, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported");
        }
    }
}
