package com.hanlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.dictionary.py.Pinyin;
import com.hankcs.hanlp.seg.CRF.CRFSegment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.Other.AhoCorasickDoubleArrayTrieSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.Viterbi.ViterbiSegment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.suggest.Suggester;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;
import com.hankcs.hanlp.tokenizer.TraditionalChineseTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-10-15 17:58
 */
public class HanlpTest {
    public static void main(String[] args) throws IOException {
        // 关闭词性显示
        HanLP.Config.ShowTermNature = false;
        // AhoCorasickDoubleArrayTrieSegment要求用户必须提供自己的词典路径
        AhoCorasickDoubleArrayTrieSegment segment = new AhoCorasickDoubleArrayTrieSegment(HanLP.Config.CustomDictionaryPath[0]);
        System.out.println(segment.seg("微观经济学继续教育循环经济"));
    }
   /* public static void main(String[] args){


        Participle();
//        extractKeyword();
//        extractSummary();
//        extractPhrase();
//        suggest_test();
//        converto();
//        nameRecognize();
        //analysebysyntax();
    }*/

    /**
     * @Author：sks
     * @Description：测试各种分词
     * @Date：
     */
    private static void Participle(){
        //标准分词
        //HanLP.segment 其实是对 StandardTokenizer.segment 的包装。
        //HanLP中有一系列“开箱即用”的静态分词器，以 Tokenizer 结尾
        List<Term> stermList = HanLP.segment("商品和服务");
        System.out.println(stermList);
        //[商品/n, 和/c, 服务/vn]

        //NLP分词
        //NLP分词 NLPTokenizer 会执行全部命名实体识别和词性标注。
        //所以速度比标准分词慢，并且有误识别的情况。
        List<Term> nlptermList = NLPTokenizer.segment("中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程");
        System.out.println(nlptermList);
        //输出：[中国科学院/n, 计算/v, 技术/n, 研究所/n, 的/uj, 宗成庆/nr, 教授/n, 正在/d, 教授/n, 自然/d, 语言/n, 处理/v, 课程/n]

        //索引分词
        //索引分词 IndexTokenizer 是面向搜索引擎的分词器，能够对长词全切分，另外通过 term.offset 可以获取单词在文本中的偏移量
        List<Term> termList = IndexTokenizer.segment("主副食品");
        for (Term term : termList)
        {
            System.out.println(term + " [" + term.offset + ":" + (term.offset + term.word.length()) + "]");
        }
        //主副食品/n [0:4]
        //主副食/j [0:3]
        //副食品/n [1:4]
        //副食/n [1:3]
        //食品/n [2:4]

        //繁体分词
        List<Term> fttermList = TraditionalChineseTokenizer.segment("大衛貝克漢不僅僅是名著名球員，球場以外，其妻為前辣妹合唱團成員維多利亞·碧咸，" +
                "亦由於他擁有突出外表、百變髮型及正面的形象，以至自己品牌的男士香水等商品，及長期擔任運動品牌Adidas的代言人，" +
                "因此對大眾傳播媒介和時尚界等方面都具很大的影響力，在足球圈外所獲得的認受程度可謂前所未見。");
        System.out.println(fttermList);
        //[大衛貝克漢/nrf, 不僅僅/d, 是/v, 名著/n, 名/q, 球員/n, ，/w, 球場/n, 以外/f, ，/w, 其/r, 妻/ng, 為/p, 前/f, 辣妹/nz, 合唱團/n, 成員/n, 維多利亞/ns,
        // ·/w, 碧/ag, 咸/ng, ，/w, 亦/d, 由於/c, 他/r, 擁有/v, 突出/a, 外表/n, 、/w, 百變/nz, 髮型/n, 及/c, 正面/d, 的/uj, 形象/n, ，/w,
        // 以至/c, 自己/r, 品牌/n, 的/uj, 男士/n, 香水/n, 等/u, 商品/n, ，/w, 及/c, 長期/d, 擔任/v, 運動/n, 品牌/n, Adidas/nx, 的/uj, 代言人/n,
        // ，/w, 因此/c, 對/p, 大眾/n, 傳播/vn, 媒介/n, 和/c, 時尚界/nz, 等/u, 方面/n, 都/d, 具/vg, 很大/d, 的/uj, 影響力/n, ，/w,
        // 在/p, 足球/n, 圈外/nz, 所/u, 獲得/v, 的/uj, 認/v, 受/v, 程度/n, 可/v, 謂/vg, 前所未見/l, 。/w]


        //极速词典分词
        //极速分词是词典最长分词，速度极其快，精度一般。调用方法如下:
        String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";
        System.out.println(SpeedTokenizer.segment(text));
        long start = System.currentTimeMillis();
        int pressure = 1000000;
        for (int i = 0; i < pressure; ++i)
        {
            SpeedTokenizer.segment(text);
        }
        double costTime = (System.currentTimeMillis() - start) / (double)1000;
        System.out.printf("分词速度：%.2f字每秒", text.length() * pressure / costTime);


        //N-最短路径分词
        //N最短路分词器 NShortSegment 比最短路分词器( DijkstraSegment )慢，但是效果稍微好一些，对命名实体识别能力更强
        //一般场景下最短路分词的精度已经足够，而且速度比N最短路分词器快几倍
        Segment nShortSegment = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
        Segment shortestSegment = new ViterbiSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
        String[] testCase = new String[]{
                "刘喜杰石国祥会见吴亚琴先进事迹报告团成员",
        };
        for (String sentence : testCase)
        {
            System.out.println("N-最短分词：" + nShortSegment.seg(sentence) + "\n最短路分词：" + shortestSegment.seg(sentence));
        }

        //CRF分词
        //基于CRF模型和BEMS标注训练得到的分词器
        //CRF对新词有很好的识别能力，但是无法利用自定义词典。
        //也不支持命名实体识别，应用场景仅限于新词识别。
        Segment segment = new CRFSegment();
        segment.enablePartOfSpeechTagging(true);
        List<Term> crftermList = segment.seg("你看过穆赫兰道吗");
        System.out.println(crftermList);
        for (Term term : crftermList)
        {
            if (term.nature == null)
            {
                System.out.println("识别到新词：" + term.word);
            }
        }
    }
    /**
     * 这里使用HanLP进行分词 ,只获取名称和动名称
     * @param text
     * @return
     */

