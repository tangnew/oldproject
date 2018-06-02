/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-17
 *  Time: 16:50
 *  Description:
 */
EXAM.mainModuleApp.menuApp.service("menuService", 
	[ "$http","$rootScope", function($http, $rootScope) {
		var menusCreated = function(menu){
			$rootScope.$broadcast("menusCreated", menu);
		};
		
		var menusUpdated = function(menu){
			$rootScope.$broadcast("menusUpdated", menu);
		};
		
		var menusDeleted = function(menu){
			$rootScope.$broadcast("menusDeleted", menu); 
		};
		
		var getMenus = function() {
			var config = {
				method : 'POST',
				url : EXAM.constant.url.getMenus
			};
			return EXAM.utils.httpPromise($http, config);
		};
	
		var createMenu = function(params) {
			var config = {
				method : 'POST',
				url : EXAM.constant.url.createMenu,
				data : params
			};
			return EXAM.utils.httpPromise($http, config);
		};
	
		var updateMenu = function(params) {
			var config = {
				method : 'POST',
				url : EXAM.constant.url.updateMenu,
				data : params
			};
			return EXAM.utils.httpPromise($http, config);
		};
	
		var deleteMenu = function(params) {
			var config = {
				method : 'POST',
				url : EXAM.constant.url.deleteMenu,
				data : params
			};
			return EXAM.utils.httpPromise($http, config);
		};
		
		var pageMenus = function(params){
			var config = {
					method : 'POST',
					url : EXAM.constant.url.pageMenus,
					data : params
			};
			
			return EXAM.utils.httpPromise($http, config);
		};
		
		return {
			getMenus : getMenus,
			createMenu : createMenu,
			updateMenu : updateMenu,
			deleteMenu : deleteMenu,
			pageMenus : pageMenus,
			menusUpdated : menusUpdated,
			menusDeleted : menusDeleted,
			menusCreated : menusCreated
		};
	}]
);
