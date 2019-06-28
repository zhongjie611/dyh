package com.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by zezhong.shang on 16-4-12.
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public void test(){
        System.out.print("test");
    }

    @RequestMapping(value="/uploadFile",method= RequestMethod.POST)
    @ResponseBody
    public String uploadHeadPic(@RequestParam("myfile")CommonsMultipartFile myfile , HttpServletRequest request) {
        String uuid = UUID.randomUUID().toString().trim();
        String fileN=myfile.getOriginalFilename();
        int index=fileN.indexOf(".");
        String fileName=uuid+fileN.substring(index);
        try {
            File fileMkdir=new File("/usr/local/apache-tomcat-7.0.52/webapps/ROOT");
            //"/usr/local/apache-tomcat-7.0.52/webapps/ROOT"

            if(!fileMkdir.exists()) {
                fileMkdir.mkdir();
            }
            System.out.println("fileMkdir ============1:"+fileMkdir.getAbsolutePath());
            //定义输出流 将文件保存在D盘    file.getOriginalFilename()为获得文件的名字
            FileOutputStream os = new FileOutputStream(fileMkdir.getPath()+"/"+fileN);
            System.out.println("fileMkdir ============2:"+fileMkdir.getPath()+"/"+fileN);
 ;
            InputStream in = myfile.getInputStream();
            System.out.println("fileMkdir ============3:"+in.toString());
            int b = 0;
            while((b=in.read())!=-1){ //读取文件
                os.write(b);
            }
            os.flush(); //关闭流
            in.close();
            os.close();
        } catch (Exception e) {
            return  "上传失败！";
        }
        return fileN;
    }
}
