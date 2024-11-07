package LAB2.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import LAB2.Dao.UserDAO;
import LAB2.Dao.UserDAOImpl;
import LAB2.entity.Userr;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({
    "/user/crud/index",
    "/user/crud/edit/*",
    "/user/crud/create",
    "/user/crud/update",
    "/user/crud/delete",
    "/user/crud/reset"
})
public class UserCRUDServlet extends HttpServlet {
    private UserDAO dao = new UserDAOImpl();  // Khai báo UserDAO

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Userr form = new Userr();
        try {
            // Sử dụng BeanUtils để lấy dữ liệu từ request và gán cho form
            BeanUtils.populate(form, req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        String path = req.getServletPath();
        String message = "Enter user information";  // Thông báo mặc định

        if (path.contains("edit")) {
            // Xử lý khi nhấp vào "edit"
            String id = req.getPathInfo().substring(1);
            form = dao.findById(id);  // Tìm user theo ID từ DAO
            message = "Edit user: " + id;
        } else if (path.contains("create")) {
            // Xử lý khi nhấp vào "create"
            dao.create(form);  // Thêm user mới vào CSDL
            message = "Created user: " + form.getId();
            form = new Userr();  // Reset form sau khi tạo
        } else if (path.contains("update")) {
            // Xử lý khi nhấp vào "update"
            dao.update(form);  // Cập nhật thông tin user trong CSDL
            message = "Updated user: " + form.getId();
        } else if (path.contains("delete")) {
            // Xử lý khi nhấp vào "delete"
            dao.deleteById(form.getId());  // Xóa user theo ID khỏi CSDL
            message = "Deleted user: " + form.getId();
            form = new Userr();  // Reset form sau khi xóa
        } else if (path.contains("reset")) {
            // Xử lý khi nhấp vào "reset"
            form = new Userr();  // Reset form
        }

        // Truy vấn danh sách tất cả user từ CSDL
        List<Userr> list = dao.findAll();
        req.setAttribute("message", message);  // Gán thông báo cho request
        req.setAttribute("user", form);        // Gán user hiện tại cho request
        req.setAttribute("users", list);       // Gán danh sách user cho request

        // Chuyển hướng tới trang JSP để hiển thị dữ liệu
        req.getRequestDispatcher("/LAB2/user.jsp").forward(req, resp);
    }
}
