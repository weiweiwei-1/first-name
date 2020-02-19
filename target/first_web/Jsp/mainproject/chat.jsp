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
    <link rel="stylesheet" type="text/css" href="../../CSS/recommend.css">
    <link rel="stylesheet" type="text/css" href="../../CSS/addUser.css">
    <link rel="stylesheet" type="text/css" href="../../CSS/permitUser.css">
    <script type="text/javascript"  rel="script" src="../../Jquery-min/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" rel="script" src="../../Javascript/chat.js"></script>
    <script type="text/javascript" rel="script" src="../../Javascript/updateUser.js"></script>
    <script type="text/javascript" rel="script" src="../../Javascript/friendList.js"></script>
    <script type="text/javascript" rel="script" src="../../Javascript/chatList.js"></script>
    <script type="text/javascript" rel="script" src="../../Javascript/userRecomend.js"></script>
    <script type="text/javascript" rel="script" src="../../Javascript/addUserList.js"></script>
    <%--<script type="text/javascript" rel="script" src="../../Javascript/updatePassword.js"></script>--%>
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
                    <%--<li>
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

<div class="recomendBox">
    <div class="recomend-condition">
        <input type="text" class="recomend-text" placeholder="查找好友">
        <button class="recomend-search">搜索</button>
    </div>
    <div class="promot"></div>
    <div class="overflow-hide">
        <div class="recomendContent">
            <span class="system-confirm">${systemConfirm}</span>
            <%--<div class="user-block" data-userId="12">
                <div class="user-img">
                    <img class="appear" src="">
                </div>
                <div class="user-name"></div>
                <div class="user-school"></div>
                <div class="user-company"></div>
            </div>

            <div class="user-block" data-userId="16">
                <div class="user-img">
                    <img class="appear" src="../../Img/me.jpg">
                </div>
                <div class="user-name">曾庆威</div>
                <div class="user-school">合肥工业大学</div>
                <div class="user-company">中兴通讯</div>
            </div>--%>
        </div>
    </div>
    <div class="refresh"><span>系统推荐/换一批</span></div>
</div>

<div class="unKnownUser">
    <div class="flex-center">
        <div class="unKnownUser-Box">
            <div class="unKnowUser-img">
                <img class="unKnownUserImg">
            </div>
            <div class="unKnowUser-name"></div>
            <div class="add-name">我是：<input type="text" id="addName"></div>
            <div class="add-button"><button class="add">发送申请</button></div>
        </div>
    </div>
</div>

<div class="permitUser">
    <div class="flex-permitUser">
        <div class="permitUser-Box">
            <div class="permitUser-img">
                <img class="permitUserImg">
            </div>
            <div class="permitUser-name"></div>
            <div class="permitUser-school"></div>
            <div class="permitUser-company"></div>
            <div class=""></div>
        </div>
    </div>
</div>

<div class="userBox">
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
                </tr>
            </table>

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
            <input type="password" id="origin-password" class="password-input" placeholder="原密码"><span class="error-confirm"></span>
        </div>
        <div class="updatepassword-block"><input type="password" id="new-password" class="password-input" placeholder="新密码"><span span class="error-confirm"></span></div>
        <div class="updatepassword-block"><input type="password" id="sure-password" class="password-input" placeholder="确认新的密码"><span span class="error-confirm"></span></div>
        <div class="updatepassword-block"><button type="button" id="confirm-updatepassword" disabled="disabled">确认修改</button></div>
    </div>
</div>

</body>
</html>
