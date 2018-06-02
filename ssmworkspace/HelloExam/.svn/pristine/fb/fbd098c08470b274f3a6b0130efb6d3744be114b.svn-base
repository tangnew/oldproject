/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-08
 *  Time: 16:35
 *  Description:
 */
EXAM.namespace("EXAM.constant");
EXAM.constant.context = "http://127.0.0.1:8080/exam";
EXAM.extend(
    EXAM.constant,
    {	
    	isLogin: true,
    	pageSize: 3,
        homePage: EXAM.constant.context + "/app/index.html",
        mainPage: EXAM.constant.context + "/app/main.html",
        claerUserInfo: function(){
        	window.localStorage.removeItem("userInfo");
        },
        setUserInfo: function(user){
        	window.localStorage.setItem("userInfo", JSON.stringify(user));
        },
        getUserInfo: function(){
        	var user = window.localStorage.getItem("userInfo");
        	if(!user){
        		EXAM.utils.commonError(null,"暂时未登陆！");
        		return;
        	}
        	return $.parseJSON(user);
        }
    }
);

EXAM.namespace("EXAM.constant.state");
EXAM.extend(
    EXAM.constant.state,
    {
        viewPrefix: EXAM.constant.context + "/app/"
    }
);
