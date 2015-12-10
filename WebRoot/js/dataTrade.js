$(function() {
	var url = null;
	var Theme = getBodyID();
	if (Theme == 'question') {
		url = '';
		doFour();
	}
})

/**
 *解析url的参数
 */
function Readurl() {
	var urlparam = location.search;
	urlparam = urlparam.slice(1); //url除去？后的参数
	var paramArr = urlparam.split("&");
	var infoArr = new Array;
	var detalArr = new Array
	for (var i = 0; i < paramArr.length; i++) {
		infoArr = paramArr[i].split('=')
		detalArr[infoArr[0]] = infoArr[1];
	};
	return detalArr
}

/**
 *获取body ID
 */
function getBodyID() {
	var a = $('body').attr('id');
	return a
}

/**
四大板块的数据处理
 */
function doFour() {
	window.urlArr = Readurl();
	window.ThemeType = urlArr['ThemeType'];
	ThemeType = ThemeType == undefined ? 'allTheme' : urlArr['ThemeType'];
	var ThemeTypeId = "#" + ThemeType;
	window.order = urlArr['order'];
	order = order == undefined ? 0 : order['order'];
	setTaO(ThemeTypeId, order);
	sendSet();
}

/**
 *页面配置
 */
function setTaO(ThemeTypeId, order) {
	$(ThemeTypeId).addClass();
	if (order == 0) {

	} else {

	}
}

/**
 *发送用户配置信息
 */
function sendSet() {
	$.ajax({
		type: 'POST',
		url: url,
		data: {
			"Theme": Theme,
			"ThemeType": ThemeType,
			"order": order
		},
		success: function(data) {
			if (data.success == 1) {
				getContent(data);
			} else {
				sendSet();
			};
		},
		error: function(jqXHR) {
			alert(jqXHR);
		}

	})
}

/**
 *配置内容
 */
function getContent(data) {
	var article = data.article;
	var alength = article.length;
	for (var i = 0; i < alength; i++) {
		addArtLi(i)
	};
	for (var i = 0; i < alength; i++) {
		dogetContent(i)
	};
}

/**
 *添加文章列表标签
 */
function addArtLi(i) {
	var a = function() {};

}

/**
 * [配置文章列表信息]
 * @param  {[numbner]} i [第i条]
 * @return {[null]}   
 */
function dogetContent(i) {
	var card = $('.card').eq(i);
	var userImg = card.find('.card-userImg');
	var title = card.find('.card-titile');
	var username = card.find('.card-userName');
	var time = card.find('card-time');
	var preview = card.find('.card-preview');
	var answer = card.find('.card-answer');
	var follow = card.find('.card-follow');
	var share = card.find('.card-share')
}