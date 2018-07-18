package com.gupao.edu.study.vip;

/**
 * <br>Darian
 **/
public class DemoServiceImpl implements DemoService {
    @Override
    public String protocolDemo(String msg) {
        return "I'm protolcol demo:" + msg;
    }
}
