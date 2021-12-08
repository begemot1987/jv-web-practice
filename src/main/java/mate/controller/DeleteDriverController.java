package mate.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import mate.lib.Injector;
import mate.service.DriverService;

@WebServlet("/drivers/delete")
public class DeleteDriverController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("mate");
    private static DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long driverId = Long.parseLong(req.getParameter("id"));
        driverService.delete(driverId);
        resp.sendRedirect("/drivers");
    }
}
