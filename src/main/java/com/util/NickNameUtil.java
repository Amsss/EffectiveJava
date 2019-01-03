package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NickNameUtil {

    private static StringBuilder regEx = new StringBuilder("[")
            .append("a-zA-Z0-9０-９")
            .append("一二三四五六七八九十壹贰叁肆伍陆柒捌玖拾")
            .append("①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮⑯⑰⑱⑲⑳")
            .append("㈠㈡㈢㈣㈤㈥㈦㈧㈨")
            .append("⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽⑾⑿⒀⒁⒂⒃⒄⒅⒆⒇")
            .append("⒈⒉⒊⒋⒌⒍⒎⒏⒐⒑⒒⒓⒔⒕⒖⒗⒘⒙⒚⒛")
            .append("ⒶⒷⒸⒹⓐⓑⓒⓓⓔⓕⓖⓗⓘⓙⓚⓛⓜⓝⓞⓟⓠⓡⓢⓣⓤⓥⓦⓧⓨⓩ")
            .append("ΑΒΕΖΗΙΚΜΝΟΡΤΥΧ")
            .append("αγικνορτυχω")
            .append("АВЕЗКМНОПРСТУХШЫЬ")
            .append("авекмнорстухчыь")
            .append("]");
    private static Pattern nickPattern = Pattern.compile(regEx.toString());

    private static Pattern blankPattern = Pattern.compile("^[^ ]+$");

    /**
     * 对昵称中的字母和数字进行过滤，超过4个后面打*
     *
     * @param nickName
     * @return
     */
    public static String normalize(String nickName) {
        Matcher matcher = nickPattern.matcher(nickName);
        int count = 0;
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            if (count >= 4) {
                matcher.appendReplacement(sb, "*");
            }
            count++;
        }
        return matcher.appendTail(sb).toString();
    }

    public static boolean hasBlank(String nickName) {
        return !blankPattern.matcher(nickName).matches();
    }

    public static void main(String[] args) {
        System.out.println(normalize("$$$$111$$11$$$"));
		/*Pattern pattern = Pattern.compile("(another) (test)");
	    StringBuffer sb = new StringBuffer();

	    String candidateString = "This is another test.";

	    String replacement = "$1 AAA $2";
	    Matcher m = pattern.matcher(candidateString);
	    m.find();

	    m.appendReplacement(sb, replacement);
	    //m.appendTail(sb);
	    String msg = sb.toString();
	    System.out.println(msg);*/
    }
}
