package mate.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import mate.lib.Injector;
import mate.service.ManufacturerService;

@WebServlet("/manufacturers/delete")
public class DeleteManufacturerController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("mate");
    private static ManufacturerService manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long manufacturerId = Long.parseLong(req.getParameter("id"));
        manufacturerService.delete(manufacturerId);
        resp.sendRedirect("/manufacturers");
    }
}