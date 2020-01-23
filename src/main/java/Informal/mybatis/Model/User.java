package Informal.mybatis.Model;

//import Informal.mybatis.Validator.isInteger;
import Informal.mybatis.validatorgroups.AddValidator;
import Informal.mybatis.validatorgroups.updateValidator;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
//整数类型不能用size,用max或者min
//字符串类型不能用max或者min，要用size
public class User implements Serializable{
    @NotNull(message="{user.notnull}",groups={AddValidator.class})
//    @Size(min=1,max=1000,message="{user.id.error}",groups={AddValidator.class})
    @Min(value=1,groups={AddValidator.class},message="{user.id.error}")
    @Max(value=1000,groups={AddValidator.class})
//    @isInteger(message="整数长度必须是字符类型",groups={updateValidator.class})
//    @Digits("")
    private Integer id;
//    @NotNull(message="{user.name.error}",groups = {AddValidator.class})
    @NotEmpty(message="不能为夸空",groups={AddValidator.class})
    @Size(min=1,max=20,message="用户名长度必须介于{min}到{max}之间",groups={AddValidator.class})
    private String username;

    @Past(message="{user.birthday.validate}",groups={AddValidator.class})
    @DateTimeFormat(pattern="yyyy-mm-dd")
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date birthday;

//  @Pattern(regexp = "男",regexp="女",message="格式必须为男或者女")
    @Size(min=1,max=1,message="必须是一个字符，否则不成立",groups={AddValidator.class})
    private String sex;

    @Size(min=1,max = 50,message = "长度必须小于50个字符大于1字符",groups={AddValidator.class})
    private String email;

    private String address;

    private String password;

    private Integer age;

    private String photo;

    private String telephone;

    private String occupation;

    private String school;

    private String company;

    private String hobby;

    private String introduction;

    private Orders orders;

    /*设置无参构造方法，new一个对象时，可以选择传入属性参数，
    也可以直接new一个无参对象,为了下面批量插入数据时不产生冲突*/
    public User() {
    }

    public User(Integer id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", photo='" + photo + '\'' +
                ", telephone='" + telephone + '\'' +
                ", occupation='" + occupation + '\'' +
                ", school='" + school + '\'' +
                ", company='" + company + '\'' +
                ", hobby='" + hobby + '\'' +
                ", introduction='" + introduction + '\'' +
                ", orders=" + orders +
                '}';
    }
}
