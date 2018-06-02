/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-09
 *  Time: 15:45
 *  Description:
 */
EXAM.mainModuleApp.config([
    "$stateProvider",
    "$urlRouterProvider",
    function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.when("", EXAM.mainModuleApp.defaultUrl);
        $urlRouterProvider.otherwise(EXAM.mainModuleApp.defaultUrl);

        var stateAndConfigs = EXAM.modules.states;
        angular.forEach(stateAndConfigs, function (module) {
            angular.forEach(module, function (value) {
                var templateUrl = value.stateConfig.templateUrl;
                if (templateUrl) {
                    value.stateConfig.templateUrl = EXAM.constant.state.viewPrefix + templateUrl;
                }
                $stateProvider.state(value.stateName, value.stateConfig);
            });
        });
    }
]);

/**
 * 配置状态切换事件
 */
EXAM.mainModuleApp.run([
		"$rootScope",
		"$window",
		function($rootScope, $window) {
			$rootScope.$on('$stateNotFound', function(event, unfoundState,
					fromState, fromParams) {
				EXAM.utils.commonError(null, "无法找到该状态[" + unfoundState.to + "]", true);
			});

			$rootScope.$on('$stateChangeSuccess', function(event, toState,
					toParams, fromState, fromParams) {
			});

			$rootScope.$on('$stateChangeError', function(event, toState,
					toParams, fromState, fromParams, error) {
				EXAM.utils.commonError(null, "切换到该状态[" + toState + "]出现error:" + error, true);
			});
		} 
]);