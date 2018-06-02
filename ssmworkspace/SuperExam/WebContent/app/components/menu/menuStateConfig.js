/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-14
 *  Time: 13:04
 *  Description:
 */
EXAM.namespace("EXAM.modules.states.menu");
EXAM.modules.states.menu = EXAM.extend(
    EXAM.modules.states.menu,
    {
        home: {
            stateName: "main.menu",
            stateConfig: {
                url: "/menu",
                templateUrl: "components/menu/tpl/home.html",
                controller: function ($state) {
                    $state.go(EXAM.modules.states.menu.list.stateName);
                }
            }
        },
        list: {
            stateName: "main.menu.list",
            stateConfig: {
                url: "/list",
                templateUrl: "components/menu/tpl/list.html",
                resolve: {
                	menus: function (menuService, $stateParams) {
                    	var page = {
            				pageSize : EXAM.constant.pageSize,
            				currentPage : 1              
            			};
                    	
                    	if($stateParams.page && $stateParams.page.currentPage){
                    		page.currentPage = $stateParams.page.currentPage;
                    	}
                    	
                        return menuService.pageMenus(page);
                    }
                },
                controller: function ($scope, $state, menus) {
                    $scope.pageItems = menus.data;
                    //todo 需要改进，不然会死循环
                    if(!menus.data.items || !menus.data.items.length){
                    	 $scope.pageItems.totalPage = 0;
                    	 $scope.currentPage = 0;
                    }else{
                        $scope.pageItems.totalPage = Math.ceil($scope.pageItems.counts / $scope.pageItems.pageSize);
                        $scope.currentPage = $scope.pageItems.currentPage;
                    }
                    
                    
                    $scope.getPrevPageClass = function(){
                    	var prevPage = parseInt($scope.pageItems.currentPage) - 1;
                    	if(prevPage < 1 ){
            	    		return "disabled";
            	    	}
            	    	
                    	return "";
            	    };
            	    
            	    $scope.getNextPageClass = function(){
            	    	var nextPage = parseInt($scope.pageItems.currentPage) + 1;
            	    	if( nextPage > $scope.pageItems.totalPage){
            	    		return "disabled";
            	    	}
            	    	
            	    	return "";
            	    };
            	    
            	    
            	    $scope.goPage = function(currentPage){
            	    	if(currentPage < 1){
            	    		EXAM.utils.commonAlertError(null, "不能够小于最小页码1");
            	    	    return;
            	    	}
            	    	
            	    	if($scope.currentPage == currentPage){
            	    		EXAM.utils.commonAlertError(null, "已经是当前页");
            	    	    return;
            	    	}
            	    	
            	    	if(currentPage > $scope.pageItems.totalPage){
            	    		EXAM.utils.commonAlertError(null, "已经超过了最大页");
            	    	    return;
            	    	}
            	    	
            	    	$scope.listMenuByPage(currentPage);
            	    };
            	    
            	    $scope.listMenuByPage = function(currentPage){
            	    	if(currentPage < 1){
            	    	    return;
            	    	}
            	    	
            	    	if($scope.currentPage == currentPage){
            	    	    return;
            	    	}
            	    	
            	    	if(currentPage > $scope.pageItems.totalPage){
            	    	    return;
            	    	}
            	    	
            	    	$state.go(EXAM.modules.states.menu.list.stateName, {page:{currentPage:currentPage}});
            	    };
                },
                params: {
                    page: {}
                }
            }
        },
        create: {
            stateName: "main.menu.create",
            stateConfig: {
                url: "/create",
                templateUrl: "components/menu/tpl/create.html"
            }
        },
        edit: {
            stateName: "main.menu.edit",
            stateConfig: {
                url: "/edit",
                templateUrl: "components/menu/tpl/create.html",
                controller: function ($scope, $stateParams) {
                    $scope.menuData = $stateParams.menu;
                    $("#styleClass").val($stateParams.menu.styleClass).trigger("change");
                },
                params: {
                    menu: {}
                }
            }
        }
    }
);
