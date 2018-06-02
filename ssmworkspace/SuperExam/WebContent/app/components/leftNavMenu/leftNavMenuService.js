/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-08
 *  Time: 14:56
 *  Description:
 */
EXAM.mainModuleApp.leftNavMenuApp.service("leftNavMenuService", ["$http", function ($http) {
    var getMenus = function (params) {
        var config = {
            method: 'POST',
            url: EXAM.constant.url.getMenus,
            data: params
        };
        return EXAM.utils.httpPromise($http, config);
    };

    return {getMenus: getMenus};
}]);
