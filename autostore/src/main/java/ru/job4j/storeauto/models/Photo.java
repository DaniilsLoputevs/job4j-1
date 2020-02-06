package ru.job4j.storeauto.models;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "car_photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "path")
    private String path;

    @Column(name = "filename")
    private String filename;

    public Photo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Photo photo = (Photo) o;
        return Objects.equals(id, photo.id)
                &&
                Objects.equals(path, photo.path);
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path);
    }

    @Override
    public String toString() {
        return "Photo{"
                +
                "id="
                + id
                +
                ", path='"
                + path
                + '\''
                +
                '}';
    }
}
