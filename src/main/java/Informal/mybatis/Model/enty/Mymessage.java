package Informal.mybatis.Model.enty;

public class Mymessage {
    private String receiver;
    private String message;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Mymessage{" +
                "receiver='" + receiver + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
