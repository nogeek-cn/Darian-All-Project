package com.gupao.study.vip;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class protoBufDemo {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        // fluent 风格
        UserProto .User user = UserProto.User.newBuilder().setName("Darian").setAge(18).build();

        ByteString bytes = user.toByteString();
        System.out.println(bytes);

        UserProto.User nUser = UserProto.User.parseFrom(bytes);
        System.out.println(nUser);

    }
}
