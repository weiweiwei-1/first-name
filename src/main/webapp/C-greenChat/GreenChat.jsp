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

    <!-- Favicon -->
    <link rel="icon" href="./dist/media/img/favicon.png" type="image/png">

    <!-- Bundle Styles -->
    <link rel="stylesheet" href="./vendor/bundle.css">

    <!-- App styles -->
    <link rel="stylesheet" href="./dist/css/app.min.css">
</head>
<body>

<!-- Page loading -->
<div class="page-loading"></div>
<!-- ./ Page loading -->

<!-- Body plate -->
<div class="body-plate"></div>
<!-- ./ Body plate -->

<!-- Disconnected modal -->
<div class="modal fade" id="disconnected" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered modal-dialog-zoom" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="row mb-5">
                    <div class="col-md-6 offset-md-3">
                        <img src="./dist/media/svg/undraw_warning_cyit.svg" class="img-fluid" alt="image">
                    </div>
                </div>
                <p class="lead text-center">Application disconnected</p>
            </div>
            <div class="modal-footer justify-content-center">
                <button type="button" class="btn btn-success btn-lg">Reconnect</button>
                <a href="login.html" class="btn btn-link">Logout</a>
            </div>
        </div>
    </div>
</div>
<!-- ./ Disconnected modal -->

<!-- Voice call modal -->
<div class="modal call fade" id="call" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-zoom" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="call">
                    <div>
                        <figure class="mb-4 avatar avatar-xl">
                            <img src="./dist/media/img/avatar7.png" class="rounded-circle" alt="image">
                        </figure>
                        <h4>Brietta Blogg <span class="text-success">calling...</span></h4>
                        <div class="action-button">
                            <button type="button" class="btn btn-danger btn-floating btn-lg" data-dismiss="modal">
                                <i data-feather="x"></i>
                            </button>
                            <button type="button" class="btn btn-success btn-pulse btn-floating btn-lg">
                                <i data-feather="phone"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ./ Voice call modal -->

<!-- voice call modal -->
<div class="modal call fade" id="videoCall" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-zoom" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="call">
                    <div>
                        <figure class="mb-4 avatar avatar-xl">
                            <img src="./dist/media/img/avatar4.png" class="rounded-circle" alt="image">
                        </figure>
                        <h4>Brietta Blogg <span class="text-success">video calling...</span></h4>
                        <div class="action-button">
                            <button type="button" class="btn btn-danger btn-floating btn-lg" data-dismiss="modal">
                                <i data-feather="x"></i>
                            </button>
                            <button type="button" class="btn btn-success btn-pulse btn-floating btn-lg">
                                <i data-feather="video"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ./ voice call modal -->

<!-- Add friends modal -->
<div class="modal fade" id="addFriends" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-zoom" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <i data-feather="user-plus" class="mr-2"></i> Add Friends
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <i class="ti-close"></i>
                </button>
            </div>
            <div class="modal-body">
                <div class="alert alert-info">Send invitations to friends.</div>
                <form>
                    <div class="form-group">
                        <label for="emails" class="col-form-label">Email addresses</label>
                        <input type="text" class="form-control" id="emails">
                    </div>
                    <div class="form-group">
                        <label for="message" class="col-form-label">Invitation message</label>
                        <textarea class="form-control" id="message"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </div>
</div>
<!-- ./ Add friends modal -->

<!-- New group modal -->
<div class="modal fade" id="newGroup" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-zoom" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <i data-feather="users" class="mr-2"></i> New Group
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <i class="ti-close"></i>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="group_name" class="col-form-label">Group name</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="group_name">
                            <div class="input-group-append">
                                <button class="btn btn-light" data-toggle="tooltip" title="Emoji" type="button">
                                    <i data-feather="smile"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                    <p class="mb-2">The group members</p>
                    <div class="form-group">
                        <div class="avatar-group">
                            <figure class="avatar" data-toggle="tooltip" title="Tobit Spraging">
                                <span class="avatar-title bg-success rounded-circle">T</span>
                            </figure>
                            <figure class="avatar" data-toggle="tooltip" title="Cloe Jeayes">
                                <img src="./dist/media/img/avatar6.png" class="rounded-circle" alt="image">
                            </figure>
                            <figure class="avatar" data-toggle="tooltip" title="Marlee Perazzo">
                                <span class="avatar-title bg-warning rounded-circle">M</span>
                            </figure>
                            <figure class="avatar" data-toggle="tooltip" title="Stafford Pioch">
                                <img src="./dist/media/img/avatar2.png" class="rounded-circle" alt="image">
                            </figure>
                            <figure class="avatar" data-toggle="tooltip" title="Bethena Langsdon">
                                <span class="avatar-title bg-info rounded-circle">B</span>
                            </figure>
                            <a href="#" title="Add friends">
                                <figure class="avatar">
                                    <span class="avatar-title bg-primary rounded-circle">
                                        <i data-feather="plus"></i>
                                    </span>
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="description" class="col-form-label">Description</label>
                        <textarea class="form-control" id="description"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Create Group</button>
            </div>
        </div>
    </div>
</div>
<!-- ./ New group modal -->

