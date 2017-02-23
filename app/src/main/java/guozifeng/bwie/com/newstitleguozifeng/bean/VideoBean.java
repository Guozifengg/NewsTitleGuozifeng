package guozifeng.bwie.com.newstitleguozifeng.bean;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/2/23.
 * 作用：
 */
public class VideoBean {

    /**
     * cover : http://vimg3.ws.126.net/image/snapshot/2017/2/Q/1/VCCQJ3QQ1.jpg
     * description : 还没翻篇呢！曝王思聪与豆得儿亲密逛街共享晚餐
     * length : 75
     * m3u8_url : http://flv2.bn.netease.com/tvmrepo/2017/2/I/1/ECCQ7EJI1/SD/movie_index.m3u8
     * mp4_url : http://flv2.bn.netease.com/tvmrepo/2017/2/I/1/ECCQ7EJI1/SD/ECCQ7EJI1-mobile.mp4
     * playCount : 0
     * playersize : 1
     * ptime : 2017-02-20 17:13:16
     * replyBoard : video_bbs
     * replyid : CCQ7FEEE008535RB
     * sectiontitle :
     * title : 曝王思聪与豆得儿亲密逛街共享晚餐
     * topicDesc : 柯南改行娱乐侦探
     * topicImg : http://vimg1.ws.126.net/image/snapshot/2016/4/9/G/VBJ42I79G.jpg
     * topicName : 八卦柯南君
     * topicSid : VBJ42I79E
     * vid : VCCQ7FEEE
     * videoTopic : {"alias":"柯南改行娱乐侦探","ename":"T1460515714560","tid":"T1460515714560","tname":"八卦柯南君","topic_icons":"http://img2.cache.netease.com/m/newsapp/topic_icons/T1460515714560.png"}
     * videosource : 新媒体
     */

    private String cover;
    private String description;
    private int length;
    private String m3u8_url;
    private String mp4_url;
    private int playCount;
    private int playersize;
    private String ptime;
    private String replyBoard;
    private String replyid;
    private String sectiontitle;
    private String title;
    private String topicDesc;
    private String topicImg;
    private String topicName;
    private String topicSid;
    private String vid;
    private VideoTopicBean videoTopic;
    private String videosource;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getM3u8_url() {
        return m3u8_url;
    }

    public void setM3u8_url(String m3u8_url) {
        this.m3u8_url = m3u8_url;
    }

    public String getMp4_url() {
        return mp4_url;
    }

    public void setMp4_url(String mp4_url) {
        this.mp4_url = mp4_url;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getPlayersize() {
        return playersize;
    }

    public void setPlayersize(int playersize) {
        this.playersize = playersize;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getReplyBoard() {
        return replyBoard;
    }

    public void setReplyBoard(String replyBoard) {
        this.replyBoard = replyBoard;
    }

    public String getReplyid() {
        return replyid;
    }

    public void setReplyid(String replyid) {
        this.replyid = replyid;
    }

    public String getSectiontitle() {
        return sectiontitle;
    }

    public void setSectiontitle(String sectiontitle) {
        this.sectiontitle = sectiontitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getTopicImg() {
        return topicImg;
    }

    public void setTopicImg(String topicImg) {
        this.topicImg = topicImg;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicSid() {
        return topicSid;
    }

    public void setTopicSid(String topicSid) {
        this.topicSid = topicSid;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public VideoTopicBean getVideoTopic() {
        return videoTopic;
    }

    public void setVideoTopic(VideoTopicBean videoTopic) {
        this.videoTopic = videoTopic;
    }

    public String getVideosource() {
        return videosource;
    }

    public void setVideosource(String videosource) {
        this.videosource = videosource;
    }

    public static class VideoTopicBean {
        /**
         * alias : 柯南改行娱乐侦探
         * ename : T1460515714560
         * tid : T1460515714560
         * tname : 八卦柯南君
         * topic_icons : http://img2.cache.netease.com/m/newsapp/topic_icons/T1460515714560.png
         */

        private String alias;
        private String ename;
        private String tid;
        private String tname;
        private String topic_icons;

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getTopic_icons() {
            return topic_icons;
        }

        public void setTopic_icons(String topic_icons) {
            this.topic_icons = topic_icons;
        }
    }
}
