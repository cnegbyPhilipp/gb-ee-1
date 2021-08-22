package ru.gb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.gb.domain.Product;
import ru.gb.service.ProductService;
import ru.gb.service.impl.ProductServiceImpl;

@WebServlet(name = "productServlet", value = "/products")
public class ProductServlet extends HttpServlet {

  private final ProductService productService;

  public ProductServlet() {
    productService = new ProductServiceImpl();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Product> products = productService.createProducts();

    PrintWriter out = resp.getWriter();
    out.println("<html><body>");

    out.println("<h1>");
    out.println("Products list:");
    out.println("</h1>");

    products.forEach(product -> {
      out.println("<br>");
      out.println(product.toString());
      out.println("</br>");
    });

    out.println("</body></html>");
  }
}