<!-- Setting modal -->
<div class="modal fade" id="settingModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-zoom" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <i data-feather="settings" class="mr-2"></i> Settings
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <i class="ti-close"></i>
                </button>
            </div>
            <div class="modal-body">
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                        <a href="https://www.51qianduan.com/">51前端</a>
                    </li>
                    <li class="nav-item">
                        <a href="https://www.51qianduan.com/">51前端</a>
                    </li>
                    <li class="nav-item">
                        <a href="https://www.51qianduan.com/">51前端</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane show active" id="account" role="tabpanel">
                        <div class="form-item custom-control custom-switch">
                            <input type="checkbox" class="custom-control-input" checked id="customSwitch1">
                            <label class="custom-control-label" for="customSwitch1">Allow connected contacts</label>
                        </div>
                        <div class="form-item custom-control custom-switch">
                            <input type="checkbox" class="custom-control-input" checked id="customSwitch2">
                            <label class="custom-control-label" for="customSwitch2">Confirm message requests</label>
                        </div>
                        <div class="form-item custom-control custom-switch">
                            <input type="checkbox" class="custom-control-input" checked id="customSwitch3">
                            <label class="custom-control-label" for="customSwitch3">Profile privacy</label>
                        </div>
                        <div class="form-item custom-control custom-switch">
                            <input type="checkbox" class="custom-control-input" id="customSwitch4">
                            <label class="custom-control-label" for="customSwitch4">Developer mode options</label>
                        </div>
                        <div class="form-item custom-control custom-switch">
                            <input type="checkbox" class="custom-control-input" checked id="customSwitch5">
                            <label class="custom-control-label" for="customSwitch5">Two-step security
                                verification</label>
                        </div>
                    </div>
                    <div class="tab-pane" id="notification" role="tabpanel">
                        <div class="form-item custom-control custom-switch">
                            <input type="checkbox" class="custom-control-input" checked id="customSwitch6">
                            <label class="custom-control-label" for="customSwitch6">Allow mobile notifications</label>
                        </div>
                        <div class="form-item custom-control custom-switch">
                            <input type="checkbox" class="custom-control-input" id="customSwitch7">
                            <label class="custom-control-label" for="customSwitch7">Notifications from your
                                friends</label>
                        </div>
                        <div class="form-item custom-control custom-switch">
                            <input type="checkbox" class="custom-control-input" id="customSwitch8">
                            <label class="custom-control-label" for="customSwitch8">Send notifications by email</label>
                        </div>
                    </div>
                    <div class="tab-pane" id="contact" role="tabpanel">
                        <div class="form-item custom-control custom-switch">
                            <input type="checkbox" class="custom-control-input" id="customSwitch9">
                            <label class="custom-control-label" for="customSwitch9">Suggest changing passwords every
                                month.</label>
                        </div>
                        <div class="form-item custom-control custom-switch">
                            <input type="checkbox" class="custom-control-input" checked id="customSwitch10">
                            <label class="custom-control-label" for="customSwitch10">Let me know about suspicious
                                entries to your account</label>
                        </div>
                        <div class="form-item">
                            <p>
                                <a href="https://www.51qianduan.com/">51前端</a>
                            </p>
                            <div class="collapse" id="collapseExample">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Question 1">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Answer 1">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Question 2">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Answer 2">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Save</button>
            </div>
        </div>
    </div>
</div>
<!-- ./ Setting modal -->

<!-- Edit profile modal -->
<div class="modal fade" id="editProfileModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-zoom" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <i data-feather="edit-2" class="mr-2"></i> Edit Profile
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <i class="ti-close"></i>
                </button>
            </div>
            <div class="modal-body">
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                        <a href="https://www.51qianduan.com/">51前端</a>
                    </li>
                    <li class="nav-item">
                        <a href="https://www.51qianduan.com/">51前端</a>
                    </li>
                    <li class="nav-item">
                        <a href="https://www.51qianduan.com/">51前端</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane show active" id="personal" role="tabpanel">
                        <form>
                            <div class="form-group">
                                <label for="fullname" class="col-form-label">Fullname</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="fullname">
                                    <div class="input-group-append">
                                        <span class="input-group-text">
                                            <i data-feather="user"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-form-label">Avatar</label>
                                <div class="d-flex align-items-center">
                                    <div>
                                        <figure class="avatar mr-3 item-rtl">
                                            <img src="./dist/media/img/avatar8.png" class="rounded-circle"
                                                 alt="image">
                                        </figure>
                                    </div>
                                    <div class="custom-file">
                                        <input type="file" class="custom-file-input" id="customFile">
                                        <label class="custom-file-label" for="customFile">Choose file</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="city" class="col-form-label">City</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="city" placeholder="Ex: Columbia">
                                    <div class="input-group-append">
                                        <span class="input-group-text">
                                            <i data-feather="target"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="phone" class="col-form-label">Phone</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="phone" placeholder="(555) 555 55 55">
                                    <div class="input-group-append">
                                        <span class="input-group-text">
                                            <i data-feather="phone"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="website" class="col-form-label">Website</label>
                                <input type="text" class="form-control" id="website" placeholder="https://">
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane" id="about" role="tabpanel">
                        <form>
                            <div class="form-group">
                                <label for="about-text" class="col-form-label">Write a few words that describe
                                    you</label>
                                <textarea class="form-control" id="about-text"></textarea>
                            </div>
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" checked id="customCheck1">
                                <label class="custom-control-label" for="customCheck1">View profile</label>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane" id="social-links" role="tabpanel">
                        <form>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Username">
                                    <div class="input-group-append">
                                        <span class="input-group-text bg-facebook">
                                            <i class="ti-facebook"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Username">
                                    <div class="input-group-append">
                                        <span class="input-group-text bg-twitter">
                                            <i class="ti-twitter"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Username">
                                    <div class="input-group-append">
                                        <span class="input-group-text bg-instagram">
                                            <i class="ti-instagram"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Username">
                                    <div class="input-group-append">
                                        <span class="input-group-text bg-linkedin">
                                            <i class="ti-linkedin"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Username">
                                    <div class="input-group-append">
                                        <span class="input-group-text bg-dribbble">
                                            <i class="ti-dribbble"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Username">
                                    <div class="input-group-append">
                                        <span class="input-group-text bg-youtube">
                                            <i class="ti-youtube"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Username">
                                    <div class="input-group-append">
                                        <span class="input-group-text bg-google">
                                            <i class="ti-google"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Username">
                                    <div class="input-group-append">
                                        <span class="input-group-text bg-whatsapp">
                                            <i class="fa fa-whatsapp"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Save</button>
            </div>
        </div>
    </div>
