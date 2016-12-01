package com.sven.rx.model;

import java.util.List;

/**
 * Created by Sven on 2016/12/1.
 */

public class Bean {


    /**
     * error : false
     * results : [{"_id":"583ba766421aa9710ec9340b","createdAt":"2016-11-28T11:41:26.668Z","desc":"滚动时图片产生视差效果的ImageView","images":["http://img.gank.io/5ff18d45-6bd9-4858-9a99-e8ed00a82ec7"],"publishedAt":"2016-12-01T11:36:13.685Z","source":"web","type":"Android","url":"https://github.com/gjiazhe/ScrollParallaxImageView","used":true,"who":"郭佳哲"},{"_id":"583c4e52421aa971108b6598","createdAt":"2016-11-28T23:33:38.6Z","desc":"在Android图形处理-Canvas已经有了基本的使用，但是这节介绍几个好玩的属性","images":["http://img.gank.io/4ad4a5a7-7c57-4a31-bf10-eaab88ba6391"],"publishedAt":"2016-12-01T11:36:13.685Z","source":"web","type":"Android","url":"http://www.haotianyi.win/2016/11/android%E5%9B%BE%E5%BD%A2%E5%A4%84%E7%90%86-%E7%99%BE%E5%8F%98paint.html","used":true,"who":"HaoTianYi"},{"_id":"583f700f421aa939befafae7","createdAt":"2016-12-01T08:34:23.85Z","desc":"简单实用的页面多状态布局(content,loading,empty,error)","images":["http://img.gank.io/2074ca5d-578d-455d-8a96-9ec92869421d","http://img.gank.io/229ccb07-603c-4451-9807-d2672b2f1671"],"publishedAt":"2016-12-01T11:36:13.685Z","source":"web","type":"Android","url":"https://github.com/czy1121/loadinglayout","used":true,"who":"ezy"},{"_id":"583f7f75421aa939b58d31be","createdAt":"2016-12-01T09:40:05.296Z","desc":"一开始，我只是想用它来显示Github贡献图，所以才给它起名字叫TContributionsView，后来，我发现它似乎还有很多更有意思的玩法\u2026\u2026","images":["http://img.gank.io/4267408e-82c7-4b5e-a8c6-dc0c3cc787a0","http://img.gank.io/0bab9df3-ae49-4029-be63-ebdb2d9e6d65"],"publishedAt":"2016-12-01T11:36:13.685Z","source":"web","type":"Android","url":"https://github.com/barryhappy/TContributionsView","used":true,"who":"Barry"},{"_id":"583f8ff8421aa939b835360c","createdAt":"2016-12-01T10:50:32.704Z","desc":"360黑科技，未经用户同意自动开启辅助功能","publishedAt":"2016-12-01T11:36:13.685Z","source":"chrome","type":"Android","url":"http://www.freebuf.com/articles/terminal/121253.html","used":true,"who":"Dear宅学长"},{"_id":"583d096f421aa939b58d31a8","createdAt":"2016-11-29T12:51:59.0Z","desc":"仿斗鱼滑动验证码","images":["http://img.gank.io/0ddd7a74-7416-4d62-a651-78bff58c353f"],"publishedAt":"2016-11-30T11:35:55.916Z","source":"web","type":"Android","url":"https://github.com/mcxtzhang/SwipeCaptcha","used":true,"who":"张旭童"},{"_id":"583d5684421aa939b58d31ab","createdAt":"2016-11-29T18:20:52.350Z","desc":"数字增加动画的 TextView","images":["http://img.gank.io/c8bb7c7e-00c0-4047-9a3c-43641195acd2"],"publishedAt":"2016-11-30T11:35:55.916Z","source":"web","type":"Android","url":"https://github.com/Bakumon/NumberAnimTextView","used":true,"who":"马飞"},{"_id":"583d77e0421aa939b83535fe","createdAt":"2016-11-29T20:43:12.862Z","desc":"在策略模式（Strategy Pattern）中定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。这种类型的设计模式属于行为型模式。","publishedAt":"2016-11-30T11:35:55.916Z","source":"web","type":"Android","url":"http://www.haotianyi.win/2016/11/java%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%E4%B9%8B%E7%AD%96%E7%95%A5%E6%A8%A1%E5%BC%8F.html","used":true,"who":"HaoTianYi"},{"_id":"583e180c421aa939bb4637ca","createdAt":"2016-11-30T08:06:36.653Z","desc":"支持多个方向滑动的 View，类似 Calendar 里的 UI 效果","images":["http://img.gank.io/ea35e7ac-0d12-474b-b038-ff86d0b0dad3"],"publishedAt":"2016-11-30T11:35:55.916Z","source":"chrome","type":"Android","url":"https://github.com/Kelin-Hong/ScrollablePanel","used":true,"who":"嗲马甲"},{"_id":"583e1830421aa939befafad3","createdAt":"2016-11-30T08:07:12.645Z","desc":"Adblock Webview，支持自动屏蔽广告。","images":["http://img.gank.io/486a8cdd-fb4e-4240-8f4a-ef1147c3b032"],"publishedAt":"2016-11-30T11:35:55.916Z","source":"chrome","type":"Android","url":"https://github.com/AmniX/AdBlockedWebView-Android","used":true,"who":"代码家"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 583ba766421aa9710ec9340b
         * createdAt : 2016-11-28T11:41:26.668Z
         * desc : 滚动时图片产生视差效果的ImageView
         * images : ["http://img.gank.io/5ff18d45-6bd9-4858-9a99-e8ed00a82ec7"]
         * publishedAt : 2016-12-01T11:36:13.685Z
         * source : web
         * type : Android
         * url : https://github.com/gjiazhe/ScrollParallaxImageView
         * used : true
         * who : 郭佳哲
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "_id='" + _id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    ", images=" + images +
                    '}';
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