    /**
     * @Author：sks
     * @Description：抽取关键字
     * @Date：
     */
    private static List<String> hanLPSegment(String text){
        List<String> wordList = new ArrayList<String>();
        List<Term> words= HanLP.segment(text);
        for(Term tm:words){
            if(tm.nature== Nature.n||tm.nature== Nature.vn){
                wordList.add(tm.word);
            }
        }

        return wordList;
    }


    private static void extractKeyword(){
        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
        //返回频次最高的5个关键词
        List<String> keywordList = HanLP.extractKeyword(content, 5);
        System.out.println(keywordList);
    }

    /**
     * @Author：sks
     * @Description：提取摘要
     * @Date：
     */
    private static void extractSummary(){
        //同样是一句话调用，第一个参数指定文本，第二个参数指定需要提取几个句子:

        String document = "算法可大致分为基本算法、数据结构的算法、数论算法、计算几何的算法、图的算法、动态规划以及数值分析、加密算法、排序算法、检索算法、随机化算法、并行算法、厄米变形模型、随机森林算法。\n" +
                "算法可以宽泛的分为三类，\n" +
                "一，有限的确定性算法，这类算法在有限的一段时间内终止。他们可能要花很长时间来执行指定的任务，但仍将在一定的时间内终止。这类算法得出的结果常取决于输入值。\n" +
                "二，有限的非确定算法，这类算法在有限的时间内终止。然而，对于一个（或一些）给定的数值，算法的结果并不是唯一的或确定的。\n" +
                "三，无限的算法，是那些由于没有定义终止定义条件，或定义的条件无法由输入的数据满足而不终止运行的算法。通常，无限算法的产生是由于未能确定的定义终止条件。";
        List<String> sentenceList = HanLP.extractSummary(document, 3);//3:返回的句子数
        System.out.println(sentenceList);

        String summary = HanLP.getSummary(document,50);//返回的摘要长度
        System.out.println(summary);
    }

