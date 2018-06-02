/**
 * 
 */
EXAM.mainModuleApp.controller("headerController", ["$scope", "$http", "$window",function ($scope, $http, $window) {
    $scope.userInfo = EXAM.constant.getUserInfo();
	$scope.logout = function() {
		var config = {
			method : 'POST',
			url : EXAM.constant.url.logout
		};

		var promise = EXAM.utils.httpPromise($http, config);
		promise.success(function(response) {
			EXAM.constant.claerUserInfo();
			$window.location = EXAM.constant.homePage;
		});
	}
}]);