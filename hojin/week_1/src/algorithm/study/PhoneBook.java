package algorithm.study;

import java.util.Arrays;

public class PhoneBook {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
            if (phoneBook[i+1].contains(phoneBook[i])) {
                result = false;
                break;
            }
        }
        System.out.println(result);
        return result;
    }
}