/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-09
 *  Time: 15:21
 *  Description:
 */
EXAM.mainModuleApp.registerApp = angular.module("registerApp", []);
EXAM.loadResources.loadJavaScript("./components/register/registerStateConfig.js");
EXAM.loadResources.loadJavaScript("./components/register/registerController.js");
EXAM.loadResources.loadJavaScript("./components/register/registerService.js");
EXAM.loadResources.loadJavaScript("./components/register/registerDirective.js");