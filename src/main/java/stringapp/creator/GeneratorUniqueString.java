package stringapp.creator;



import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import stringapp.domain.UserRequirements;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class GeneratorUniqueString {


    private UserRequirements userRequirements;
    private LinkedList<String> tmp = new LinkedList<>();

    public GeneratorUniqueString(UserRequirements userRequirements) {
        this.userRequirements = userRequirements;
    }

    public LinkedList<String> stringGenerator() {

        int x = userRequirements.getMax();
        char[] arrTemp = userRequirements.getArrayString();
        
        String[] arr = new String[arrTemp.length];
        
        for (int i=0; i<arrTemp.length; i++) {
            arr[i] = Character.toString(arrTemp[i]);
        }
        String[] ml = arr;
        

        for (int z = 0; z < x - 1; z++) {
            for (String value : arr) {
                for (String s : ml) {
                    if (!Objects.equals(value, s)) {
                        tmp.add(s + value);
                    }
                }
            }
            ml = tmp.toArray(new String[0]);
        }
        tmp.addAll(Arrays.asList(arr));
        for (int i = 0; i < arr.length; i++) {
            StringBuilder a = new StringBuilder();
            for (int b = 0; b < x; b++) {
                String d = arr[i];
                a.append(d);
            }
            tmp.add(a.toString());
        }
        return tmp;
    }

    public List<String> getElementsBySize() {

        int min = userRequirements.getMin();
        int max = userRequirements.getMax();
        return tmp.stream()
                .filter(l -> l.length() >= min)
                .filter(l -> l.length() <= max)
                .collect(Collectors.toList());
    }

    public boolean isCountSmallerThenSizeList() {
        int count = userRequirements.getCountOfString();
        return getElementsBySize().size() >= count;
    }

    public LinkedList<String> getFinishList() {
       LinkedList<String> list = new LinkedList<>();
       int count = userRequirements.getCountOfString();
        if(isCountSmallerThenSizeList()) {
            for(int i=0; i<count; i++) {
                list.add((getElementsBySize().get(i)));
            }
        }
        return list;
    }
}
