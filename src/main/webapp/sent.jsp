<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/20 0020
  Time: 下午 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="zh-cmn-Hans">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
    <meta name="apple-itunes-app" content="app-id=458270120" />
    <title>我的寄件订单</title>
    <meta name="keywords" content="申通快递单号查询,ems快递单号查询,圆通快递查询单号,中通快递单号查询,韵达快递单号查询" />
    <meta name="description" content="提供一站式的快递查询服务，涵盖近百家常用物流快递公司，支持手机快递查询。并为B2C等网络应用提供免费的快递查询接口(api)服务。" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.gif" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/personalCenter/base_v4.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sz/daterangepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/page/sent_v6.css?version=20201224" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/home_page/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/css/layui.css"></script>
</head>
<body id="indexBody">
<style>
    .w1220 {
        width: 1220px;
        margin: 0 auto;
    }

    .logo a img {
        width: 119px;
    }

    .head-nav {
        float: right;
    }

    .head-nav>ul>li:before {
        position: absolute;
        bottom: -28px;
        right: 50%;
        left: 50%;
        border-top: 2px solid #0082FA;
        line-height: 0;
        transition: all .3s;
        content: '';
    }

    .head-nav li.head-nav-select:before,
    .head-nav li:hover:before {
        left: 20px;
        right: 20px;
    }

    .head-nav li .badge-tips {
        position: absolute;
        top: 9px;
        right: 0;
        margin-left: -40px;
        width: auto;
        padding: 4px;
        background: #ff9634;
        border-radius: 4px;
        color: #FFF;
        line-height: 12px;
        font-size: 11px;
    }

    .head-nav li .badge-tips:after {
        position: absolute;
        bottom: -3px;
        left: 10px;
        border-top: 3px solid #ff9634;
        border-left: 3px solid transparent;
        border-right: 3px solid transparent;
        content: "";
    }

    .head-nav>ul>li {
        margin-right: 0;
        margin-left: 10px;
        padding: 0 20px;
    }

    .user-box {
        margin-left: 35px;
    }

    .head-nav-select>a,
    .head-nav-select .ico_triangle,
    li:hover .ico_triangle {
        color: #317ee7 !important;
    }

    .head-nav ul li .ico_triangle {
        display: inline-block;
        vertical-align: middle;
        width: 0;
        margin-left: 10px;
        margin-top: 4px;
        border-top: 8px solid;
        border-left: 5px solid transparent;
        border-right: 5px solid transparent;
        content: '';
    }

    .head-nav ul li .ico_select {
        display: none;
    }
</style>
<div class="header">
    <div class="w1220">
        <div class="logo"><a href="https://www.kuaidi100.com/" title="查快递， 寄快递，上快递100"><img
                src="https://cdn.kuaidi100.com/images/logo.png?version=201707191039" alt="快递100" width="142"
                height="53" /></a></div>
        <div class="user-box">
            <div class="head-nav user-info hidden" id="userInfo">
                <ul>
                    <li><!-- 快递管家、我的查件记录 -->
                        <a href="https://sso.kuaidi100.com/user/account.jsp">
								<span class="user-img">
									<img width="35" height="35" id="userImg"></span>
                            <span class="user-name" id="userName"></span>
                        </a>
                        <ul>
                            <li id="userUrl"></li>
                            <li><a href="sent.html">我的寄件订单</a></li>
                            <li><a href="personalCenter_homePage.html" target="_blank">用户中心</a></li>
                            <li><a href="login.html" onclick="logout();return false;">退出</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <span id="welcome" class="sign hidden"><a
                    href="register.html">注册</a><i>|</i><a
                    href="login.html">登录</a></span>
        </div>
        <div class="head-nav">
            <ul>
                <li id="menu-track"><a href="" title="查快递， 寄快递，上快递100">首页</a></li>
                <li id="menu-person"><a>个人用户</a><i class="ico_triangle"></i>
                    <ul>
                        <li><a href="">产品介绍</a></li>
                        <li><a href="" target="_blank">寄快递</a></li>
                        <li><a href="" target="_blank">国际快递</a></li>
                        <li><a href="">快递大全</a></li>
                        <li><a href="" target="_blank">开放服务</a>
                        </li>
                    </ul>
                </li>
                <li><a>企业用户</a><i class="ico_triangle"></i>
                    <ul>
                        <li><a href="">快递管家</a></li>
                        <li><a href="" target="_blank">企业API</a></li>
                    </ul>
                </li>
                <li><a>物流服务商</a><i class="ico_triangle"></i>
                    <ul>
                        <li><a href=""
                               target="_blank">快递员收件端</a></li>
                        <li><a href=""
                               target="_blank">云打印硬件</a></li>
                        <li><a href="" target="_blank">快递公司入驻</a></li>
                    </ul>
                </li>
                <li>
                    <a href="" id="menu-api" target="_blank">接口(API)</a>
                    <i class="ico_triangle"></i>
                    <ul>
                        <li><a href="" target="_blank">产品介绍</a></li>
                        <li><a href="" target="_blank">接口申请</a></li>
                        <li><a href="" target="_blank">技术文档</a></li>
                        <li><a href="" target="_blank">云平台</a></li>
                    </ul>
                </li>
                <li><a href="" target="_blank">3.5元寄全国</a><span
                        class="badge-tips">商家特惠</span></li>
            </ul>
        </div>
        <div class="box"></div>
    </div>
