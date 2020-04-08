package org.example.helloworld.entity.persistence;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Strings;
import lombok.Data;
import org.example.helloworld.entity.Computation;

@Data
public class RequestsDataStorage {
    public static List<String> requests = new ArrayList<>() ;

    public void addRequest(Computation computation){
        requests.add(computation.toString()) ;
    }

    @Override
    public String toString() {
        return String.join(" ", requests);
    }
}
