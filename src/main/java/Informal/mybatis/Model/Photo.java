package Informal.mybatis.Model;

public class Photo {
    private Integer id;
    private Integer memoryId;
    private String photoUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemoryId() {
        return memoryId;
    }

    public void setMemoryId(Integer memoryId) {
        this.memoryId = memoryId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", memoryId=" + memoryId +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
