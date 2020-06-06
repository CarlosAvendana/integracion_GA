package backendga;

import backendga.modelo.dao.GestorCurso;
import java.util.ArrayList;
import java.util.List;

public class BackendGA {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        
        for(Integer i:list)
            System.err.println(i);
        
        list.remove(2);
        
        for(Integer i:list)
            System.err.println(i);
        
    }

}
