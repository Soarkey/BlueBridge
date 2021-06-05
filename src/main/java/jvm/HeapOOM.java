package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * HeapOOM class
 * -XX:+HeapDumpOnOutOfMemoryError
 * @author Soarkey
 * @date 2021/3/28
 */
public class HeapOOM {
    static class OOMObject{
    }

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
