package ThoughtWorks.homework.galaxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/5/005.
 */
public class TestCase {
    public static List<String> normalData(){
        List<String> inputData = new ArrayList<>();
        inputData.add("glob is I");
        inputData.add("prok is V");
        inputData.add("pish is X");
        inputData.add("tegj is L");
        inputData.add("glob glob Silver is 34 Credits");
        inputData.add("glob prok Gold is 57800 Credits");
        inputData.add("pish pish Iron is 3910 Credits");
        inputData.add("how much is pish tegj glob glob ?");
        inputData.add("how many Credits is glob prok Silver ?");
        inputData.add("how many Credits is glob prok Gold ?");
        inputData.add("how many Credits is glob prok Iron ?");
        inputData.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
        return inputData;
    }

    public static List<String> moreRepeat(){
        List<String> inputData = new ArrayList<>();
        inputData.add("glob is I");
        inputData.add("prok is V");
        inputData.add("pish is X");
        inputData.add("tegj is L");
        inputData.add("glob glob Silver is 34 Credits");
        inputData.add("glob prok Gold is 57800 Credits");
        inputData.add("pish pish Iron is 3910 Credits");
        inputData.add("how much is pish tegj glob glob glob glob ?");
        inputData.add("how many Credits is glob prok Silver ?");
        inputData.add("how many Credits is glob prok Gold ?");
        inputData.add("how many Credits is glob prok Iron ?");
        inputData.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
        return inputData;
    }

    public static List<String> illegalSubtract(){
        List<String> inputData = new ArrayList<>();
        inputData.add("glob is I");
        inputData.add("prok is V");
        inputData.add("pish is X");
        inputData.add("tegj is L");
        inputData.add("glob glob Silver is 34 Credits");
        inputData.add("glob prok Gold is 57800 Credits");
        inputData.add("pish pish Iron is 3910 Credits");
        inputData.add("how much is pish tegj glob glob glob tegj ?");
        inputData.add("how many Credits is glob prok Silver ?");
        inputData.add("how many Credits is glob prok Gold ?");
        inputData.add("how many Credits is glob prok Iron ?");
        inputData.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
        return inputData;
    }

    public static List<String> notAllowRepeat(){
        List<String> inputData = new ArrayList<>();
        inputData.add("glob is I");
        inputData.add("prok is V");
        inputData.add("pish is X");
        inputData.add("tegj is L");
        inputData.add("glob glob Silver is 34 Credits");
        inputData.add("glob prok Gold is 57800 Credits");
        inputData.add("pish pish Iron is 3910 Credits");
        inputData.add("how much is pish tegj prok prok ?");
        inputData.add("how many Credits is glob prok Silver ?");
        inputData.add("how many Credits is glob prok Gold ?");
        inputData.add("how many Credits is glob prok Iron ?");
        inputData.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
        return inputData;
    }

}
