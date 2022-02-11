package main.java.edu.zju.zjh.lcold;

public class T451 {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        String res = "";

        for (int i=0; i<s.length(); i++){
            freq[(int)s.charAt(i)]++;
        }

        int maxCount = 1, indexMax;
        while (maxCount > 0){
            maxCount = 0;
            indexMax = 0;
            for (int j=0; j<128; j++){
                if (maxCount < freq[j]){
                    maxCount = freq[j];
                    indexMax = j;
                }
            }

            freq[indexMax] = 0;
            for (int ri=0; ri<maxCount; ri++){
                res += (char)indexMax;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "Aavv";

        T451 t451 = new T451();
        System.out.println(t451.frequencySort(s));
    }
}
