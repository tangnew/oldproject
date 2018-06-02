/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-08
 *  Time: 16:30
 *  Description:
 */
EXAM.mainModuleApp.controller("mainController", ["$scope", function ($scope) {
    $scope.homePage = EXAM.constant.homePage;
    $scope.mainPage = EXAM.constant.mainPage;
    $scope.states = EXAM.modules.states;
}]);
