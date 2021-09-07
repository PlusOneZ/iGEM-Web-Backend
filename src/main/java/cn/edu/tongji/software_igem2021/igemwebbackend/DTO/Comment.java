package cn.edu.tongji.software_igem2021.igemwebbackend.DTO;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Comment {
    private String firstname;
    private String lastname;
    private String time;
    private String content;

    public String getContent() {
        return content;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTime() {
        return time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String toString() {
        return "Comment Object: " + firstname + ", " + lastname + " says " + content + " at " + time;
    }
}
