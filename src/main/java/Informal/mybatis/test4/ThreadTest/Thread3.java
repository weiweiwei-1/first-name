package Informal.mybatis.test4.ThreadTest;

public class Thread3 {
    private int url;

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }
    public Thread3(int url){
        this.url=url;
    }
    public void decrease(){
        url--;
        System.out.println(url);

    }
}
