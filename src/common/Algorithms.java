
package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Algorithms {
    private Library l;
    public Algorithms(){
        l = new Library(); 
    }
    public HashMap<String, List<Integer>> getNumber(String input) {
        Algorithms algo = new Algorithms();
        HashMap<String, List<Integer>> m = new HashMap();
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(input);
        
        m.put("All Numbers", new ArrayList<>());
        while (matcher.find()) {
            String strGrp = matcher.group();
            int num;
            num = Integer.parseInt(strGrp);
            m.get("All Numbers").add(num);

        }

        m.put("Odd Numbers", algo.checkOddNumber(m.get("All Numbers")));
        m.put("Even Numbers", algo.checkEvenNumber(m.get("All Numbers")));
        m.put("Perfect Numbers", algo.listPerfectNumber(m.get("All Numbers")));

        return m;
    }

    public List<Integer> checkOddNumber(List<Integer> list) {
        List<Integer> result = new ArrayList<>();

        for (Integer integer : list) {
            if (integer % 2 != 0) {
                result.add(integer);
            }
        }
        return result;
    }

    public List<Integer> checkEvenNumber(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                result.add(integer);
            }
        }
        return result;
    }

    public List<Integer> listPerfectNumber(List<Integer> list) {
        List<Integer> result = new ArrayList<>();

        for (Integer integer : list) {
            if (isPerfectNumber(integer)) {
                result.add(integer);
            }
        }
        return result;
    }

    public boolean isPerfectNumber(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (i * i == n) {
                return true;
            }
        }
        return false;
    }
    
    public HashMap<String, List<Character>> getCharacter(String input) {
        Algorithms algo = new Algorithms();
        HashMap<String, List<Character>> m = new HashMap();
        m.put("Uppercase Characters", new ArrayList<>());
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) >= 65 && input.charAt(i) <= 90) {
                m.get("Uppercase Characters").add(input.charAt(i));
            }
        }
        m.put("Lowercase Characters", new ArrayList<>());
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) >= 97 && input.charAt(i) <= 122) {
                m.get("Lowercase Characters").add(input.charAt(i));
            }
        }
        m.put("Special Characters", new ArrayList<>());
        for (int i = 0; i < input.length(); i++) {
            if((input.charAt(i) >= 33 && input.charAt(i) <= 47)
                    || (input.charAt(i) >= 91 && input.charAt(i) <= 96)
                    || (input.charAt(i) >= 123 && input.charAt(i) <= 126)) {
                m.get("Special Characters").add(input.charAt(i));
            }
        }
        m.put("All Characters", new ArrayList<>());
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) >= 32 && input.charAt(i) <= 126) {
                m.get("All Characters").add(input.charAt(i));
            }
        }

        return m;
    }
    
    public void AnalyzeProgram(){
        String stringInput = l.getString("Input string: ");
        HashMap<String, List<Integer>> result = getNumber(stringInput);
        for (Map.Entry<String, List<Integer>> entry : result.entrySet()) {
            String typeNum = entry.getKey();
            List<Integer> listNum = entry.getValue();
            System.out.println(typeNum + ": " + listNum);
            
        }
        HashMap<String, List<Character>> resultC = getCharacter(stringInput);
        for (Map.Entry<String, List<Character>> entry : resultC.entrySet()) {
            String typeChar = entry.getKey();
            List<Character> listNum = entry.getValue();
            String s = "";
            for (Character character : listNum) {
                s += character;
            }
            System.out.println(typeChar + ": " + s);
            
        }
    }
}
