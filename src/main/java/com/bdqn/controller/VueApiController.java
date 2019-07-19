package com.bdqn.controller;

import com.bdqn.module.ResponseVueStL;
import com.bdqn.module.ResponseVueStr;
import com.bdqn.module.RetInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019-07-18.
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class VueApiController {

    @RequestMapping("/getlunbo")
    public ResponseVueStL getLunbo(){
        ResponseVueStL rvl = new ResponseVueStL();
        List<RetInfo> list = new ArrayList<RetInfo>();
        RetInfo i1 = new RetInfo();
        i1.setId(1);
        i1.setImg("https://img20.360buyimg.com/da/jfs/t2077/314/2192172483/11044/f861504a/56ca6792N64e5eafc.png");
        i1.setUrl("https://img20.360buyimg.com/da11");
        list.add(i1);
        RetInfo i2 = new RetInfo();
        i2.setId(1);
        i2.setImg("https://img10.360buyimg.com/n1/s150x150_jfs/t1/17750/12/4036/254252/5c2daaf6E00a8e328/7c73afe6ccaa7247.jpg");
        i2.setUrl("https://img20.360buyimg.com/da1122");
        list.add(i2);
        rvl.setMessage(list);
        return rvl;
    }
    @RequestMapping("/getnewslist")
    public ResponseVueStL getNewsList(){
        ResponseVueStL rvl = new ResponseVueStL();
        List<RetInfo> list = new ArrayList<RetInfo>();
        RetInfo i1 = new RetInfo();
        i1.setId(13);
        i1.setTitle("欧议会议员要求特区政府不起诉示威者 驻港公署回应");
        i1.setZhaiyao("驻香港公署：强烈谴责欧洲议会议员借涉港议案干涉香港事务和中国内政");
        i1.setImg_url("https://img30.360buyimg.com/n1/jfs/t1/67839/17/560/155400/5cecee2eEf4ff290b/31d628ccfb8fc465.jpg");
        i1.setClick(3);
        i1.setAdd_time(new Date());
        list.add(i1);
        RetInfo i2 = new RetInfo();
        i2.setId(14);
        i2.setTitle("国际货币基金组织：中国经济外部再平衡取得进展");
        i2.setZhaiyao("新华社华盛顿7月17日电（记者高攀 熊茂伶）国际货币基金组织（IMF）17日表示，2018年中国外部头寸基本符合中期经济基本面，中国经济外部再平衡继续取得进展。");
        i2.setImg_url("https://img30.360buyimg.com/n1/jfs/t1/31456/16/14626/410465/5cbee858E71abe49f/cb39ab09173b2481.jpg");
        i2.setUrl("https://img20.360buyimg.com/da1122");
        i2.setClick(2);
        i2.setAdd_time(new Date());
        list.add(i2);
        rvl.setMessage(list);
        return rvl;
    }
    @RequestMapping("/getnew/{id}")
    public ResponseVueStL getNews(String id){
        System.out.println(id);
        ResponseVueStL rvl = new ResponseVueStL();
        List<RetInfo> list = new ArrayList<RetInfo>();
        RetInfo i1 = new RetInfo();
        i1.setId(13);
        i1.setTitle("欧议会议员要求特区政府不起诉示威者 驻港公署回应");
        i1.setContent("<p>　新华社华盛顿7月17日电（记者高攀 熊茂伶）国际货币基金组织（IMF）17日表示，2018年中国外部头寸基本符合中期经济基本面，中国经济外部再平衡继续取得进展。\n" +
                "\n" +
                "　　IMF当天发布《2019外部风险报告》说，中国经常账户顺差占国内生产总值（GDP）比重已从2007年的约10%大幅降至2018年的0.4%，中国外部头寸已基本符合中期经济基本面，表明中国经济增长不再依赖出口拉动，而转向内需驱动。\n" +
                "\n" +
                "　　报告说，2007年以来中国经常账户顺差持续大幅下降，是主要发达经济体需求疲软、中国制造业技术升级、人民币实际有效汇率升值、服务贸易逆差扩大等多种因素作用的结果，反映出中国经济再平衡取得显著进展。\n" +
                "\n" +
                "　　随着中国经济再平衡继续推进，IMF预计未来几年中国经常账户顺差将进一步下降。IMF表示，2018年人民币实际有效汇率与经济基本面保持一致，从全年看跨境资本流动为小幅净流入。\n" +
                "\n" +
                "　　IMF首席经济学家吉塔·戈皮纳特当天在新闻发布会上表示，IMF期待中国继续依靠国内消费驱动经济增长，减少信贷依赖，并鼓励私营部门更多参与到经济当中。她呼吁拥有经常账户顺差和逆差的经济体共同努力解决全球失衡问题，重振国际贸易，避免采取扭曲的贸易政策措施。\n" +
                "\n" +
                "　　IMF当天发布的报告还显示，全球经常账户差额占全球GDP的比重已从2007年的约6%降至2018年的约3%，其中经常账户顺差过大的主要是欧元区经济体和韩国、新加坡等亚洲经济体，经常账户逆差过大的主要有美国、英国、阿根廷和印度尼西亚等。\n" +
                "\n" +
                "　　IMF自2012年开始每年发布《外部风险报告》，对美国、中国、德国、日本等全球29个主要经济体和欧元区整体的外部失衡情况及汇率进行分析评估。</p>");
        i1.setClick(3);
        i1.setAdd_time(new Date());
        list.add(i1);
        rvl.setMessage(list);
        return rvl;
    }
    //getimages/:cateid
    @RequestMapping("/getimages/{cateid}")
    public ResponseVueStL getImages(@PathVariable String cateid){
        ResponseVueStL rvl = new ResponseVueStL();
        List<RetInfo> list = new ArrayList<RetInfo>();
        RetInfo i1 = new RetInfo();
        i1.setId(50);
        i1.setTitle("欧议会议员要求特区政府不起诉示威者 驻港公署回应");
        i1.setZhaiyao("驻香港公署：强烈谴责欧洲议会议员借涉港议案干涉香港事务和中国内政");
        i1.setImg_url("https://img30.360buyimg.com/n1/jfs/t1/67839/17/560/155400/5cecee2eEf4ff290b/31d628ccfb8fc465.jpg");
        i1.setClick(3);

        RetInfo i2 = new RetInfo();
        i2.setId(51);
        i2.setTitle("国际货币基金组织：中国经济外部再平衡取得进展");
        i2.setZhaiyao("新华社华盛顿7月17日电（记者高攀 熊茂伶）国际货币基金组织（IMF）17日表示，2018年中国外部头寸基本符合中期经济基本面，中国经济外部再平衡继续取得进展。");
        i2.setImg_url("https://img30.360buyimg.com/n1/jfs/t1/31456/16/14626/410465/5cbee858E71abe49f/cb39ab09173b2481.jpg");
        i2.setUrl("https://img20.360buyimg.com/da1122");
        i2.setClick(2);
        if("0".equals(cateid)){
            list.add(i1);
            list.add(i2);
        }else if("14".equals(cateid)){
            list.add(i1);
        }else{
            list.add(i2);
        }

        rvl.setMessage(list);
        return rvl;
    }
    ///api/getimgcategory
    @RequestMapping("/getimgcategory")
    public ResponseVueStL getImgCategory(String cid){
        ResponseVueStL rvl = new ResponseVueStL();
        List<RetInfo> list = new ArrayList<RetInfo>();
        RetInfo i1 = new RetInfo();
        i1.setId(14);
        i1.setTitle("中国经济外部再平衡取得进展");
        list.add(i1);
        RetInfo i2 = new RetInfo();
        i2.setId(15);
        i2.setTitle("国际货币基金组织：中国经济外部再平衡取得进展");
        list.add(i2);
        rvl.setMessage(list);
        return rvl;
    }
    ///api/getthumimages/:imgid
    @RequestMapping("/getthumimages/{imgid}")
    public ResponseVueStL getThumimages(String imgid){
        ResponseVueStL rvl = new ResponseVueStL();
        List<RetInfo> list = new ArrayList<RetInfo>();
        RetInfo i1 = new RetInfo();
        i1.setSrc("https://img30.360buyimg.com/n1/jfs/t1/67839/17/560/155400/5cecee2eEf4ff290b/31d628ccfb8fc465.jpg");
        list.add(i1);
        RetInfo i2 = new RetInfo();
        i2.setSrc("https://img30.360buyimg.com/n1/jfs/t1/31456/16/14626/410465/5cbee858E71abe49f/cb39ab09173b2481.jpg");
        list.add(i2);
        rvl.setMessage(list);
        return rvl;
    }
    ///api/getimageInfo/:imgid
    @RequestMapping("/getimageInfo/{imgid}")
    public ResponseVueStL getImageInfo(String imgid){
    ResponseVueStL rvl = new ResponseVueStL();
    List<RetInfo> list = new ArrayList<RetInfo>();
    RetInfo i1 = new RetInfo();
        i1.setId(43);
        i1.setTitle("欧议会议员要求特区政府不起诉示威者 驻港公署回应");
        i1.setContent("驻香港公署：强烈谴责欧洲议会议员借涉港议案干涉香港事务和中国内政");
        i1.setImg_url("https://img30.360buyimg.com/n1/jfs/t1/67839/17/560/155400/5cecee2eEf4ff290b/31d628ccfb8fc465.jpg");
        i1.setClick(3);
        i1.setAdd_time(new Date());
        list.add(i1);

        rvl.setMessage(list);
        return rvl;
    }
    ///api/getcomments/:artid?pageindex=1
    @RequestMapping("/getcomments/{artid}")
    public ResponseVueStL getComments(String artid,@RequestParam("pageindex") Integer pageindex){
        ResponseVueStL rvl = new ResponseVueStL();
        List<RetInfo> list = new ArrayList<RetInfo>();
        RetInfo i1 = new RetInfo();
        list.add(i1);
        RetInfo i2 = new RetInfo();
        list.add(i2);
        RetInfo i3 = new RetInfo();
        list.add(i3);
        RetInfo i4 = new RetInfo();
        list.add(i4);
        RetInfo i5 = new RetInfo();
        list.add(i5);
        RetInfo i7 = new RetInfo();
        list.add(i7);
        RetInfo i6 = new RetInfo();
        list.add(i6);
        rvl.setMessage(list);
        return rvl;
    }
    ////api/postcomment/:artid content: 评论的内容
    @RequestMapping(value ="/postcomment/{artid}",method = RequestMethod.POST)
    public ResponseVueStr getComments(@PathVariable("artid") int artid, @RequestBody  String content)  {
        ResponseVueStr rstr = new ResponseVueStr();
        rstr.setStatus(0);
        rstr.setMessage("評論成功");
        return rstr;
    }
    ///api/getgoods?pageindex=number
    @RequestMapping("/getgoods")
    public ResponseVueStL getGoods(Integer pageindex  ){
        ResponseVueStL rvl = new ResponseVueStL();
        List<RetInfo> list = new ArrayList<RetInfo>();
        RetInfo i1 = new RetInfo();
        i1.setId(87);
        i1.setTitle("苹果 20 ");
        i1.setZhaiyao("苹果：强烈谴责欧洲议会议员借涉港议案干涉香港事务和中国内政");
        i1.setImg_url("https://img30.360buyimg.com/n1/jfs/t1/67839/17/560/155400/5cecee2eEf4ff290b/31d628ccfb8fc465.jpg");
        i1.setClick(3);
        i1.setSell_price(5999);
        i1.setMarket_price(6999);
        i1.setStock_quantity(60);
        i1.setAdd_time(new Date());
        list.add(i1);
        RetInfo i2 = new RetInfo();
        i2.setId(88);
        i2.setTitle("华为：中国经济外部再平衡取得进展");
        i2.setZhaiyao("华为（记者高攀 熊茂伶）国际货币基金组织（IMF）17日表示，2018年中国外部头寸基本符合中期经济基本面，中国经济外部再平衡继续取得进展。");
        i2.setImg_url("https://img30.360buyimg.com/n1/jfs/t1/31456/16/14626/410465/5cbee858E71abe49f/cb39ab09173b2481.jpg");
        i2.setUrl("https://img20.360buyimg.com/da1122");
        i2.setClick(2);
        i2.setAdd_time(new Date());
        i2.setSell_price(3999);
        i2.setMarket_price(4999);
        i2.setStock_quantity(30);
        list.add(i2);
        rvl.setMessage(list);
        return rvl;
    }
    ///api/goods/getdesc/:id
    @RequestMapping("/goods/getdesc/{id}")
    public ResponseVueStL getDesc(String id){
        ResponseVueStL rvl = new ResponseVueStL();
        List<RetInfo> list = new ArrayList<RetInfo>();
        RetInfo i1 = new RetInfo();
        i1.setTitle("苹果 20 ");
        i1.setContent("苹果：xx强烈谴责欧洲议会议员借涉港议案干涉香港事务和中国内政");
        list.add(i1);
        RetInfo i2 = new RetInfo();
        i2.setTitle("华为：中国经济外部再平衡取得进展");
        i2.setContent("华为xxx（记者高攀 熊茂伶）国际货币基金组织（IMF）17日表示，2018年中国外部头寸基本符合中期经济基本面，中国经济外部再平衡继续取得进展。");
        list.add(i2);
        rvl.setMessage(list);
        return rvl;
    }
    ///api/goods/getshopcarlist/:ids
    @RequestMapping("/goods/getshopcarlist/{ids}")
    public ResponseVueStL getShopcarList(String  ids){
        ResponseVueStL rvl = new ResponseVueStL();
        List<RetInfo> list = new ArrayList<RetInfo>();
        RetInfo i1 = new RetInfo();
        i1.setId(87);
        i1.setCou(1);
        i1.setTitle("苹果 20 ");
        i1.setThumb_path("https://img30.360buyimg.com/n1/jfs/t1/67839/17/560/155400/5cecee2eEf4ff290b/31d628ccfb8fc465.jpg");
        i1.setSell_price(5999);
        list.add(i1);
        RetInfo i2 = new RetInfo();
        i2.setId(88);
        i2.setTitle("华为：中国经济外部再平衡取得进展");
        i2.setThumb_path("https://img30.360buyimg.com/n1/jfs/t1/31456/16/14626/410465/5cbee858E71abe49f/cb39ab09173b2481.jpg");
        i2.setClick(2);
        i2.setCou(1);
        i2.setSell_price(4999);
        list.add(i2);
        rvl.setMessage(list);
        return rvl;
    }
    ///api/goods/getinfo/:id
    @RequestMapping("/goods/getinfo/{id}")
    public ResponseVueStL getGoods(String id){
        ResponseVueStL rvl = new ResponseVueStL();
        List<RetInfo> list = new ArrayList<RetInfo>();
        RetInfo i1 = new RetInfo();
        i1.setId(101);
        i1.setTitle("苹果 101 ");
        i1.setGoods_no("SD12345894");
        i1.setSell_price(5999);
        i1.setMarket_price(6999);
        i1.setStock_quantity(60);
        i1.setAdd_time(new Date());
        list.add(i1);
        RetInfo i2 = new RetInfo();
        i2.setId(102);
        i2.setTitle("华为102：中国经济外部再平衡取得进展");
        i2.setGoods_no("SD12345894");
        i2.setAdd_time(new Date());
        i2.setSell_price(3999);
        i2.setMarket_price(4999);
        i2.setStock_quantity(30);
        list.add(i2);
        rvl.setMessage(list);
        return rvl;
    }
    //api/getprodlist
    @RequestMapping("/getprodlist ")
    public ResponseVueStL getGoods( ){
        ResponseVueStL rvl = new ResponseVueStL();
        List<RetInfo> list = new ArrayList<RetInfo>();
        RetInfo i1 = new RetInfo();
        i1.setId(111);
        i1.setTitle("萝莉  ");
        i1.setCtime(new Date());
        list.add(i1);
        RetInfo i2 = new RetInfo();
        i2.setId(112);
        i2.setTitle("轿车");
        i2.setCtime(new Date());
        list.add(i2);
        rvl.setMessage(list);
        return rvl;
    }
    ///delproduct/:id
    @RequestMapping(value ="/delproduct/{id}" )
    public ResponseVueStr delProduct(String id )  {
        ResponseVueStr rstr = new ResponseVueStr();
        rstr.setStatus(0);
        rstr.setMessage("删除品牌成功");
        return rstr;
    }
    ///api/addproduct
    @RequestMapping(value ="/addproduct",method = RequestMethod.POST)
    public ResponseVueStr addproduct(@RequestBody Map<String, Object> map )  {
        ResponseVueStr rstr = new ResponseVueStr();
        rstr.setStatus(0);
        rstr.setMessage("添加品牌成功");
        return rstr;
    }
}
