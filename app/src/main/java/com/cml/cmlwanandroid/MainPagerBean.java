package com.cml.cmlwanandroid;

import java.util.List;

/**
 * Created by chenmingliang on 2018/4/28.
 */

public class MainPagerBean {

    /**
     * a_branch
     */


    public DataBean data;
    public int errorCode;
    public String errorMsg;

    public static class DataBean {

        public int curPage;
        public int offset;
        public boolean over;
        public int pageCount;
        public int size;
        public int total;
        public List<DatasBean> datas;

        public static class DatasBean {

            public String apkLink;
            public String author;
            public int chapterId;
            public String chapterName;
            public boolean collect;
            public int courseId;
            public String desc;
            public String envelopePic;
            public boolean fresh;
            public int id;
            public String link;
            public String niceDate;
            public String origin;
            public String projectLink;
            public long publishTime;
            public int superChapterId;
            public String superChapterName;
            public String title;
            public int type;
            public int visible;
            public int zan;
            public List<TagsBean> tags;

            public static class TagsBean {

                public String name;
                public String url;
            }
        }
    }
}
