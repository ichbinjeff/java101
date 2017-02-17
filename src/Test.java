/**
 * Created by jli on 4/21/15.
 */
import java.util.*;

public class Test {
    public Test(){}
    public String foo;
    public void testSth() throws Exception{
        Boolean first = true;
        try{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your age in years: ");
            double age = input.nextDouble();
            System.out.print("your age is" + age);
            System.out.print("Enter term: ");
            String term = input.next();
            System.out.print("term is" + term);
        }
        catch(Exception e){
            System.out.print("error!!!!!");
            if(first){
                throw new Exception("dfjkfjdf");
            }
            first = false;
        }
    }



    public static void insertSort(char[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++){
            char cur = data[k];
            int j = k;
            while(j > 0 && data[j-1] > cur){
                data[j] = data[j-1];
                j--;
            }
            data[j] = cur;
        }
    }


    public static void main(String[] args) {
//        Object abc = null;
//        String efg = (String) abc;
//        System.out.print(efg);
//
//        String d = abc.toString();
        Scope s = new Scope();
        Map<String, String> a = new HashMap<String, String>();
        a.put("abc", "efg");

        s.setAbc(a);
        Map<String, String> e = s.getAbc();
        e.put("a", null);
        Set<String> set = new HashSet<String>();
        set.add("12");
        set.add("13");

        String testelement  = "12";
        set.contains(testelement);
//        a = new HashMap<String, String>();
//        a.put("dfdf", "djkfjdf");
        //s.setAbc(a);
        Currency dime = Currency.DIME;
        Currency dim2 = Currency.valueOf("DIME");
        Currency c3 = Currency.fromCode(2);
        String test2 = "abc";
//        String [] hij = test2.split(",");
//        String [] foo = null;
//        if(foo.length != 0) {
//            System.out.print("find");
//        }
//        System.out.print("fdsfjlsf");
//        Date abc = new Date();
//        Object myobj = new Object();
//        ((Date) myobj).toString();

//        Set testset = new HashSet();
//        testset.add(1);
//        testset.add(2);
//        testset.add(3);
//
//        Set testset2 = new HashSet();
//        testset.add(1);
//        testset.add(2);
//
//        if(testset.containsAll(testset2)) {
//            System.out.print("it's true");
//
//        }

        ImpressionPixel imp = new ImpressionPixel();
        imp.setJs("123");

        ImpressionPixel imp2 = new ImpressionPixel();
        imp2.setJs("123");

        String js = "123";
        if(imp.getJs() == imp2.getJs()) {
            System.out.print("equals");
        }

        Set testset3 = new HashSet();
        testset3.add(null);
        testset3.add("");

        Set impressionSet = new HashSet<ImpressionPixel>();
        List abc = new ArrayList();
        abc.add("[]");
        abc.add("[]");

        System.out.print(abc.isEmpty());

        Map testmap = new HashMap();
        testmap.put("k1", "[]");
        //testmap.put("k2", "[\"a.com\", \"b.com\"]");

        testmap.values().isEmpty();
        System.out.print("fdsfjldsf");


//        int n = 10;
//        try {
//            n = Integer.parseInt(args[0]);
//            if(n <=0 ){
//                System.out.print("must positive. Using default");
//            }
//        }
//        catch(ArrayIndexOutOfBoundsException e){
//            System.out.print("No argument specified for n. Using default.");
//        }
//        catch(NumberFormatException e){
//            System.out.print("Invalid integer argument. Using default");
//        }
// ================================================================================
        Map<String, List<String>> errorLog = new HashMap<String, List<String>>();

        Set<ImpressionPixel> tset = new HashSet<ImpressionPixel>();
        Set<ImpressionPixel> wrapper = new HashSet<ImpressionPixel>();
        ImpressionPixel a1 = new ImpressionPixel();
        tset.add(a1);
        tset.contains(a1);
        a1.setUnrelated("abcd");
        tset.contains(a1);

        wrapper.addAll(tset);
        wrapper.contains(a1);
        wrapper.clear();
        wrapper.addAll(tset);
        wrapper.contains(a1);

        System.out.print(tset.contains(a1));


//        Test t = new Test();
//        for(int i = 0; i < 10; i++) {
//            List value = errorLog.get("abc");
//            if(value == null){
//                value = new ArrayList<String>();
//            }
//            value.add("first item");
//
//            errorLog.put("abc",value);
//            try {
//                t.testSth();
//
//
//            }
//
//        catch(Exception e){
//            System.out.print(e.getMessage() + " final message");
//            //break;
//        }
//        }

        double mydou = 0.0004222222;
        System.out.print("\n");
        System.out.print(mydou);

        long v1 = 890000;
        long v2 = 400000;
        //double fs = (((double)v1 - (double)v2) / 1000000);
        float rst = ((float)v1 - (float)v2) / 1000000;
        System.out.print("\n");
        System.out.print(rst);
    }

    public static void updateVal(String abc) {
        abc = abc + "fdfjkdsfjldfsj";
    }
}