</div>
<div class="hr"></div>


<div class="container w960">
    <div class="nav-crumbs"><a href="HomePage.html">首页</a>&nbsp;&gt;&nbsp;我的寄件订单</div>
    <div class="tabs">
        <!-- <div class="tab"><a href="">我的查件记录</a></div> -->
        <div class="tab active">我的寄件记录</div>
    </div>
    <!-- 寄件记录详细信息 -->
    <div id="orders" class="orders">
        <div class="top-tips-wrap">
            <div id="topTips" class="top-tips hidden"><a onclick="closeTopTips();" class="close-tips"></a>
                <p></p>
            </div>
        </div>
        <div class="order-form">
            <div class="form-item"><label>快递类型：</label>
                <div class="form-wrap"><select>
                    <option value="">全部</option>
                    <option value="1">待接单</option>
                    <option value="0">已取消</option>
                    <option value="2">已揽收</option>
                    <option value="3">已派送</option>
                    <option value="4">已签收</option>
                </select>
                    <div class="select">全部</div>
                </div>
            </div>
            <div class="form-item"><label>搜索：</label>
                <div class="form-wrap"><input type="text" class="searchVal" placeholder="收件人信息"> <span class="search"></span></div>
            </div>
            <div class="form-item"><label>寄件时间：</label>
                <div id="daterange" class="form-wrap">
                    <div class="select" style="width: 234px;">最近一个月</div>
                </div>
            </div>
        </div>
        <table class="lists">
            <tbody>
            <tr>
                <th style="width: 200px;">寄件人</th>
                <th style="width: 95px;">寄件类型</th>
                <th style="width: 135px;">订单号</th>
                <th style="width: 130px;">寄件时间</th>
                <th style="width: 120px; text-align: right;">状态</th>
                <th style="text-align: right;">操作</th>
            </tr>
            <tr class="ctrl">
                <td colspan="6" class="td-paginate"><span class="td-paginateFirstSpan">1-10</span> <span>共<strong>${count}</strong>条</span>
                    <div class="page-ctrl">
                        <span id="prevs" class="prev disable"></span> <span id="nexts" class="next disable"></span>
                    </div>
                </td>
            </tr>
            <!--<tr><iframe src="test.html" width="100%" height="939" frameborder="0"></iframe></tr>-->
            </tbody>
            <tbody id="listBody">
            <c:forEach var="orders" items="${ordersList}" varStatus="loop">
                <!--显示的订单信息begin-->
                <tr>
                    <!-- 寄、收件人 -->
                    <td>
                        <div class="td-name"><span class="addr">${sendAddressList[loop.count-1].addressName}</span><span class="trans"></span>
                            <span class="addr">${recAddressList[loop.count-1].addressName}</span></div>
                        <div class="phone">${sendAddressList[loop.count-1].addressPhone}</div>
                    </td>
                    <td>全国优选</td>
                    <td>${orders.ordernumber}</td>
                    <td class="dateTime">${orders.ordertime}</td><!-- 寄件时间 -->
                    <td style="text-align: right;">
                        <c:choose>
                            <c:when test="${orders.orderstate==1}">
                            <span class="txt-status">待接单</span>
                            </c:when>
                            <c:when test="${orders.orderstate==0}">
                                <span class="txt-status">订单已取消</span>
                            </c:when>
                            <c:when test="${orders.orderstate==2}">
                                <span class="txt-status">已揽收</span>
                            </c:when>
                            <c:when test="${orders.orderstate==3}">
                                <span class="txt-status">已派送</span>
                            </c:when>
                            <c:when test="${orders.orderstate==4}">
                                <span class="txt-status">已签收</span>
                            </c:when>
                        </c:choose>
                    </td>
                    <td style="text-align: right;">
                        <div class="ctrl-wrap">
                            <c:if test="${orders.orderstate==1 || orders.orderstate==2}">
                            <span class="td-warn">取消订单</span>
                            <span style="display: none">${orders.orderId}</span>
                            </c:if>
                        </div>
                    </td>
                </tr>
                <!--显示的订单信息end-->
                <!--隐藏的信息详情begin-->
                <tr class="ctrl">
                    <td colspan="6" class="detail">
                        <div class="slide-wrap" style="display: block;">
                            <div class="head-wrap">
                                <div class="head status">
                                    <div class="title">状态追踪</div>
                                    <div class="service">客服电话：400-000-0387</div>
                                </div>
                                <div class="head detail">
                                    <div class="title">包裹信息</div>
                                </div>
                            </div>
                            <div class="table">
                                <div class="row">
                                    <div class="col status" style="width: 540px;">
                                        <div class="content">
                                            <div class="express-detail">
                                                <div class="list scrollbar">
                                                    <div class="item start">
                                                        <div class="info">订单已取消</div>
                                                        <div class="time">2021-04-13 16:57:17</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col" style="width: 20px; border: none;"></div>
                                    <div class="col detail" style="width: 400px;">
                                        <div class="content">
                                            <div class="infos">
                                                <!-- 寄件地址信息 -->
                                                <div class="item">
                                                    <div class="label">寄件信息：</div>
                                                    <div class="info">
                                                         ${sendAddressList[loop.count-1].addressName} &nbsp; ${sendAddressList[loop.count-1].addressPhone}
                                                        <div class="addr">${sendAddressList[loop.count-1].province}${sendAddressList[loop.count-1].city}${sendAddressList[loop.count-1].district}${sendAddressList[loop.count-1].street}</div>
                                                    </div>
                                                </div>
                                                <!-- 收件地址信息 -->
                                                <div class="item">
                                                    <div class="label">收件信息：</div>
                                                    <div class="info">
                                                            ${recAddressList[loop.count-1].addressName} &nbsp; ${recAddressList[loop.count-1].addressPhone}
                                                        <div class="addr">${recAddressList[loop.count-1].province}${recAddressList[loop.count-1].city}${recAddressList[loop.count-1].district}${recAddressList[loop.count-1].street}</div>
                                                    </div>
                                                </div>
                                                <div class="item">
                                                    <div class="label">已付运费：</div>
                                                    <div class="info">0元
                                                        <!---->
                                                    </div>
                                                </div>
                                                <!-- 付费方式 -->
                                                <div class="item">
                                                    <div class="label">付费方式：</div>
                                                    <div class="info">取件后支付</div>
                                                </div>
                                                <div class="item">
                                                    <div class="label">保价金额：</div>
                                                    <div class="info">不保价</div>
                                                </div>
                                                <div class="item">
                                                    <div class="label">物品信息：</div>
                                                    <!-- 快递类别 -->
                                                    <div class="info">服饰
                                                    </div>
                                                </div>
                                                <!---->
                                                <div class="item">
                                                    <div class="label">留  言：</div>
                                                    <div class="info">-</div>
                                                </div>
                                                <div class="item">
                                                    <div class="label">订&nbsp;单&nbsp;号：</div>
                                                    <!-- 订单号 -->
                                                    <div class="info">${orders.ordernumber} <span
                                                            data-clipboard-text="${orders.ordernumber}"
                                                            class="copy">复制</span></div>
                                                </div>
                                                <!---->
                                                <div class="item">
                                                    <div class="label">取消原因：</div>
                                                    <div class="info">预支付超时</div>
                                                </div>
                                                <div class="item">
                                                    <div class="label">下单时间：</div>
                                                    <!-- 下单时间 -->
                                                    <div class="info">2021-04-13 16:26:41</div>
                                                </div>
                                                <div class="item">
                                                    <div class="label">下单来源：</div>
                                                    <div class="info">WEB端</div>
                                                </div>
                                                <div class="item">
                                                    <div class="label">下单位置：</div>
                                                    <div class="info">-</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <!--隐藏的信息详情end-->
            </tbody>
            <tbody>
            <!---->
            </tbody>
        </table>
        <!--分页条begin-->
        <div class="paginate">
            <span id="prev" class="prev disable"></span>
            <c:forEach var="i" begin="1" end="${page}" step="1">
                <a class="active page-active">${i}</a>
            </c:forEach>
            <span id="next" class="next disable"></span>
        </div>
        <!--分页条end-->

        <!--点击取消订单提交取消原因-->	<!--取消订单弹框being-->
        <div class="dialog-wrap" style="display: none;">
            <div class="dialog">
                <div class="dialog-close"></div>
                <div class="dialog-head">
                    请告诉我们取消原因
                    <p class="small">我们努力做得更好</p>
                </div>
                <div class="dialog-body">
                    <div class="reason-wrap">
                        <ul class="reason-list scrollbar">
                            <li class="reason-item" >
                                <label class="label-wrap label-wrap-ok">
                                <input type="radio" name="reason" value="电话联系不上快递员">
                                <span class="label">电话联系不上快递员</span>
                                </label>
                            </li>
                            <li class="reason-item" >
                                <label class="label-wrap label-wrap-ok">
                                    <input type="radio" name="reason" value="填错收件人信息">
                                    <span class="label">填错收件人信息</span>
                                </label>
                            </li>
                            <li class="reason-item" >
                                <label class="label-wrap label-wrap-ok">
                                    <input type="radio" name="reason" value="需求有变,暂时不需要寄件">
                                    <span class="label">需求有变,暂时不需要寄件</span>
                                </label>
                            </li>
                            <li class="reason-item" >
                                <label class="label-wrap label-wrap-ok">
                                    <input type="radio" name="reason" value="快递员说太员,快递员没来">
                                    <span class="label">快递员说太员,快递员没来</span>
                                </label>
                            </li>
                            <li class="reason-item">
                                <label class="label-wrap label-wrap-ok">
                                    <input type="radio" name="reason" value="下单后等太久,快递员没来">
                                    <span class="label">下单后等太久,快递员没来</span>
                                </label>
                            </li>
                            <li class="reason-item">
                                <label class="label-wrap label-wrap-else">
                                    <input type="radio" name="reason" value="6">
                                    <span class="label">其他</span>
                                </label>
                            </li>
                            <li class="reason-item last-reason-item" style="display: none">
                                <input type="text" placeholder="请输入其他原因">
                            </li>
                        </ul>
                        <div class="btn-wrap">
                            <!---->
                            <div class="btn">提交</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--取消订单弹框end-->
    </div>
    <!-- 订单详细信息框结束 -->
