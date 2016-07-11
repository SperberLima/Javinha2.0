package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class verdisciplina_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\" style=\"\r\n");
      out.write("    min-width: 100%;\r\n");
      out.write("\"><head>\r\n");
      out.write("<meta charset=\"utf-8\"> \r\n");
      out.write("<title>COOP</title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1, user-scalable=no\"> \r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/scm.css\">   \r\n");
      out.write(" <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.3/jquery.min.js\"></script>  \r\n");
      out.write("<script type=\"text/javascript\" src=\"js/script.js\"></script>\r\n");
      out.write("<link rel=\"icon\" href=\"http://i.imgur.com/4LnFIn3.png\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Fjalla+One|Oswald:400,700|Passion+One|Anton|Source+Sans+Pro\" rel=\"stylesheet\" type=\"text/css\">  \r\n");
      out.write("<style type=\"text/css\"></style><style type=\"text/css\"></style><style type=\"text/css\"></style><style type=\"text/css\"></style><style type=\"text/css\"></style><style type=\"text/css\"></style></head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"html\">  \r\n");
      out.write("      \r\n");
      out.write("    <header id=\"header\" class=\"\" style=\"display: none;\">  \r\n");
      out.write("        <nav class=\"main\"> \r\n");
      out.write("  \t\t     \t\r\n");
      out.write("          <div style=\"margin: 0 auto;\">\r\n");
      out.write("            <img src=\"http://imgur.com/eqKINnm.png\" style=\"height: 50px;margin-top: 16px;\">   \r\n");
      out.write("          </div>\r\n");
      out.write("        </nav>   \r\n");
      out.write("    </header>    \r\n");
      out.write("      \r\n");
      out.write("    <div id=\"content\" class=\"\" style=\"\">  \r\n");
      out.write("        <div id=\"menu\" class=\"hide\">   \r\n");
      out.write("  <h1>MENU</h1>\r\n");
      out.write("            <ul> <a href=\"index.jsp\"><li><span>Home</span></li></a> <a href=\"ajuda.html\"><li><span>Ajuda</span></li></a> <a href=\"about.html\"><li><span>Sobre nós</span></li></a> </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"wrapper\" class=\"\">\r\n");
      out.write("            <div style=\"min-width: 100%; height: 63px; padding-top: 16px; background: #668f86; box-shadow: 0px 0px 5px 6px rgba(0, 0, 0, 0.10); position: relative;\">\r\n");
      out.write("                <a id=\"openMenu\" onclick=\"javascript: showMenu();\" class=\"\"><img class=\"burguer\" src=\"http://www.sbrnetportal.com/images/hamburger.png\" style=\"\"></a>\r\n");
      out.write("                <img src=\"http://i.imgur.com/r3Mrk7e.png\" style=\"height: 50px;margin: 0 auto;display: block;\">   \r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("<div class=\"form_container\">\r\n");
      out.write("  <h1 class=\"form_title\">Lista de disciplinas</h1>\r\n");
      out.write("\r\n");
      out.write("            <form name=\"fmCurso\" method=\"post\" action=\"\">\r\n");
      out.write("                <table class=\"view\">\r\n");
      out.write("                    <tbody><tr style=\"\r\n");
      out.write("\">\r\n");
      out.write("                        <th>\r\n");
      out.write("                            ID\r\n");
      out.write("                        </th>\r\n");
      out.write("                        <th>\r\n");
      out.write("                            Carga Horária\r\n");
      out.write("                        </th>\r\n");
      out.write("                        <th>\r\n");
      out.write("                            Nome\r\n");
      out.write("                        </th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("                            Ementa\r\n");
      out.write("                        </th>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("  <th style=\"\r\n");
      out.write("    padding-right: 0px;\r\n");
      out.write("\"></th><th style=\"\r\n");
      out.write("    padding-right: 0px;\r\n");
      out.write("\"></th>\r\n");
      out.write("                    </tr>\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr style=\"\r\n");
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("                          sample\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\tsample\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tsample\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\tsample\r\n");
      out.write("\t\t\t\t\t\t</td> \r\n");
      out.write("\t\t\t\t\t\t<td style=\"\r\n");
      out.write("    padding-right: 10px;\r\n");
      out.write("\">                            \r\n");
      out.write("\t\t\t\t\t\t\t<button id=\"alterar\" onclick=\"\"></button>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("  \t\t\t\t\t\t<td style=\"padding-right: 0px;\">                            \r\n");
      out.write("\t\t\t\t\t\t\t<button id=\"excluir\" onclick=\"\"></button>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("                </tbody></table>\r\n");
      out.write("            </form>\r\n");
      out.write("</div>\r\n");
      out.write(" \r\n");
      out.write("        </div>\r\n");
      out.write("           \r\n");
      out.write("    </div>  \r\n");
      out.write("          </body></html> ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
