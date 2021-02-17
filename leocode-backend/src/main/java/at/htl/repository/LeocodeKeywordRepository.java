package at.htl.repository;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.util.*;

@ApplicationScoped
public class LeocodeKeywordRepository {
    public Set<String> filterStringInput(List<InputPart> inputParts){
        Set<String> filteredSet = new HashSet<>();

        inputParts.forEach(inputPart -> {
            try {
                String[] words = inputPart.getBodyAsString().split("\\P{Alpha}+");
                filteredSet.addAll(Arrays.asList(words));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return filteredSet;
    }
}
