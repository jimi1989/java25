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
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientUtil {

	public static String httpClientGet(String url, String encoding) {
		// 1.创建客户端对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 2.创建httpGet对象
		HttpGet get = new HttpGet(url);
		// 3.发起get请求并接收响应
		InputStream in = null;
		String result = null;
		try {
			HttpResponse response = httpClient.execute(get);
			// 4.获得响应httpCode判断htppCode的值是否为200
			int httpCode = response.getStatusLine().getStatusCode();
			if(httpCode == 200) {
				// 5.接收服务端返回的内容，实质上都是流
				in = response.getEntity().getContent();
				result = IOUtils.toString(in,encoding);
				return result;
			} else {
				System.out.println("访问异常，error:" + httpCode);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//　关闭资源
			try {
				if(in != null) {
					in.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				try {
					if(httpClient != null) {
						httpClient.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
		}
		
		return result;
	}
	
	public static String httpClientPost(String url, String encoding, Map<String,String> params) {
		// 创建客户端对象
		CloseableHttpClient httpCilent = HttpClients.createDefault();
		// 创建post请求
		HttpPost post = new HttpPost(url);
		
		// 封装post请求参数集合
		List<NameValuePair> lists = new ArrayList<>();
		// 解析map集合中的键值对到BasicNameValuePair对象中去并add到list集合
		Set<Entry<String,String>> sets = params.entrySet();
		for(Entry<String,String> set : sets) {
			lists.add(new BasicNameValuePair(set.getKey(), set.getValue()));
		}
		InputStream in = null;
		String result = null;
		try {
			// 设置到post请求对象的entity属性
			post.setEntity(new UrlEncodedFormEntity(lists));
			
			HttpResponse resp = httpCilent.execute(post);
			
			int httpCode = resp.getStatusLine().getStatusCode();
			if(httpCode == 200) {
				in = resp.getEntity().getContent();
				result = IOUtils.toString(in,encoding);
				return result;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(httpCilent != null) {
						try {
							httpCilent.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
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
