package com.kyy.springboot.study.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimyongyeon on 2016-06-03.
 */
@Controller
public class OpenApiController {

    @Data
    class BillContent {
        String billId;
        String billName;
        String billNo;
        String passGubn;
        String procStageCd;
        String proposeDt;
        String proposerKind;
        String summary;
        String generalResult;
        String procDt;
    }

    @RequestMapping(value = "/ajaxTest", method = RequestMethod.GET)
    public String getOpenApi(Model model, HttpServletRequest request) throws Exception{

        String pageNo = request.getParameter("pageNo");

        List<BillContent> billList = new ArrayList<>();

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/9710000/BillInfoService/getBillInfoList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=vu5aXshfW3WPibn0VqOvLn3ZNWdOqWpqcLVppW7h4WzAT5cSbeWkMi7Og1i4wEYenRIliNxqb3%2BFEmULsps4qA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*검색건수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /*페이지 번호*/

        System.out.println("url : " + urlBuilder.toString());

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        Document doc = parseXML(conn.getInputStream());
        NodeList descNodes = doc.getElementsByTagName("item");

        for(int i=0; i<descNodes.getLength();i++){
            BillContent billContent = new BillContent();
            for(Node node = descNodes.item(i).getFirstChild(); node!=null; node=node.getNextSibling()){

                if(node.getNodeName().equals("billId")){

                    billContent.setBillId(node.getTextContent());
                    System.out.println(node.getTextContent());

                }else if(node.getNodeName().equals("billName")){

                    billContent.setBillName(node.getTextContent());
                    System.out.println(node.getTextContent());

                }else if(node.getNodeName().equals("billNo")){

                    billContent.setBillNo(node.getTextContent());
                    System.out.println(node.getTextContent());

                }else if(node.getNodeName().equals("passGubn")){

                    billContent.setPassGubn(node.getTextContent());
                    System.out.println(node.getTextContent());

                }else if(node.getNodeName().equals("procStageCd")){

                    billContent.setProcStageCd(node.getTextContent());
                    System.out.println(node.getTextContent());

                }else if(node.getNodeName().equals("proposeDt")){

                    billContent.setProposeDt(node.getTextContent());
                    System.out.println(node.getTextContent());

                }else if(node.getNodeName().equals("proposerKind")){

                    billContent.setProposerKind(node.getTextContent());
                    System.out.println(node.getTextContent());

                }else if(node.getNodeName().equals("summary")){

                    billContent.setSummary(node.getTextContent());
                    System.out.println(node.getTextContent());

                }else if(node.getNodeName().equals("generalResult")){

                    billContent.setGeneralResult(node.getTextContent());
                    System.out.println(node.getTextContent());

                }else if(node.getNodeName().equals("procDt")){

                    billContent.setProcDt(node.getTextContent());
                    System.out.println(node.getTextContent());

                }
            }
            billList.add(billContent);
        }


        model.addAttribute("billList",billList);


        return "ajaxTest";

    }

    private Document parseXML(InputStream stream) throws Exception{

        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;

        try{

            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);

        }catch(Exception ex){
            throw ex;
        }

        return doc;
    }
}