</div>
<!-- ./ Edit profile modal -->

<!-- Header -->
<header class="main-header">
    <div id="logo">
        <a href="#">
            <img src="dist/media/img/logo.png" alt="logo">
        </a>
    </div>
    <div class="header-nav">
        <ul class="nav">
            <li><a href="#" data-navigation-target="contact-information">Profile</a></li>
            <li><a href="#" data-navigation-target="friends">Friends</a></li>
            <li><a href="#" data-navigation-target="favorites">Favorites</a></li>
            <li><a href="#" data-navigation-target="archived">Archived</a></li>
        </ul>
    </div>
    <div class="header-right">
        <div class="navbar-toggler">
            <a href="#">
                <i data-feather="menu"></i>
            </a>
        </div>
        <div class="dropdown">
            <a href="#" data-toggle="dropdown">
                <span class="mr-2 d-none d-sm-inline-block">Mirabelle Tow</span>
                <figure class="avatar">
                    <img src="./dist/media/img/avatar3.png" class="rounded-circle" alt="image">
                </figure>
            </a>
            <div class="dropdown-menu dropdown-menu-right">
                <a href="#" class="dropdown-item" data-navigation-target="contact-information">Profile</a>
                <a href="#" class="dropdown-item" data-toggle="modal" data-target="#settingModal">Settings</a>
                <div class="dropdown-divider"></div>
                <a href="login.html" class="dropdown-item text-danger">Logout</a>
            </div>
        </div>
    </div>
</header>
<!-- ./ Header -->

