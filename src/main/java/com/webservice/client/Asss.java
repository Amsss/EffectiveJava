package com.webservice.client;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import java.rmi.RemoteException;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 12:09
 */
public class Asss {

    public static void main(String[] args) {
        //serialization();
        try {
            String endpoint = "http://55.33.0.9:8861/webServiceEntry?wsdl";
            String soapActionURI = "http://tempuri.org/ISearch/buildBSXml";
            // 直接引用远程的wsdl文件

            // 以下都是套路
            Service service = new Service();

            Call call = (Call) service.createCall();

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            // WSDL里面描述的接口名称
            call.setOperationName(new QName("http://tempuri.org/", "buildBSXml"));
            call.setSOAPActionURI(soapActionURI);
            // 接口的参数
            call.addParameter("arg0", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            // 设置返回类型*/
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);

            String temp = "测试人员";

            String result = (String) call.invoke(new Object[]{temp});

            // 给方法传递参数，并且调用方法

            System.out.println("result is " + result);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.toString());

        }

    }

    public static void test() {
        String url = "http://localhost:8555/webService?wsdl";
        String namespace = "http://tempuri.org/";
        String methodName = "sayHello";
        String soapActionURI = "http://impl.service.serialization.zhuzz.com/myWebServiceImpl/sayHelloRequest";
        Service service = new Service();
        Call call;
        try {
            call = (Call) service.createCall();

            call.setTargetEndpointAddress(url);
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapActionURI);
            call.setOperationName(new QName(namespace, methodName));

            call.addParameter(new QName(namespace, "sayHello"), XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_STRING);

            String[] str = new String[1];
            str[0] = "111111";

            Object obj = call.invoke(str);
            System.out.println(obj);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}