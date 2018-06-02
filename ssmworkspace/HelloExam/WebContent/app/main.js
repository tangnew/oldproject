/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-11
 *  Time: 14:32
 *  Description:
 */
EXAM.constant.isLogin = false;
/**
 * 加载客户化的模块和菜单
 */
EXAM.loadCustomModuleAndMenu = function() {
    $.ajax({
        url: EXAM.constant.context + "/jw/menu/items",
        type: "POST",
        async: false,
        success: function(data) {
        	if(typeof data === 'string'){
        		data = $.parseJSON(data);
        		EXAM.utils.commonError(null, "session过期，将返回到主页");
				return;
        	}
        	EXAM.getDependOnModuleAndMenu(data);
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
        	EXAM.utils.commonError(null, textStatus);
        }
    })
};

/**
 * 从后端获取到依赖模块以及菜单名称
 * @param modules
 */
EXAM.getDependOnModuleAndMenu = function(modules) {
    var length = modules.length;
    for (var i = 0; i < length; i++) {
        var module = modules[i];

        var isNotModule = module.status?false:true;
        var notLoadResources = isNotModule;
        var moduleName = module.moduleName;
        var dependModule = {};
        dependModule[moduleName + "App"] = {
        	isNotModule: isNotModule,
        	notLoadResources: notLoadResources,
            js: ["./components/" + moduleName + "/" + moduleName + "App.js"]
        };
        angular.extend(EXAM.dependOnModules, dependModule);

        var menuName = module.menuName;
        var seq = module.seq;
        EXAM.leftNavMenus.push({
        	id:module.id,
            menuName: menuName,
            moduleName: moduleName,
            styleClass: module.styleClass,
            seq: seq,
            isNotModule: isNotModule,
            notLoadResources: notLoadResources
        });

    }
};

EXAM.leftNavMenus = [];

/**
 * 依赖的自定义的模块
 */
EXAM.dependOnModules = {
    mainStateConfig: {
        isNotModule: true,
        css: [],
        js: ["./components/layout/mainStateConfig.js"]
    },
    leftNavMenuApp: {
        css: [],
        js: ["./components/leftNavMenu/leftNavMenuApp.js"]
    }
};

/**
 * 从后端获取到依赖的模块以及菜单名字
 */
EXAM.loadCustomModuleAndMenu();

/**
 * 主模块的初始化
 */
EXAM.dependOnModuleNames = ["ui.router"];
EXAM.init({ ngApp: "mainApp", defaultUrl: "/main" });

/**
 * url常量
 */
EXAM.namespace("EXAM.constant.url");
EXAM.constant.url = EXAM.extend(
    EXAM.constant.url,
    {
        getMenus: EXAM.constant.context + "/jw/menu/items",
        createMenu: EXAM.constant.context + "/jw/menu/create",
        updateMenu: EXAM.constant.context + "/jw/menu/update",
        deleteMenu: EXAM.constant.context + "/jw/menu/delete",
        pageMenus: EXAM.constant.context + "/jw/menu/pageMenus",
        logout: EXAM.constant.context + "/jw/account/logout"
    }
);