<!-- Layout -->
<div class="layout">

    <!-- Content -->
    <div class="content">

        <!-- Chats sidebar -->
        <div id="chats" class="sidebar chat-list active">
            <header>
                <span>Chats</span>
            </header>
            <form>
                <input type="text" class="form-control" placeholder="Search">
            </form>
            <div class="sidebar-body">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <figure class="avatar avatar-state-success">
                            <img src="./dist/media/img/avatar1.png" class="rounded-circle" alt="image">
                        </figure>
                        <div class="users-list-body">
                            <div>
                                <h5 class="text-primary">Townsend Seary</h5>
                                <p>What's up, how are you?</p>
                            </div>
                            <div class="users-list-action">
                                <div class="new-message-count">3</div>
                                <small class="text-primary">03:41 PM</small>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <figure class="avatar avatar-state-warning">
                            <img src="./dist/media/img/avatar2.png" class="rounded-circle" alt="image">
                        </figure>
                        <div class="users-list-body">
                            <div>
                                <h5 class="text-primary">Forest Kroch</h5>
                                <p>
                                    <i class="fa fa-camera mr-1"></i> Photo
                                </p>
                            </div>
                            <div class="users-list-action">
                                <div class="new-message-count">1</div>
                                <small class="text-primary">Yesterday</small>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item active-chat">
                        <div>
                            <figure class="avatar">
                                <img src="./dist/media/img/avatar3.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Byrom Guittet</h5>
                                <p>I sent you all the files. Good luck with 😃</p>
                            </div>
                            <div class="users-list-action">
                                <small class="text-muted">11:05 AM</small>
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <a href="#" class="dropdown-item">Add to archive</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar">
                                <img src="./dist/media/img/avatar4.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Margaretta Worvell</h5>
                                <p>I need you today. Can you come with me?</p>
                            </div>
                            <div class="users-list-action">
                                <small class="text-muted">03:41 PM</small>
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <a href="#" class="dropdown-item">Add to archive</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <figure class="avatar">
                                <span class="avatar-title bg-warning bg-success rounded-circle">
                                    <i class="fa fa-users"></i>
                                </span>
                        </figure>
                        <div class="users-list-body">
                            <div>
                                <h5>😍 My Family 😍</h5>
                                <p><strong>Maher Ruslandi: </strong>Hello!!!</p>
                            </div>
                            <div class="users-list-action">
                                <small class="text-muted">Yesterday</small>
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <a href="#" class="dropdown-item">Add to archive</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar avatar-state-warning">
                                <img src="./dist/media/img/avatar5.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Jennica Kindred</h5>
                                <p>
                                    <i class="fa fa-video-camera mr-1"></i>
                                    Video
                                </p>
                            </div>
                            <div class="users-list-action">
                                <small class="text-muted">03:41 PM</small>
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <a href="#" class="dropdown-item">Add to archive</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar">
                                <span class="avatar-title bg-info rounded-circle">M</span>
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Marvin Rohan</h5>
                                <p>Have you prepared the files?</p>
                            </div>
                            <div class="users-list-action">
                                <small class="text-muted">Yesterday</small>
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <a href="#" class="dropdown-item">Add to archive</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar">
                                <img src="./dist/media/img/avatar5.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Townsend Seary</h5>
                                <p>Where are you?</p>
                            </div>
                            <div class="users-list-action">
                                <small class="text-muted">03:41 PM</small>
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <a href="#" class="dropdown-item">Add to archive</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar">
                                <span class="avatar-title bg-secondary rounded-circle">G</span>
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Gibb Ivanchin</h5>
                                <p>I want to visit them.</p>
                            </div>
                            <div class="users-list-action">
                                <small class="text-muted">03:41 PM</small>
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <a href="#" class="dropdown-item">Add to archive</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar">
                                <img src="./dist/media/img/avatar7.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Harald Kowalski</h5>
                                <p>Reports are ready.</p>
                            </div>
                            <div class="users-list-action">
                                <small class="text-muted">03:41 PM</small>
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <a href="#" class="dropdown-item">Add to archive</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar">
                                <span class="avatar-title bg-success rounded-circle">A</span>
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Afton McGilvra</h5>
                                <p>I do not know where is it. Don't ask me, please.</p>
                            </div>
                            <div class="users-list-action">
                                <small class="text-muted">03:41 PM</small>
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <a href="#" class="dropdown-item">Add to archive</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar">
                                <img src="./dist/media/img/avatar8.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Alexandr Donnelly</h5>
                                <p>Can anyone enter the meeting?</p>
                            </div>
                            <div class="users-list-action">
                                <small class="text-muted">03:41 PM</small>
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <a href="#" class="dropdown-item">Add to archive</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="p-3">
                <button data-navigation-target="new-chat" class="btn btn-primary btn-block btn-lg">New Chat</button>
            </div>
        </div>
        <!-- ./ Chats sidebar -->

        <!-- Friends sidebar -->
        <div id="friends" class="sidebar">
            <header>
                <span>Friends</span>
                <ul class="list-inline">
                    <li class="list-inline-item" data-toggle="tooltip" title="Add friends">
                        <a class="btn btn-outline-light" href="#" data-toggle="modal" data-target="#addFriends">
                            <i data-feather="user-plus"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#" class="btn btn-danger sidebar-close">
                            <i data-feather="x"></i>
                        </a>
                    </li>
                </ul>
            </header>
            <form>
                <input type="text" class="form-control" placeholder="Search">
            </form>
            <div class="sidebar-body">
                <p>137 Friends</p>
                <div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <div>
                                <figure class="avatar">
                                    <img src="./dist/media/img/avatar3.png" class="rounded-circle" alt="image">
                                </figure>
                            </div>
                            <div class="users-list-body">
                                <div>
                                    <h5>Harrietta Souten</h5>
                                    <p>Dental Hygienist</p>
                                </div>
                                <div class="users-list-action">
                                    <div class="action-toggle">
                                        <div class="dropdown">
                                            <a data-toggle="dropdown" href="#">
                                                <i data-feather="more-horizontal"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">New chat</a>
                                                <a href="#" data-navigation-target="contact-information"
                                                   class="dropdown-item">Profile</a>
                                                <div class="dropdown-divider"></div>
                                                <a href="#" class="dropdown-item text-danger">Block</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div>
                                <figure class="avatar avatar-state-warning">
                                    <span class="avatar-title bg-success rounded-circle">A</span>
                                </figure>
                            </div>
                            <div class="users-list-body">
                                <div>
                                    <h5>Aline McShee</h5>
                                    <p>Marketing Assistant</p>
                                </div>
                                <div class="users-list-action">
                                    <div class="action-toggle">
                                        <div class="dropdown">
                                            <a data-toggle="dropdown" href="#">
                                                <i data-feather="more-horizontal"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">New chat</a>
                                                <a href="#" data-navigation-target="contact-information"
                                                   class="dropdown-item">Profile</a>
                                                <div class="dropdown-divider"></div>
                                                <a href="#" class="dropdown-item text-danger">Block</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div>
                                <figure class="avatar avatar-state-success">
                                    <img src="./dist/media/img/avatar8.png" class="rounded-circle" alt="image">
                                </figure>
                            </div>
                            <div class="users-list-body">
                                <div>
                                    <h5>Brietta Blogg</h5>
                                    <p>Actuary</p>
                                </div>
                                <div class="users-list-action">
                                    <div class="action-toggle">
                                        <div class="dropdown">
                                            <a data-toggle="dropdown" href="#">
                                                <i data-feather="more-horizontal"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">New chat</a>
                                                <a href="#" data-navigation-target="contact-information"
                                                   class="dropdown-item">Profile</a>
                                                <div class="dropdown-divider"></div>
                                                <a href="#" class="dropdown-item text-danger">Block</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div>
                                <figure class="avatar avatar-state-success">
                                    <img src="./dist/media/img/avatar6.png" class="rounded-circle" alt="image">
                                </figure>
                            </div>
                            <div class="users-list-body">
                                <div>
                                    <h5>Karl Hubane</h5>
                                    <p>Chemical Engineer</p>
                                </div>
                                <div class="users-list-action">
                                    <div class="action-toggle">
                                        <div class="dropdown">
                                            <a data-toggle="dropdown" href="#">
                                                <i data-feather="more-horizontal"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">New chat</a>
                                                <a href="#" data-navigation-target="contact-information"
                                                   class="dropdown-item">Profile</a>
                                                <div class="dropdown-divider"></div>
                                                <a href="#" class="dropdown-item text-danger">Block</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div>
                                <figure class="avatar">
                                    <img src="./dist/media/img/avatar5.png" class="rounded-circle" alt="image">
                                </figure>
                            </div>
                            <div class="users-list-body">
                                <div>
                                    <h5>Jillana Tows</h5>
                                    <p>Project Manager</p>
                                </div>
                                <div class="users-list-action">
                                    <div class="action-toggle">
                                        <div class="dropdown">
                                            <a data-toggle="dropdown" href="#">
                                                <i data-feather="more-horizontal"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">New chat</a>
                                                <a href="#" data-navigation-target="contact-information"
                                                   class="dropdown-item">Profile</a>
                                                <div class="dropdown-divider"></div>
                                                <a href="#" class="dropdown-item text-danger">Block</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div>
                                <figure class="avatar avatar-state-success">
                                    <span class="avatar-title bg-info rounded-circle">AD</span>
                                </figure>
                            </div>
                            <div class="users-list-body">
                                <div>
                                    <h5>Alina Derington</h5>
                                    <p>Nurse</p>
                                </div>
                                <div class="users-list-action">
                                    <div class="action-toggle">
                                        <div class="dropdown">
                                            <a data-toggle="dropdown" href="#">
                                                <i data-feather="more-horizontal"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">New chat</a>
                                                <a href="#" data-navigation-target="contact-information"
                                                   class="dropdown-item">Profile</a>
                                                <div class="dropdown-divider"></div>
                                                <a href="#" class="dropdown-item text-danger">Block</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div>
                                <figure class="avatar avatar-state-secondary">
                                    <span class="avatar-title bg-warning rounded-circle">S</span>
                                </figure>
                            </div>
                            <div class="users-list-body">
                                <div>
                                    <h5>Stevy Kermeen</h5>
                                    <p>Associate Professor</p>
                                </div>
                                <div class="users-list-action">
                                    <div class="action-toggle">
                                        <div class="dropdown">
                                            <a data-toggle="dropdown" href="#">
                                                <i data-feather="more-horizontal"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">New chat</a>
                                                <a href="#" data-navigation-target="contact-information"
                                                   class="dropdown-item">Profile</a>
                                                <div class="dropdown-divider"></div>
                                                <a href="#" class="dropdown-item text-danger">Block</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div>
                                <figure class="avatar">
                                    <img src="./dist/media/img/avatar1.png" class="rounded-circle" alt="image">
                                </figure>
                            </div>
                            <div class="users-list-body">
                                <div>
                                    <h5>Stevy Kermeen</h5>
                                    <p>Senior Quality Engineer</p>
                                </div>
                                <div class="users-list-action">
                                    <div class="action-toggle">
                                        <div class="dropdown">
                                            <a data-toggle="dropdown" href="#">
                                                <i data-feather="more-horizontal"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">New chat</a>
                                                <a href="#" data-navigation-target="contact-information"
                                                   class="dropdown-item">Profile</a>
                                                <div class="dropdown-divider"></div>
                                                <a href="#" class="dropdown-item text-danger">Block</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div>
                                <figure class="avatar">
                                    <img src="./dist/media/img/avatar7.png" class="rounded-circle" alt="image">
                                </figure>
                            </div>
                            <div class="users-list-body">
                                <div>
                                    <h5>Gloriane Shimmans</h5>
                                    <p>Web Designer</p>
                                </div>
                                <div class="users-list-action">
                                    <div class="action-toggle">
                                        <div class="dropdown">
                                            <a data-toggle="dropdown" href="#">
                                                <i data-feather="more-horizontal"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">New chat</a>
                                                <a href="#" data-navigation-target="contact-information"
                                                   class="dropdown-item">Profile</a>
                                                <div class="dropdown-divider"></div>
                                                <a href="#" class="dropdown-item text-danger">Block</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div>
                                <figure class="avatar avatar-state-warning">
                                    <span class="avatar-title bg-secondary rounded-circle">B</span>
                                </figure>
                            </div>
                            <div class="users-list-body">
                                <div>
                                    <h5>Bernhard Perrett</h5>
                                    <p>Software Engineer</p>
                                </div>
                                <div class="users-list-action">
                                    <div class="action-toggle">
                                        <div class="dropdown">
                                            <a data-toggle="dropdown" href="#">
                                                <i data-feather="more-horizontal"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">New chat</a>
                                                <a href="#" data-navigation-target="contact-information"
                                                   class="dropdown-item">Profile</a>
                                                <div class="dropdown-divider"></div>
                                                <a href="#" class="dropdown-item text-danger">Block</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- ./ Friends sidebar -->

        <!-- New chat sidebar -->
        <div id="new-chat" class="sidebar">
            <header>
                <span>New Chat</span>
                <ul class="list-inline">
                    <li class="list-inline-item" data-toggle="tooltip" title="Create Group">
                        <a class="btn btn-outline-light" href="#" data-toggle="modal" data-target="#newGroup">
                            <i data-feather="users"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#" class="btn btn-danger sidebar-close">
                            <i data-feather="x"></i>
                        </a>
                    </li>
                </ul>
            </header>
            <form>
                <input type="text" class="form-control" placeholder="Search">
            </form>
            <div class="sidebar-body">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar">
                                <img src="./dist/media/img/avatar1.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Harrietta Souten</h5>
                                <p>Dental Hygienist</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item">New chat</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Block</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar avatar-state-warning">
                                <span class="avatar-title bg-success rounded-circle">A</span>
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Aline McShee</h5>
                                <p>Marketing Assistant</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item">New chat</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Block</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar avatar-state-success">
                                <img src="./dist/media/img/avatar10.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Brietta Blogg</h5>
                                <p>Actuary</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item">New chat</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Block</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar avatar-state-success">
                                <img src="./dist/media/img/avatar5.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Karl Hubane</h5>
                                <p>Chemical Engineer</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item">New chat</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Block</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar">
                                <img src="./dist/media/img/avatar8.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Jillana Tows</h5>
                                <p>Project Manager</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item">New chat</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Block</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar avatar-state-success">
                                <span class="avatar-title bg-info rounded-circle">AD</span>
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Alina Derington</h5>
                                <p>Nurse</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item">New chat</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Block</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar avatar-state-secondary">
                                <span class="avatar-title bg-warning rounded-circle">S</span>
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Stevy Kermeen</h5>
                                <p>Associate Professor</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item">New chat</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Block</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar">
                                <img src="./dist/media/img/avatar7.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Stevy Kermeen</h5>
                                <p>Senior Quality Engineer</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item">New chat</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Block</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar">
                                <img src="./dist/media/img/avatar3.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Gloriane Shimmans</h5>
                                <p>Web Designer</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item">New chat</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Block</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div>
                            <figure class="avatar avatar-state-warning">
                                <span class="avatar-title bg-secondary rounded-circle">B</span>
                            </figure>
                        </div>
                        <div class="users-list-body">
                            <div>
                                <h5>Bernhard Perrett</h5>
                                <p>Software Engineer</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item">New chat</a>
                                            <a href="#" data-navigation-target="contact-information"
                                               class="dropdown-item">Profile</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Block</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <!-- ./ New chat sidebar -->

        <!-- Favorites sidebar -->
        <div id="favorites" class="sidebar">
            <header>
                <span>Favorites</span>
                <ul class="list-inline">
                    <li class="list-inline-item">
                        <a href="#" class="btn btn-danger sidebar-close">
                            <i data-feather="x"></i>
                        </a>
                    </li>
                </ul>
            </header>
            <form>
                <input type="text" class="form-control" placeholder="Search">
            </form>
            <div class="sidebar-body">
                <ul class="list-group list-group-flush users-list">
                    <li class="list-group-item">
                        <div class="users-list-body">
                            <div>
                                <h5>Jennica Kindred</h5>
                                <p>I know how important this file is to you. You can trust me ;)</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" class="dropdown-item">Remove favorites</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="users-list-body">
                            <div>
                                <h5>Marvin Rohan</h5>
                                <p>Lorem ipsum dolor sitsdc sdcsdc sdcsdcs</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" class="dropdown-item">Remove favorites</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="users-list-body">
                            <div>
                                <h5>Frans Hanscombe</h5>
                                <p>Lorem ipsum dolor sitsdc sdcsdc sdcsdcs</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" class="dropdown-item">Remove favorites</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="users-list-body">
                            <div>
                                <h5>Karl Hubane</h5>
                                <p>Lorem ipsum dolor sitsdc sdcsdc sdcsdcs</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" class="dropdown-item">Remove favorites</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <!-- ./ Stars sidebar -->

        <!-- Archived sidebar -->
        <div id="archived" class="sidebar">
            <header>
                <span>Archived</span>
                <ul class="list-inline">
                    <li class="list-inline-item">
                        <a href="#" class="btn btn-danger sidebar-close">
                            <i data-feather="x"></i>
                        </a>
                    </li>
                </ul>
            </header>
            <form>
                <input type="text" class="form-control" placeholder="Search">
            </form>
            <div class="sidebar-body">
                <ul class="list-group list-group-flush users-list">
                    <li class="list-group-item">
                        <figure class="avatar">
                            <span class="avatar-title bg-danger rounded-circle">M</span>
                        </figure>
                        <div class="users-list-body">
                            <div>
                                <h5>Mercedes Pllu</h5>
                                <p>I know how important this file is to you. You can trust me ;)</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" class="dropdown-item">Restore</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <figure class="avatar">
                            <span class="avatar-title bg-secondary rounded-circle">R</span>
                        </figure>
                        <div class="users-list-body">
                            <div>
                                <h5>Rochelle Golley</h5>
                                <p>Lorem ipsum dolor sitsdc sdcsdc sdcsdcs</p>
                            </div>
                            <div class="users-list-action">
                                <div class="action-toggle">
                                    <div class="dropdown">
                                        <a data-toggle="dropdown" href="#">
                                            <i data-feather="more-horizontal"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item btn-open-chat">Open</a>
                                            <a href="#" class="dropdown-item">Restore</a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item text-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <!-- ./ Archived sidebar -->

        <!-- Profile sidebar -->
        <div id="contact-information" class="sidebar">
            <header>
                <span>Profile</span>
                <ul class="list-inline">
                    <li class="list-inline-item">
                        <a href="#" class="btn btn-outline-light" data-toggle="modal" data-target="#editProfileModal"
                           title="Edit profile">
                            <i data-feather="edit-2"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#" class="btn btn-danger sidebar-close">
                            <i data-feather="x"></i>
                        </a>
                    </li>
                </ul>
            </header>
            <div class="sidebar-body">
                <div class="text-center">
                    <figure class="avatar avatar-xl mb-4">
                        <img src="./dist/media/img/avatar3.png" class="rounded-circle" alt="image">
                    </figure>
                    <h5 class="mb-1">Mirabelle Tow</h5>
                    <small class="text-muted font-italic">Last seen: Today</small>
                    <ul class="nav nav-tabs justify-content-center mt-5" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a href="https://www.51qianduan.com/">51前端</a>
                        </li>
                        <li class="nav-item">
                            <a href="https://www.51qianduan.com/">51前端</a>
                        </li>
                    </ul>
                </div>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <p class="text-muted">Lorem ipsum is a pseudo-Latin text used in web design, typography,
                            layout, and printing in place of English to emphasise design elements over content.
                            It's also called placeholder (or filler) text. It's a convenient tool for
                            mock-ups.</p>
                        <div class="mt-4 mb-4">
                            <h6>Phone</h6>
                            <p class="text-muted">(555) 555 55 55</p>
                        </div>
                        <div class="mt-4 mb-4">
                            <h6>City</h6>
                            <p class="text-muted">Germany / Berlin</p>
                        </div>
                        <div class="mt-4 mb-4">
                            <h6>Website</h6>
                            <p>
                                <a href="#">www.franshanscombe.com</a>
                            </p>
                        </div>
                        <div class="mt-4 mb-4">
                            <h6 class="mb-3">Social media accounts</h6>
                            <ul class="list-inline social-links">
                                <li class="list-inline-item">
                                    <a href="#" class="btn btn-sm btn-floating btn-facebook"
                                       data-toggle="tooltip" title="Facebook">
                                        <i class="fa fa-facebook"></i>
                                    </a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="#" class="btn btn-sm btn-floating btn-twitter"
                                       data-toggle="tooltip" title="Twitter">
                                        <i class="fa fa-twitter"></i>
                                    </a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="#" class="btn btn-sm btn-floating btn-whatsapp"
                                       data-toggle="tooltip" title="Whatsapp">
                                        <i class="fa fa-whatsapp"></i>
                                    </a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="#" class="btn btn-sm btn-floating btn-linkedin"
                                       data-toggle="tooltip" title="Linkedin">
                                        <i class="fa fa-linkedin"></i>
                                    </a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="#" class="btn btn-sm btn-floating btn-google" data-toggle="tooltip"
                                       title="Google">
                                        <i class="fa fa-google"></i>
                                    </a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="#" class="btn btn-sm btn-floating btn-instagram"
                                       data-toggle="tooltip" title="Instagram">
                                        <i class="fa fa-instagram"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="mt-4 mb-4">
                            <h6 class="mb-3">Settings</h6>
                            <div class="form-group">
                                <div class="form-item custom-control custom-switch">
                                    <input type="checkbox" class="custom-control-input" id="customSwitch11">
                                    <label class="custom-control-label" for="customSwitch11">Block</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-item custom-control custom-switch">
                                    <input type="checkbox" class="custom-control-input" checked=""
                                           id="customSwitch12">
                                    <label class="custom-control-label" for="customSwitch12">Mute</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-item custom-control custom-switch">
                                    <input type="checkbox" class="custom-control-input" id="customSwitch13">
                                    <label class="custom-control-label" for="customSwitch13">Get
                                        notification</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <h6 class="mb-3 d-flex align-items-center justify-content-between">
                            <span>Recent Files</span>
                            <a href="#" class="btn btn-link small">
                                <i data-feather="upload" class="mr-2"></i> Upload
                            </a>
                        </h6>
                        <div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item pl-0 pr-0 d-flex align-items-center">
                                    <a href="#">
                                        <i class="fa fa-file-pdf-o text-danger mr-2"></i> report4221.pdf
                                    </a>
                                </li>
                                <li class="list-group-item pl-0 pr-0 d-flex align-items-center">
                                    <a href="#">
                                        <i class="fa fa-image text-muted mr-2"></i> avatar_image.png
                                    </a>
                                </li>
                                <li class="list-group-item pl-0 pr-0 d-flex align-items-center">
                                    <a href="#">
                                        <i class="fa fa-file-excel-o text-success mr-2"></i>
                                        excel_report_file2020.xlsx
                                    </a>
                                </li>
                                <li class="list-group-item pl-0 pr-0 d-flex align-items-center">
                                    <a href="#">
                                        <i class="fa fa-file-text-o text-warning mr-2"></i> articles342133.txt
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Profile sidebar -->

        <!-- Chat -->
        <div class="chat">
            <div class="chat-body"> <!-- .no-message -->
                <!--
                <div class="no-message-container">
                    <div class="row mb-5">
                        <div class="col-md-4 offset-md-4">
                            <img src="./dist/media/svg/undraw_empty_xct9.svg" class="img-fluid" alt="image">
                        </div>
                    </div>
                    <p class="lead">Select a chat to read messages</p>
                </div>
                -->
                <div class="messages">
                    <div class="message-item outgoing-message">
                        <div class="message-avatar">
                            <figure class="avatar" title="Mirabelle Tow">
                                <img src="./dist/media/img/avatar3.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content">
                                Hello how are you?
                            </div>
                            <div class="time">01:20 PM <i class="ti-double-check text-info"></i></div>
                        </div>
                    </div>
                    <div class="message-item">
                        <div class="message-avatar">
                            <figure class="avatar" title="Byrom Guittet">
                                <img src="./dist/media/img/avatar4.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content">
                                I'm fine, how are you 😃
                            </div>
                            <div class="time">01:35 PM</div>
                        </div>
                    </div>
                    <div class="message-item outgoing-message">
                        <div class="message-avatar">
                            <figure class="avatar" title="Mirabelle Tow">
                                <img src="./dist/media/img/avatar3.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content">
                                I'm fine thank you. I expect you to send me some files.
                            </div>
                            <div class="time">05:31 PM <i class="ti-double-check text-info"></i></div>
                        </div>
                    </div>
                    <div class="message-item">
                        <div class="message-avatar">
                            <figure class="avatar" title="Byrom Guittet">
                                <img src="./dist/media/img/avatar4.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content">
                                What files are you talking about? I'm sorry I can't remember right now.
                            </div>
                            <div class="time">10:12 PM</div>
                        </div>
                    </div>
                    <div class="message-item outgoing-message">
                        <div class="message-avatar">
                            <figure class="avatar" title="Mirabelle Tow">
                                <img src="./dist/media/img/avatar3.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content">
                                I want those files for you. I want you to send 1 PDF and 1 image file.
                            </div>
                            <div class="time">11:56 PM <i class="ti-double-check text-info"></i></div>
                        </div>
                    </div>
                    <div class="message-item">
                        <div class="message-avatar">
                            <figure class="avatar" title="Byrom Guittet">
                                <img src="./dist/media/img/avatar4.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content message-file">
                                <div class="file-icon">
                                    <i class="fa fa-file-pdf-o"></i>
                                </div>
                                <div>
                                    <div>important_documents.pdf <i class="text-muted small">(50KB)</i></div>
                                    <ul class="list-inline">
                                        <li class="list-inline-item mb-0"><a href="#">Download</a></li>
                                        <li class="list-inline-item mb-0"><a href="#">View</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="time">11:59 PM</div>
                        </div>
                    </div>
                    <div class="message-item">
                        <div class="message-avatar">
                            <figure class="avatar" title="Byrom Guittet">
                                <img src="./dist/media/img/avatar4.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content">
                                I'm about to send the other file now.
                            </div>
                            <div class="time">07:15 AM</div>
                        </div>
                    </div>
                    <div class="message-item outgoing-message">
                        <div class="message-avatar">
                            <figure class="avatar" title="Mirabelle Tow">
                                <img src="./dist/media/img/avatar3.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content">
                                Thank you so much. These files are very important to me. I guess you didn't make any
                                changes
                                to these files. So I need the original versions of these files. Thank you very much
                                again.
                            </div>
                            <div class="time">07:45 AM <i class="ti-double-check text-info"></i></div>
                        </div>
                    </div>
                    <div class="message-item">
                        <div class="message-avatar">
                            <figure class="avatar" title="Byrom Guittet">
                                <img src="./dist/media/img/avatar4.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content">
                                I thank you. We are glad to help you. 😃
                            </div>
                            <div class="time">08:00 AM</div>
                        </div>
                    </div>
                    <div class="message-item outgoing-message">
                        <div class="message-avatar">
                            <figure class="avatar" title="Mirabelle Tow">
                                <img src="./dist/media/img/avatar3.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content">
                                😃 😃 ❤ ❤
                            </div>
                            <div class="time">09:23 AM <i class="ti-double-check text-info"></i></div>
                        </div>
                    </div>
                    <div class="message-item">
                        <div class="message-avatar">
                            <figure class="avatar" title="Byrom Guittet">
                                <img src="./dist/media/img/avatar4.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content message-image">
                                <img src="dist/media/img/image1.png" class="rounded" alt="image">
                            </div>
                            <div class="time">10:43 AM</div>
                        </div>
                    </div>
                    <div class="message-item outgoing-message">
                        <div class="message-avatar">
                            <figure class="avatar" title="Mirabelle Tow">
                                <img src="./dist/media/img/avatar3.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content">
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet at dolores dolorum
                                expedita, odio quas quod. Assumenda doloribus eaque eveniet excepturi exercitationem
                                fuga fugit incidunt laboriosam necessitatibus obcaecati, optio ratione tempora tempore
                                voluptate voluptatem. Aut doloribus eveniet exercitationem id! Atque commodi, ea
                                exercitationem minima necessitatibus repellendus sit totam unde veniam.
                            </div>
                            <div class="message-content">
                                😃 😃 ❤ ❤
                            </div>
                            <div class="time">10:50 AM <i class="ti-double-check text-info"></i></div>
                        </div>
                    </div>
                    <div class="message-item messages-divider" data-label="1 message unread"></div>
                    <div class="message-item">
                        <div class="message-avatar">
                            <figure class="avatar" title="Byrom Guittet">
                                <img src="./dist/media/img/avatar4.png" class="rounded-circle" alt="image">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content">
                                I sent you all the files. Good luck with 😃
                            </div>
                            <div class="time">11:05 AM</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="chat-footer">
                <form>
                    <div>
                        <button class="btn btn-light mr-3 d-none d-sm-inline-block" data-toggle="tooltip" title="Emoji" type="button">
                            <i data-feather="smile"></i>
                        </button>
                        <button class="btn btn-danger mr-3 d-inline d-sm-none btn-close-chat" data-toggle="tooltip" title="Emoji" type="button">
                            <i data-feather="arrow-left"></i>
                        </button>
                    </div>
                    <input type="text" class="form-control" placeholder="Write a message.">
                    <div class="form-buttons">
                        <button class="btn btn-light d-none d-sm-inline-block" data-toggle="tooltip" title="Add files" type="button">
                            <i data-feather="paperclip"></i>
                        </button>
                        <button class="btn btn-light d-none d-sm-inline-block" data-toggle="tooltip"
                                title="Send a voice record" type="button">
                            <i data-feather="mic"></i>
                        </button>
                        <button class="btn btn-primary" type="submit">
                            <i data-feather="send"></i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <!-- ./ Chat -->

    </div>
    <!-- ./ Content -->

</div>
<!-- ./ Layout -->

<!-- Bundle -->
<script src="./vendor/bundle.js"></script>

<!-- App scripts -->
<script src="./dist/js/app.min.js"></script>

<!-- Examples -->
<script src="./dist/js/examples.js"></script>
</body>
</html>