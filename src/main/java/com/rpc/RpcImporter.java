package com.rpc;

import net.sf.cglib.proxy.Proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;


/**
 * @description:
 * @author: zhuzz
 * @date: 2019-09-18 11:21
 */
public class RpcImporter<S> {
    public S importer(final Class<?> serviceClass, final InetSocketAddress addr) {
        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class<?>[]{serviceClass.getInterfaces()[0]}, (o, method, objects) -> {
            Socket socket = null;
            ObjectOutputStream output = null;
            ObjectInputStream input = null;
            try {
                socket = new Socket();
                socket.connect(addr);
                output = new ObjectOutputStream(socket.getOutputStream());
                output.writeUTF(serviceClass.getName());
                output.writeUTF(method.getName());
                output.writeObject(method.getParameterTypes());
                output.writeObject(objects);
                input = new ObjectInputStream(socket.getInputStream());
                return input.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    socket.close();
                }
                if (output != null) {
                    output.close();
                }
                if (input != null) {
                    input.close();
                }
            }
            return null;
        });
    }
}
