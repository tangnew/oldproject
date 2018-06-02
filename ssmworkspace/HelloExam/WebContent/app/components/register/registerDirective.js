/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-10
 *  Time: 11:59
 *  Description:
 */
EXAM.mainModuleApp.registerApp.directive('compare', function () {
    return {
        strict: 'AE',
        require: 'ngModel',
        scope: {
            orgText: '=compare'
        },
        link: function (scope, element, attrs, ctrl) {
            ctrl.$validators.compare = function (v) {
                return v == scope.orgText;
            };
            
            scope.$watch('orgText', function () {
                ctrl.$validate();
            });
        }
    }
});