</div>
</div>

<style>
    .footer {
        height: 340px;
        padding-top: 75px;
        background: #02163c;
        color: #FFF;
    }

    .footer .foot-link dt {
        margin-bottom: 30px;
        font-size: 18px;
        line-height: 25px;
        color: #FFF;
    }

    .foot-link,
    .foot-link a {
        color: #FFF;
    }

    .foot-copyright {
        padding-top: 25px;
        margin-top: 50px;
        border-top: 1px solid #4a4a4a;
        text-align: center;
        font-size: 14px;
    }

    .foot-copyright a {
        color: #FFF;
    }

    .footer-industry {
        padding-top: 10px;
        text-align: center;
    }

    .footer-industry li {
        display: inline-block;
    }

    .footer-industry a {
        display: block;
        width: 50px;
        height: 50px;
        background: url(img/sp-index.png) -287px -206px;
    }

    .footer-qrcode {
        float: right;
    }

    .footer-code {
        float: left;
        margin-left: 30px;
        width: 123px;
        text-align: center;
        font-size: 16px;
    }

    .footer-qrcode img {
        width: 123px;
        height: 123px;
        margin-bottom: 16px;
    }
</style>
<div class="fix-box-middle" id="floatCtrl">
    <i href="#" onclick="gototop();return false;" class="ctrl-btn-1" title="回到顶部"></i>
    <a target="_blank" class="ctrl-btn-2" title="联系客服" id="uDeskTarget"></a>
    <a href="javascript:;" class="ctrl-btn-2 ctrl-btn-3" title="手机版（H5站）"></a><!-- id="goH5"-->
