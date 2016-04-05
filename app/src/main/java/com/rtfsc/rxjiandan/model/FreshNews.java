package com.rtfsc.rxjiandan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kdroid on 16-3-29.
 */
public class FreshNews implements Serializable{
    public static final int PAGE_FIRST = 1;

    /**
     * status : ok
     * count : 24
     * count_total : 54278
     * pages : 2262
     * posts : [{"id":77329,"url":"http://jandan.net/2016/03/29/woman-pooping-date.html","title":"一场约会中的便便事故","date":"2016-03-29 11:00:06","tags":[{"id":712,"slug":"meme","title":"meme","description":"","post_count":116}],"author":{"id":550,"slug":"mayan","name":"mayan","first_name":"may","last_name":"an","nickname":"mayan","url":"","description":""},"comment_count":6,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/GSF8.jpg"]}},{"id":77331,"url":"http://jandan.net/2016/03/29/african-rhino.html","title":"犀牛大逃亡：引渡至澳洲以存火种","date":"2016-03-29 09:33:55","tags":[{"id":575,"slug":"%e7%8e%af%e4%bf%9d","title":"环保","description":"","post_count":640}],"author":{"id":587,"slug":"cedric","name":"Cedric","first_name":"Cedric","last_name":"Hsu","nickname":"Cedric","url":"","description":""},"comment_count":14,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/2NMC.jpg"]}},{"id":77321,"url":"http://jandan.net/2016/03/29/always-hungry.html","title":"为何胃像无底洞，总是吃不饱？","date":"2016-03-29 08:06:09","tags":[{"id":687,"slug":"%e6%97%a0%e5%8e%98%e5%a4%b4%e7%a0%94%e7%a9%b6","title":"无厘头研究","description":"","post_count":2216}],"author":{"id":523,"slug":"joan","name":"桃子","first_name":"","last_name":"","nickname":"桃子","url":"","description":""},"comment_count":16,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/CDXD.jpg"]}},{"id":77320,"url":"http://jandan.net/2016/03/28/early-modern-sleep.html","title":"怕恶魔的近代欧洲人，晚上睡觉的时候怎么办？","date":"2016-03-28 23:46:05","tags":[{"id":843,"slug":"%e5%8f%b2%e6%b5%b7%e9%92%a9%e6%b2%89","title":"史海钩沉","description":"","post_count":255}],"author":{"id":523,"slug":"joan","name":"桃子","first_name":"","last_name":"","nickname":"桃子","url":"","description":""},"comment_count":20,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/D19U.jpg"]}},{"id":77316,"url":"http://jandan.net/2016/03/28/misdiagnose-rude-patients.html","title":"自讨苦吃：不友好的患者更容易被误诊","date":"2016-03-28 22:30:05","tags":[{"id":687,"slug":"%e6%97%a0%e5%8e%98%e5%a4%b4%e7%a0%94%e7%a9%b6","title":"无厘头研究","description":"","post_count":2216}],"author":{"id":486,"slug":"island","name":"island","first_name":"","last_name":"","nickname":"island","url":"http://weibo.com/u/1058924852","description":""},"comment_count":15,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/C2AG.jpg"]}},{"id":77325,"url":"http://jandan.net/2016/03/28/about-beavers.html","title":"有关河狸的真相","date":"2016-03-28 20:32:47","tags":[{"id":449,"slug":"%e8%b5%b0%e8%bf%9b%e7%a7%91%e5%ad%a6","title":"走进科学","description":"","post_count":3301}],"author":{"id":567,"slug":"innerve","name":"放学回家","first_name":"","last_name":"","nickname":"放学回家","url":"","description":""},"comment_count":24,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/3SVC.jpg"]}},{"id":77323,"url":"http://jandan.net/2016/03/28/lcpinai-01.html","title":"OOXX居然能让人变美变瘦？","date":"2016-03-28 20:08:43","tags":[{"id":549,"slug":"sex","title":"SEX","description":"","post_count":1224}],"author":{"id":376,"slug":"chaozaiji","name":"超载鸡","first_name":"chaozai","last_name":"ji","nickname":"超载鸡","url":"","description":""},"comment_count":71,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/OF1R.jpg"]}},{"id":77322,"url":"http://jandan.net/2016/03/28/killed-photos.html","title":"美国大萧条珍藏照上的神秘黑洞究竟是什么","date":"2016-03-28 19:00:52","tags":[{"id":791,"slug":"%e6%91%84%e5%bd%b1","title":"摄影","description":"","post_count":564}],"author":{"id":553,"slug":"catherine","name":"杨二姐","first_name":"","last_name":"","nickname":"杨二姐","url":"","description":""},"comment_count":25,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/O7OI.jpg"]}},{"id":77308,"url":"http://jandan.net/2016/03/28/burner-phones.html","title":"一次性手机在美国将禁用","date":"2016-03-28 17:45:29","tags":[{"id":120,"slug":"geek","title":"Geek","description":"","post_count":3260}],"author":{"id":597,"slug":"congsi","name":"次次小姐","first_name":"","last_name":"","nickname":"次次小姐","url":"","description":""},"comment_count":27,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/B2PA.jpg"]}},{"id":77314,"url":"http://jandan.net/2016/03/28/10-hardest-habits.html","title":"这十种习惯最难戒，你中枪了吗","date":"2016-03-28 16:30:31","tags":[{"id":693,"slug":"%e5%b0%8f%e8%b4%b4%e5%a3%ab","title":"小贴士","description":"","post_count":650}],"author":{"id":523,"slug":"joan","name":"桃子","first_name":"","last_name":"","nickname":"桃子","url":"","description":""},"comment_count":49,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/VPAA.jpg"]}},{"id":77319,"url":"http://jandan.net/2016/03/28/vr-porn-channel.html","title":"Pornhub进军VR，工作闲暇也能看小黄片","date":"2016-03-28 15:10:21","tags":[{"id":860,"slug":"%e8%99%9a%e6%8b%9f%e7%8e%b0%e5%ae%9e","title":"虚拟现实","description":"","post_count":81}],"author":{"id":553,"slug":"catherine","name":"杨二姐","first_name":"","last_name":"","nickname":"杨二姐","url":"","description":""},"comment_count":27,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/XWBS.jpg"]}},{"id":77312,"url":"http://jandan.net/2016/03/28/mindfulness-meditation.html","title":"正念冥想的神奇：帮你缓解背痛","date":"2016-03-28 13:49:22","tags":[{"id":831,"slug":"%e5%81%a5%e5%ba%b7","title":"健康","description":"","post_count":757}],"author":{"id":523,"slug":"joan","name":"桃子","first_name":"","last_name":"","nickname":"桃子","url":"","description":""},"comment_count":10,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/4I2C.jpg"]}},{"id":77305,"url":"http://jandan.net/2016/03/28/donating-leftover.html","title":"星巴克的承诺：每天剩余食物都捐了","date":"2016-03-28 11:40:59","tags":[{"id":824,"slug":"%e6%ad%a3%e8%83%bd%e9%87%8f","title":"正能量","description":"","post_count":241}],"author":{"id":593,"slug":"banana","name":"一只咸鱼","first_name":"","last_name":"","nickname":"一只咸鱼","url":"","description":""},"comment_count":18,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/OUES.jpg"]}},{"id":77300,"url":"http://jandan.net/2016/03/28/mysterious-herculaneum-scrolls.html","title":"烧成炭也认识你：上古卷轴解读在即","date":"2016-03-28 10:30:15","tags":[{"id":449,"slug":"%e8%b5%b0%e8%bf%9b%e7%a7%91%e5%ad%a6","title":"走进科学","description":"","post_count":3301}],"author":{"id":587,"slug":"cedric","name":"Cedric","first_name":"Cedric","last_name":"Hsu","nickname":"Cedric","url":"","description":""},"comment_count":35,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/DWSU.jpg"]}},{"id":77296,"url":"http://jandan.net/2016/03/28/first-date-3.html","title":"第一次约会最好选在早上","date":"2016-03-28 09:30:36","tags":[{"id":847,"slug":"%e5%bf%83%e7%90%86%e5%ad%a6","title":"心理学","description":"","post_count":335}],"author":{"id":523,"slug":"joan","name":"桃子","first_name":"","last_name":"","nickname":"桃子","url":"","description":""},"comment_count":20,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/2UHQ.jpg"]}},{"id":77297,"url":"http://jandan.net/2016/03/28/polish-board-game.html","title":"俄罗斯人玻璃心：波兰桌游全面遭禁","date":"2016-03-28 08:17:34","tags":[{"id":856,"slug":"%e4%bf%84%e7%bd%97%e6%96%af","title":"俄罗斯","description":"","post_count":232}],"author":{"id":587,"slug":"cedric","name":"Cedric","first_name":"Cedric","last_name":"Hsu","nickname":"Cedric","url":"","description":""},"comment_count":40,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/3T6A.jpg"]}},{"id":77301,"url":"http://jandan.net/2016/03/28/balloon-pop.html","title":"插不破的气球是怎么回事？","date":"2016-03-28 00:12:32","tags":[{"id":449,"slug":"%e8%b5%b0%e8%bf%9b%e7%a7%91%e5%ad%a6","title":"走进科学","description":"","post_count":3300}],"author":{"id":587,"slug":"cedric","name":"Cedric","first_name":"Cedric","last_name":"Hsu","nickname":"Cedric","url":"","description":""},"comment_count":27,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/N4EV.jpg"]}},{"id":77285,"url":"http://jandan.net/2016/03/27/jandan-pictures-4.html","title":"无聊图大吐槽【44P】","date":"2016-03-27 23:00:20","tags":[{"id":663,"slug":"%e5%a4%a7%e5%90%90%e6%a7%bd","title":"大吐槽","description":"","post_count":333}],"author":{"id":578,"slug":"skydom","name":"金星","first_name":"","last_name":"","nickname":"金星","url":"","description":""},"comment_count":30,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/J9RL.jpg"]}},{"id":77288,"url":"http://jandan.net/2016/03/27/jandan-comments-2.html","title":"一周优评：老司机们叹了一口气 ，又少了一位女乘客了","date":"2016-03-27 22:30:19","tags":[{"id":650,"slug":"%e5%91%a8%e6%9c%ab%e5%95%a6","title":"周末啦","description":"","post_count":252}],"author":{"id":578,"slug":"skydom","name":"金星","first_name":"","last_name":"","nickname":"金星","url":"","description":""},"comment_count":21,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/MG98.jpg"]}},{"id":77303,"url":"http://jandan.net/2016/03/27/cinderellas-shattered-dreams.html","title":"灰姑娘的水晶鞋，跑起来居然会碎","date":"2016-03-27 21:29:29","tags":[{"id":687,"slug":"%e6%97%a0%e5%8e%98%e5%a4%b4%e7%a0%94%e7%a9%b6","title":"无厘头研究","description":"","post_count":2216}],"author":{"id":559,"slug":"lping2","name":"大脑袋","first_name":"","last_name":"","nickname":"大脑袋","url":"","description":""},"comment_count":48,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/KJG6.jpg"]}},{"id":77298,"url":"http://jandan.net/2016/03/27/limb-of-sun.html","title":"煎蛋小学堂：太阳的边缘","date":"2016-03-27 21:05:21","tags":[{"id":765,"slug":"%e5%b0%8f%e5%ad%a6%e5%a0%82","title":"小学堂","description":"","post_count":312}],"author":{"id":479,"slug":"lping","name":"小脑袋","first_name":"","last_name":"","nickname":"小脑袋","url":"http://weibo.com/u/1913923340","description":""},"comment_count":6,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/GT3H.jpg"]}},{"id":77281,"url":"http://jandan.net/2016/03/27/mp59.html","title":"没品小视频：通灵师","date":"2016-03-27 20:34:55","tags":[{"id":825,"slug":"%e6%b2%a1%e5%93%81%e5%b0%8f%e8%a7%86%e9%a2%91","title":"没品小视频","description":"","post_count":84}],"author":{"id":559,"slug":"lping2","name":"大脑袋","first_name":"","last_name":"","nickname":"大脑袋","url":"","description":""},"comment_count":17,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/KYL2.jpg"]}},{"id":77295,"url":"http://jandan.net/2016/03/27/ai-literary.html","title":"AI进军文学界，所创小说入围大赛初选","date":"2016-03-27 20:18:05","tags":[{"id":777,"slug":"tech","title":"Tech","description":"","post_count":278}],"author":{"id":587,"slug":"cedric","name":"Cedric","first_name":"Cedric","last_name":"Hsu","nickname":"Cedric","url":"","description":""},"comment_count":26,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/GBYK.jpg"]}},{"id":77294,"url":"http://jandan.net/2016/03/27/paper-print.html","title":"《独立报》彻底走向电子平台，纸媒未来在何方？","date":"2016-03-27 19:30:51","tags":[{"id":489,"slug":"%e5%86%b7%e6%96%b0%e9%97%bb","title":"冷新闻","description":"","post_count":3806}],"author":{"id":597,"slug":"congsi","name":"次次小姐","first_name":"","last_name":"","nickname":"次次小姐","url":"","description":""},"comment_count":12,"custom_fields":{"thumb_c":["http://tankr.net/s/custom/EDTV.jpg"]}}]
     */

    private String status;
    private int count;
    private int count_total;
    private int pages;
    /**
     * id : 77329
     * url : http://jandan.net/2016/03/29/woman-pooping-date.html
     * title : 一场约会中的便便事故
     * date : 2016-03-29 11:00:06
     * tags : [{"id":712,"slug":"meme","title":"meme","description":"","post_count":116}]
     * author : {"id":550,"slug":"mayan","name":"mayan","first_name":"may","last_name":"an","nickname":"mayan","url":"","description":""}
     * comment_count : 6
     * custom_fields : {"thumb_c":["http://tankr.net/s/custom/GSF8.jpg"]}
     */

    private List<Post> posts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount_total() {
        return count_total;
    }

    public void setCount_total(int count_total) {
        this.count_total = count_total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
