

<!doctype html>
<html lang="zh-cmn-Hans" xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
  <meta name="renderer" content="webkit" />
  <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no,minimal-ui">
  <meta name="format-detection" content="telephone=no">
  <title>欢迎您登录快递100</title>
  <link rel="shortcut icon" href="https://cdn.kuaidi100.com/favicon.ico" />
  <link rel="icon" type="image/gif" href="https://cdn.kuaidi100.com/images/favicon.gif" />
  <link rel="stylesheet" href="https://cdn.kuaidi100.com/css/sz/base_v4.css?version=201707271620" />
  <link rel="stylesheet" href="https://cdn.kuaidi100.com/css/user/login_v5.css?version=202101051100" />
</head>
<body>
  <div class="log-head">
        <img src="img/login_logo_v5.png"/>
    <h1>一个账号，畅享所有服务！</h1>
  </div>
  <div class="form-container">
      <h3 id="title">账号密码登录</h3>
      <form action="/pc_web/login/accountLogin" method="POST" id="account">
        <input name="directlogin" type="hidden" value="1" />
        <input name="data" type="hidden" value="JofmxldwnAX71Q7rDGGQHNs5anPRdwPzuv2NkcffIWdlY6FYbTlru2N-Y836XmHETkGJCM_dRxenPPlUTGhBTEWR2DFYlbvc0p4_fqyOfbI-PT7TnynbzL5ZSiMMcD4MN6YhvZC_uzPqvG4ePERrcq7BDHARirNuKzuubZ8iLwJOjezZiJ7ZrEv2GZhXtWsj6ru0LyPDOQN-WPdne2voVDTNzLfcqMC0spgPKmlf-t9GmCpld2otBA" />
        <input name="sign" type="hidden" value="6A0C38902F9FDF7D91E7EB1119359EE5" />
        <input name="referer" type="hidden" value="" />
        <input name="force" type="hidden" value="" />
        <input name="identifytype" type="hidden" value="" />
        <input name="isvalid" id="isvalid" type="hidden" value="" />
        <div class="form-ctrl">
            <input type="text" placeholder="手机号/邮箱/用户名" name="name" id="name" autocomplete="name" value="" /></div>
        <div class="form-ctrl">
          <input type="password" placeholder="请输入密码" name="password" id="password" value="" />
          <!--<a th:href="@{/pc_web/view/findPwdPage}" id="find">忘记密码？</a>-->
          <a href="https://sso.kuaidi100.com/sso/findpwd.jsp" id="find">忘记密码？</a>
        </div>
        <div class="form-ctrl hidden" id="validcode">
          <input type="text" placeholder="请输入图片验证码" autocomplete="code"  name="validcode" />
          <img height="30" alt="验证码" title="点击刷新验证码" />
        </div>
      </form>
      <form action="/pc_web/login/mobileLogin" method="POST" style="display:none;" id="phone">
        <input name="directlogin" type="hidden" value="1" />
        <input name="data" type="hidden" value="JofmxldwnAX71Q7rDGGQHNs5anPRdwPzuv2NkcffIWdlY6FYbTlru2N-Y836XmHETkGJCM_dRxenPPlUTGhBTEWR2DFYlbvc0p4_fqyOfbI-PT7TnynbzL5ZSiMMcD4MN6YhvZC_uzPqvG4ePERrcq7BDHARirNuKzuubZ8iLwJOjezZiJ7ZrEv2GZhXtWsj6ru0LyPDOQN-WPdne2voVDTNzLfcqMC0spgPKmlf-t9GmCpld2otBA" />
        <input name="sign" type="hidden" value="6A0C38902F9FDF7D91E7EB1119359EE5" />
        <input name="referer" type="hidden" value="" />
        <input name="force" type="hidden" value="" />
        <input name="identifytype" type="hidden" value="" />
        <div class="form-ctrl">
            <input type="text" placeholder="请输入手机号" name="name" id="mobile" value=""/></div>
        <div class="form-ctrl hidden" id="phoneValidcode">
          <input type="text" placeholder="请输入图片验证码" autocomplete="code" />
          <img height="30" alt="验证码" title="点击刷新验证码" />
        </div>
        <div class="form-ctrl">
          <input type="text" placeholder="请输入短信验证码" name="dpassword" id="dpassword"/>
          <a id="send">获取手机验证码</a>
        </div>
      </form>
      <form style="display:none;" method="POST" id="thirdLogin">
        <input name="data" type="hidden" value="JofmxldwnAX71Q7rDGGQHNs5anPRdwPzuv2NkcffIWdlY6FYbTlru2N-Y836XmHETkGJCM_dRxenPPlUTGhBTEWR2DFYlbvc0p4_fqyOfbI-PT7TnynbzL5ZSiMMcD4MN6YhvZC_uzPqvG4ePERrcq7BDHARirNuKzuubZ8iLwJOjezZiJ7ZrEv2GZhXtWsj6ru0LyPDOQN-WPdne2voVDTNzLfcqMC0spgPKmlf-t9GmCpld2otBA" />
        <input name="sign" type="hidden" value="6A0C38902F9FDF7D91E7EB1119359EE5" />
      </form>
      <div id="voice" class="voice" style="display:none;"><a>收不到？试试语音验证码</a></div>
      <div class="text-warn" id="warn" style="display:none"></div>
      <button class="btn-submit" id="submit" role="account">登录</button>

        <div class="qr-code-tab" id="qrtab">
          <span role="app">快递100</span>
          <span role="mini">微信</span>
        </div>
        <!-- app code -->
	      <div class="code-wrap" style="display:none" id="code">
	        <div class="qr-code">
	          <img>
	          <div class="img-mask">
	            <span id="refreshCode">刷新</span>
	            <p id="codeErr">二维码失效，请刷新</p>
	          </div>
	        </div>
	        <div class="code-txt">打开快递100APP，扫一扫登录</div>
        </div>
        <!-- miniprogram code -->
        <div class="code-wrap" style="display:none" id="minicode">
	        <div class="qr-code">
	          <img>
	          <div class="img-mask">
	            <span id="refreshMiniCode">刷新</span>
	            <p id="minicodeErr">二维码失效，请刷新</p>
	          </div>
	        </div>
	        <div class="code-txt">请使用微信扫二维码登录</div>
	      </div>
	      <div class="type" id="type">
		        <a class="bd" role="phone">手机短信登录</a>
		        <a role="account" style="display:none;">账号密码登录</a>
		        <a role="code">扫码登录</a>
		        <a role="reg" class="fr" id="goReg" href="register.html">立即注册</a>
	      </div>
	      <div class="divide">
              <span>快捷登录</span>
          </div>
	      <div class="oauth" id="oauth">
              <div class="fl">
	            <a title="使用QQ登录" class="qq" role="qq" id="qq"></a>
                <!-- <a title="使用微信登录" class="wx" role="weixin" id="wx"></a> -->
                <a title="使用微信登录" class="wx" role="miniprogram" id="miniprogram"></a>
              </div>
              <div class="fr" role="buyer">
	            卖家用户：
	            <a href="https://b.kuaidi100.com/open/mai/quickLogin.do?type=JINGDONG" class="jd" title="使用京东账号登录"></a>
                <a href="https://b.kuaidi100.com/open/mai/quickLogin.do?type=TAOBAO" class="tb" title="使用淘宝账号登录"></a>
                <a href="https://b.kuaidi100.com/open/mai/quickLogin.do?type=PINDUODUO" class="pdd" title="使用拼多多账号登录"></a>
              </div>
        </div>

      	
  </div>
<script src="https://cdn.kuaidi100.com/js/util/jquery-1.12.1.min.js"></script>
<script src="https://cdn.kuaidi100.com/js/util/jquery-migrate-1.4.1.min.js"></script>
<script src="https://cdn.kuaidi100.com/js/share/base_v4.js?version=201802011630"></script>
<script src="https://cdn.kuaidi100.com/js/user/login_new.js"></script>
<script src="https://cdn.kuaidi100.com/js/share/count.js?version=201707271620"></script>
<script>document.write('<script src="//' + (location.host || 'localhost').split(':')[0] + ':35929/livereload.js?snipver=1"></' + 'script>')</script><script>document.addEventListener('LiveReloadDisconnect', function() { setTimeout(function() { window.location.reload(); }, 500); })</script></body>
</html>
