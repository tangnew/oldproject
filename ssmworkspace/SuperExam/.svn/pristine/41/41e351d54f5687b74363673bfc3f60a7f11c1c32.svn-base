/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-08
 *  Time: 14:52
 *  Description:
 */
EXAM.mainModuleApp.registerApp.service("registerService", ["$http", function ($http) {
    var register = function (params) {
        var config = {
            method: 'POST',
            url: EXAM.constant.url.register,
            data: params
        };
        return EXAM.utils.httpPromise($http, config);
    };

    return {register: register};
}]);