</div>
<div class="footer">
    <div class="w1220">
        <div class="foot-link">
            <dl>
                <dt>了解我们</dt>
                <dd><a href="" target="_blank">关于快递100</a></dd>
                <dd><a href="" target="_blank">新闻资讯</a></dd>
                <dd><a href="" target="_blank">隐私政策</a></dd>
            </dl>
            <dl>
                <dt>关注我们</dt>
                <dd><a href="">微信公众号</a></dd>
                <dd><a href="">新浪微博</a></dd>
                <dd><a href="">100社区</a></dd>
            </dl>
            <dl>
                <dt>联系我们</dt>
                <dd><a href="" target="_blank">联系方式</a></dd>
                <dd><a href="" target="_blank">加入我们</a></dd>
                <dd><a href="">帮助文档</a></dd>
            </dl>
            <dl>
                <dt>快速通道</dt>
                <dd><a href="#" id="viewH5">手机HTML5站</a></dd>
                <dd><a href="">快递网点入驻/加盟</a></dd>
                <dd><a href="">快递网点维护/更新</a></dd>
            </dl>
            <ul class="footer-qrcode">
                <li class="footer-code">
                    <img src="img/qrcode-courier.png" alt="快递员端">
                    <p>快递100收件端</p>
                </li>
                <li class="footer-code">
                    <img src="img/qrcode-public.png" alt="关注公众号">
                    <p>快递100</p>
                </li>
            </ul>
            <div class="box"></div>
        </div>
        <div class="foot-copyright">
            深圳前海百递网络有限公司 版权所有&copy;2010-<span id="copyrightYear">2021</span>
            <script>
                document.getElementById("copyrightYear").innerHTML = (new Date()).getFullYear();
            </script>
            <a href="http://beian.miit.gov.cn" target="_blank" rel="nofollow">粤ICP备14085002号-5</a>
            <a href="https://www.kuaidi100.com/about/licence.shtml" target="_blank"
               rel="nofollow">粤B2-20150010</a>
        </div>

        <ul class="footer-industry">
            <li><a target="_blank" href="http://szcert.ebs.org.cn/C8900EF4-041B-4E72-96CC-EDCEF5A444C0"
                   title="深圳市市场监督管理局企业主体身份公示"
                   style="background-position: -287px -206px;width: 16px;height: 17px;" rel="nofollow"></a>
            </li>
            <!-- <li><a target="_blank" href="http://61.144.227.239:9002/" title="深圳市网上报警平台" style="background-position: -287px -233px;width: 16px;height: 18px;" rel="nofollow"></a></li> -->
            <li><a target="_blank" title="可信任网站"
                   href="https://ss.knet.cn/verifyseal.dll?sn=e17090744030068817gc1i000000&amp;pa=111332"
                   style="background-position: -262px -259px;width: 42px;height: 15px;" rel="nofollow"></a>
            </li>
        </ul>
        <div class="box"></div>
    </div>
