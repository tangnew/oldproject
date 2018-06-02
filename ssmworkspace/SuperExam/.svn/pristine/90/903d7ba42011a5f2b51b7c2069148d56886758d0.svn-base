/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-08
 *  Time: 14:49
 *  Description:
 */
EXAM.mainModuleApp.loginApp.controller("loginController", ["$scope", "$window", "loginService", function ($scope, $window, loginService) {
	$scope.login = function (loginData) {
		EXAM.constant.claerUserInfo();
        var promise = loginService.login(loginData);
        promise.success(function (response) {
        	EXAM.constant.setUserInfo(response);
            $window.location = EXAM.constant.mainPage;
        });
    };
}]);