    private static void extractPhrase(){
        String text = "算法工程师\n" +
                "算法（Algorithm）是一系列解决问题的清晰指令，也就是说，能够对一定规范的输入，在有限时间内获得所要求的输出。如果一个算法有缺陷，或不适合于某个问题，执行这个算法将不会解决这个问题。不同的算法可能用不同的时间、空间或效率来完成同样的任务。一个算法的优劣可以用空间复杂度与时间复杂度来衡量。算法工程师就是利用算法处理事物的人。\n" +
                "\n" +
                "1职位简介\n" +
                "算法工程师是一个非常高端的职位；\n" +
                "专业要求：计算机、电子、通信、数学等相关专业；\n" +
                "学历要求：本科及其以上的学历，大多数是硕士学历及其以上；\n" +
                "语言要求：英语要求是熟练，基本上能阅读国外专业书刊；\n" +
                "必须掌握计算机相关知识，熟练使用仿真工具MATLAB等，必须会一门编程语言。\n" +
                "\n" +
                "2研究方向\n" +
                "视频算法工程师、图像处理算法工程师、音频算法工程师 通信基带算法工程师\n" +
                "\n" +
                "3目前国内外状况\n" +
                "目前国内从事算法研究的工程师不少，但是高级算法工程师却很少，是一个非常紧缺的专业工程师。算法工程师根据研究领域来分主要有音频/视频算法处理、图像技术方面的二维信息算法处理和通信物理层、雷达信号处理、生物医学信号处理等领域的一维信息算法处理。\n" +
                "在计算机音视频和图形图像技术等二维信息算法处理方面目前比较先进的视频处理算法：机器视觉成为此类算法研究的核心；另外还有2D转3D算法(2D-to-3D conversion)，去隔行算法(de-interlacing)，运动估计运动补偿算法(Motion estimation/Motion Compensation)，去噪算法(Noise Reduction)，缩放算法(scaling)，锐化处理算法(Sharpness)，超分辨率算法(Super Resolution),手势识别(gesture recognition),人脸识别(face recognition)。\n" +
                "在通信物理层等一维信息领域目前常用的算法：无线领域的RRM、RTT，传送领域的调制解调、信道均衡、信号检测、网络优化、信号分解等。\n" +
                "另外数据挖掘、互联网搜索算法也成为当今的热门方向。\n" +
                "算法工程师逐渐往人工智能方向发展。";
        List<String> phraseList = HanLP.extractPhrase(text, 10);
        System.out.println(phraseList);
    }

    /**
     * @Author：sks
     * @Description：智能提示
     * @Date：
     */
    private static void suggest_test(){
        Suggester suggester = new Suggester();
        String[] titleArray =
                (
                        "威廉王子发表演说 呼吁保护野生动物\n" +
                                "《时代》年度人物最终入围名单出炉 普京马云入选\n" +
                                "“黑格比”横扫菲：菲吸取“海燕”经验及早疏散\n" +
                                "日本保密法将正式生效 日媒指其损害国民知情权\n" +
                                "英报告说空气污染带来“公共健康危机”"
                ).split("\\n");
        for (String title : titleArray)
        {
            suggester.addSentence(title);
        }

        System.out.println(suggester.suggest("发言", 1));       // 语义
        System.out.println(suggester.suggest("危机公共", 1));   // 字符
        System.out.println(suggester.suggest("mayun", 1));      // 拼音
    }

    /**
     * @Author：sks
     * @Description：简繁转换
     * @Date：
     */
    private static void converto(){
        //简繁转换
        System.out.println(HanLP.convertToTraditionalChinese("“以后等你当上皇后，就能买草莓庆祝了”"));
        System.out.println(HanLP.convertToSimplifiedChinese("用筆記簿型電腦寫程式HelloWorld"));

        //拼音转换
        String text = "重载不是重任";
        List<Pinyin> pinyinList = HanLP.convertToPinyinList(text);
        System.out.print("原文,");
        for (char c : text.toCharArray())
        {
            System.out.printf("%c,", c);
        }
        System.out.println();

        System.out.print("拼音（数字音调）,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin);
        }
        System.out.println();

        System.out.print("拼音（符号音调）,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin.getPinyinWithToneMark());
        }
        System.out.println();

        System.out.print("拼音（无音调）,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin.getPinyinWithoutTone());
        }
        System.out.println();

        System.out.print("声调,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin.getTone());
        }
        System.out.println();

        System.out.print("声母,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin.getShengmu());
        }
        System.out.println();

        System.out.print("韵母,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin.getYunmu());
        }
        System.out.println();

        System.out.print("输入法头,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin.getHead());
        }
        System.out.println();
    }

