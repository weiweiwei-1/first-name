package Informal.mybatis.Model;

import java.util.Date;

public class Message {
    private Integer id;
    private Integer senderId;
    private Integer receiverId;
    private String content;
    private String sendTime;
    private String status;
    private String messageType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Message(){

    }

    public Message(int senderId,int receiverId,String content,String status){
        this.senderId=senderId;
        this.receiverId=receiverId;
        this.content=content;
        this.status=status;
    }

    public Message(int senderId,int receiverId){
        this.senderId=senderId;
        this.receiverId=receiverId;
    }

    public Message(int senderId,int receiverId,String content){
        this.senderId=senderId;
        this.receiverId=receiverId;
        this.content=content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                ", status='" + status + '\'' +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
