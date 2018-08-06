package ThoughtWorks.homework.galaxy;

import java.io.FileWriter;
import java.io.Writer;
import java.util.*;
import java.util.Map.Entry;

public class Convert {
    private String romanNumbers = "IVXLCDM";
    private String[] romanSymbol = {"I","V","X","L","C","D","M"};
    private int[] value = {1,5,10,50,100,500,1000};
    private boolean[] repeated = {true,false,true,false,true,false,true};
    private int[] times = {3,1,3,1,3,1,3};
    private boolean[] subtracted = {true,false,true,false,true,false};
    private String[] subtractedPattern = {"IV,IX",null,"XL,XC",null,"CD,CM",null,null};

    // 输入输出文件所在位置
    static String directory = String.valueOf(System.getProperty("user.dir"));
    static String outputPath = directory.replaceAll( "\\\\ ",   "/") + "\\output.txt";

    private final int repeatedTimes = 3;

    // 换算罗马字符序列对应的数值
    public int numberConvert(String romanOrder,List<String> outputData){
        int convertedNumber = 0;
        try {
            if(!isExistInvalidSymbol(romanOrder,outputData) && !invalidRepeated(romanOrder,outputData)){
                List<RomanNumeral> romans = new ArrayList<RomanNumeral>();
                for(int i = 0; i < romanOrder.length(); i++){
                    String symbol = String.valueOf(romanOrder.charAt(i));
                    int cursor = romanNumbers.indexOf(symbol);
                    RomanNumeral roman = new RomanNumeral (romanSymbol[cursor],
                    value[cursor],repeated[cursor],times[cursor],subtracted[cursor],subtractedPattern[cursor]);
                    romans.add(roman);
                }
                if(romans.size() == 1){
                    return romans.get(0).getValue();
                }else {
                    for(int index = 0; index < romans.size(); index++){
                        if(index + 1 <= romans.size() - 1){
                            if(romans.get(index).getValue() < romans.get(index + 1).getValue()){
                                if(illegalSubtracted(romans.get(index),romans.get(index + 1),outputData)){
                                    return -1;
                                }else {
                                    String subtractedStr = romans.get(index).getSymbol() + romans.get(index + 1).getSymbol();
                                    convertedNumber += romans.get(index + 1).getValue() - romans.get(index).getValue();
                                    index++;
                                }
                            }else {
                                convertedNumber += romans.get(index).getValue();
                            }
                        }else {
                            convertedNumber += romans.get(index).getValue();
                        }
                    }
                }
            }else {
                convertedNumber = -1;
            }
        }catch (Exception e){
            convertedNumber = -1;
            e.printStackTrace();
        }
        return convertedNumber;
    }

    // 描述：罗马符号序列中是否存在无效符号,即I,V,X,L,C,D,M之外的罗马字符
    public boolean isExistInvalidSymbol(String order,List<String> ouputData){
        boolean exist = false;
        try {
            if(order == null || order.length() == 0){
                exist = true;
            }else {
                char[] symbols = order.toCharArray();
                for(int i = 0; i < symbols.length; i++){
                    if(!romanNumbers.contains(String.valueOf(symbols[i]))){
                        exist = true;
                        String outputStr = String.valueOf(symbols[i] + " is not valid Roman numeral !");
                        ouputData.add(outputStr);
                        break;
                    }else {
                        continue;
                    }
                }
            }
        }catch (IndexOutOfBoundsException e){
            exist = false;
            e.printStackTrace();
        }
        return exist;
    }

    // 罗马字序列中是否存在无效的重复,即I,X,C可重复三次，D,L,V不可重复
    public boolean invalidRepeated(String order,List<String> outputData){
        boolean invalidRepeated = false;
        String threeRepeated = "IXC";
        String noRepeated = "DLV";
        if(order.length() > 0){
            char[] symbols = order.toCharArray();
            for(int i = 0; i < symbols.length -1; i++){
                int count = 1;
                for(int j = i + 1; j < symbols.length; j++){
                    if(symbols[i] == symbols[j]){
                        count++;
                    }else {
                        count = 0;
                    }
                }
                if(count > 1 && noRepeated.contains(String.valueOf(symbols[i]))){
                    invalidRepeated = true;
                    String outputStr = "Roman order " + order + " Symbol " + String.valueOf(symbols[i]) + " never be repeated !";
                    outputData.add(outputStr);
                    return invalidRepeated;
                }
                if(count > repeatedTimes && threeRepeated.contains(String.valueOf(symbols[i]))){
                    invalidRepeated = true;
                    String outputStr = "Roman order " + order + " Symbol " + String.valueOf(symbols[i]) + " can be repeated three times, but no more !";
                    outputData.add(outputStr);
                    return invalidRepeated;
                }
            }
        }
        return invalidRepeated;
    }

    public boolean illegalSubtracted(RomanNumeral pre, RomanNumeral rear,List<String> outputData){
        boolean result = false;
        if(pre.isSubtracted() == false){
            String outputStr = pre.getSymbol() + " never be subtracted ";
            outputData.add(outputStr);
            result = true;
            return result;
        }else {
            String subtractedOrder = pre.getSymbol() + rear.getSymbol();
            String legalOrder = pre.getSubtractedPattern();
            if(!legalOrder.contains(subtractedOrder)){
                String outputStr = pre.getSymbol() + " can not be subtracted from " + rear.getSymbol();
                outputData.add(outputStr);
                result = true;
                return result;
            }
        }
        return result;
    }

    // 用is作为分隔符，分隔每一行的输入
    public int getIndexOfIs(String[] str){
        int index = -1;
        for(int i = 0; i < str.length; i++){
            if("is".equals(str[i])){
                index = i;
                break;
            }else {
                continue;
            }
        }
        return index;
    }

    // 拼接每一行输入对应的输入字符串
    public String getoutpString(String[] str, int startIndex){
        String output = "";
        for(int i = startIndex + 1; i < str.length - 1; i++){
            output += str[i] + " ";
        }
        return output;
    }

    // 判断该行输入，是否需要进行数值或单位换算，用于输出 I have no idea what you are talking about
    public boolean validInput(String line, Map<String,String> map){
        boolean valid = true;
        List<String> keys = new ArrayList<>();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Entry entry = (Entry)iterator.next();
            keys.add(String.valueOf(entry.getKey()));
        }
        if(keys.size() > 0){
            for(String key:keys){
                if (line.contains(key)){
                    valid = true;
                    break;
                }else {
                    valid = false;
                }
            }
        }
        return valid;
    }

    public static void outputToFile(List<String> outputData){
        try {
            Writer writer = new FileWriter(outputPath);
            for(int item = 0; item < outputData.size(); item++){
                writer.write(outputData.get(item));
                writer.write("\r\n");
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