    /**
     * @Author：sks
     * @Description：中国人姓名识别
     * @Date：
     */
    private static void nameRecognize(){
        //目前分词器基本上都默认开启了中国人名识别，比如HanLP.segment()接口中使用的分词器等等，用户不必手动开启；上面的代码只是为了强调。
        String[] testCase = new String[]{
                "签约仪式前，秦光荣、李纪恒、仇和等一同会见了参加签约的企业家。",
                "王国强、高峰、汪洋、张朝阳光着头、韩寒、小四",
                "张浩和胡健康复员回家了",
                "王总和小丽结婚了",
                "编剧邵钧林和稽道青说",
                "这里有关天培的有关事迹",
                "龚学平等领导,邓颖超生前",
        };
        Segment segment = HanLP.newSegment().enableNameRecognize(true);
        for (String sentence : testCase)
        {
            List<Term> termList = segment.seg(sentence);
            System.out.println(termList);
        }

        //音译人名识别
        //目前分词器基本上都默认开启了音译人名识别，用户不必手动开启；上面的代码只是为了强调。
        String[] testCase1 = new String[]{
                "一桶冰水当头倒下，微软的比尔盖茨、Facebook的扎克伯格跟桑德博格、亚马逊的贝索斯、苹果的库克全都不惜湿身入镜，这些硅谷的科技人，飞蛾扑火似地牺牲演出，其实全为了慈善。",
                "世界上最长的姓名是简森·乔伊·亚历山大·比基·卡利斯勒·达夫·埃利奥特·福克斯·伊维鲁莫·马尔尼·梅尔斯·帕特森·汤普森·华莱士·普雷斯顿。",
        };
        Segment segment1 = HanLP.newSegment().enableTranslatedNameRecognize(true);
        for (String sentence : testCase1)
        {
            List<Term> termList = segment1.seg(sentence);
            System.out.println(termList);
        }

        //地名识别
        //可以自动识别地名，标注为ns:
        //目前标准分词器都默认关闭了地名识别，用户需要手动开启；这是因为消耗性能，其实多数地名都收录在核心词典和用户自定义词典中。
        //在生产环境中，能靠词典解决的问题就靠词典解决，这是最高效稳定的方法
        String[] areaCase = new String[]{
                "武胜县新学乡政府大楼门前锣鼓喧天",
                "蓝翔给宁夏固原市彭阳县红河镇黑牛沟村捐赠了挖掘机",
        };
        Segment areasegment = HanLP.newSegment().enablePlaceRecognize(true);
        for (String sentence : areaCase)
        {
            List<Term> termList = areasegment.seg(sentence);
            System.out.println(termList);
        }

        //机构名识别
        //可以自动识别地名，标注为ns:
        //目前分词器默认关闭了机构名识别，用户需要手动开启；这是因为消耗性能，其实常用机构名都收录在核心词典和用户自定义词典中。
        //HanLP的目的不是演示动态识别，在生产环境中，能靠词典解决的问题就靠词典解决，这是最高效稳定的方法。
        String[] jgCase = new String[]{
                "我在上海林原科技有限公司兼职工作，",
                "同时在上海外国语大学日本文化经济学院学习经济与外语。",
                "我经常在台川喜宴餐厅吃饭，",
                "偶尔去地中海影城看电影。",
        };
        Segment jgsegment =  HanLP.newSegment().enableOrganizationRecognize(true);
        for (String sentence : jgCase)
        {
            List<Term> termList = jgsegment.seg(sentence);
            System.out.println(termList);
        }
    }

    private static void analysebysyntax(){
        System.out.println(HanLP.parseDependency("把市场经济奉行的等价交换原则引入党的生活和国家机关政务活动中"));
        //System.out.println(CRFDependencyParser.compute("把市场经济奉行的等价交换原则引入党的生活和国家机关政务活动中"));
    }
}
