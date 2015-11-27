$(function() {
	//是否可注册登陆的判断
	window.LogonFlag = null; //0为不可登陆，1为可登录
	window.SignFlag = null; //0为不可注册，1为可注册
	$(":input").val("");
	$(":checkbox").attr('checked', false);
	$(document).click(function(e) {
		if (e.which == 1) {
			var target = e.target;
			var targetName = target.tagName;
			var targetClass = $(target).attr('class');
			var targetID = $(target).attr('id');
			closeLogon(targetClass);
			while (targetID == undefined && targetName != 'HTML') {
				target = $(target).parent();
				targetID = $(target).attr('id');
				targetName = $(target)[0].tagName;
			}
			BindClickID(targetID);
		}
	})
	$(window).scroll(function() {
		window.winTop = $(window).scrollTop();
		navbarFixed();
	})
	signBlurCheck();
})

function BindClickID(targetID) {
	if (targetID == 'logon')
		logonshow();
	else if (targetID == 'sign_btn')
		showSign();
	else if (targetID == 'logon_btn')
		showLogon();
	else if (targetID == 'removeLogon')
		removeLogon();
	else if (targetID == 'logonsend')
	//登陆触发事件
		logonNullCheck();
	else if (targetID == 'signsend') {
		signNullCheck();
	}

}


function logonshow() {
	$('.logon_container').addClass('show');
	$('.logon_bg').addClass('show');
	$('.logon_wrap').addClass('show');
}

function showSign() {
	setTimeout(function() {
		$('.logon_body_row1').hide();
		$('.logon_body_row2').show();
		$('.glyphicon-remove').addClass('posLeft')
	}, 150);
	$('.logon_body').addClass('turn')
}

function showLogon() {
	setTimeout(function() {
		$('.logon_body_row2').hide();
		$('.logon_body_row1').show();
		$('.glyphicon-remove').removeClass('posLeft')
	}, 150);
	$('.logon_body').removeClass('turn')
}

function removeLogon() {
	$('.logon_container').removeClass('show');
	$('.logon_bg').removeClass('show');
	$('.logon_wrap').removeClass('show');
	showLogon();
	$(":input").val("");
	$(":checkbox").attr('checked', false);
	$('.input_tips').removeClass('show');
	$(":input").removeClass('wrong_input')
}

function closeLogon(targetClass) {
	if ($('.logon_container').hasClass('show')) {
		if (targetClass == 'logon_wrap show' || targetClass == 'logon_container show') {
			removeLogon()
		};
	}
}

function navbarFixed() {
	var navbarH = $('.navbar').height();
	var changeTop = $('.head').height();
	if (winTop > changeTop) {
		$('#searchcon').show();
		$('.navbar li').addClass('blue');
		$('.navbar-brand').addClass('blue');
		$('.navbar').removeClass('navbar_absolute');
		$('.navbar').addClass('navbar-fixed-top');
	}
	if (winTop == 0) {
		$('#searchcon').hide();
		$('.navbar li').removeClass('blue');
		$('.navbar-brand').removeClass('blue');
		$('.navbar').addClass('navbar_absolute');
		$('.navbar').removeClass('navbar-fixed-top');
	};
}

function logonNullCheck() {
	var logon = $('#logon_main');
	var username = logon.find('.username');
	var password = logon.find('.password')
	Nullcheck(username)
	Nullcheck(password)
}

function signNullCheck() {
	var sign = $('#sign_main');
	var username = sign.find('.username')
	var email = sign.find('.email');
	var password = sign.find('.password');
	Nullcheck(username);
	Nullcheck(email);
	Nullcheck(password);
	passswrodCheck(password);
	//如果可注册就执行注册方法
	if (SignFlag == 1) {
		RegisterSend(username, email, password);
	} else
		return;
}

function Nullcheck(target) {
	if (target.val() == '') {
		addwrong(target);
		SignFlag = 0;
	} else {
		SignFlag = 1;
	};
}

/**
 *添加输入错误红框
 */
function addwrong(target) {
	target.addClass('wrong_input');
	cancel_wrong(target)
}

/**
 *用于取消输入错误的红框事件
 *
 */
