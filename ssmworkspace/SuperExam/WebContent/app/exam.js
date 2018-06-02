/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-08
 *  Time: 15:10
 *  Description:
 */
/**
 * 全局变量
 * @type {{}}
 */
window.EXAM = {};

/**
 * 命名空间函数
 * @param spaces
 */
EXAM.namespace = function (spaces) {
    if (!spaces) {
        return;
    }

    var names = spaces.trim().split('.');
    var length = names.length;
    var currentObj = EXAM;
    for (var i = 1; i < length; i++) {
        var name = names[i];
        currentObj = currentObj[name] = currentObj[name] || {};
    }
};

/**
 * 加载资源对象
 * @type {{loadStyleSheet: EXAM.loadResources.loadStyleSheet, loadJavaScript: EXAM.loadResources.loadJavaScript}}
 */
EXAM.loadResources = {
    loadStyleSheet: function (cssUrl) {
        document.writeln("<link rel='stylesheet' href='" + cssUrl + "' type='text/css'>");
    },
    loadJavaScript: function (scriptUrl) {
    	try{
            document.writeln("<script src='" + scriptUrl + "' type='text/javascript'><\/script>");
    	}catch(e){
    		console.log(e + "加载"+scriptUrl+"失败");
    	}
    }
};

/**
 * 获取到模块依赖模块的名称
 * @param dependOnModuleNames
 * @param dependOnModules
 */
EXAM.getDependOnModuleNames = function (dependOnModuleNames, dependOnModules) {
    angular.forEach(dependOnModules, function (module, moduleName) {
        if (!module.isNotModule) {
            dependOnModuleNames.push(moduleName);
        }
    });
};


/**
 * 加载模块的js文件
 * @param modules
 */
EXAM.loadModuleResources = function (modules) {
    var jses = [];
    angular.forEach(modules, function (value) {
    	if(value.notLoadResources){
    		return ;
    	}
    	
		var js = value.js;
        if (angular.isArray(js)) {
            angular.forEach(js, function (tempJs) {
                jses.push(tempJs);
            });
        } else {
            jses.push(js);
        }
    });

    angular.forEach(jses, function (js) {
        EXAM.loadResources.loadJavaScript(js);
    });
};

/**
 * 扩展对象
 * @param dest
 * @param src
 * @returns {Object}
 */
EXAM.extend = function(dest, src){
  return angular.extend(dest, src);
};

/**
 * 系统的初始化启动
 * @param ngAppInfo
 */
EXAM.init = function (ngAppInfo) {
    /**
     * 注入主模块的依赖模块
     */
    EXAM.getDependOnModuleNames(EXAM.dependOnModuleNames, EXAM.dependOnModules);

    /**
     * 主模块生成
     */
    EXAM.mainModuleApp = angular.module(ngAppInfo.ngApp, EXAM.dependOnModuleNames);
    EXAM.mainModuleApp.defaultUrl = ngAppInfo.defaultUrl;

    /**
     * 加载主模块的配置信息
     */
    EXAM.loadResources.loadJavaScript("./common/moduleConfig.js");

    /**
     * 加载依赖的自定义的模块的css、js
     */
    EXAM.loadModuleResources(EXAM.dependOnModules);
};

/**
 * 加载常量
 */
EXAM.loadResources.loadJavaScript("./common/constant.js");
EXAM.loadResources.loadJavaScript("./common/utils.js");
