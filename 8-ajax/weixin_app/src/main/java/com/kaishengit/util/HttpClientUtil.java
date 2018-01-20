package com.kaishengit.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;


public class HttpClientUtil {

	public static String HttpClientGet(String url, String encoding) {
		// 创建一个客户端对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建get请求对象
		HttpGet get = new HttpGet(url);
		String result = null;
		try {
			// 发起请求并接收相应数据
			HttpResponse resp = httpClient.execute(get);
			// 获取相应的状态码
			int code = resp.getStatusLine().getStatusCode();
			if (code == 200) {
				InputStream in = resp.getEntity().getContent();
				result = IOUtils.toString(in, encoding);

			} else {
				
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public static String HttpCilentPost(String url, String encoding, Map<String, String> params) {
		// 创建一个客户端对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// 创建post请求对象
		HttpPost post = new HttpPost(url);

		List<NameValuePair> pairsList = new ArrayList<>();
		Set<Entry<String, String>> entrySet = params.entrySet();
		for (Entry<String, String> entry : entrySet) {
			pairsList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		String result = null;
		try {

			post.setEntity(new UrlEncodedFormEntity(pairsList));
			// 发起post请求，并接收响应数据
			HttpResponse resp = httpClient.execute(post);

			int code = resp.getStatusLine().getStatusCode();
			if (code == 200) {
				InputStream in = resp.getEntity().getContent();
				result = IOUtils.toString(in, encoding);
				
			} else {
				System.out.println("请求异常");
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	
	 /**
     * 根据api地址和参数生成请求URL
     * @param url
     * @param params
     * @return
     */
    public static String getUrlWithQueryString(String url, Map<String,String> params) {
        if (params == null) {
            return url;
        }

        StringBuilder builder = new StringBuilder(url);
        if (url.contains("?")) {
            builder.append("&");
        } else {
            builder.append("?");
        }

        int i = 0;
        for (String key : params.keySet()) {
            String value = params.get(key);
            if (value == null) { // 过滤空的key
                continue;
            }

            if (i != 0) {
                builder.append('&');
            }

            builder.append(key);
            builder.append('=');
            builder.append(encode(value));

            i++;
        }

        return builder.toString();
    }
    
    /**
     * 进行URL编码
     * @param input
     * @return
     */
    public static String encode(String input) {
        if (input == null) {
            return "";
        }

        try {
            return URLEncoder.encode(input, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return input;
    }
    
}