function cancel_wrong(target) {
	//绑定事件
	var target = target;
	target.bind('keyup', function() {
		if (target.hasClass('wrong_input')) {
			target.removeClass('wrong_input');
		};
	})
}

/**
 *注册界面
 *注册用户名失去焦点触发事件(usernamecheck)
 *校验用户名格式
 *检查用户名是否被注册(usernameExit)
 *邮箱失去焦点触法事件(emailcheck)
 *检验邮箱格式
 *检查邮箱是否注册(emailExit)
 */
function signBlurCheck() {
	SignFlag = 0; //0为不可注册，1为可注册
	var sign = $('#sign_main');
	var username = sign.find('.username');
	var email = sign.find('.email');
	var password = sign.find('.password');
	usernamecheck = username.blur(function() {
		var registerFlag = 0;
		var usernameText = username.val();
		var usernameTips1 = username.nextAll('.input_tips').eq(0);
		var usernameTips2 = username.nextAll('.input_tips').eq(1);
		//格式校验
		if (usernameText.length > 10 || usernameText.length < 2) {
			addwrong(username)
			usernameTips2.addClass('show');
			SignFlag = 0;
		} else {
			usernameTips2.removeClass('show')
				//用户名存在校验
			usernameExit = $.ajax({
				type: "POST",
				url: "servlet/RegisterServlet?type=0",
				data: {
					"username": usernameText
				},
				dataType: "json",
				success: function(data) {
					registerFlag = data.registerFlag;
					if (registerFlag == 0) {
						SignFlag = 1;
						usernameTips1.removeClass('show')
					} else {
						SignFlag = 0;
						usernameTips1.addClass('show')
						cancel_Tips(username, usernameTips1);
					}
				},
				error: function(jqXHR) {
					alert(jqXHR.status)
				},
			})
		}
	})
	emailcheck = email.blur(function() {
		var registerFlag = 0;
		var emailText = email.val();
		//格式校验错误提示
		var emailTips1 = email.nextAll('.input_tips').eq(0);
		//已注册错误提示
		var emailTips2 = email.nextAll('.input_tips').eq(1);
		var regObj = /[\w!#$%&'*+\/=?^_`{|}~-]+(?:\/\.[\/\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/
		var emailFormatflag = regObj.test(emailText);
		if (!emailFormatflag) {
			addwrong(email);
			emailTips2.addClass('show');
			cancel_Tips(email, emailTips2);
			SignFlag = 0;
		} else {
			emailTips2.removeClass('show')
			emailExit = $.ajax({
				type: "POST",
				url: "servlet/RegisterServlet?type=1",
				data: {
					"email": emailText
				},
				dataType: "json",
				success: function(data) {
					registerFlag = data.emailFlag;
					if (registerFlag == 0) {
						SignFlag = 1;
						emailTips1.removeClass('show');
					} else {
						SignFlag = 0;
						emailTips1.addClass('show');
						cancel_Tips(email, emailTips1);
					}
				},
				error: function(jqXHR) {
					alert(jqXHR.status)
				}
			})
		}
	})

}
/**
 *@parm:cancel Tips
 *		用于绑定目标文本框，键盘输入时取消输入提示
 */
function cancel_Tips(target, targetTips) {
	target.bind('keyup', function() {
		if (targetTips.hasClass('show')) {
			targetTips.removeClass('show')
		};
	})
}

function passswrodCheck(password) {
	var passwordText = password.val();
	var passwordTips = password.nextAll('.input_tips');
	if (passwordText.length < 6 || passwordText.length > 20) {
		SignFlag = 0;
		addwrong(password);
		passwordTips.addClass('show')
	} else {;
		SignFlag = 1;
		passwordTips.removeClass('show')
	}
}

function RegisterSend(username, email, password) {
	this.username = username.val();
	this.email = email.val();
	this.password = password.val();
	var url;
	var sendToFlag;
	$.ajax({
		type: "POST",
		url: "servlet/RegisterServlet",
		data: {
			"type":2,
			"username": this.username,
			"email": this.email,
			"password": this.password
		},
		dataType: "json",
		success: function(data) {
			if (data.success == 1) {
				// alert(data.url)
				location = data.url;
			};
		},
		error: function(jqXHR) {
			alert(jqXHR.status)
		}
	})
}