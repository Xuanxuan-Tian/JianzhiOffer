牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意
思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你
能帮助他么？
public class Solution {
    public String ReverseSentence(String str) {
        if(str == null || str ==" ")
            return str;
        char[] array = str.toCharArray();
        int low = 0;
        int high = array.length - 1;
        
        //反转整个句子
        reverse(array,low,high);
        
        //反转句子中的每个单词
        int begin=0;
        for(int i = 1;i < array.length;i++){
            if(array[i] == ' '){
                reverse(array,begin,i-1);
                begin = i + 1;
            }
        }
        reverse(array,begin,array.length - 1);

        //String res = String.valueOf(array);
        return new String(array);

    }

    //reverse的功能是反转任意一段字符串
    void reverse(char[] array,int low,int high){
        while(low < high){
            char temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            low++;
            high--;
        }
    }
}
