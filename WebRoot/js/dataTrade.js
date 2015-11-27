$(function() {
	var username="liyihang";
	var password="123";
	
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