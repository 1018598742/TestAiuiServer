package com.fta;

import com.fta.aiuimodel.AiuiModel;
import com.fta.aiuimodel.AiuiModule;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Admin on 2018/7/18
 */
public class AiuiSelvert extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger aiui = Logger.getLogger("aiui_get");
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> headernames = req.getHeaderNames();
        while (headernames.hasMoreElements()) {
            String key = headernames.nextElement();
            String value = req.getHeader(key);
            aiui.info("aiui_get=key=" + key + "\nvalue=" + value);
            map.put(key, value);
        }


        String timestamp = req.getHeader("timestamp");
        aiui.info("aiui:" + "科大讯飞测试");
        aiui.info("timestamp=" + timestamp);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().append("103506ffbfec39968274b0f68e56a66dd8a60786");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger aiui = Logger.getLogger("aiui_post");
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> headernames = req.getHeaderNames();
        aiui.info("aiui_post=aiui服务端测试");
        while (headernames.hasMoreElements()) {
            String key = headernames.nextElement();
            String value = req.getHeader(key);
            aiui.info("aiui_post=key=" + key + "\nvalue=" + value);
            map.put(key, value);
        }

        // 获取HTTP body
//        BufferedReader bufferedReader = new BufferedReader(
//                new InputStreamReader((ServletInputStream) req.getInputStream(), "utf-8"));
//        StringBuffer stringBuffer = new StringBuffer("");
//        String temp = "";
//        while ((temp = bufferedReader.readLine()) != null) {
//            stringBuffer.append(temp);
//        }
//        String message = stringBuffer.toString();
//        aiui.info("aiui_post=信息=" + message);
//        resp.setContentType("application/json;charset=utf-8");
//        resp.getWriter().append("{\"intent\":{\"rc\":4,\"uuid\":\"atn00071a7b@dx00070ea9f495a10e01\",\"sid\":\"cida15e3d96@dx00990ea9f495040001\",\"text\":\"你好\"}}");

        AiuiModel aiuiModel = new AiuiModel(req);
        String responseMessage = aiuiModel.responseString();
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().append(responseMessage.toString());
    }
}
