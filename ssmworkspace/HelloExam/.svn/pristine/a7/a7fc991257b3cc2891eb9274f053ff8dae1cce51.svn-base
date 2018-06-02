/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-11
 *  Time: 14:33
 *  Description:
 */
EXAM.constant.isLogin = true;
/**
 * 依赖的自定义的模块
 */
EXAM.dependOnModules = {
    indexStateConfig: {
        isNotModule: true,
        css: [],
        js: ["./components/layout/indexStateConfig.js"]
    },
    loginApp: {
        css: [],
        js: ["./components/login/loginApp.js"]
    },
    registerApp: {
        css: [],
        js: ["./components/register/registerApp.js"]
    }
};

/**
 * 主模块的初始化
 */
EXAM.dependOnModuleNames = ["ui.router"];
EXAM.init({ngApp: "loginAndRegisterApp", defaultUrl: "/index/login"});

/**
 * url常量
 */
EXAM.namespace("EXAM.constant.url");
EXAM.constant.url = EXAM.extend(
    EXAM.constant.url,
    {
        login: EXAM.constant.context + "/jw/account/login",
        register: EXAM.constant.context + "/jw/account/register"
    }
);

