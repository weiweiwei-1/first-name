package Informal.mybatis.Model.enty;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("unReadMessageList")
public class UnReadMessageList {
    private int id;
    private int unReadMessageCount;
    private int friendId;
    private int receiverId;
    private String friendPhoto;
    private String friendMark;
    private String content;
    private Date sendTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnReadMessageCount() {
        return unReadMessageCount;
    }

    public void setUnReadMessageCount(int unReadMessageCount) {
        this.unReadMessageCount = unReadMessageCount;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getFriendMark() {
        return friendMark;
    }

    public void setFriendMark(String friendMark) {
        this.friendMark = friendMark;
    }

    public String getFriendPhoto() {
        return friendPhoto;
    }

    public void setFriendPhoto(String friendPhoto) {
        this.friendPhoto = friendPhoto;
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
        return "UnReadMessageList{" +
                "id=" + id +
                ", unReadMessageCount=" + unReadMessageCount +
                ", friendId=" + friendId +
                ", receiverId=" + receiverId +
                ", friendPhoto='" + friendPhoto + '\'' +
                ", friendMark='" + friendMark + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