</div>
<div id="updateNotice"
     style="position:fixed;top:0;left:0;right:0;bottom:0;z-index: 99999;background:rgba(0,0,0,.3);text-align:center;display:none;">
    <div style="display:inline-block;vertical-align:middle;position:relative;">
        <div id="noticeClose"
             style="position: absolute;right: 0;top: -37px;background: url(https://cdn.kuaidi100.com/images/sz/ico_close.png) no-repeat;width: 24px;height: 24px;display: inline-block;cursor: pointer;">
					<span
                            style="display: block;border-left: 2px solid #fff;height: 14px;content: '';margin-top: 24px;margin-left: 10px;"></span>
        </div>
        <img src="https://cdn.kuaidi100.com/images/temp/notice_20180803.png" alt="">
    </div>
    <span style="display:inline-block;vertical-align:middle;width:0;height: 100%;"></span>
</div>
<script>
    function gototop() {
        acceleration = 0.3;
        time = 15;
        var x = 0,
            y = 0;
        if (document.documentElement) {
            x = document.documentElement.scrollLeft || 0;
            y = document.documentElement.scrollTop || 0;
        }
        var speed = 1 + acceleration;
        window.scrollTo(x, Math.floor(y / speed));
        if (y > 0) {
            var invokeFunction = "gototop()";
            window.setTimeout(invokeFunction, time);
        }
    }
