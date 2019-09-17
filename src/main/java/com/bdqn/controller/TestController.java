package com.bdqn.controller;

import com.bdqn.module.ExpressInfo;
import com.bdqn.service.IExpressInfoService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.apache.poi.ss.usermodel.*;
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
    @Autowired
    IExpressInfoService expressInfoService;


    @RequestMapping(value="/exFile",method= RequestMethod.POST)
    @ResponseBody
    public String uploadExcel(@RequestParam("exfile")CommonsMultipartFile exfile , HttpServletRequest request) {

        //1.解析Excel
        //1.1.根据Excel文件创建工作簿
        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(exfile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.获取Sheet
        Sheet sheet = wb.getSheetAt(0);//参数：索引
        //1.3.获取Sheet中的每一行，和每一个单元格
        int length = sheet.getLastRowNum();
        List<ExpressInfo> list = new ArrayList();
        ExpressInfo info = null;
        for (int rowNum = 1; rowNum<= length ;rowNum ++) {
            Row row = sheet.getRow(rowNum);//根据索引获取每一个行
            StringBuilder sb = new StringBuilder();
            Cell orderNubCell = row.getCell(1);
            Cell productCell = row.getCell(2);
            Cell nameCell = row.getCell(4);
            Object onStr = getCellValue(orderNubCell);
            Object productStr = getCellValue(productCell);
            Object nameStr = getCellValue(nameCell);
            System.out.println((String)onStr);
            System.out.println((String)nameStr);
            info = new ExpressInfo();
            info.setProduct((String) productStr);
            info.setOrderNumb((String)onStr);
            info.setCreateDate(new Date());
            info.setSendStates(true);
            info.setUserName((String)nameStr);
            list.add(info);
        }
        //2.获取用户数据列表
        expressInfoService.saveExpressInfo(list);
        System.out.println(sheet.getLastRowNum());
        return "";
    }
    public static Object getCellValue(Cell cell) {
        //1.获取到单元格的属性类型
        CellType cellType = cell.getCellType();
        //2.根据单元格数据类型获取数据
        Object value = null;
        switch (cellType) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)) {
                    //日期格式
                    value = cell.getDateCellValue();
                }else{
                    //数字
                    value = cell.getNumericCellValue();
                }
                break;
            case FORMULA: //公式
                value = cell.getCellFormula();
                break;
            default:
                break;
        }
        return value;
    }

    @PostMapping("/express")
    @ResponseBody
    public List<ExpressInfo> getExpressInfoList( @RequestParam("name") String name) {
        String param = "";
        try {
            System.out.println("name:"+name);
            param = new String(name.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("param:"+param);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  expressInfoService.find(name);
    }
    @GetMapping("/express/all/delete")
    public void deleteAll( ) {
        expressInfoService.removeAll();
    }

}
