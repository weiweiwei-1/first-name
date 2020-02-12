package Informal.mybatis.Model.enty;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("readAndUnReadMessageList")
public class ReadAndUnReadMessageList {
    private Integer id;
    private Integer friendId;
    private String friendPhoto;
    private String friendMark;
    private Integer unReadMessageCount;
    private String content;
    private Date sendTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getFriendPhoto() {
        return friendPhoto;
    }

    public void setFriendPhoto(String friendPhoto) {
        this.friendPhoto = friendPhoto;
    }

    public String getFriendMark() {
        return friendMark;
    }

    public void setFriendMark(String friendMark) {
        this.friendMark = friendMark;
    }

    public Integer getUnReadMessageCount() {
        return unReadMessageCount;
    }

    public void setUnReadMessageCount(Integer unReadMessageCount) {
        this.unReadMessageCount = unReadMessageCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "ReadAndUnReadMessageList{" +
                "id=" + id +
                ", friendId=" + friendId +
                ", friendPhoto='" + friendPhoto + '\'' +
                ", friendMark='" + friendMark + '\'' +
                ", unReadMessageCount='" + unReadMessageCount + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
