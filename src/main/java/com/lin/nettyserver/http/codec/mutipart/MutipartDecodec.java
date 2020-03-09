package com.lin.nettyserver.http.codec.mutipart;

import com.lin.nettyserver.http.codec.HttpDecodec;
import com.lin.nettyserver.http.util.UrlUtil;
import io.netty.handler.codec.http.multipart.FileUpload;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.MixedAttribute;
import io.netty.util.CharsetUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MutipartDecodec implements HttpDecodec<HttpPostRequestDecoder> {

    @Override
    public <T> T decode(HttpPostRequestDecoder decoder, Class<T> paramClass) {

        try {
            List<InterfaceHttpData> postList = decoder.getBodyHttpDatas();
            Map<String, List<Object>> params =new HashMap<String, List<Object>>();
            for (InterfaceHttpData data : postList) {
                List<Object> values = new ArrayList<Object>();
                switch (data.getHttpDataType()){
                    case FileUpload:
                        FileUpload fileUploadData = (FileUpload)data;
                        values.add(fileUploadData.get());
                        break;
                    case Attribute:
                        MixedAttribute value = (MixedAttribute) data;
                        value.setCharset(CharsetUtil.UTF_8);
                        values.add(value.getValue());
                        break;
                    case InternalAttribute:
                        MixedAttribute value2 = (MixedAttribute) data;
                        value2.setCharset(CharsetUtil.UTF_8);
                        values.add(value2.getValue());
                        break;
                }
                params.put(data.getName(),values);
            }
            return (T) UrlUtil.instanceObject(params, paramClass, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
