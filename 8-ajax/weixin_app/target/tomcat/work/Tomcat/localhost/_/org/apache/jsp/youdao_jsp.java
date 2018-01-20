/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-01-20 08:52:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class youdao_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>我的翻译官\t</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<input type=\"text\" id=\"word\" />\r\n");
      out.write("\t<button id=\"btn\">翻译</button>\r\n");
      out.write("\t<div id=\"content\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t<script src=\"/static/js/ajax.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t(function(){\r\n");
      out.write("\t\t\tvar input = document.getElementById(\"word\");\r\n");
      out.write("\t\t\tvar btn = document.getElementById(\"btn\");\r\n");
      out.write("\t\t\tvar content = document.getElementById(\"content\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tbtn.onclick = function(){\r\n");
      out.write("\t\t\t\tcontent.innerText = \"\";\r\n");
      out.write("\t\t\t\tvar xmlHttp = $.createXmlHttp();\r\n");
      out.write("\t\t\t\txmlHttp.open(\"GET\",\"/youdao2?p=\" + input.value);\r\n");
      out.write("\t\t \t\txmlHttp.onreadystatechange = function(){\r\n");
      out.write("\t\t\t\t\tif(xmlHttp.readyState == 4) {\r\n");
      out.write("\t\t\t\t\t\tif(xmlHttp.status == 200) {\r\n");
      out.write("\t\t\t\t\t\t\t/* var xmlDom = xmlHttp.responseXML;\r\n");
      out.write("\t\t\t\t\t\t\tvar explains = xmlDom.getElementsByTagName(\"explains\")[0];\r\n");
      out.write("\t\t\t\t\t\t\tvar ex = explains.getElementsByTagName(\"ex\")[0];\r\n");
      out.write("\t\t\t\t\t\t\tvar text = ex.childNodes[0].nodeValue;\r\n");
      out.write("\t\t\t\t\t\t\t */\r\n");
      out.write("\t\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t\t\tvar json = JSON.parse(xmlHttp.responseText);\r\n");
      out.write("\t\t\t\t\t\t\tconsole.log(json);\r\n");
      out.write("\t\t\t\t\t\t\tvar text = json.translation[0];\r\n");
      out.write("\t\t\t\t\t\t\tvar p = document.createElement(\"p\");// <p></p>\r\n");
      out.write("\t\t\t\t\t\t\tvar textNode = document.createTextNode(text);\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\tp.appendChild(textNode);\r\n");
      out.write("\t\t\t\t\t\t\tcontent.appendChild(p);\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\talert(\"系统繁忙，请稍后重试\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\txmlHttp.send();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t})();\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