</script>
<%--<script src="${pageContext.request.contextPath}/js/util/jquery-1.12.1.min.js"></script>--%>
<script src="${pageContext.request.contextPath}/js/util/jquery-migrate-1.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/share/vue.js"></script>
<script src="${pageContext.request.contextPath}/js/share/base_v4.js?version=201707191039"></script>
<script src="${pageContext.request.contextPath}/js/share/user_v4.js?version=201909091000"></script>
<script src="${pageContext.request.contextPath}/js/share/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/js/share/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/share/clipboard.min-20191031.js?vertion=20191031"></script>
<script src="${pageContext.request.contextPath}/js/page/sent_v6.js?version=8"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</body>

<script type="text/javascript">
    $(function () {
        //得到当前日期
        var date=new Date();
        //日
        var day = date.getDate();
        //月
        var month = date.getMonth()+1;

        var year = date.getFullYear();
        //循环所有时间
        $(".dateTime").each(function () {
            var zuotian=$(this).text().split(" ")[1];
            //拿到日
            var days=$(this).text().split(" ")[0].split("-")[2];
            //拿到月
            var months=$(this).text().split(" ")[0].split("-")[1];
            //拿到年
            var years=$(this).text().split(" ")[0].split("-")[0];
            //判断是同一天
            if(days==day && months==month && year==years){
                $(this).text(""+$(this).text().split(" ")[1])
            }else if((day-days)==1 && months==month && year==years){
                //昨天
                $(this).text("昨天"+zuotian.split(":")[0]+":"+zuotian.split(":")[1])
            }else if((day-days)==2 && months==month && year==years){
                //前天
                $(this).text("前天"+zuotian.split(":")[0]+":"+zuotian.split(":")[1])
            }else{
                $(this).text($(this).text().split(" ")[0])
            }
        });
        //初始化 隐藏订单下面的订单详情
        $("#listBody").children(".ctrl").hide();

        //得到当前页面
        var offsets=${offsets};
        //设置显示当前页面的数字样式
        $(".page-active").each(function () {
           if($(this).text()==offsets){
               $(this).css("color","#317ee7");
           }else{
               $(this).css("color","#888");
           }
        })
        //得到总页数
       var page = ${page};
        /*判断总页数是否大于当前页数*/
        if (page>offsets){
            $("#next").removeClass("next disable").addClass("next");
            $("#nexts").removeClass("next disable").addClass("next");
            //下一页添加点击事件
            $(".next").click(function () {
                window.location.href="pjcSelectAllOrder?offset="+(offsets+1);
            })
        }
        if(offsets>1){
            $("#prev").removeClass("prev disable").addClass("prev");
            $("#prevs").removeClass("prev disable").addClass("prev");
            //上一页添加点击事件
            $(".prev").click(function () {
                window.location.href="pjcSelectAllOrder?offset="+(offsets-1);
            })
        }
        //例如1页1-10  2页 11-20 ......
        $(".td-paginateFirstSpan").text(((offsets*10)-9)+"-"+(offsets*10));

         //赋值搜索框
        var addressName = '${addressName}';
        var addressPhone = '${addressPhone}';
        //判断收/寄名字不等于空
        if(addressName!="w"){
             $(".searchVal").val(addressName);
        }else if(addressPhone!="w"){
             $(".searchVal").val(addressPhone);
        }
        //赋值选中订单状态的下拉列表
        var orderState=${orderState};
        //循环所有的订单状态
        $(".form-wrap>select>option").each(function () {
            //判断上次选中的订单状态和下拉列表里面的订单状态相同
            if (orderState==$(this).val()){
                $(this).parent().next(".select").text($(this).text());
                $(this).attr("selected",true);
            }else{
                $(this).attr("selected",false);
            }
        })
    });
    //给订单状态添加点击事件(目的显示订单下面隐藏的订单详情tr)
    $(".txt-status").click(function(){
        if($(this).parent().parent().next(".ctrl").is(':hidden')){
            $("#listBody").children(".ctrl").hide();
            $(this).parent().parent().next(".ctrl").show();
        }else{
            $(this).parent().parent().next(".ctrl").hide();
        }
    });
    //给下面的当前页面数字添加点击事件
    $(".page-active").click(function () {
        window.location.href="pjcSelectAllOrder?offset="+$(this).text();
    });
    /*给选中快递类型添加点击事件*/
    $(".form-wrap>select>option").click(function () {
        $(this).parent().next(".select").text($(this).text());
        var nameOrPhone="";
        if((/^(0\d{2}-\d{7,8}|0\d{3}-\d{7,8}|1[345678]\d{9})$/).test($(".searchVal").val())){
            nameOrPhone="addressPhone"
        }else{
            nameOrPhone="addressName"
        }
        window.location.href="pjcSelectAllOrder?orderState="+$(this).val()+"&"+nameOrPhone+"="+$(".searchVal").val();
    });
    /*给搜索框添加点击事件*/
    $(".search").click(function () {
        var nameOrPhone="";
        if((/^(0\d{2}-\d{7,8}|0\d{3}-\d{7,8}|1[345678]\d{9})$/).test($(".searchVal").val())){
            nameOrPhone="addressPhone"
        }else{
            nameOrPhone="addressName"
        }
        window.location.href="pjcSelectAllOrder?orderState="+$(".form-wrap>select").val()+"&"+nameOrPhone+"="+$(".searchVal").val();
    });

    /*给取消订单添加点击事件*/
    //选中的订单id
    var  orderId=0;
    $(".td-warn").click(function () {
        $(".dialog-wrap").show();
        //赋值订单id
        orderId = $(this).next().text();
        /*默认选中*/
        $(".label-wrap-else").children("input").attr("checked",true);
        //显示隐藏的input
        /*$(".last-reason-item").show();*/
        $(".last-reason-item").children().val("");
    });
    var reasonofcancellation="";
    /*关闭弹框*/
    $(".dialog-close").click(function () {
        $(".dialog-wrap").hide();
        $(".label-wrap").children("input").attr("checked",false);
        //将值赋为空
        reasonofcancellation="";
    });
    /*给其它原因添加点击事件*/
    $(".label-wrap-else").click(function () {
        $(".last-reason-item").show();
    });
    /*给原因添加点击事件*/
    $(".label-wrap-ok").click(function () {
        $(".last-reason-item").hide();
        reasonofcancellation=$(this).children("input").val();
    });
    /*提交按钮添加点击事件*/
    $(".btn").click(function () {
        if(!$(".last-reason-item").is(":hidden")){
            if($(".last-reason-item").children("input").val().length>4){
                reasonofcancellation=$(".last-reason-item").children("input").val();
            }else{
                reasonofcancellation="";
                layui.use(['layer','laydate'], function() {
                    layui.layer.msg("取消原因不能小于四个字符",{icon:5});
                });
            }
        }

        if(reasonofcancellation!=""){
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/orders/pjcUpdateState",
                data: "orderId="+orderId+"&reasonofcancellation="+reasonofcancellation,
                success : function (msg) {
                    //调用检查是否有带条件的方法
                    checkParmeter();
                }
            })
        }
    })

    /*检查是否有带条件的方法*/
    function checkParmeter() {
        var orderState;
        //循环所有的订单状态
        $(".form-wrap>select>option").each(function () {
            //判断上次选中的订单状态和下拉列表里面的订单状态相同
            if ( $(this).parent().next(".select").text()==$(this).text()){
                orderState=$(this).val();
            }
        })
        //判断带条件的
        if(orderState!="" || $(".searchVal").val()!=""){
            var nameOrPhone="";
            if((/^(0\d{2}-\d{7,8}|0\d{3}-\d{7,8}|1[345678]\d{9})$/).test($(".searchVal").val())){
                nameOrPhone="addressPhone"
            }else{
                nameOrPhone="addressName"
            }
            //待参数刷新
            window.location.href="pjcSelectAllOrder?orderState="+orderState+"&"+nameOrPhone+"="+$(".searchVal").val();
        }else{
            //刷新
            window.location.href="pjcSelectAllOrder";
        }
    }

    //复制
    var clipboard = new ClipboardJS('.copy');
    layui.use(['layer','laydate'], function() {
        var layer = layui.layer;
        var laydate = layui.laydate;
        clipboard.on('success', function (e) {
            layer.msg('复制成功！');
            console.log(e);
        });

        clipboard.on('error', function (e) {
            layer.msg('复制失败');
            console.log(e);
        });
    });

</script>
</html>
