/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-08
 *  Time: 14:55
 *  Description:
 */
EXAM.mainModuleApp.leftNavMenuApp.controller("leftNavMenuController", [
		"$scope", function($scope) {
			$scope.menus = EXAM.leftNavMenus;

			$scope.$on("menusCreated", function(event, menu) {
				$scope.menus.push(menu);
			});
			
			$scope.$on("menusUpdated", function(event, menu) {
				$scope.menus.forEach(function(tempMenu){
					if(tempMenu.id == menu.id){
						EXAM.extend(tempMenu,menu);
					}
				});
			});
			
			$scope.$on("menusDeleted", function(event, menu) {
				var menuId = menu.menuId;
				var newMenus = [];
				$scope.menus.forEach(function(tempMenu){
					if(tempMenu.id != menuId){
						newMenus.push(tempMenu);
					}
				});
				
				$scope.menus = newMenus;
			});
			
		} ]);