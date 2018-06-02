/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-08
 *  Time: 14:52
 *  Description:
 */
EXAM.mainModuleApp.loginApp.service("loginService", ["$http", function ($http) {
    var login = function (params) {
        var config = {
            method: 'POST',
            url: EXAM.constant.url.login,
            data: params
        };
        return EXAM.utils.httpPromise($http, config);
    };

    return {login: login};
}]);
