/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-08
 *  Time: 15:07
 *  Description:
 */
EXAM.namespace("EXAM.utils");
EXAM.utils = EXAM.extend(EXAM.utils, {
	httpPromise : function($http, config, error) {
		var promise = $http(config);
		if (error && typeof error === "function") {
			promise.error(error);
		} else {
			promise.error(function(response) {
				EXAM.utils.commonError(response);
			});
		}
		return promise;
	}
});

EXAM.utils.hasError = false;
EXAM.utils.commonError = function(response, errorContent, stopCurrentState) {
	if(EXAM.utils.hasError){
		return;
	}
	EXAM.utils.hasError = true;
	var errorMsg =  "系统暂时无法提供服务,jw正在拼命的解决中......";
	if(errorContent){
		errorMsg = errorContent;
	}
	$.confirm({
		icon : "icon-question-sign",
		title : "确认",
		content : errorMsg,
		theme : "my-light",
//		autoClose : "ok|5000",
		buttons : {
			ok : {
				text : "&nbsp;确定",
				btnClass : 'btn btn-danger icon-home icon-large',
				action : function() {
					EXAM.utils.hasError = false;
					if(!stopCurrentState){
						window.location = EXAM.constant.homePage;
					}
				}
			}
		}
	});
}

EXAM.utils.commonAlertError = function(response, errorContent){
	var errorMsg =  "jw正在拼命的解决中......";
	if(errorContent){
		errorMsg = errorContent;
	}
	
	$.alert({
	    title: '注意!',
	    theme : "my-light",
	    content: '<i class="icon-comment-alt"></i>&nbsp;'+errorMsg,
	    buttons : {
			ok : {
				text : "&nbsp;确定",
				btnClass : 'btn btn-info icon-undo icon-large'
			}
		}
	});
}
