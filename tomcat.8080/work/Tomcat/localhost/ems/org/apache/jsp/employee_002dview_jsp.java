/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.7
 * Generated at: 2023-09-18 08:57:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class employee_002dview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <!-- Required meta tags -->\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css\">\r\n");
      out.write("    <link href=\"assets/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <title>View Employees</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"search_all_employees();\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"container mt-5\">\r\n");
      out.write("    <div class=\"row d-flex justify-content-center\">\r\n");
      out.write("        <h1 class=\"text-center text-uppercase\">Manage Employees - search/update/delete</h1>\r\n");
      out.write("        <div class=\"col-10\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-6 mt-3\">\r\n");
      out.write("                            <label for=\"hire-date\" class=\"form-label\">Employee name</label>\r\n");
      out.write("                            <input type=\"text\" id=\"hire-date\" class=\"form-control\" aria-describedby=\"passwordHelpBlock\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-4 mt-3\">\r\n");
      out.write("                            <label for=\"\" class=\"form-label\">Select Option</label>\r\n");
      out.write("                            <select class=\"form-select\" aria-label=\"Default select example\">\r\n");
      out.write("                                <option selected>Open this select menu</option>\r\n");
      out.write("                                <option value=\"1\">One</option>\r\n");
      out.write("                                <option value=\"2\">Two</option>\r\n");
      out.write("                                <option value=\"3\">Three</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <button class=\"btn btn-outline-dark col-2 font-monospace\"\r\n");
      out.write("                                style=\"height: 45px; margin-top: 45px\"> Search\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <table class=\"table\" id=\"table\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th scope=\"col\">#</th>\r\n");
      out.write("                            <th scope=\"col\">name</th>\r\n");
      out.write("                            <th scope=\"col\">position</th>\r\n");
      out.write("                            <th scope=\"col\">department</th>\r\n");
      out.write("                            <th scope=\"col\">hire-date</th>\r\n");
      out.write("                            <th scope=\"col\">salary</th>\r\n");
      out.write("                            <th scope=\"col\">update</th>\r\n");
      out.write("                            <th scope=\"col\">delete</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        </tbody>\r\n");
      out.write("\r\n");
      out.write("                    </table>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <div class=\"row mt-5 d-flex justify-content-center\">\r\n");
      out.write("                        <a href=\"employee-add.jsp\" class=\"text-center\">\r\n");
      out.write("                            <button class=\"btn btn-primary text-center col-4\"> Go to Add-Employee</button>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Update Modal -->\r\n");
      out.write("<div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <h5 class=\"modal-title\" id=\"exampleModalLabel\">Update Employee - 00111</h5>\r\n");
      out.write("                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <h3 class=\"text-center text-uppercase\">Update Employee </h3>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"mt-3\">\r\n");
      out.write("                    <label for=\"name\" class=\"form-label\">Name</label>\r\n");
      out.write("                    <input type=\"text\" id=\"name\" class=\"form-control\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"mt-3\">\r\n");
      out.write("                    <label for=\"position\" class=\"form-label\">Position</label>\r\n");
      out.write("                    <input type=\"text\" id=\"position\" class=\"form-control\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"mt-3\">\r\n");
      out.write("                    <label for=\"department\" class=\"form-label\">Department</label>\r\n");
      out.write("                    <input type=\"text\" id=\"department\" class=\"form-control\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"mt-3\">\r\n");
      out.write("                    <label for=\"hiredate\" class=\"form-label\">Hire Date</label>\r\n");
      out.write("                    <input type=\"date\" id=\"hiredate\" class=\"form-control\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"mt-3\">\r\n");
      out.write("                    <label for=\"salary\" class=\"form-label\">Salary</label>\r\n");
      out.write("                    <input type=\"number\" id=\"salary\" class=\"form-control\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Close</button>\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" id=\"update-model-save\">Save changes</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Modal -->\r\n");
      out.write("<div class=\"modal fade\" id=\"deleteModel\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <h5 class=\"modal-title\" id=\"deleteModel-title\">Delete User</h5>\r\n");
      out.write("                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\" id=\"deleteModel-body\">\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\" id=\"deleteModel-close\">Close\r\n");
      out.write("                </button>\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" id=\"deleteModel-save\">Save changes</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"assets\\bootstrap.bundle.js\"></script>\r\n");
      out.write("<script src=\"assets/main.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}