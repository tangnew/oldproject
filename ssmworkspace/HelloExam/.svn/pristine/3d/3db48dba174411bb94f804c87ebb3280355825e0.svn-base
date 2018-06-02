/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-22
 *  Time: 09:30
 *  Description:
 */
EXAM.mainModuleApp.service('httpInterceptorService', function($q, $window) {
	var interceptor = {
		'request' : function(config) {
			// 成功的请求方法
			return config; // 或者 $q.when(config);
		},
		'response' : function(response) {
			// 响应成功
			if(response.data && response.data.code && response.data.code == 300){
				EXAM.utils.commonError(null, "session过期，将返回到主页");
			}else{
			   return response; // 或者 $q.when(config);
			}
		},
		'requestError' : function(rejection) {
			// 请求发生了错误，如果能从错误中恢复，可以返回一个新的请求或promise
			return response; // 或新的promise
			// 或者，可以通过返回一个rejection来阻止下一步
			// return $q.reject(rejection);
		},
		'responseError' : function(rejection) {
			EXAM.utils.commonError(null);
			// 请求发生了错误，如果能从错误中恢复，可以返回一个新的响应或promise
			//return rejection; // 或新的promise
			// 或者，可以通过返回一个rejection来阻止下一步
			// return $q.reject(rejection);
		}
	};
	
	return interceptor;
});


