package com.example.lixiang.rxjavatest.data;

import java.util.List;

/**
 * Created by lixiang on 2016/11/12.
 */

public class JokeItemData {

    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"content":"一妹纸十一放假去外地玩，当地有一个男生同学可以照应照应！但是当天晚上该同学却以遗憾的口气告诉她寝室关门了，无奈之下两人只好去住宾馆，一路之上都在纠结...然后当宾馆的房门打开之时，妹纸以迅雷不及掩耳之势冲进卫生间\u2026\u2026把妆给卸了\u2026\u2026结果那一晚两人的贞操都得以保存\u2026","hashId":"c313f837ed554d593ccf6ea633749663","unixtime":1478919230,"updatetime":"2016-11-12 10:53:50"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    @Override
    public String toString() {
        return "JokeItemData{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "data=" + data +
                    '}';
        }

        public static class DataBean {
            /**
             * content : 一妹纸十一放假去外地玩，当地有一个男生同学可以照应照应！但是当天晚上该同学却以遗憾的口气告诉她寝室关门了，无奈之下两人只好去住宾馆，一路之上都在纠结...然后当宾馆的房门打开之时，妹纸以迅雷不及掩耳之势冲进卫生间……把妆给卸了……结果那一晚两人的贞操都得以保存…
             * hashId : c313f837ed554d593ccf6ea633749663
             * unixtime : 1478919230
             * updatetime : 2016-11-12 10:53:50
             */

            private String content;
            private String hashId;
            private int unixtime;
            private String updatetime;

            @Override
            public String toString() {
                return "DataBean{" +
                        "content='" + content + '\'' +
                        ", hashId='" + hashId + '\'' +
                        ", unixtime=" + unixtime +
                        ", updatetime='" + updatetime + '\'' +
                        '}';
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public int getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(int unixtime) {
                this.unixtime = unixtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }
        }
    }
}
