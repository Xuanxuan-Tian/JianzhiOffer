请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，
匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配。

/*题目考察正则匹配
  *表示它前面的字符或子串可以出现0次或一次，
  因此"aaa"匹配"ab*ac*a"的原因是，两个*前面的字符b和c出现0次，因此能够匹配为"aaa"
  不能匹配"ab*a"因为如果匹配一次，那么编程了匹配"aba"，如果匹配0次，则变成了匹配"aa"。
  正则匹配的具体规则，参见菜鸟教程讲解http://www.runoob.com/java/java-regular-expressions.html
*/
class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null)
            return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str,strIndex,pattern,patternIndex);
    }

    public boolean matchCore(char[] str,int strIndex,char[] pattern,int patternIndex){
        //检查有效性，str到尾且pattern到尾，匹配成功
        if(strIndex == str.length && patternIndex == pattern.length)
            return true;

        //pattern先到尾，匹配失败
        if(strIndex != str.length && patternIndex == pattern.length)
            return false;

        //模式数组第2个是*，且字符串数组第1个与模式数组第一个匹配，则分三种匹配模式，如果不匹配，模式后移两位
        if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*'){
            if((strIndex != str.length && pattern[patternIndex] == str[strIndex]) ||
                    (pattern[patternIndex] == '.' && strIndex != str.length)){
                return matchCore(str,strIndex,pattern,patternIndex + 2)//模式后移2，相当于x*匹配0个字符
                        || matchCore(str,strIndex + 1,pattern,patternIndex + 2)//视为匹配一个字符
                        ||  matchCore(str,strIndex + 1,pattern,patternIndex);//*匹配1个，再匹配str中的下一个
            }else
                return  matchCore(str,strIndex ,pattern,patternIndex + 2);//模式数组与字符串数组第1个不匹配，模式直接后移2
        }

        //模式数组的第2个不是*，且字符串数组第1个跟模式数组第1个不匹配，则都后移1位，否则直接返回false
        if((strIndex != str.length && pattern[patternIndex] == str[strIndex]) ||
                (pattern[patternIndex] == '.' && strIndex != str.length))
            return matchCore(str,strIndex + 1 ,pattern,patternIndex + 1);
        return false;
    }
}
