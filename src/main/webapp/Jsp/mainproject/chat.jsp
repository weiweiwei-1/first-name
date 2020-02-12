<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聊天页面</title>
    <link rel="stylesheet" type="text/css" href="../../CSS/updatePassword.css">
<link rel="stylesheet" type="text/css" href="../../CSS/user.css">
<link rel="stylesheet" type="text/css" href="../../CSS/qq.css">
    <script type="text/javascript"  <%--rel="script"--%> src="../../Jquery-min/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" <%--rel="script"--%> src="../../Javascript/chat.js"></script>
    <script type="text/javascript" <%--rel="script"--%> src="../../Javascript/updateUser.js"></script>
</head>
<body>

<div class="qqBox">
	<div class="BoxHead">
		<div class="headImg">
            <c:if test="${user.photo !=null}">
                <img src="/web-store/${user.photo}">
            </c:if>
		</div>
		<div class="internetName">${user.username}</div>
        <div class="friend-message-icon">
            <div class="messageImg">
                <img src="../../Img/message.jpg">
            </div>
            <div class="friendImg">
                <img src="../../Img/friend.jpg">
            </div>
            <div class="addfriendImg">
                <img src="../../Img/addFriend.jpg">
            </div>
        </div>
	</div>
	<div class="context">
        <div class="friend-content">
            <div class="search-content">
                <input type="text" name="search-condition" class="search-condition">
                <button type="button" class="search-submit">搜索</button>
            </div>
            <div class="conLeft">
                <ul>
                    <c:forEach items="${allMessageList}" var="item">
                        <li id="${item.friendId}">
                            <div class="liLeft"><img src="/web-store/${item.friendPhoto}"></div>
                            <div class="liRight">
                                <span class="friendName">${item.friendMark}</span>
                                <span class="lastunreadMessage">${item.content}</span>
                            </div>
                            <div class="unreadMessage">
                                <div class="unreadMessage-count">${item.unReadMessageCount}</div>
                                <div class="unreadMessage-time"><fmt:formatDate value="${item.sendTime}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
                            </div>
                        </li>
                    </c:forEach>
                    <%--<li class="bg">
                        <div class="liLeft"><img src="../../Img/20170926103645_04.jpg"></div>
                        <div class="liRight">
                            <span class="friendName">前端交流群前端交流群前端交流群</span>
                            <span class="lastunreadMessage">厉害了hahahhahaha</span>
                        </div>
                        <div class="unreadMessage">
                            <div class="unreadMessage-count">88</div>
                            <div class="unreadMessage-time">12:34</div>
                        </div>
                    </li>


                    <li>
                        <div class="liLeft"><img src="../../Img/20170926103645_19.jpg"></div>
                        <div class="liRight">
                            <span  class="friendName">赵鹏</span>
                            <span class="lastunreadMessage">[流泪]</span>
                        </div>
                        <div class="unreadMessage">
                            <div class="unreadMessage-count">23</div>
                            <div class="unreadMessage-time">11:30</div>
                        </div>
                    </li>--%>
                    <%--<li>
                        <div class="liLeft"><img src="../../Img/20170926103645_25.jpg"></div>
                        <div class="liRight">
                            <span  class="intername">...</span>
                            <span class="infor">[么么哒]</span>
                        </div>
                    </li>
                    <li>
                        <div class="liLeft"><img src="../../Img/20170926103645_27.jpg"></div>
                        <div class="liRight">
                            <span  class="intername">前端交流群</span>
                            <span class="infor">前端小黑：怎么才能</span>
                        </div>
                    </li>
                    <li>
                        <div class="liLeft"><img src="../../Img/20170926103645_29.jpg"></div>
                        <div class="liRight">
                            <span  class="intername">前端交流群</span>
                            <span class="infor">大西瓜：差评，这个下面又</span>
                        </div>
                    </li>
                    <li>
                        <div class="liLeft"><img src="../../Img/20170926103645_54.jpg"></div>
                        <div class="liRight">
                            <span  class="intername">前端交流群</span>
                            <span class="infor">[流泪]</span>
                        </div>
                    </li>
                    <li>
                        <div class="liLeft"><img src="../../Img/20170926103645_04.jpg"></div>
                        <div class="liRight">
                            <span  class="intername">前端交流群</span>
                            <span class="infor">[流泪]</span>
                        </div>
                    </li>
                    <li>
                        <div class="liLeft"><img src="../../Img/20170926103645_19.jpg"></div>
                        <div class="liRight">
                            <span  class="intername">赵鹏</span>
                            <span class="infor">[流泪]</span>
                        </div>
                    </li>
                    <li>
                        <div class="liLeft"><img src="../../Img/20170926103645_27.jpg"></div>
                        <div class="liRight">
                            <span  class="intername">web交流群</span>
                            <span class="infor">[流泪]</span>
                        </div>
                    </li>
                    <li>
                        <div class="liLeft"><img src="../../Img/20170926103645_21.jpg"></div>
                        <div class="liRight">
                            <span  class="intername">jquery插件库</span>
                            <span class="infor">[流泪]</span>
                        </div>
                    </li>
                    <li>
                        <div class="liLeft"><img src="../../Img/20170926103645_23.jpg"></div>
                        <div class="liRight">
                            <span  class="intername">我的phone</span>
                            <span class="infor">[流泪]</span>
                        </div>
                    </li>
                    <li>
                        <div class="liLeft"><img src="../../Img/20170926103645_25.jpg"></div>
                        <div class="liRight">
                            <span  class="intername">...</span>
                            <span class="infor">[流泪]</span>
                        </div>
                    </li>
                    <li>
                        <div class="liLeft"><img src="../../Img/20170926103645_27.jpg"></div>
                        <div class="liRight">
                            <span  class="intername">前端交流群</span>
                            <span class="infor">[流泪]</span>
                        </div>
                    </li>--%>
                </ul>
            </div>
        </div>
		<div class="conRight">
			<div class="Righthead">
				<div class="headImg"><img src=""></div>
                <div class="headName"></div>
			</div>
			<div class="RightCont">
			</div>
			<div class="RightFoot">
				<div class="inputBox">
					<textarea id="dope"></textarea>
					<button class="sendBtn">发送(s)</button>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="userBox">
    <%--<div class="neighborBox"></div>--%>
    <div class="userCenter">
        <div class="user-head">
            <div class="img-block">
                <input type="file" name="file" accept="image/gif,image/jpeg,image/png,image/jpg" class="img-file">
                <P class="plus">+</P>
                <p class="tishi">点击上传图片</p>
                <img class="user-img" src="/web-store/${user.photo}">
            </div>
            <div class="img-edit">
                    <button id="preview" class="edit">预览</button>
                <button id="delete" class="edit">删除</button>
            </div>
        </div>
        <div class="user-information" >
            <table border="0" cellspacing="5" align="center">
                <tr>
                    <td>账号: <span id="user-email">${user.email}</span><%--<input type="text" name="email" class="email" readonly="readonly">--%></td>
                    <td>名字：<input type="text" name="username" class="edit-text" id='username' readonly="readonly" value="${user.username}"></td>
                </tr>
                <tr>
                    <td>公司：<input type="text" name="company" class="edit-text" id='company' readonly="readonly" value="${user.company}"></td>
                    <td>学校：<input type="text" name="school" class="edit-text" id='school' readonly="readonly" value="${user.school}"></td>
                </tr>
                <tr>
                    <td>年龄：<input type="text" name="age" class="edit-text" id='age' readonly="readonly" value="${user.age}"></td>
                    <td>性别：<input type="text" name="sex" class="edit-text" id='sex' readonly="readonly" value="${user.sex}"></td>
                </tr>
                <tr>
                    <td>职业：<input type="text" name="occupation" class="edit-text" id='occupation' readonly="readonly" value="${user.occupation}"></td>
                    <td>爱好：<input type="text" name="hobby" class="edit-text" id='hobby' readonly="readonly" value="${user.hobby}"></td>
                </tr>
                <tr>
                    <td class="introduction-head">个人介绍：</td>
                    <%--<input type="text" name="introduction" class="introduction">--%>
                    <td><textarea id="introduction-content" name="introduction-content" class="introduction-content" readonly="readonly">${user.introduction}</textarea></td>
                </tr>
                <tr>
                    <td><button id="logout">注销</button> <button id="updatePassword">修改密码</button></td>
                    <td><button id="edit">编辑</button> <button id="save">保存修改</button></td>
                    <%--<input type="file"></input>--%>
                </tr>
            </table>
            <%--<ul>
                <li>
                    <tr>
                        <td>账号:<input type="text" name="count" id="count" class="user-text"></td>
                        <td>用户名:<input type="text" name="username" id="username" class="user-text"></td>
                    </tr>
                </li>
                <li>
                    <tr>
                        <td>性别</td>
                        <td>年龄</td>
                    </tr>
                </li>
                <li>
                    <tr>
                        <td>单位</td>
                        <td>学校</td>
                    </tr>
                </li>
                <li>
                    <tr>
                        <td>职业</td>
                        <td>爱好</td>
                    </tr>
                </li>
                <li>
                    <tr>
                        <td>保存 编辑</td>
                        <td>修改密码 退出登录</td>
                    </tr>
                </li>
            </ul>--%>
        </div>
    </div>
</div>
<div class="img-Box">
    <img src="../../Img/me.jpg" alt="图片" class="preview-img">
</div>

<div class="update-password">
    <div class="update-content">
        <div class="close-block"><span>&times;</span></div>
        <div class="updatepassword-block">
            <input type="text" id="origin-password" class="password-input" placeholder="原密码"><span class="error-confirm">原密码错误</span>
        </div>
        <div class="updatepassword-block"><input type="text" id="new-password" class="password-input" placeholder="新密码"><span span class="error-confirm">新的密码错误</span></div>
        <div class="updatepassword-block"><input type="text" id="sure-password" class="password-input" placeholder="确认新的密码"><span span class="error-confirm">前后密码对不上</span></div>
        <div class="updatepassword-block"><button type="button" id="confirm-updatepassword">确认修改</button></div>
    </div>
</div>
<%--<div style="text-align:center;margin:10px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>--%>
</body>
</html>
