在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。
/*自己写的代码，思路太乱，太复杂
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == "")
            return -1;
        char findChar = ' ';
        char[] strArray = str.toCharArray();
        LinkedHashMap<Character,Integer> hashMap = new LinkedHashMap<>();
        for (char ss: strArray) {
            hashMap.put(ss,0);
        }
        for (char ss: strArray) {
            hashMap.put(ss,hashMap.get(ss)+1);
        }
        
        Iterator iterator = hashMap.entrySet().iterator();
        while((iterator.hasNext())){
            Map.Entry entry = (Map.Entry) iterator.next();
            if((int)entry.getValue() == 1){
                findChar = (char)entry.getKey();
                break;
            }
        }
        int index = -1;
       for (int i = 0;i< strArray.length;i++){
            if(strArray[i] == findChar)
                index = i;
       }
        return index;
    }
}*/

/*别人的代码1*/
/*public class Solution {
	public int FirstNotRepeatingChar(String str)
        {
        char[] c = str.toCharArray();
        int[] a = new int['z'+1];
        for (char d : c)
            a[(int) d]++;
        for (int i = 0; i < c.length; i++)
            if (a[(int) c[i]] == 1)
                return i;
        return -1;
    }
}*/

/*别人的代码2，和我写的思路是一样的，但是人家写的代码更简洁*/
import java.util.LinkedHashMap;
public class Solution{
    public int FirstNotRepeatingChar(String str){
        LinkedHashMap <Character,Integer> map = new LinkedHashMap<Character,Integer>();
        for(int i = 0;i < str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i),++time);
            }else
                map.put(str.charAt(i),1);
        }
        
        int pos = -1;
        int i = 0;
        for(;i < str.length();i++){
            char c = str.charAt(i);
            if(map.get(c) == 1)
                return i;
            
        }
        return pos;
    }
}

