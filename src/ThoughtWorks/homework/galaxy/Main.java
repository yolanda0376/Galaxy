package ThoughtWorks.homework.galaxy;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception{
        testMethod();
    }

    public static void testMethod() throws Exception{
        List<String> inputData = new ArrayList<>();
        List<String> outputData = new ArrayList<>();
        Map<String,String> symbolOrder = new HashMap<>();// 存储罗马符号与数值，单位之间的换算关系。

        try {
            Convert convert = new Convert();
            String line = "";
            String caculateStr = "";

            inputData = TestCase.normalData();//read inputData

            for(int i = 0; i < inputData.size(); i++){
                int number = 0;
                String currentLine = inputData.get(i);
                String[] lineArray = currentLine.split(" ");
                int index = convert.getIndexOfIs(lineArray);
                if(!currentLine.contains("?") && !currentLine.contains("Credits")){//罗马符号与数值映射
                    symbolOrder.put(lineArray[index - 1],lineArray[index + 1]);
                    continue;
                }
                if(!currentLine.contains("?") && currentLine.contains("Credits")){// 单位映射
                    caculateStr = "";
                    for(int j = 0; j < index - 1; j++){
                        caculateStr += symbolOrder.get(lineArray[j]);
                    }
                    number = convert.numberConvert(caculateStr,outputData);
                    if (number != -1){
                        symbolOrder.put(lineArray[index - 1],String.valueOf(Integer.valueOf(lineArray[index + 1]) / number));
                    }
                    continue;
                }
                boolean validInput = convert.validInput(currentLine,symbolOrder);
                if(!validInput){
                    String outputLine = "I have no idea what you are talking about";
                    outputData.add(outputLine);
                    continue;
                }
                if(currentLine.contains("?") && !currentLine.contains("Credits")){// 数值转换计算
                    caculateStr = "";
                    int splitIndex = currentLine.indexOf("is");
                    String outputLine = convert.getoutpString(lineArray,index);
                    for(int k = index + 1; k < lineArray.length - 1; k++){
                        caculateStr += symbolOrder.get(lineArray[k]);
                    }
                    outputLine += "is" + " ";
                    number = convert.numberConvert(caculateStr,outputData);
                    if (number != -1) {
                        outputLine += number;
                    }else {
                        outputLine += caculateStr;
                    }
                    outputData.add(outputLine);
                    continue;
                }

                if(currentLine.contains("?") && currentLine.contains("Credits")){// 单位转换计算
                    int splitIndex = currentLine.indexOf("is");
                    String outputLine = convert.getoutpString(lineArray,index);
                    caculateStr = "";
                    for(int k = index + 1; k < lineArray.length - 2; k++){
                        caculateStr += symbolOrder.get(lineArray[k]);
                    }
                    number = convert.numberConvert(caculateStr,outputData);
                    if (number != -1) {
                        outputLine += "is" + " " + number * Integer.parseInt(symbolOrder.get(lineArray[lineArray.length - 2]));

                    }else {
                        outputLine += "is" + " " + caculateStr;
                    }
                    outputData.add(outputLine);
                    continue;
                }
            }

            Convert.outputToFile(outputData);// 输出结果到output文件中
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
