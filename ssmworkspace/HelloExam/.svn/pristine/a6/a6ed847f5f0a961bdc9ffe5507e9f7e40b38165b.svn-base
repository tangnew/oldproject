/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-08
 *  Time: 14:50
 *  Description:
 */
EXAM.mainModuleApp.registerApp.controller("registerController", ["$scope", "$state", "registerService", function ($scope, $state, registerService) {
        $scope.register = function (registerData) {
            var promise = registerService.register(registerData);
            promise.success(function (response) {
            	$state.go(EXAM.modules.states.login.home.stateName);
            }).error(function (response) {
            });
        };
    }]
);