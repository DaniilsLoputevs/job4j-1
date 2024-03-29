package ru.job4j.storeauto.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.storeauto.dao.PhotoDao;
import ru.job4j.storeauto.models.Photo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class PhotoController extends HttpServlet {
    private final Logger loggers = LoggerFactory.getLogger(PhotoController.class);
    private PhotoDao photoDao = PhotoDao.getPhotoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Photo photo = new Photo();
        photo.setId(Integer.parseInt(req.getParameter("id")));
        photo = photoDao.findbById(photo);
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + photo.getFilename() + "\"");
        if (Objects.nonNull(photo.getPath()) && Objects.nonNull(photo.getFilename())) {
            File file = new File(photo.getPath());
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                resp.getOutputStream().write(fileInputStream.readAllBytes());
            } catch (IOException e) {
                loggers.error("Error", e);
            }
        }
    }
}

